package com.emitrom.ti4j.holydaymemories.client;

import com.emitrom.gwt4.ti.mobile.client.core.TiEntryPoint;
import com.emitrom.ti4j.holydaymemories.client.controller.AppController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HolidayMemories extends TiEntryPoint {
    public void onStart() {
        AppController.get().startApp();
    }
}