package com.emitrom.ti4j.holydaymemories.client.utils;

import com.emitrom.gwt4.ti.mobile.client.platform.Platform;

public class Assets {

    private Assets() {

    }

    public static String getImage(String imageName) {
        String prefix = "";
        if (Platform.get().isAndroid()) {
            prefix = "holiday/";
        } else {
            prefix = "/holiday/";
        }
        return prefix + imageName;
    }
}
