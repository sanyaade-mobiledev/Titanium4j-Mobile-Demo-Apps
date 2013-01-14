package com.emitrom.ti4j.exercisetracker.client.controler;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.core.Debugger;
import com.emitrom.gwt4.ti.mobile.client.core.events.geolocation.GeolocationHandler;
import com.emitrom.gwt4.ti.mobile.client.core.events.geolocation.LocationEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.geolocation.GeocoderCallback;
import com.emitrom.gwt4.ti.mobile.client.geolocation.Geolocation;
import com.emitrom.gwt4.ti.mobile.client.geolocation.Place;
import com.emitrom.gwt4.ti.mobile.client.map.Region;
import com.emitrom.ti4j.exercisetracker.client.ui.MainMapView;
import com.emitrom.ti4j.exercisetracker.client.ui.MainWinow;
import com.emitrom.ti4j.exercisetracker.client.ui.SearchView;

public class AppController {

    private static final AppController INSTANCE = new AppController();
    private static final String GEOLOCATION_PURPOSE = "To obtain user location for tracking";
    private static final String GEOLOCATION_NOT_AVAILABLE = "Sorry, but it seems geo location is not available ou your device";

    public static AppController get() {
        return INSTANCE;
    }

    public void startApp() {
        MainWinow.get().open();
        getCurrentLocation();
        bind();
    }

    private void getCurrentLocation() {
        Geolocation.get().setDistanceFilter(10);
        // Necessary because of apple new security policies
        Geolocation.get().setPurpose(GEOLOCATION_PURPOSE);
        Geolocation.get().getCurrentPosition(new GeolocationHandler() {
            @Override
            public void onEvent(LocationEvent event) {
                if (event.isSuccess()) {
                    double longitude = event.getCoords().getLongitude();
                    double latitude = event.getCoords().getLatitude();
                    double altitude = event.getCoords().getAltitude();
                    double heading = event.getCoords().getHeading();
                    double accuracy = event.getCoords().getAccuracy();
                    double timeStamp = event.getCoords().getTimestamp();

                    Region region = new Region();
                    region.setLatitude(latitude);
                    region.setLongitude(longitude);
                    region.setLongitudeDelta(0.5);
                    region.setLatitudeDelta(0.5);
                    MainMapView.get().setRegion(region);

                } else {
                    Titanium.alert("Geolocation", GEOLOCATION_NOT_AVAILABLE);
                }
            }
        });
    }

    private void bind() {
        SearchView.get().getSearchButton().addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                String startLocation = SearchView.get().getStartLocationTextField().getValue();
                if (startLocation == null || startLocation.isEmpty() || startLocation == "") {
                    Titanium.alert("You must provide a start address !");
                } else {
                    Geolocation.get().forwardGeocoder(startLocation, new GeocoderCallback() {
                        @Override
                        public void onEvent(Place place) {
                            Debugger.get().info("Geocode succeded !");
                            Debugger.get().info(
                                            "Startlocation coordinates are : " + place.getLatitude() + " lat, "
                                                            + place.getLatitude() + " lgn.");
                            Region region = new Region();
                            region.setLatitude(place.getLatitude());
                            region.setLongitude(place.getLongitude());
                            region.setLongitudeDelta(0.5);
                            region.setLatitudeDelta(0.5);
                            MainMapView.get().setRegion(region);
                        }
                    });
                }
                String endLocation = SearchView.get().getEndLocationTextField().getValue();
                if (endLocation == null || endLocation.isEmpty() || endLocation == "") {
                    Titanium.alert("You must provide an end address !");
                } else {
                    Geolocation.get().forwardGeocoder(startLocation, new GeocoderCallback() {
                        @Override
                        public void onEvent(Place place) {
                            Debugger.get().info("Geocode succeded !");
                            Debugger.get().info(
                                            "Endlocation coordinates are : " + place.getLatitude() + " lat, "
                                                            + place.getLatitude() + " lgn.");
                        }
                    });
                }

            }
        });
    }
}
