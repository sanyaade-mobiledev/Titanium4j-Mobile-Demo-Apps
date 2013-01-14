package com.emitrom.ti4j.myrecipes.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.TabGroup;
import com.emitrom.gwt4.ti.mobile.client.ui.UI;
import com.emitrom.ti4j.myrecipes.client.ui.favorites.FavoritesTab;
import com.emitrom.ti4j.myrecipes.client.ui.recipes.RecipesTab;

public class MainTabGroup extends TabGroup {

    private static final MainTabGroup INSTANCE = new MainTabGroup();

    public static MainTabGroup get() {
        return INSTANCE;
    }

    private MainTabGroup() {
        UI.get().setBackgroundColor("#000");
        this.addTab(RecipesTab.get());
        this.addTab(FavoritesTab.get());
    }

    public void display() {
        this.open();
    }

}
