package com.services;

import com.models.Umsatz;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;

@ApplicationScoped
@Getter
public class UmsaetzeService {

  @Inject
  PgPool client;

//  @Inject
//  @RestClient
//  UmsaetzeClient umsetzClient;
//


  public Multi<Umsatz> findAll(PgPool client){
    return client.query("SELECT id, anbieter FROM umsaetze ORDER BY anbieter DESC").execute()
        .onItem()
        .transformToMulti(set -> Multi.createFrom().iterable(set))
        .onItem()
        .transform(UmsaetzeService::from);
  }

  public Uni<Umsatz> findById(PgPool client, Long id){
    return client.preparedQuery("SELECT id, anbieter FROM umsaetze WHERE id = $1").execute(Tuple.of(id))
        .onItem()
        .transform(m-> m.iterator().hasNext() ? from(m.iterator().next()): null);


  }


  public Uni<Long> save (PgPool client, String anbieter){
    return client
        .preparedQuery("INSERT INTO umsaetze (anbieter) VALUES ($1) RETURNING id")
        .execute(Tuple.of(anbieter))
        .onItem()
        .transform(m -> m.iterator().next().getLong("id"));
  }

  public Uni<Boolean> delete(PgPool client, Long id){
    return client
        .preparedQuery("DELETE FROM umsaetze WHERE id = $1")
        .execute(Tuple.of(id))
        .onItem()
        .transform(m-> m.rowCount() == 1);
  }

  private static Umsatz from (Row row){
    return new Umsatz(row.getLong("id"), row.getString("anbieter"));
  }


}
