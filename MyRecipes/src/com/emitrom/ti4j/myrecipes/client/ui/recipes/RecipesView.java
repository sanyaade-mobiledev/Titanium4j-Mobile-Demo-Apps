package com.emitrom.ti4j.myrecipes.client.ui.recipes;

import com.emitrom.gwt4.ti.mobile.client.ui.View;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;

/**
 * MainView of the loan calculator
 * 
 */
public class RecipesView extends View {

    private final static RecipesView INSTANCE = new RecipesView();

    public static RecipesView get() {
        return INSTANCE;
    }

    private RecipesView() {
        this.setLeft(0);
        this.setTop(0);
        this.setRight(0);
        this.setBottom(0);
        this.setBackgroundColor(new Color("#FFF"));
        this.add(RecipesTable.get());
    }

}
