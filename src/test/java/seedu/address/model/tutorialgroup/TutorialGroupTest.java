package seedu.address.model.tutorialgroup;

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
    public void isValidTutorialGroupName() {
        // null tutorial group name
        assertThrows(NullPointerException.class, () -> TutorialGroup.isValidTutorialGroupName(null));
    }

}
