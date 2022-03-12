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
    public void constructor_invalidGitHub_throwsIllegalArgumentException() {
        String invalidGitHub = "";
        assertThrows(IllegalArgumentException.class, () -> new GitHub(invalidGitHub));
    }

    @Test
    public void isValidGitHub() {
        // null gitHub
        assertThrows(NullPointerException.class, () -> GitHub.isValidGitHub(null));

        // invalid gitHub
        assertFalse(GitHub.isValidGitHub("")); // empty string
        assertFalse(GitHub.isValidGitHub(" ")); // spaces only

        // valid gitHub
        assertTrue(GitHub.isValidGitHub("Blk 456, Den Road, #01-355"));
        assertTrue(GitHub.isValidGitHub("-")); // one character
        assertTrue(GitHub.isValidGitHub("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }
}
