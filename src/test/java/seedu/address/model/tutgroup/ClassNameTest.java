package seedu.address.model.tutgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ClassNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ClassName(null));
    }

    @Test
    public void constructor_invalidClassName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new ClassName(invalidName));
    }

    @Test
    public void isValidClassName() {
        // null ClassName
        assertThrows(NullPointerException.class, () -> ClassName.isValidClassName(null));

        // invalid ClassName
        assertFalse(ClassName.isValidClassName("")); // empty string
        assertFalse(ClassName.isValidClassName(" ")); // spaces only
        assertFalse(ClassName.isValidClassName("^")); // only non-alphanumeric characters
        assertFalse(ClassName.isValidClassName("WW11*")); // contains non-alphanumeric characters
        assertFalse(ClassName.isValidClassName("G07 ")); //has trailing whitespace

        // valid ClassName
        assertTrue(ClassName.isValidClassName("G08")); // alphanumeric characters with capital letters
        assertTrue(ClassName.isValidClassName("08")); // numbers only
        assertTrue(ClassName.isValidClassName("g01")); // alphanumeric characters without capital letters
        assertTrue(ClassName.isValidClassName("Z01-15")); // long names
    }
}
