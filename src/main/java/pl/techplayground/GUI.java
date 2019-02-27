package pl.techplayground;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import pl.techplayground.game.GameMechanic;
import pl.techplayground.model.MemoryTile;

import static pl.techplayground.Configuration.GRID_HEIGHT;
import static pl.techplayground.Configuration.GRID_WIDTH;

public class GUI {
    @FXML private FlowPane mainScene;
    @FXML private TilePane gameGridPane;
    @FXML private Button startNewGameButton;
    @FXML private Label labelScore;
    @FXML private Label outputScore;
    @FXML private Label outputMistakes;
    @FXML private Label outputBestScore;

    private GameMechanic gameMechanic;

    private EventHandler eventTileClicked = (EventHandler<ActionEvent>) event -> {
        if (event.getSource() instanceof MemoryTile) {
            MemoryTile tile = (MemoryTile) event.getSource();
            gameMechanic.gameLoop(tile);
            updateScore();

            if(gameMechanic.hasGameEnded()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Congratulations!");
                alert.setContentText("You won!");

                alert.showAndWait();
            }
        }
    };

    @FXML
    public void initialize() {
        startNewGameButton.setOnAction(this::handleStartNewGameButton);
    }

    private void handleStartNewGameButton(ActionEvent event) {
        resetGameGrid();
    }

    private void updateScore() {
        outputScore.textProperty().setValue(gameMechanic.getScore().toString());
        outputMistakes.textProperty().setValue(gameMechanic.getMistakes().toString());
    }

    private void resetGameGrid() {
        updateScore();
        clearGameGrid();
        Button[][] memoryTiles = createNewTiles();
        createNewGameGrid(memoryTiles);
    }

    private void clearGameGrid() {
        gameGridPane.getChildren().clear();
    }

    private Button[][] createNewTiles() {
        Button[][] memoryTiles = gameMechanic.startNewGame();

        for(int i = 0; i < GRID_WIDTH; i++) {
            for(int j = 0; j < GRID_HEIGHT; j++) {
                memoryTiles[i][j].setOnAction(eventTileClicked);
            }
        }

        return memoryTiles;
    }

    private void createNewGameGrid(Button[][] memoryTiles) {
        GridPane gameGrid = new GridPane();
        for(int i = 0; i < GRID_WIDTH; i++) {
            gameGrid.addRow(i, memoryTiles[i]);
        }

        gameGridPane.getChildren().add(gameGrid);
    }

    public GameMechanic getGameMechanic() {
        return gameMechanic;
    }

    public void setGameMechanic(GameMechanic gameMechanic) {
        this.gameMechanic = gameMechanic;
    }
}
