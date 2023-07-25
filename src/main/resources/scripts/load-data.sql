DROP TABLE IF EXISTS umsaetze;
CREATE TABLE umsaetze (id SERIAL PRIMARY KEY, anbieter TEXT NOT NULL, abbuchungskonto TEXT NOT NULL, buchungszeit TEXT NOT NULL, beitrag TEXT NOT NULL, typ TEXT NOT NULL, kategorie TEXT NOT NULL, umsatzart TEXT NOT NULL, kommentar TEXT NOT NULL);

INSERT INTO umsaetze (anbieter, abbuchungskonto,buchungszeit, beitrag ,typ,kategorie,umsatzart,kommentar) VALUES
                                                                                                              ('Kaufland', '111222333444', '12:05:20 Uhr','15.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung',''),
                                                                                                              ('Aldi', '111222333444', '12:25:30 Uhr','18.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung',''),
                                                                                                              ('Wasgau', '111222333444', '12:35:50 Uhr','28.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung',''),
                                                                                                              ('Rewo', '111222333444', '12:45:30 Uhr','8.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung','');



-- INSERT INTO umsaetze (anbieter, abbuchungskonto,buchungszeit, beitrag ,typ,kategorie,umsatzart,kommentar) VALUES ('Aldi', '111222333444', '12:25:30 Uhr','18.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung','');
-- INSERT INTO umsaetze (anbieter, abbuchungskonto,buchungszeit, beitrag ,typ,kategorie,umsatzart,kommentar) VALUES ('Wasgau', '111222333444', '12:35:50 Uhr','28.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung','');
-- INSERT INTO umsaetze (anbieter, abbuchungskonto,buchungszeit, beitrag ,typ,kategorie,umsatzart,kommentar) VALUES ('Rewo', '111222333444', '12:45:30 Uhr','8.35 Euro', 'aufwaende', 'shopping', 'kartenzahlung','');
