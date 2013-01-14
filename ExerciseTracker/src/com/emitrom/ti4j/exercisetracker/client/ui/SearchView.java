package com.emitrom.ti4j.exercisetracker.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.Button;
import com.emitrom.gwt4.ti.mobile.client.ui.TextField;
import com.emitrom.gwt4.ti.mobile.client.ui.View;

/**
 * Implements the searchview
 * 
 */
public class SearchView extends View {

    private final static SearchView INSTANCE = new SearchView();

    public static SearchView get() {
        return INSTANCE;
    }

    private TextField startLocationTf;
    private TextField endLocationTf;
    private Button searchButon;

    private SearchView() {
        this.setTop(0);
        this.setLeft(0);
        this.setWidth(320);
        this.setHeight(320);
        this.setHeight(110);
        this.setBackgroundImage("exercise/gradient.png");

        View bottomBorder = new View();
        bottomBorder.setHeight(1);
        bottomBorder.setWidth(320);
        bottomBorder.setLeft(0);
        bottomBorder.setBottom(0);
        bottomBorder.setBackgroundColor("#000");
        this.add(bottomBorder);

        startLocationTf = new TextField();
        startLocationTf.setBackgroundColor("#FFF");
        startLocationTf.setLeft(10);
        startLocationTf.setTop(20);
        startLocationTf.setWidth(200);
        startLocationTf.setHeight(30);
        startLocationTf.setBorderRadius(5);
        startLocationTf.setHintText("Current location");
        this.add(startLocationTf);

        endLocationTf = new TextField();
        endLocationTf.setBackgroundColor("#FFF");
        endLocationTf.setLeft(10);
        endLocationTf.setTop(60);
        endLocationTf.setWidth(200);
        endLocationTf.setHeight(30);
        endLocationTf.setBorderRadius(5);
        endLocationTf.setHintText("End location");
        endLocationTf.setPaddingLeft(10);
        this.add(endLocationTf);

        searchButon = new Button();
        searchButon.setWidth(80);
        searchButon.setHeight(30);
        searchButon.setTop(60);
        searchButon.setRight(10);
        searchButon.setBackgroundImage("exercise/search.png");
        searchButon.setBorderRadius(3);
        this.add(searchButon);

    }

    public TextField getStartLocationTextField() {
        return startLocationTf;
    }

    public TextField getEndLocationTextField() {
        return endLocationTf;
    }

    public Button getSearchButton() {
        return searchButon;
    }

}
