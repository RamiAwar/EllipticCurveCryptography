package com.librarymanager.ui.addMember;

/**
 * Created by ramiawar on 3/21/17.
 */

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

public class addMemberController implements Initializable {

    @FXML
    private Label phone_label;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private Label lastname_label;

    @FXML
    private JFXTextField phone;

    @FXML
    private Label email_label;

    @FXML
    private Label firstname_label;

    @FXML
    private JFXButton addButton;

    @FXML
    private Label age_label;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField lastname;

    private DatabaseHandler handler;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        handler = new DatabaseHandler();

        setupValidators();
    }


    Validator firstnameValidator;
    Validator lastnameValidator;
    Validator emailValidator;
    Validator ageValidator;

    @FXML
    void addMember(ActionEvent event) {

        Boolean USER_EXISTS = false;

        if(firstnameValidator.validateNonempty() &
                lastnameValidator.validateNonempty() &
                emailValidator.validateNonempty() &
                ageValidator.validateNonempty()) {

            //Enter data into database
            String _firstname = firstname.getText();
            String _lastname = lastname.getText();
            int _age = Integer.parseInt(age.getText());
            String _phone = phone.getText();
            String _email = email.getText();

            //Check if user exists before allowing query to be executed to avoid duplicates
            String searchQuery = "SELECT * FROM users WHERE email = '" + _email +
                                "' and firstname = '" + _firstname +
                                "' and lastname = '" + _lastname + "';";

            ResultSet check = handler.executeQuery(searchQuery);

            try {
                if(check.next()){
                    USER_EXISTS = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Insert into database
            String query = "INSERT INTO users (firstname, lastname, age, email, phone) VALUES ('" +
                    _firstname + "', '" +
                    _lastname + "', '" +
                    _age + "', '" +
                    _email + "','" +
                    _phone + "');";

            if(!USER_EXISTS && handler.executeAction(query)){

                //TODO: Close window and display snackbar on main window
                System.out.println("Insertion successful.");
                //
                //
                //
                //
                //

            }else{
                //TODO: HANDLE DATABASE ENTRY ERROR (Shouldnt occur since data validated)
                System.out.println("User already exists.");
                //
                //
                //
                //
                //

            }

        }
    }

    @FXML
    void cancel(ActionEvent event) {

    }






    void setupValidators(){
        firstnameValidator = new Validator(firstname_label, firstname, "Required");
        firstnameValidator.createNonEmptyValidator();

        lastnameValidator = new Validator(lastname_label, lastname, "Required");
        lastnameValidator.createNonEmptyValidator();

        emailValidator = new Validator(email_label, email, "Required");
        emailValidator.createEmailValidator();

        ageValidator = new Validator(age_label, age, "Required");
        ageValidator.createNumberValidator(Validator.AGE);

    }




//    private void loadData(){
//        DatabaseHandler handler = new DatabaseHandler();
//        String query = "SELECT * FROM books";
//        ResultSet resultSet = handler.executeQuery(query);
//        try {
//            while (resultSet.next()) {
//                String title = resultSet.getString("title");
//                String id = Integer.toString(resultSet.getInt("id"));
//                Boolean availability = resultSet.getBoolean("available");
//                String author = resultSet.getString("author");
//                String publisher = resultSet.getString("publisher");
//
//                list.add(new com.librarymanager.ui.listBook.listBookController.Book(id, title, author, publisher, availability));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        table_view.getItems().setAll(list);
//    }


}
