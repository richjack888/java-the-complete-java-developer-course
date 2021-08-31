package contactChallenge;

import contactChallenge.datamodel.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Controller {

    @FXML
    public TableColumn<Contact, String> firstNameCol;
    @FXML
    public TableColumn<Contact, String> lastNameCol;
    @FXML
    public TableColumn<Contact, String> phoneNumberCol;
    @FXML
    public TableColumn<Contact, String> notesCol;
    @FXML
    private TableView<Contact> tableview;
    private List<Contact> contact;

    public void initialize() {
        tableview = new TableView<>();
        ObservableList<Contact> contacts = getContacts();
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));
        tableview.setItems(contacts);
        tableview.getColumns().setAll(firstNameCol, lastNameCol, phoneNumberCol, notesCol);


    }

    public ObservableList<Contact> getContacts() {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("Muse", "Beauty", "12345678", "abc"));
        return contacts;

    }


}
