package contactChallenge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 820, 420));
        primaryStage.show();
    }

//    @Override
//    public void init() throws Exception {
//        try {
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Override
//    public void stop() throws Exception {
//        try {
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
