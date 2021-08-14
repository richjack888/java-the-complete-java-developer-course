package todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import todolist.datamodel.TodoData;
import todolist.datamodel.TodoItem;

import java.awt.*;
import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public void processResult(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoData.getInstance().addTodoItem(new TodoItem(shortDescription, details, deadlineValue));

    }

}
