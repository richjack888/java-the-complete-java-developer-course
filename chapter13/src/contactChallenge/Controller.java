package contactChallenge;

import contactChallenge.datamodel.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Controller {

    @FXML
    public TextField firstNameField;
    @FXML
    public TableColumn<Contact, String> firstNameCol;
    @FXML
    public TableColumn<Contact, String> lastNameCol;
    @FXML
    public TableColumn<Contact, String> phoneNumberCol;
    @FXML
    public TableColumn<Contact, String> notesCol;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField phoneNumberField;
    @FXML
    public TextField notesField;
    @FXML
    public Button addBtn;
    @FXML
    public Button editBtn;
    @FXML
    public Button delBtn;
    @FXML
    private TableView<Contact> tableview;

    private List<Contact> contact;

    public void initialize() {

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("Notes"));
        tableview.setItems(getContacts());


    }

    public ObservableList<Contact> getContacts() {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("James", "David", "4700229", ""));
        contacts.add(new Contact("Robert", "Richard", "4455696", ""));
        contacts.add(new Contact("John", "Joseph", "4335919", "JJ"));
        contacts.add(new Contact("Michael", "Thomas", "4335919", ""));
        contacts.add(new Contact("William", "Charles", "3564276", ""));
        return contacts;

    }

    @FXML
    public void handleAddBtn() {
    }

    @FXML
    public void handleEditBtn(ActionEvent actionEvent) {
    }

    @FXML
    public void handleDelBtn(ActionEvent actionEvent) {
    }
}
