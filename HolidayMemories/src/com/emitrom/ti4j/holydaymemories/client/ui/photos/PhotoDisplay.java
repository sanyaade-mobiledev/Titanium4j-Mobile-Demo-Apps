package com.emitrom.ti4j.holydaymemories.client.ui.photos;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.ti.mobile.client.ui.ScrollableView;
import com.emitrom.gwt4.ti.mobile.client.ui.View;

public class PhotoDisplay extends ScrollableView {

    private static final PhotoDisplay INSTANCE = new PhotoDisplay();
    List<View> views = new ArrayList<View>();

    public static PhotoDisplay get() {
        return INSTANCE;
    }

    private PhotoDisplay() {
        this.setLeft(17);
        this.setTop(15);
        this.setCurrentPage(0);
        this.setViews(views);
    }

    public List<View> getViews() {
        return views;
    }
}
