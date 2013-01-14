package com.emitrom.ti4j.myrecipes.client.ui.favorites;

import com.emitrom.gwt4.ti.mobile.client.ui.View;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;

/**
 * MainView of the loan calculator
 * 
 */
public class FavoritesView extends View {

    private final static FavoritesView INSTANCE = new FavoritesView();

    public static FavoritesView get() {
        return INSTANCE;
    }

    private FavoritesView() {
        this.setLeft(0);
        this.setTop(0);
        this.setRight(0);
        this.setBottom(0);
        this.setBackgroundColor(new Color("#FFF"));
        this.add(FavoritesTable.get());
    }

}
