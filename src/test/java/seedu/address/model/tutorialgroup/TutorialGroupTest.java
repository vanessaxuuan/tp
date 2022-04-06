package seedu.address.model.tutorialgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.tutorialgroup.TutorialGroup.isValidTutorialGroupName;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TutorialGroupTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TutorialGroup(null));
    }

    @Test
    public void constructor_invalidTutorialGroupName_throwsIllegalArgumentException() {
        String invalidTutorialGroupName = "";
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup(invalidTutorialGroupName));
    }

    @Test
    public void isValidTutorialGroupName_nullTutorialGroup_throwsNullPointerException() {
        // null tutorial group name
        assertThrows(NullPointerException.class, () -> isValidTutorialGroupName(null));
    }

    @Test
    public void isValidTutorialGroupName_TutorialGroupLongerThan100Characters_returnsFalse() {
        // tutorial group with 100 characters
        assertFalse(isValidTutorialGroupName("CS2106 "
            + "W51245414141241123213213123213123231323321313131311414124112321321312321312323132332131313131"));

        // tutorial group with 101 characters
        assertFalse(isValidTutorialGroupName("CS2106 "
            + "W512454141412411232134213123213123231323321313131311414124112321321312321312323132332131313131"));
    }

    @Test
    public void isValidTutorialGroupName_TutorialGroupLessThan100Characters_returnsTrue() {
        // tutorial group with 99 characters
        assertTrue(isValidTutorialGroupName("CS2106 "
            + "W5124541414124112321321312321312323132332131313131141412411232132131232131232313233213131313"));
    }



}
