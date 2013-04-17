/**
 * Copyright 2012:
 * Projekt Phoenics:
 * Bau-Berufsgenossenschaft Hamburg, Holstenwall 8-9, 20355 Hamburg,
 * Bau-Berufsgenossenschaft Hannover, Hildesheimer Str. 309, 30519 Hannover,
 * Bau-Berufsgenossenschaft Rheinland und Westfalen, Victoriastr. 21, 42115 Wuppertal,
 * Bau-Berufsgenossenschaft Frankfurt, An der Festeburg 27-29, 60389 Frankfurt am Main,
 * Südwestliche Bau-Berufsgenossenschaft, Steinhäuser Str. 10, 76135 Karlsruhe,
 * Württembergische Bau-Berufsgenossenschaft, Friedrich-Gerstlacher-Str. 15, 71032 Böblingen,
 * Bau-Berufsgenossenschaft Bayern und Sachsen, Loristr. 8, 80267 München,
 * Tiefbau-Berufsgenossenschaft, Am Knie 6, 81241 München und
 * Berufsgenossenschaft Nahrungsmittel und Gaststätten, Dynamostraße 7-11, 68165 Mannheim;
 * vertreten durch den Stellvertretenden Geschäftsführer, Ernst Bauer, der
 * Arbeitsgemeinschaft der Bau-Berufsgenossenschaften, An der Festeburg 27-29, 60389 Frankfurt am Main
 */
package de.gp.pms.client.auth.event;

import com.google.gwt.event.shared.EventHandler;

public interface LogoutEventHandler extends EventHandler {

    void onLogout(LogoutEvent event);
    
}
