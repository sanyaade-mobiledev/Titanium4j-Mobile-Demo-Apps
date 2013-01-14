package com.emitrom.ti4j.locancalculator.client;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.app.App;
import com.emitrom.gwt4.ti.mobile.client.core.events.TiEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.EventHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.ui.Button;
import com.emitrom.gwt4.ti.mobile.hybrid.client.core.TiTouch4jEntryPoint;
import com.emitrom.gwt4.touch.client.core.ViewPort;
import com.emitrom.ti4j.locancalculator.client.ui.MainTabGroup;
import com.emitrom.ti4j.locancalculator.client.ui.chart.ChartController;
import com.emitrom.ti4j.locancalculator.client.ui.chart.ChartPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoanCalculator extends TiTouch4jEntryPoint {

    @Override
    public void onNativeLoad() {
        MainTabGroup.get().open();
    }

    @Override
    public void onWebLoad() {
        // Handling event that will be fired from Titanium
        App.get().addEventHandler("loanEvent", new EventHandler() {
            @Override
            public void onEvent(TiEvent event) {
                ChartController.createChart(event);
            }
        });
        // create Touch4j UI
        ViewPort.get().add(ChartPanel.get());

        Button button = new Button("Tap me");
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                Titanium.alert("Hello,World");
            }
        });
    }

}