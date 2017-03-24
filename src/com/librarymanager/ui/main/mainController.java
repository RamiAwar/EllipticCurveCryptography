package com.librarymanager.ui.main;

import com.jfoenix.controls.JFXButton;
import com.librarymanager.ui.draggable.EffectUtilities;
import com.librarymanager.ui.icons;
import de.jensd.fx.fontawesome.AwesomeIcon;
import de.jensd.fx.fontawesome.Icon;
import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadIcons();

    }

    public void loadIcons(){

        icons.setSize("4em");
        addMemberButton.setGraphic(icons.ADD_USER);
        addBookButton.setGraphic(icons.ADD_BOOK);
        listMembersButton.setGraphic(icons.LIST_BOOKS);
        listBooksButton.setGraphic(icons.LIST_USERS);
        settingsButton.setGraphic(icons.SETTINGS);

    }


}
