package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField nameField;

    @FXML
    private Button ClickButton;

    @FXML
    private Button LeaveButton;

    @FXML
    public  void  initialize(){
        ClickButton.setDisable(true);
        LeaveButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        String text = "You typing: " + nameField.getText();
        if(e.getSource().equals(ClickButton)){
            System.out.println("This is click button. " + text);
        }else if(e.getSource().equals(LeaveButton)){
            System.out.println("This is leave button. " + text);
        }else {
            System.out.println("None of above button. " + text);
        }
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // second condition is not allow entering space
        ClickButton.setDisable(disableButtons);
        LeaveButton.setDisable(disableButtons);
    }
}
