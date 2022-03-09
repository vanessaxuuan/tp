package seedu.address.model.tutgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ZoomLinkTest {
    @Test
    public void constructor_null_createZoomLink() {
        assertThrows(NullPointerException.class, () -> new ZoomLink(null));
    }

    @Test
    public void constructor_invalidZoomLink_throwsIllegalArgumentException() {
        String invalidZoomLink = "";
        assertThrows(IllegalArgumentException.class, () -> new ZoomLink(invalidZoomLink));
    }

    @Test
    public void isValidZoomLink() {
        // null name
        assertThrows(NullPointerException.class, () -> ZoomLink.isValidZoomLink(null));

        // invalid zoomLink
        assertFalse(ZoomLink.isValidZoomLink("")); // empty string
        assertFalse(ZoomLink.isValidZoomLink(" ")); // spaces only
        assertFalse(ZoomLink.isValidZoomLink("https://google.com")); // incorrect beginning substring
        assertFalse(ZoomLink.isValidZoomLink("https://nus-sg.zoom.us/j/923072123*")); // contains non-alphanumeric
        // characters
        assertFalse(ZoomLink.isValidZoomLink("https://nus-sg.zoom.us/j/923072123")); // 9 numbers at the end

        // valid zoomLink
        assertTrue(ZoomLink.isValidZoomLink("https://nus-sg.zoom.us/j/34256312401")); // proper link with 11 digits at
        // the end
    }
}
