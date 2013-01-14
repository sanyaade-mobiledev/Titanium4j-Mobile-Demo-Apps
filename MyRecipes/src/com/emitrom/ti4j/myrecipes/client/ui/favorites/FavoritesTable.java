package com.emitrom.ti4j.myrecipes.client.ui.favorites;

import com.emitrom.gwt4.ti.mobile.client.ui.TableView;

/**
 * TableView for favorites
 */
public class FavoritesTable extends TableView {

    private static final FavoritesTable INSTANCE = new FavoritesTable();

    public static FavoritesTable get() {
        return INSTANCE;
    }

    private FavoritesTable() {

    }
}
