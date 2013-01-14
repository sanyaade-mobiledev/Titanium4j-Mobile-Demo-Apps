package com.emitrom.ti4j.photosharing.client;

import com.emitrom.gwt4.ti.mobile.client.core.TiEntryPoint;
import com.emitrom.ti4j.photosharing.client.controller.AppController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhotoSharing extends TiEntryPoint {

    @Override
    public void onStart() {
        AppController.get().startApp();
    }

}