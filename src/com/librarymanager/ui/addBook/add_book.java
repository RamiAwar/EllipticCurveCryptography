package com.librarymanager.ui.addBook;/**
 * Created by ramiawar on 3/18/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class add_book extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("add_book.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadFonts(){
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Roboto-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Roboto-Light.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Roboto-Medium.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Roboto-Thin.ttf"), 14);

    }
}
