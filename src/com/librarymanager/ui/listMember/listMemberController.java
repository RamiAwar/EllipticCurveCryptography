package com.librarymanager.ui.listMember;

/**
 * Created by ramiawar on 3/21/17.
 */

import com.librarymanager.database.DatabaseHandler;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class listMemberController implements Initializable{

    private ObservableList<listMemberController.Member> membersList = FXCollections.observableArrayList();


    @FXML
    private TableColumn<Member, String> email_column;

    @FXML
    private TableColumn<Member, String> phone_column;

    @FXML
    private TableView<Member> table_view;

    @FXML
    private TableColumn<Member, String> lastname_column;

    @FXML
    private TableColumn<Member, Integer> age_column;

    @FXML
    private AnchorPane root_pane;

    @FXML
    private TableColumn<Member, String> firstname_column;

    @FXML
    private TableColumn<Member, Integer> id_column;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();

        loadData();
    }

    private void initColumns(){
        id_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, Integer>("id"));
        firstname_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, String>("firstname"));
        lastname_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, String>("lastname"));
        age_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, Integer>("age"));
        email_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, String>("email"));
        phone_column.setCellValueFactory(new PropertyValueFactory<listMemberController.Member, String>("phone"));
    }

    private void loadData(){
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String query = "SELECT * FROM users";
        ResultSet resultSet = handler.executeQuery(query);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                membersList.add(new listMemberController.Member(id, firstname, lastname, age, email, phone));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table_view.getItems().setAll(membersList);
    }

    public static class Member{

        public int getId() {
            return id.get();
        }
        public String getFirstname() {
            return firstname.get();
        }
        public String getLastname() {
            return lastname.get();
        }
        public int getAge() {
            return age.get();
        }
        public String getEmail() {
            return email.get();
        }
        public String getPhone() {
            return phone.get();
        }


        private final SimpleIntegerProperty id;
        private final SimpleStringProperty firstname;
        private final SimpleStringProperty lastname;
        private final SimpleIntegerProperty age;
        private final SimpleStringProperty email;
        private final SimpleStringProperty phone;

        Member(Integer id, String firstname, String lastname, Integer age, String email, String phone){
            this.id = new SimpleIntegerProperty(id);
            this.firstname = new SimpleStringProperty(firstname);
            this.lastname = new SimpleStringProperty(lastname);
            this.age= new SimpleIntegerProperty(age);
            this.email = new SimpleStringProperty(email);
            this.phone = new SimpleStringProperty(phone);
        }



    }

}
