package pl.techplayground;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.techplayground.game.GameGridGenerator;
import pl.techplayground.game.GameMechanic;
import pl.techplayground.model.MemoryTile;

import java.util.Random;

import static pl.techplayground.Configuration.GRID_HEIGHT;
import static pl.techplayground.Configuration.GRID_WIDTH;

public class MemoryGame extends Application {

    @Override
    public void start(Stage stage) {
        Random random = new Random();
        GameGridGenerator gameGridGenerator = new GameGridGenerator(random);
        GameMechanic gameMechanic = new GameMechanic(gameGridGenerator);
        Button button[][] = gameMechanic.startNewGame();

        EventHandler clicked = (EventHandler<ActionEvent>) event -> {
            if (event.getSource() instanceof MemoryTile) {
                MemoryTile chb = (MemoryTile) event.getSource();
                gameMechanic.gameLoop(chb);
            }
        };

        FlowPane flowPane = new FlowPane();

        VBox vbox = new VBox(new Label("Hello World"));
        GridPane gridPane = new GridPane();

        for(int i = 0; i < GRID_WIDTH; i++) {
            for(int j = 0; j < GRID_HEIGHT; j++) {
                button[i][j].setOnAction(clicked);
            }
        }

        gridPane.addRow(0, button[0]);
        gridPane.addRow(1, button[1]);
        gridPane.addRow(2, button[2]);

        flowPane.getChildren().add(vbox);
        flowPane.getChildren().add(gridPane);

        flowPane.setHgap(15);

        Scene scene = new Scene(flowPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}