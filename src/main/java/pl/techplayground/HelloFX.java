package pl.techplayground;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.techplayground.GameMechanic;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        GameMechanic gameMechanic = new GameMechanic();
        gameMechanic.initializeGrid();
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Button button[][] = gameMechanic.getTilesAsButtons();
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, button[0]);
        gridPane.addRow(1, button[1]);
        gridPane.addRow(2, button[2]);
        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}