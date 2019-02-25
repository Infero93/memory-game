package pl.techplayground.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MemoryTile extends Button {

    private static Integer BUTTON_SIZE = 64;

    private static final String EMPTY_STRING = "";
    private final ImageView imageView;

    public MemoryTile(ImageView imageView) {
        super(EMPTY_STRING, imageView);
        setWidth(BUTTON_SIZE);
        setHeight(BUTTON_SIZE);

        this.imageView = imageView;

        this.imageView.fitHeightProperty();
        this.imageView.fitWidthProperty();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
