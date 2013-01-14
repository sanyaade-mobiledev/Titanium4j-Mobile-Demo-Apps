package com.emitrom.ti4j.holydaymemories.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.TabGroup;
import com.emitrom.ti4j.holydaymemories.client.ui.audio.AudioTab;
import com.emitrom.ti4j.holydaymemories.client.ui.photos.PhotosTab;
import com.emitrom.ti4j.holydaymemories.client.ui.videos.VideosTab;

public class MainTabGroup extends TabGroup {

    private static final MainTabGroup INSTANCE = new MainTabGroup();

    public static MainTabGroup get() {
        return INSTANCE;
    }

    private MainTabGroup() {
        this.addTab(PhotosTab.get());
        this.addTab(VideosTab.get());
        this.addTab(AudioTab.get());
    }
}
