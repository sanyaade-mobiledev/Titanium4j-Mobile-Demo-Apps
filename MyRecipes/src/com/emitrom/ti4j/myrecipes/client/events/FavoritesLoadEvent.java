package com.emitrom.ti4j.myrecipes.client.events;

import com.emitrom.ti4j.myrecipes.client.events.handlers.FavoritesLoadHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Dispatched when an asset is loaded
 * 
 */
public class FavoritesLoadEvent extends GwtEvent<FavoritesLoadHandler> {

    public static Type<FavoritesLoadHandler> TYPE = new Type<FavoritesLoadHandler>();

    @Override
    public Type<FavoritesLoadHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FavoritesLoadHandler handler) {
        handler.onEvent(this);
    }

}
