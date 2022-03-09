package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalClasses.T03;
import static seedu.address.testutil.TypicalClasses.T04;
import static seedu.address.testutil.TypicalModules.CS2100;
import static seedu.address.testutil.TypicalModules.CS2100_WITH_WRONG_CLASS;
import static seedu.address.testutil.TypicalModules.CS2100_WITH_WRONG_NAME;
import static seedu.address.testutil.TypicalModules.CS2101;
import static seedu.address.testutil.TypicalModules.CS2101_WITH_TRAILING_SPACES;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.model.tutgroup.Class;

public class ModuleTest {
    private static final ModuleName cs2100Name = new ModuleName("CS2100");
    private static final Class[] classesForCs2100 = {T03, T04};

    @Test
    public void isSameModule() {
        // same object -> returns true
        assertTrue(CS2101.isSameModule(CS2101));

        // null -> returns false
        assertFalse(CS2101.isSameModule(null));

        // different name, all other attributes same -> returns false
        assertFalse(CS2101.isSameModule(CS2100_WITH_WRONG_NAME));

        // name has trailing spaces, all other attributes same -> returns false
        assertFalse(CS2101.isSameModule(CS2101_WITH_TRAILING_SPACES));
    }

    @Test
    public void equals() {
        final Module cs2100Copy = new Module(cs2100Name, new HashSet<Class>(Arrays.asList(classesForCs2100)));

        // same values -> returns true
        assertTrue(CS2100.equals(cs2100Copy));

        // same object -> returns true
        assertTrue(CS2100.equals(CS2100));

        // null -> returns false
        assertFalse(CS2100.equals(null));

        // different type -> returns false
        assertFalse(CS2100.equals(5));

        // different person -> returns false
        assertFalse(CS2100.equals(CS2101));

        // different name -> returns false
        assertFalse(CS2100.equals(CS2100_WITH_WRONG_NAME));

        // different class -> returns false
        assertFalse(CS2100.equals(CS2100_WITH_WRONG_CLASS));
    }
}
