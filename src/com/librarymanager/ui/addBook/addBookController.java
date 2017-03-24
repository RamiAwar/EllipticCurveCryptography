package com.librarymanager.ui.addBook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.librarymanager.validation.Validator;
import com.librarymanager.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addBookController implements Initializable{

    @FXML
    private JFXButton cancelButton;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private JFXButton addButton;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField title;

    //VALIDATION LABELS
    @FXML
    private Label title_label;
    @FXML
    private Label id_label;
    @FXML
    private Label author_label;
    @FXML
    private Label publisher_label;

    DatabaseHandler databaseHandler;
    Validator bookIDValidator;
    Validator bookTitleValidator;
    Validator bookAuthorValidator;
    Validator bookPublisherValidator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandler = DatabaseHandler.getInstance();

        setupValidators();

    }


    @FXML
    void addBook(ActionEvent event) {

        Boolean BOOK_EXISTS = false;

        // Check if all fields nonempty\
        //& NOT &&
        if(bookIDValidator.validateNonempty() &
            bookTitleValidator.validateNonempty() &
            bookAuthorValidator.validateNonempty() &
            bookPublisherValidator.validateNonempty()){

            //TODO: Check if book ID exists before allowing query to be executed to avoid exception
            //
            //
            //
            //

            String _id = id.getText();
            String _title = title.getText();
            String _author = author.getText();
            String _publisher = publisher.getText();

            String searchQuery = "SELECT * FROM books WHERE id = '" + _id+ "';";

            ResultSet check = databaseHandler.executeQuery(searchQuery);

            try {
                if(check.next()){
                    BOOK_EXISTS = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Insert into database
            String action = "INSERT INTO books (id, title, author, publisher, available) VALUES ('" +
                    _id + "', '" +
                    _title + "', '" +
                    _author + "', '" +
                    _publisher + "', " + true + ");";

            //USER && because we need second condition execution to be skipped if book exists
            //Or else SQL Exception will be generated.
            if(!BOOK_EXISTS && databaseHandler.executeAction(action)){

                //TODO: Close window and display snackbar on main window
                System.out.println("Insertion successful.");
                //
                //
                //
                //
                //

            }else{
                //HANDLE DATABASE ENTRY ERROR (Shouldnt occur since data validated) ~> error is no connection
                //TODO: Display connection error message
                System.out.println("Book already exists. Please enter another book.");


            }

        }else{
            return;
        }








    }

    @FXML
    void cancel(ActionEvent event) {
        //TODO: Close window and do not display anything
        //
        //
        //
        //
        //
        //
        //
        //
    }

    void setupValidators(){

        bookIDValidator = new Validator(id_label, id,  "Please enter a book ID");
        bookIDValidator.createNumberValidator(Validator.NUMBER);

        bookTitleValidator = new Validator(title_label, title,  "Please enter a book title");
        bookTitleValidator.createNonEmptyValidator();

        bookAuthorValidator = new Validator(author_label, author, "Please enter a book author");
        bookAuthorValidator.createNonEmptyValidator();

        bookPublisherValidator = new Validator(publisher_label, publisher, "Please enter a book publisher");
        bookPublisherValidator.createNonEmptyValidator();

    }
}

