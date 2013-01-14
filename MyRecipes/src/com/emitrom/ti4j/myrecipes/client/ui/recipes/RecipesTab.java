package com.emitrom.ti4j.myrecipes.client.ui.recipes;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;

public class RecipesTab extends Tab {

    private static final RecipesTab INSTANCE = new RecipesTab();

    public static RecipesTab get() {
        return INSTANCE;
    }

    private RecipesTab() {
        this.setTitle("Recipes");
        this.setIcon("recipes/fork-and-knife.png");
        this.setWindow(RecipesWindow.get());
    }
}
