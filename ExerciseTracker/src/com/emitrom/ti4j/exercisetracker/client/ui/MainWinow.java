package com.emitrom.ti4j.exercisetracker.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.Window;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;

/**
 * Main Application Window
 */
public class MainWinow extends Window {

    private static final MainWinow INSTANCE = new MainWinow();

    public static MainWinow get() {
        return INSTANCE;
    }

    private MainWinow() {
        this.setBackgroundColor(Color.WHITE);
        this.setTitle("Exersice Tracker");
        this.add(SearchView.get());
        this.add(MainMapView.get());
    }
}
