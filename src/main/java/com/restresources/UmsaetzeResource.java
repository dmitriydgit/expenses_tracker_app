package com.restresources;

import com.models.Umsatz;
import com.services.UmsaetzeService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.net.URI;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "kontrollevonfinanzen_umsaetze")
@Path("umsaetze")
@Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// @SecurityRequirement(name = "Keycloak")
public class UmsaetzeResource {

  final String Anbieter = "Kaufland";

  @Inject PgPool client;

  @Inject UmsaetzeService businessService;

  @PostConstruct
  void config() {
    initdb();
  }

  @GET
  @Path("")
  public Multi<Umsatz> get() {
    return businessService.findAll(client);
  }

  @GET
  @Path("{id}")
  public Uni<Response> get(@PathParam("id") Long id) {
    return businessService.findById(client, id)
        .onItem()
        .transform(umsatz ->
            umsatz != null ?
                Response.ok(umsatz) :
            Response.status(Status.NOT_FOUND))
        .onItem()
        .transform(Response.ResponseBuilder::build);
  }

  @POST
  public Uni<Response> create(Umsatz umsatz){
    return businessService
        .save(client, umsatz.getAnbieter())
        .onItem()
        .transform(id -> URI.create("/umsaetze/" + id ))
        .onItem()
        .transform(uri -> Response.created(uri).build());
  }

  @DELETE
  @Path("{id}")
  public Uni<Response> delete(@PathParam("id") Long id){
    return businessService
        .delete(client, id)
        .onItem()
        .transform(deleted -> deleted ?  Response.Status.NO_CONTENT : Response.Status.NOT_FOUND)
        .onItem()
        .transform(status -> Response.status(status).build());
      }



  private void initdb() {
    client
        .query("DROP TABLE IF EXISTS umsaetze")
        .execute()
        .flatMap(
            m ->
                client
                    .query("CREATE TABLE umsaetze (id SERIAL PRIMARY KEY, anbieter TEXT NOT NULL)")
                    .execute())
        //        .flatMap(m -> client.query("INSERT INTO umsaetze (buchungszeit , abbuchungskonto,
        // beitrag, anbieter, typ, kategorie, umsatzart, kommentar) VALUES (Buchungszeit ,
        // Abbuchungskonto, Beitrag, Anbieter, Typ, Kategorie, Umsatzart, Kommentar)").execute())
        .flatMap(m -> client.query("INSERT INTO umsaetze (anbieter) VALUES ('Kaufland')").execute())
        .flatMap(m -> client.query("INSERT INTO umsaetze (anbieter) VALUES ('Lidl')").execute())
        .await()
        .indefinitely();
  }
}
