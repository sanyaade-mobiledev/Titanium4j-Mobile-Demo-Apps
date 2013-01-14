package com.emitrom.ti4j.holydaymemories.client.ui.photos;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;
import com.emitrom.ti4j.holydaymemories.client.utils.Assets;

public class PhotosTab extends Tab {

    private static final PhotosTab INSTANCE = new PhotosTab();

    public static PhotosTab get() {
        return INSTANCE;
    }

    private PhotosTab() {
        this.setTitle("Photos");
        this.setIcon(Assets.getImage("photos.png"));
        this.setWindow(PhotosView.get());
    }
}
