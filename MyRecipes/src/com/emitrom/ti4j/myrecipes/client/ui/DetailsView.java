package com.emitrom.ti4j.myrecipes.client.ui;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.api.API;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.platform.Platform;
import com.emitrom.gwt4.ti.mobile.client.ui.Button;
import com.emitrom.gwt4.ti.mobile.client.ui.Label;
import com.emitrom.gwt4.ti.mobile.client.ui.WebView;
import com.emitrom.gwt4.ti.mobile.client.ui.Window;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;
import com.emitrom.ti4j.myrecipes.client.database.RecipeDatabase;
import com.emitrom.ti4j.myrecipes.client.ui.recipes.RecipesTab;

/**
 * Implements the details view of a given recipe
 * 
 */
public class DetailsView extends Window {

    private String title;
    private String description;
    private String link;
    private Button favButton;
    private final String ADD_FAV_TEXT = "Add Favorite";
    private final String REMOVE_FAV_TEXT = "Remove Favorite";
    private final String VIEW_IN_SAFARI = "View in Safari";
    private int id;
    private Button linkButton;

    public DetailsView() {
        this("", "", "");
    }

    public DetailsView(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;

        this.setTitle(title);
        this.setBackgroundColor(Color.WHITE);

        favButton = new Button("Add Favorite");
        favButton.setLeft(10);
        favButton.setTop(10);
        favButton.setWidth(140);
        favButton.setHeight(30);
        favButton.addClickHandler(favoritesHandler);
        this.add(favButton);

        linkButton = new Button(VIEW_IN_SAFARI);
        linkButton.setRight(10);
        linkButton.setTop(10);
        linkButton.setWidth(140);
        linkButton.setHeight(30);
        linkButton.addClickHandler(linkHandler);
        this.add(linkButton);

        Label descriptionLabel = new Label(description);
        descriptionLabel.setLeft(10);
        descriptionLabel.setTop(50);
        descriptionLabel.setWidth(300);
        descriptionLabel.setHeight("auto");
        descriptionLabel.setColor(Color.BLACK);
        this.add(descriptionLabel);

    }

    private InteractionHandler favoritesHandler = new InteractionHandler() {
        @Override
        public void onClick(InteractionEvent event) {
            if (favButton.getTitle().equalsIgnoreCase(ADD_FAV_TEXT)) {
                API.get().info("About to insert favorite : " + title);
                int newId = RecipeDatabase.get().insertFavorite(title, description, link);
                API.get().info("Newly inserted favorite id : " + newId);
                DetailsView.this.id = newId;
                Titanium.alert("This recipe has been added as a favorite !");
                favButton.setTitle(REMOVE_FAV_TEXT);
            } else if (favButton.getTitle().equalsIgnoreCase(REMOVE_FAV_TEXT)) {
                int id = DetailsView.this.id;
                if (id > 0) {
                    RecipeDatabase.get().deleteFavorite(id);
                    API.get().info("Deleted favorite with the id " + id);
                    DetailsView.this.id = 0;
                    Titanium.alert("This Receipe has been removed from the favorites");
                    favButton.setTitle(ADD_FAV_TEXT);
                }
            }

        }
    };

    private InteractionHandler linkHandler = new InteractionHandler() {
        @Override
        public void onClick(InteractionEvent event) {
            if (Platform.get().isAndroid()) {
                Platform.get().openURL(link);
            } else {
                createWebView(link);
            }

        }

    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    private void createWebView(String link) {
        Window w = new Window(link);
        WebView view = new WebView(link);
        w.add(view);
        RecipesTab.get().open(w);
    }
}
