package com.emitrom.ti4j.holydaymemories.client.ui.videos;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;
import com.emitrom.ti4j.holydaymemories.client.utils.Assets;

public class VideosTab extends Tab {

    private static final VideosTab INSTANCE = new VideosTab();

    public static VideosTab get() {
        return INSTANCE;
    }

    private VideosTab() {
        this.setTitle("Video");
        this.setIcon(Assets.getImage("movies.png"));
        this.setWindow(VideosView.get());
    }
}
