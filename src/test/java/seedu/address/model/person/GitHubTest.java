package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GitHubTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GitHub(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new GitHub(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> GitHub.isValidAddress(null));

        // invalid addresses
        assertFalse(GitHub.isValidAddress("")); // empty string
        assertFalse(GitHub.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(GitHub.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(GitHub.isValidAddress("-")); // one character
        assertTrue(GitHub.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }
}
