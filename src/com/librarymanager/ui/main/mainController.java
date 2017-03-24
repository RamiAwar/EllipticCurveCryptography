package com.librarymanager.ui.main;

import com.jfoenix.controls.JFXButton;
import com.librarymanager.ui.draggable.EffectUtilities;
import com.librarymanager.ui.icons.icons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ramiawar on 3/23/17.
 */
public class mainController implements Initializable{

    @FXML
    JFXButton addMemberButton;

    @FXML
    JFXButton addBookButton;

    @FXML
    JFXButton listMembersButton;

    @FXML
    JFXButton listBooksButton;

    @FXML
    JFXButton settingsButton;

    @FXML
    MenuBar menuBar;

    @FXML
    MenuItem closeMenuItem;


    private double xOffset;
    private double yOffset;
    private Stage stage;

    //Receiving stage from main class to make window draggable
    void registerStage(Stage stage){
        this.stage = stage;
        EffectUtilities.makeDraggable(stage, menuBar);
    }

    @FXML
    void close(ActionEvent event) {

        Stage stage = (Stage) addMemberButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loadAddMember(ActionEvent event) {
        loadWindow("/com/librarymanager/ui/addMember/add_member.fxml", "New Member");
    }

    @FXML
    void loadAddBook(ActionEvent event) {
        loadWindow("/com/librarymanager/ui/addBook/add_book.fxml", "New Book");
    }

    @FXML
    void loadMembersList(ActionEvent event) {
        loadWindow("/com/librarymanager/ui/listMember/list_member.fxml", "Members");
    }

    @FXML
    void loadBooksList(ActionEvent event) {
        loadWindow("/com/librarymanager/ui/listBook/list_book.fxml", "Books");
    }

    void loadWindow(String location, String title){
        try {

            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadIcons();

    }

    public void loadIcons(){

        //Setting icons on buttons using **ui.icons.icons** class
        icons.setSize("4em");
        addMemberButton.setGraphic(icons.ADD_USER);
        addBookButton.setGraphic(icons.ADD_BOOK);
        listMembersButton.setGraphic(icons.LIST_BOOKS);
        listBooksButton.setGraphic(icons.LIST_USERS);
        settingsButton.setGraphic(icons.SETTINGS);

    }


}
