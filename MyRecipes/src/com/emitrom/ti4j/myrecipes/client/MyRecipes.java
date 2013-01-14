package com.emitrom.ti4j.myrecipes.client;

import com.emitrom.gwt4.ti.mobile.client.core.TiEntryPoint;
import com.emitrom.ti4j.myrecipes.client.controller.AppController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyRecipes extends TiEntryPoint {
    @Override
    public void onStart() {
        AppController.get().startApp();
    }
}