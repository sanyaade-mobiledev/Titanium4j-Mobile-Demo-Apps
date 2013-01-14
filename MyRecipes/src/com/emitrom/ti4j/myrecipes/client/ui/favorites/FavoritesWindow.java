package com.emitrom.ti4j.myrecipes.client.ui.favorites;

import com.emitrom.gwt4.ti.mobile.client.core.events.ui.UIEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.UIEventHandler;
import com.emitrom.gwt4.ti.mobile.client.ui.Window;
import com.emitrom.ti4j.myrecipes.client.eventbus.EventBusUtil;
import com.emitrom.ti4j.myrecipes.client.events.FavoritesLoadEvent;

/**
 * Implements the MainWindow of the application
 * 
 */
public class FavoritesWindow extends Window {

    private static final FavoritesWindow INSTANCE = new FavoritesWindow();

    public static FavoritesWindow get() {
        return INSTANCE;
    }

    private FavoritesWindow() {
        this.setTitle("Favorites");
        this.setBackgroundColor("#fff");
        this.add(FavoritesView.get());
        this.addFocusHander(new UIEventHandler() {
            @Override
            public void onEvent(UIEvent event) {
                EventBusUtil.get().fireEvent(new FavoritesLoadEvent());
            }
        });
    }
}
