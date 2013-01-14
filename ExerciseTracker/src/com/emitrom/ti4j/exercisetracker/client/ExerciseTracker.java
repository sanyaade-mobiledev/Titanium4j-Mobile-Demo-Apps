package com.emitrom.ti4j.exercisetracker.client;

import com.emitrom.gwt4.ti.mobile.client.core.TiEntryPoint;
import com.emitrom.ti4j.exercisetracker.client.controler.AppController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExerciseTracker extends TiEntryPoint {

    @Override
    public void onStart() {
        AppController.get().startApp();
    }

}