package com.librarymanager.ui.main;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.fontawesome.AwesomeIcon;
import de.jensd.fx.fontawesome.Icon;
import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ramiawar on 3/23/17.
 */
public class mainController implements Initializable{

    FontAwesomeIconView ADD_USER;
    FontAwesomeIconView LIST_USERS;
    FontAwesomeIconView ADD_BOOK;
    FontAwesomeIconView LIST_BOOKS;
    FontAwesomeIconView SETTINGS;

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
    MenuItem closeMenuItem;

    @FXML
    void close(ActionEvent event) {

        Stage stage = (Stage) addMemberButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadIcons();

    }

    public void loadIcons(){

        ADD_USER = new FontAwesomeIconView(FontAwesomeIcon.USER_PLUS);
        ADD_USER.setSize("2em");
        LIST_USERS = new FontAwesomeIconView(FontAwesomeIcon.USERS);
        LIST_USERS.setSize("2em");
        ADD_BOOK = new FontAwesomeIconView(FontAwesomeIcon.LEANPUB);
        ADD_BOOK.setSize("2em");
        LIST_BOOKS = new FontAwesomeIconView(FontAwesomeIcon.LIST);
        LIST_BOOKS.setSize("2em");
        SETTINGS = new FontAwesomeIconView(FontAwesomeIcon.COG);
        SETTINGS.setSize("2em");

        addMemberButton.setGraphic(ADD_USER);
        addBookButton.setGraphic(ADD_BOOK);
        listMembersButton.setGraphic(LIST_BOOKS);
        listBooksButton.setGraphic(LIST_USERS);
        settingsButton.setGraphic(SETTINGS);

    }
}
