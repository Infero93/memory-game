package pl.techplayground.util;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageLoader {

    private static List<Image> IMAGES;
    private static Image DEFAULT_IMAGE;

    public static Image getDefaultImage() {
        if(DEFAULT_IMAGE == null) {
            DEFAULT_IMAGE = new Image("/transparent.png", 64,64, true, false);
        }

        return DEFAULT_IMAGE;
    }

    public static List<Image> getEmbbemedImages() {

        if(IMAGES == null) {
            IMAGES = new ArrayList<>();

            IMAGES.add(new Image("/bird.png", 64,64, true, false));
            IMAGES.add(new Image("/dog.png",64,64, true, false));
            IMAGES.add(new Image("/fish.png", 64,64, true, false));
        }


        return Collections.unmodifiableList(IMAGES);
    }
}
