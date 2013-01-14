package com.emitrom.ti4j.myrecipes.client.ui.recipes;

import com.emitrom.gwt4.ti.mobile.client.ui.Window;

/**
 * Implements the MainWindow of the application
 * 
 */
public class RecipesWindow extends Window {

    private static final RecipesWindow INSTANCE = new RecipesWindow();

    public static RecipesWindow get() {
        return INSTANCE;
    }

    private RecipesWindow() {
        this.setTitle("Recipes");
        this.setBackgroundImage("recipes/background.png");
        this.add(RecipesView.get());
    }
}
