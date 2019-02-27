package pl.techplayground.game;

import javafx.scene.control.Button;
import pl.techplayground.model.MemoryTile;

import static pl.techplayground.Configuration.*;


public class GameMechanic {

    private GameGridGenerator gameGridGenerator;

    private MemoryTile firstTile;
    private MemoryTile secondTile;
    private Double bestScore = 0.0;
    private Double currentScore = 0.0;
    private Integer pairCount;
    private Integer mistakes;
    private Boolean successfulMatch;

    public GameMechanic(GameGridGenerator gameGridGenerator) {
        this.gameGridGenerator = gameGridGenerator;
        resetGameState();
    }

    public Button[][] startNewGame() {
        resetGameState();
        return gameGridGenerator.generateGrid();
    }

    public void gameLoop(MemoryTile memoryTile) {
        clearTiles();
        tileClicked(memoryTile);
        updateState();
    }

    public boolean hasGameEnded() {
        return pairCount == (GRID_WIDTH * GRID_HEIGHT) / GRID_MAX_SAME_IMAGE_COUNT;
    }

    private void resetGameState() {
        if(bestScore < currentScore) bestScore = currentScore;
        successfulMatch = false;
        pairCount = 0;
        mistakes = 0;
        currentScore = 0.0;
        firstTile = null;
        secondTile = null;
    }

    private void clearTiles() {
        if(bothTilesSelected()) {
            if(!successfulMatch) {
                firstTile.toggleDefaultImage();
                secondTile.toggleDefaultImage();
            }

            firstTile = null;
            secondTile = null;
        }
    }

    private void tileClicked(MemoryTile memoryTile) {
        if(firstTile == null) {
            firstTile = memoryTile;
        } else {
            secondTile = memoryTile;
        }

        memoryTile.toggleOriginalImage();
    }

    private void updateState() {
        if(bothTilesSelected()) {
            if(firstTile == secondTile) {
                System.out.println("Clicked same tile!");
            } else if(firstTile.getImageIndex().equals(secondTile.getImageIndex())) {
                System.out.println("Clicked different tile with same image");
                firstTile.setDisable(true);
                secondTile.setDisable(true);
                successfulMatch = true;
                pairCount += 1;
            } else {
                System.out.println("Clicked different tile with different image!");
                successfulMatch = false;
                mistakes += 1;
            }
        }

        updateScore();
    }

    private void updateScore() {
        if(pairCount == 0) currentScore = 0.0;
        else if(mistakes == 0) currentScore = (double) pairCount;
        else currentScore = (double) pairCount / mistakes;

        currentScore *= 100;
    }

    private boolean bothTilesSelected() {
        return firstTile != null && secondTile != null;
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public Integer getMistakes() {
        return mistakes;
    }

    public Double getBestScore() {
        return bestScore;
    }

    public Double getCurrentScore() {
        return currentScore;
    }
}
