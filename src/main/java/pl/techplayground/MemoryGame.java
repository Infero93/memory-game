package pl.techplayground;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.techplayground.game.GameGridGenerator;
import pl.techplayground.game.GameMechanic;
import pl.techplayground.util.ImageLoader;

import java.io.IOException;
import java.util.Random;


public class MemoryGame extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Random random = new Random();
        GameGridGenerator gameGridGenerator = new GameGridGenerator(random);
        GameMechanic gameMechanic = new GameMechanic(gameGridGenerator);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(MemoryGame.class.getResource("/gui.fxml"));
        Pane pane = loader.load();
        GUI controller = loader.getController();

        controller.setGameMechanic(gameMechanic);

        Scene scene = new Scene(pane);
        stage.setTitle("Memory game");
        stage.getIcons().add(ImageLoader.getImageFromResourcesFolder("brain.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}