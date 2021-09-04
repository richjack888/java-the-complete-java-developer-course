package contactChallenge;

import contactChallenge.datamodel.Contact;
import contactChallenge.datamodel.ContactData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Optional;

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
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField phoneNumberField;
    @FXML
    public TextField notesField;
    @FXML
    public Button addBtn;

    @FXML
    private TableView<Contact> tableview;

    public void initialize() {

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("Notes"));

        // show data in tableview
        tableview.setItems(ContactData.getInstance().getContacts());

        // edit function
        tableview.setEditable(true);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        notesCol.setCellFactory(TextFieldTableCell.forTableColumn());

    }


    @FXML
    public void handleAddBtn() {
        Contact contact = new Contact(
                firstNameField.getText(),
                lastNameField.getText(),
                phoneNumberField.getText(),
                notesField.getText()
        );
        tableview.getItems().add(contact);

        firstNameField.clear();
        lastNameField.clear();
        phoneNumberField.clear();
        notesField.clear();

    }


    public void handleDelClick() {
        final ContextMenu listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete contact");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Contact contact = tableview.getSelectionModel().getSelectedItem();
                deleteContact(contact);
            }
        });
        listContextMenu.getItems().add(deleteMenuItem);
        tableview.setContextMenu(listContextMenu);
    }

    @FXML
    public void handleDelKeyPressed(KeyEvent keyEvent) {
        Contact contact = tableview.getSelectionModel().getSelectedItem();
        if (contact != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteContact(contact);
            }
        }
    }

    private void deleteContact(Contact contact) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact ");
        alert.setContentText("Are you sure? Press OK  to confirm.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            tableview.getItems().remove(contact);
        }
    }

    public void onEditFirstName(TableColumn.CellEditEvent<Contact, String> contactStringCellEditEvent) {
        Contact contact = tableview.getSelectionModel().getSelectedItem();
        contact.setFirstName(contactStringCellEditEvent.getNewValue());
    }

    public void onEditLastName(TableColumn.CellEditEvent<Contact, String> contactStringCellEditEvent) {
        Contact contact = tableview.getSelectionModel().getSelectedItem();
        contact.setLastName(contactStringCellEditEvent.getNewValue());

    }

    public void onEditPhoneNumber(TableColumn.CellEditEvent<Contact, String> contactStringCellEditEvent) {
        Contact contact = tableview.getSelectionModel().getSelectedItem();
        contact.setPhoneNumber(contactStringCellEditEvent.getNewValue());

    }

    public void onEditNotes(TableColumn.CellEditEvent<Contact, String> contactStringCellEditEvent) {
        Contact contact = tableview.getSelectionModel().getSelectedItem();
        contact.setNotes(contactStringCellEditEvent.getNewValue());
    }
}
