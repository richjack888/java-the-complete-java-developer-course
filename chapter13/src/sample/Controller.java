package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField nameField;

    @FXML
    public void onButtonClicked(ActionEvent e) {
        System.out.println("Are you typing: " + nameField.getText());
        System.out.println("The following button was pressed: " + e.getSource());
    }
}
