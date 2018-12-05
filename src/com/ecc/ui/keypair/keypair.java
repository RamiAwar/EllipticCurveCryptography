package com.ecc.ui.keypair;
/**
 * Created by ramiawar on 3/21/17.
 */

import com.ecc.ui.main.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class keypair extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = main.getLoader();
        Parent root = loader.load(getClass().getResource("list_member.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
