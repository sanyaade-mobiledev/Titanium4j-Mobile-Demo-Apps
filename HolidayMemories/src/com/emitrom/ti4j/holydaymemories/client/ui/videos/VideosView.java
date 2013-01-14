package com.emitrom.ti4j.holydaymemories.client.ui.videos;

import com.emitrom.gwt4.ti.mobile.client.ui.Window;
import com.emitrom.ti4j.holydaymemories.client.utils.Assets;

public class VideosView extends Window {

    private static final VideosView INSTANCE = new VideosView();

    public static VideosView get() {
        return INSTANCE;
    }

    private VideosView() {
        this.setTitle("Video");
        this.setBarColor("#000");
        this.setBackgroundImage(Assets.getImage("background.png"));
    }
}
