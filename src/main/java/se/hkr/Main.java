package se.hkr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.hkr.database.Database;

public class Main extends MockAuthProvider {

    private static Database database;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("ATM");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws ClassNotFoundException {
        database = new Database("localhost", "root", "", "atm", 3306);

        launch(args);
    }

    public static Database getDatabase() {
        return database;
    }
}
