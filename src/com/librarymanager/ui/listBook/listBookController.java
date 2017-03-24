package com.librarymanager.ui.listBook;

/**
 * Created by ramiawar on 3/20/17.
 */

import com.librarymanager.database.DatabaseHandler;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sun.java2d.pipe.SpanShapeRenderer;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class listBookController implements Initializable{

    private ObservableList<Book> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Book> table_view;

    @FXML
    private TableColumn<Book, Boolean> availability_column;

    @FXML
    private TableColumn<Book, String> publisher_column;

    @FXML
    private AnchorPane root_pane;

    @FXML
    private TableColumn<Book, String> author_column;

    @FXML
    private TableColumn<Book, String> title_column;

    @FXML
    private TableColumn<Book, String> id_column;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initColumns();

        loadData();
    }

    private void initColumns(){
        title_column.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        id_column.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
        availability_column.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("availability"));
        author_column.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publisher_column.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
    }

    private void loadData(){
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String query = "SELECT * FROM books";
        ResultSet resultSet = handler.executeQuery(query);
        try {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String id = Integer.toString(resultSet.getInt("id"));
                Boolean availability = resultSet.getBoolean("available");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");

                list.add(new Book(id, title, author, publisher, availability));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table_view.getItems().setAll(list);
    }

    public static class Book{

        private final SimpleStringProperty title;
        private final SimpleStringProperty id;
        private final SimpleStringProperty author;
        private final SimpleStringProperty publisher;
        private final SimpleBooleanProperty availability;

        Book(String id, String title, String author, String publisher, Boolean availability){
            this.id = new SimpleStringProperty(id);
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.publisher = new SimpleStringProperty(publisher);
            this.availability = new SimpleBooleanProperty(availability);

        }

        public String getTitle() {
            return title.get();
        }

        public String getId() {
            return id.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getPublisher() {
            return publisher.get();
        }

        public boolean isAvailability() {
            return availability.get();
        }
    }

}
