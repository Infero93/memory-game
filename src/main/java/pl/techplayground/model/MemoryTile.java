package pl.techplayground.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MemoryTile {

    private static final String EMPTY_STRING = "";
    private final Button tile;
    private final ImageView imageView;

    public MemoryTile(ImageView imageView) {
        this.imageView = imageView;
        this.tile = new Button(EMPTY_STRING, imageView);
    }

    public Button getTile() {
        return tile;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
