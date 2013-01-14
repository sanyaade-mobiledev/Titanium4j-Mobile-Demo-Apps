package com.emitrom.ti4j.holydaymemories.client.controller;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.blob.Blob;
import com.emitrom.gwt4.ti.mobile.client.core.Debugger;
import com.emitrom.gwt4.ti.mobile.client.core.events.LineChangeEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.RecordingInputEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.media.MediaError;
import com.emitrom.gwt4.ti.mobile.client.core.events.media.MediaEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.media.VolumentEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.dialog.DialogClickEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.scrollview.ScrollableViewEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.media.LineChangeHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.media.RecordingInputHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.media.VolumeHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.DialogClickHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.ScrollableViewScrollHandler;
import com.emitrom.gwt4.ti.mobile.client.filesystem.File;
import com.emitrom.gwt4.ti.mobile.client.filesystem.FileSystem;
import com.emitrom.gwt4.ti.mobile.client.media.AudioRecorder;
import com.emitrom.gwt4.ti.mobile.client.media.Media;
import com.emitrom.gwt4.ti.mobile.client.media.MediaOptionsType;
import com.emitrom.gwt4.ti.mobile.client.media.MediaSelectionCallback;
import com.emitrom.gwt4.ti.mobile.client.ui.ImageView;
import com.emitrom.gwt4.ti.mobile.client.ui.OptionDialog;
import com.emitrom.ti4j.holydaymemories.client.ui.MainTabGroup;
import com.emitrom.ti4j.holydaymemories.client.ui.audio.AudioView;
import com.emitrom.ti4j.holydaymemories.client.ui.photos.PhotoDisplay;
import com.emitrom.ti4j.holydaymemories.client.ui.photos.PhotosView;

public class AppController {

    private static final AppController INSTANCE = new AppController();

    public static AppController get() {
        return INSTANCE;
    }

    private AppController() {
        bind();
    }

    public void startApp() {
        MainTabGroup.get().open();
    }

    private void bind() {
        bindPhotoView();
        bindPhotoDisplay();
        bindSavePhoto();
        bindAudio();
    }

    private void bindPhotoView() {
        PhotosView.get().getChooseButton().addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                OptionDialog dialog = new OptionDialog();
                dialog.setTitle("Choose an image source...");
                dialog.setOptions("Camera", "Photo Gallery", "Cancel");
                dialog.setCancel(2);
                dialog.addClickHandler(new DialogClickHandler() {
                    @Override
                    public void onClick(DialogClickEvent event) {
                        Debugger.get().info("You selected : " + event.getIndex());
                        if (event.getIndex() == 0) {
                            loadImageWithCamera();
                        } else if (event.getIndex() == 1) {
                            loadImageWithPhotoGallery();
                        }
                    }

                });
                dialog.show();
            }
        });
    }

    private void loadImageWithCamera() {
        MediaOptionsType options = new MediaOptionsType();
        options.setAllowEditing(true);
        options.setSaveToPhotoGallery(false);
        options.setCallback(new MediaSelectionCallback() {
            @Override
            public void onSuccess(MediaEvent event) {
                Debugger.get().info("Camera sucess with mediatype : " + event.getMediaType());
                handleEvent(event);
            }

            @Override
            public void onError(MediaError error) {
                Titanium.alert("The camera seems to not be available. Make sure you run the application on a real device.");
            }

            @Override
            public void onCancel() {
                Titanium.alert("Getting image from Camera was cancelled.");
            }
        });
        Media.get().showCamera(options);
    }

    private void loadImageWithPhotoGallery() {
        Media.get().openPhotoGallery(new MediaSelectionCallback() {
            @Override
            public void onSuccess(MediaEvent event) {
                Debugger.get().info("Photogalerry sucess with mediatype : " + event.getMediaType());
                handleEvent(event);
            }

            @Override
            public void onError(MediaError error) {
                Titanium.alert("Error getting image from photo gallery.");
            }

            @Override
            public void onCancel() {
                Titanium.alert("Getting image from photo gallery was cancelled.");
            }
        });
    }

    private void bindPhotoDisplay() {
        PhotoDisplay.get().addScrollHandler(new ScrollableViewScrollHandler() {
            @Override
            public void onScroll(ScrollableViewEvent event) {
                Debugger.get().info("Current page : " + PhotoDisplay.get().getCurrentPage());
            }
        });
    }

    private void handleEvent(MediaEvent event) {
        Blob blob = event.getMedia();
        if (event.getMediaType() == Media.MEDIA_TYPE_PHOTO) {
            ImageView imageView = new ImageView();
            imageView.setTop(20);
            imageView.setLeft(20);
            imageView.setBottom(20);
            imageView.setRight(20);
            imageView.setImage(blob);
            PhotoDisplay.get().addView(imageView);
        }
    }

    private void bindSavePhoto() {
        PhotosView.get().getSaveButton().addClickHandler(new InteractionHandler() {
            @Override
            public void onClick(InteractionEvent event) {
                Blob media = PhotoDisplay.get().toImage();
                Debugger.get().info("Bload creation success");
                // if it does not exist create a directory called "photos"
                File dir = FileSystem.get().getFile(FileSystem.get().getApplicationDataDirectory() + "photos");
                Debugger.get().info("Get file success");
                if (!dir.exists()) {
                    dir.createDirectory();
                    Debugger.get().info("Creation dir success");
                }

                String fileName = "photo-" + PhotoDisplay.get().getCurrentPage() + ".png";
                File fileToWrite = FileSystem.get().getFile(dir.getNativePath() + fileName);
                fileToWrite.write(media);
                Titanium.alert("You save a file called " + fileName + " to the directory " + dir.getNativePath());

                File imageFile = FileSystem.get().getFile(dir.getNativePath() + fileName);
                if (!imageFile.exists()) {
                    Debugger.get().info(
                                    "ERROR : thie file " + fileName + " in the directory : " + dir.getNativePath()
                                                    + " does not exist !");
                } else {
                    Debugger.get().info(
                                    "OKEY! : thie file " + fileName + " in the directory : " + dir.getNativePath()
                                                    + " does exist !");
                }
            }
        });
    }

    private void bindAudio() {
        final AudioRecorder recording = Media.get().createAudioRecorder();
        recording.setCompression(Media.AUDIO_FORMAT_LINEAR_PCM);
        recording.setFormat(Media.AUDIO_FILEFORMAT_CAF);

        Media.get().addRecordinginputHandler(new RecordingInputHandler() {
            @Override
            public void onEvent(RecordingInputEvent event) {
                Debugger.get().info("Input availibility changed : " + event.isAvailable());
                if (event.isAvailable() && recording.isRecording()) {

                }
            }
        });
        Media.get().addLineChangeHandler(new LineChangeHandler() {
            @Override
            public void onLineChange(LineChangeEvent event) {
                AudioView.get().getLineType().setText("audio line type : " + AudioView.get().getLineTypeString());
            }
        });
        Media.get().addVolumeHandler(new VolumeHandler() {
            @Override
            public void onEvent(VolumentEvent event) {
                AudioView.get().getVolume().setText("Volume : " + event.getVolume());
            }
        });
    }
}
