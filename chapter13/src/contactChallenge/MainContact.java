package contactChallenge;

import contactChallenge.datamodel.ContactData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainwindow.fxml")));
        primaryStage.setTitle("Contacts");
        primaryStage.setScene(new Scene(root, 820, 420));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        ContactData.getInstance().loadContacts();
    }

    @Override
    public void stop() throws Exception {
        ContactData.getInstance().saveContacts();
    }
}
