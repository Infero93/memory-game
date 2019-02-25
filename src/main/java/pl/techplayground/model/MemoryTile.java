package pl.techplayground.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MemoryTile extends Button {

    private static final String EMPTY_STRING = "";
    private ImageView imageView;

    public MemoryTile(ImageView imageView) {
        super(EMPTY_STRING, imageView);
        this.imageView = imageView;
    }


}
