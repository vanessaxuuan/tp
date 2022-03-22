package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * Represents a box of a contact detail, with an image and text.
 */
public class ContactBox extends HBox {

    @FXML
    private ImageView logo;
    @FXML
    private Label details;

    private ContactBox(Image img, String text) {
        details.setText(text);
        logo.setImage(img);
        logo.setClip(getCircleClip(30));
    }

    private Circle getCircleClip(int radius) {
        return new Circle(radius, radius, radius);
    }

    public static ContactBox getContactBox(Image img, String s) {
        return new ContactBox(img, s);
    }
}
