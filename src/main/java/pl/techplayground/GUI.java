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
    @FXML private Label outputPairFound;
    @FXML private Label outputMistakes;
    @FXML private Label outputCurrentScore;
    @FXML private Label outputBestScore;

    private GameMechanic gameMechanic;

    private EventHandler eventTileClicked = (EventHandler<ActionEvent>) event -> {
        if (event.getSource() instanceof MemoryTile) {
            MemoryTile tile = (MemoryTile) event.getSource();
            gameMechanic.gameLoop(tile);
            updateScore();

            if(gameMechanic.hasGameEnded()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("You won!");
                alert.showAndWait();
            }
        }
    };

    @FXML
    public void initialize() {
        startNewGameButton.setOnAction(this::handleStartNewGameButton);
        outputPairFound.textProperty().setValue("");
        outputMistakes.textProperty().setValue("");
        outputCurrentScore.textProperty().setValue("");
        outputBestScore.textProperty().setValue("");
    }

    private void handleStartNewGameButton(ActionEvent event) {
        resetGameGrid();
    }

    private void updateScore() {
        outputPairFound.textProperty().setValue(gameMechanic.getPairCount().toString());
        outputMistakes.textProperty().setValue(gameMechanic.getMistakes().toString());
        outputCurrentScore.textProperty().setValue(gameMechanic.getCurrentScore().toString());
        outputBestScore.textProperty().setValue(gameMechanic.getBestScore().toString());
    }

    private void resetGameGrid() {
        clearGameGrid();
        Button[][] memoryTiles = createNewTiles();
        createNewGameGrid(memoryTiles);
        updateScore();
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

    public void setGameMechanic(GameMechanic gameMechanic) {
        this.gameMechanic = gameMechanic;
    }
}
