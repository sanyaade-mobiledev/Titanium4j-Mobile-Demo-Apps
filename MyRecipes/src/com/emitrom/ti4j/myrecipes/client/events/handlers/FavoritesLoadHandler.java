package com.emitrom.ti4j.myrecipes.client.events.handlers;

import com.emitrom.ti4j.myrecipes.client.events.FavoritesLoadEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to the game start event
 */
public interface FavoritesLoadHandler extends EventHandler {
    public void onEvent(FavoritesLoadEvent event);
}
