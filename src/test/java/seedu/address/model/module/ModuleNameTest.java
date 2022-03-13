package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ModuleNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ModuleName(null));
    }

    @Test
    public void constructor_invalidModuleName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new ModuleName(invalidName));
    }

    @Test
    public void isValidModuleName() {
        // null moduleName
        assertThrows(NullPointerException.class, () -> ModuleName.isValidModuleName(null));

        // invalid moduleName
        assertFalse(ModuleName.isValidModuleName("")); // empty string
        assertFalse(ModuleName.isValidModuleName(" ")); // spaces only
        assertFalse(ModuleName.isValidModuleName("^")); // only non-alphanumeric characters
        assertFalse(ModuleName.isValidModuleName("WW11*")); // contains non-alphanumeric characters
        assertFalse(ModuleName.isValidModuleName("CS2103T  ")); //with trailing whitespace

        // valid moduleName
        assertTrue(ModuleName.isValidModuleName("CS2103T")); // alphanumeric characters with capital letters
        assertTrue(ModuleName.isValidModuleName("cs2101")); // alphanumeric characters with small letters
    }
}
