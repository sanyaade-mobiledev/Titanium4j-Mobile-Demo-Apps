package com.emitrom.ti4j.photosharing.client.controller;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.blob.Blob;
import com.emitrom.gwt4.ti.mobile.client.core.Debugger;
import com.emitrom.gwt4.ti.mobile.client.core.events.media.MediaError;
import com.emitrom.gwt4.ti.mobile.client.core.events.media.MediaEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.filesystem.File;
import com.emitrom.gwt4.ti.mobile.client.filesystem.FileSystem;
import com.emitrom.gwt4.ti.mobile.client.media.Media;
import com.emitrom.gwt4.ti.mobile.client.media.MediaSelectionCallback;
import com.emitrom.gwt4.ti.mobile.client.ui.EmailDialog;
import com.emitrom.gwt4.ti.mobile.client.ui.UI;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;
import com.emitrom.ti4j.photosharing.client.ui.MainWindow;

public class AppController {

    private static final AppController INSTANCE = new AppController();
    private Blob selectedImage;

    public static AppController get() {
        return INSTANCE;
    }

    private AppController() {
        bind();
    }

    public void startApp() {
        UI.get().setBackgroundColor(Color.BLACK);
        MainWindow.get().open();
    }

    private void bind() {
        MainWindow.get().getChooseButton().addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                Media.get().openPhotoGallery(new MediaSelectionCallback() {
                    @Override
                    public void onSuccess(MediaEvent event) {
                        selectedImage = event.getMedia();
                        MainWindow.get().getThumbNail().setImage(selectedImage);
                    }

                    @Override
                    public void onError(MediaError error) {
                        Titanium.alert("Error getting image from photo gallery : " + error.getCode());
                    }

                    @Override
                    public void onCancel() {

                    }
                });
            }
        });
        MainWindow.get().getEmailButton().addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                if (selectedImage == null) {
                    Titanium.alert("You must select an image first !!!");
                } else {
                    sendEmail();
                }
            }
        });
    }

    private void sendEmail() {
        File dir = FileSystem.get().getFile(FileSystem.get().getApplicationDataDirectory() + "attachments");
        if (!dir.exists()) {
            dir.createDirectory();
        }

        File file = FileSystem.get().getFile(dir.getNativePath() + "temp-image.jpg");
        file.write(selectedImage);

        EmailDialog emailDialog = new EmailDialog();
        Debugger.get().print(emailDialog);
        emailDialog.setSubject(MainWindow.get().getTitleField().getValue());
        emailDialog.setToRecipients("jazzmatadazz@gmail.com");
        emailDialog.setMessageBody(MainWindow.get().getMessageField().getValue());
        emailDialog.addAttachment(file);
        emailDialog.open();
    }
}
