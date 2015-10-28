package org.dialog;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.dialog.controller.Message;

import java.io.IOException;


public class Dialog {

    protected Stage stage;

    protected Message ctrlMessage;

    public static Dialog newInstance() {
        return new Dialog();
    }

    public Dialog() {
        stage = new Stage();
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/message.fxml"));

        Parent p;
        try {
            p = loader.load();

            ctrlMessage = loader.getController();
            ctrlMessage.setCurrentStage(stage);

        } catch(IOException io) {
            System.out.println("Sistema interrotto");
            return;
        }

        Scene scene = new Scene(p);
        stage.setScene(scene);
    }

    public void info(String message) {
        ctrlMessage.setMessage(message, Message.TYPES.INFO);
        ctrlMessage.addYesButton(null, true, "Chiudi");
    }

    public void warning(String message) {
        ctrlMessage.setMessage(message, Message.TYPES.WARNING);
        ctrlMessage.addYesButton(null, true, "Chiudi");
    }

    public void error(String message) {
        ctrlMessage.setMessage(message, Message.TYPES.ERROR);
        ctrlMessage.addYesButton(null, true, "Chiudi");
    }

    public void confirm(EventHandler<ActionEvent> okEvent, EventHandler<ActionEvent> noEvent, String message) {
        ctrlMessage.setMessage(message, Message.TYPES.CONFIRM);
        ctrlMessage.addYesButton(okEvent, true, "OK");
        ctrlMessage.addNoButton(noEvent, true);
        ctrlMessage.addCancelButton(null);
    }

    public void show() {
        stage.show();
    }

}
