package com.emitrom.ti4j.exercisetracker.client.ui;

import com.emitrom.gwt4.ti.mobile.client.map.Map;
import com.emitrom.gwt4.ti.mobile.client.map.MapView;
import com.emitrom.gwt4.ti.mobile.client.map.Region;

public class MainMapView extends MapView {
    private static final MainMapView INSTANCE = new MainMapView();

    public static MainMapView get() {
        return INSTANCE;
    }

    private MainMapView() {
        this.setTop(110);
        this.setHeight(350);
        this.setMapType(Map.STANDARD_TYPE);

        Region region = new Region();
        region.setLatitude(51.50015);
        region.setLongitude(-0.12623);
        region.setLatitudeDelta(0.5);
        region.setLongitudeDelta(0.5);
        this.setRegion(region);

        this.setAnimate(true);
        this.setRegionFit(true);
        this.setUserLocation(true);
    }

}
