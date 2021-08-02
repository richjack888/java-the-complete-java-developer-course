package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        ClickButton.setDisable(true);
        LeaveButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        String text = "You typing: " + nameField.getText();
        if (e.getSource().equals(ClickButton)) {
            System.out.println("This is click button. " + text);
        } else if (e.getSource().equals(LeaveButton)) {
            System.out.println("This is leave button. " + text);
        } else {
            System.out.println("None of above button. " + text);
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? " UI Thread" : " Background Thread";
                    System.out.println("I'm going to sleep in the: " + s);
                    Thread.sleep(10000);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? " UI Thread" : " Background Thread";
                            ourLabel.setText("We did something!");
                        }
                    });
                } catch (InterruptedException event) {
                    // we don't care about this
                }
            }
        };

        new Thread(task).start();

        if (ourCheckBox.isSelected()) {
            nameField.clear();
            ClickButton.setDisable(true);
            LeaveButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // second condition is not allow entering space
        ClickButton.setDisable(disableButtons);
        LeaveButton.setDisable(disableButtons);
    }

    @FXML
    private void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? " checked " : " not checked "));
    }
}
