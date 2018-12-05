package com.ecc.ui.keypair;

/**
 * Created by ramiawar on 3/21/17.
 */

import com.ecc.ui.draggable.EffectUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class keypairController implements Initializable{


    private Stage stage;

    @FXML
    MenuBar menuBar;

    @FXML
    TextArea public_key_field;

    @FXML
    TextArea private_key_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void close(ActionEvent event) {

        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }

    public void registerStage(Stage stage){

        this.stage = stage;
        EffectUtilities.makeDraggable(this.stage, this.menuBar);

    }
}
