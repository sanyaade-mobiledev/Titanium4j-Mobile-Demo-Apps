package com.emitrom.ti4j.locancalculator.client.eventbus;

import com.google.gwt.event.shared.EventHandler;

public interface ChartEventHandler extends EventHandler {
    public void onChartEvent(ChartEvent event);
}