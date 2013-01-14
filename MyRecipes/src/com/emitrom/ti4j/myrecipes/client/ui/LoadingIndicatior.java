package com.emitrom.ti4j.myrecipes.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.ActivityIndicator;
import com.emitrom.gwt4.ti.mobile.client.ui.iphone.ActivityIndicatorStyle;

public class LoadingIndicatior extends ActivityIndicator {

    private static final LoadingIndicatior INSTANCE = new LoadingIndicatior();

    private LoadingIndicatior() {
        setHeight("auto");
        setWidth("auto");
        this.setTop(10);
        this.setLeft(10);
        this.setColor("green");
        this.setStyle(ActivityIndicatorStyle.DARK);
        setMessage("Loading data ...");

    }

    public static LoadingIndicatior get() {
        return INSTANCE;
    }

}
