package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("12345")); // numbers only
        assertFalse(Name.isValidName("peter the 2nd")); // alphanumeric characters
        assertFalse(Name.isValidName("^")); // only non-alphabetical characters
        assertFalse(Name.isValidName("peter*")); // contains unaccepted characters
        assertFalse(Name.isValidName("peter-")); // hyphen at the end
        assertFalse(Name.isValidName("-peter")); // hyphen at the start
        assertFalse(Name.isValidName("peter\'")); // apostrophe at the end
        assertFalse(Name.isValidName("\'peter")); // apostrophe at the start
        assertFalse(Name.isValidName("peter--jack")); // consecutive hyphens
        assertFalse(Name.isValidName("peter   jack")); // consecutive spaces
        assertFalse(Name.isValidName("peter\'\'jack")); // consecutive apostrophes

        // valid name
        assertTrue(Name.isValidName("peter jack")); // alphabets only
        assertTrue(Name.isValidName("Capital Tan")); // with capital letters
        assertTrue(Name.isValidName("Max-Ernest")); // name with hyphen
        assertTrue(Name.isValidName("Jeanne d'Arc")); // name with apostrophe
        assertTrue(Name.isValidName("Johnson-Johnson d'Arby")); // name with all hyphen, space and apostrophe
    }
}
