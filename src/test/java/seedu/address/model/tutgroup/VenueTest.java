package seedu.address.model.tutgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class VenueTest {
    @Test
    public void constructor_null_createVenue() {
        assertThrows(NullPointerException.class, () -> new Venue(null));
    }

    @Test
    public void constructor_invalidVenue_throwsIllegalArgumentException() {
        String invalidVenue = "";
        assertThrows(IllegalArgumentException.class, () -> new Venue(invalidVenue));
    }

    @Test
    public void isValidVenue() {
        // null venue
        assertThrows(NullPointerException.class, () -> Venue.isValidVenue(null));

        // invalid venue
        assertFalse(Venue.isValidVenue("")); // empty string
        assertFalse(Venue.isValidVenue(" ")); // spaces only
        assertFalse(Venue.isValidVenue("^")); // only non-alphanumeric characters
        assertFalse(Venue.isValidVenue("I3-AUD*")); // contains non-alphanumeric characters

        // valid venue
        assertTrue(Venue.isValidVenue("LT27")); // alphanumeric characters with capital letters
        assertTrue(Venue.isValidVenue("tp-sr1")); // alphanumeric characters with small letters
        assertTrue(Venue.isValidVenue("COM1-B108")); // contain hyphens
    }
}
