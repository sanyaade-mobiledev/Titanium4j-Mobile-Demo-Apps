package com.emitrom.ti4j.holydaymemories.client.ui.audio;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;
import com.emitrom.ti4j.holydaymemories.client.utils.Assets;

public class AudioTab extends Tab {

    private static final AudioTab INSTANCE = new AudioTab();

    public static AudioTab get() {
        return INSTANCE;
    }

    private AudioTab() {
        this.setTitle("Audio");
        this.setIcon(Assets.getImage("audio.png"));
        this.setWindow(AudioView.get());
    }

}
