package com.ecc.ui.main;

import com.ecc.ecc.EccWrapper;
import com.ecc.ui.draggable.EffectUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

/**
 * Created by ramiawar on 3/23/17.
 */
public class mainController implements Initializable{

    @FXML
    MenuBar menuBar;

    @FXML
    MenuItem closeMenuItem;

    @FXML
    TextArea private_key_field;

    @FXML
    TextArea public_key_field;



    private Stage stage;

    //Receiving stage from main class to make window draggable
    void registerStage(Stage stage){
        this.stage = stage;
        EffectUtilities.makeDraggable(stage, menuBar);
    }


    @FXML
    void close(ActionEvent event) {

        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void generate_keys(ActionEvent event) {

        // Call C++ modules
        String x = EccWrapper.generate();
        System.out.println(x);

        int index = x.lastIndexOf("_");
        String priv = x.substring(0, index);
        String pub = x.substring(index+1, x.length());

        private_key_field.setText(priv);
        public_key_field.setText(pub);


        // Delete files if exist
//        File file = new File("private.key");
//        try {
//            boolean result = Files.deleteIfExists(file.toPath()); //surround it in try catch block
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Create key files
//        try {
//
//            String private_key = "Hello";
//            String public_key = "";
//
//            BufferedWriter private_writer = new BufferedWriter(new FileWriter("private.key"));
//            BufferedWriter public_writer = new BufferedWriter(new FileWriter("public.key"));
//
//            private_writer.write(private_key);
//            private_writer.close();
//
//            public_writer.write(public_key);
//            public_writer.close();
//
//        }catch(IOException e){
//
//        }

    }


        @Override
        public void initialize(URL location, ResourceBundle resources) {


        }




    }
