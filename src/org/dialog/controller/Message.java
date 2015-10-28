package org.dialog.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.dialog.Dialog;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Message implements Initializable {

    public enum TYPES{INFO, ERROR, WARNING, CONFIRM}

    @FXML
    protected Label lbl;

    @FXML
    protected ImageView iconImage;

    @FXML
    protected HBox hbox;

    protected Button btnYES = new Button("SI");

    protected Button btnNO = new Button("NO");

    protected Button btnCancel = new Button("Cancel");

    protected Stage currentStage;

    protected Map<TYPES, String> icons = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        icons.put(TYPES.INFO, "assets/info.jpg");
        icons.put(TYPES.ERROR, "assets/error.jpg");
        icons.put(TYPES.WARNING, "assets/warning.jpg");
        icons.put(TYPES.CONFIRM, "assets/confirm.jpg");

        hbox.setSpacing(10);
    }

    public void setMessage(String message, TYPES type) {
        this.lbl.setText(message);
        setIcon(type);
    }

    public void setMessage(String message) {
        setMessage(message, TYPES.INFO);
    }

    public void setIcon(TYPES type) {
        String url = Dialog.newInstance().getClass().getResource(icons.get(type)).toString();
        iconImage.setImage(new Image(url));
    }

    public void addYesButton(EventHandler<ActionEvent> event, boolean closeBox, String lblText) {
        btnYES.setVisible(true);
        btnYES.setOnAction(e -> {
            if(event!=null)
                event.handle(e);

            if(closeBox)
                currentStage.close();
        });
        btnYES.setText(lblText);
        hbox.getChildren().add(btnYES);
    }

    public void addYesButton(EventHandler<ActionEvent> event) {
        addYesButton(event, true, "SI");
    }
    public void addYesButton(EventHandler<ActionEvent> event, String lblText) { addYesButton(event, true, lblText); }

    public void addNoButton(EventHandler<ActionEvent> event, boolean closeBox) {
        btnNO.setVisible(true);
        btnNO.setOnAction(e -> {
            if(event!=null)
                event.handle(e);

            if(closeBox)
                currentStage.close();
        });
        hbox.getChildren().add(btnNO);
    }

    public void addNoButton(EventHandler<ActionEvent> event) {
        addNoButton(event, true);
    }

    public void addCancelButton(EventHandler<ActionEvent> event, boolean closeBox) {
        btnCancel.setVisible(true);
        btnCancel.setOnAction(e -> {
            if(event!=null)
                event.handle(e);

            currentStage.close();
        });
        hbox.getChildren().add(btnCancel);
    }

    public void addCancelButton(EventHandler<ActionEvent> event) {
        addCancelButton(event, true);
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }
}
