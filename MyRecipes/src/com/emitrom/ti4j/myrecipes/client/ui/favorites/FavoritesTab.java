package com.emitrom.ti4j.myrecipes.client.ui.favorites;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;

public class FavoritesTab extends Tab {

    private static final FavoritesTab INSTANCE = new FavoritesTab();

    public static FavoritesTab get() {
        return INSTANCE;
    }

    private FavoritesTab() {
        this.setTitle("Favorites");
        this.setIcon("recipes/heart.png");
        this.setWindow(FavoritesWindow.get());
    }
}
