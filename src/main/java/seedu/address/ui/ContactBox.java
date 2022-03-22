package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * Represents a box of a contact detail, with an image and text.
 */
public class ContactBox extends HBox {

    private static final String FXML = "ContactBox.fxml";

    @FXML
    private ImageView logo;
    @FXML
    private Label details;

    public ContactBox(Image img, String text) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ContactBox.fxml"));
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
