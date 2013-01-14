package com.emitrom.ti4j.myrecipes.client.data;

import com.emitrom.gwt4.ti.mobile.client.core.JsoHelper;
import com.emitrom.gwt4.ti.mobile.client.data.TableViewBaseModel;

/**
 * Representation of a Recipe
 * 
 */
public class Recipe extends TableViewBaseModel {

    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String DESCRIPTION = "description";

    public Recipe() {
        jsObj = JsoHelper.createObject();
    }

    public Recipe(String title, String link, String description) {
        this();
        set(TITLE, title);
        set(LINK, link);
        set(DESCRIPTION, description);
    }

    public String getTitle() {
        return getString(TITLE);
    }

    public String getLink() {
        return getString(LINK);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }

}
