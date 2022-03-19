package seedu.address.model.tutorialgroup;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a TutorialGroup in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTutorialGroupName(String)}
 */
public class TutorialGroup {

    public static final String MESSAGE_CONSTRAINTS = "Tutorial Groups should consist of a Module code, followed by"
        + " a space, then the tutorial name";
    public static final String VALIDATION_REGEX = "[A-Za-z]{2,3}[1-8]\\d{3}[A-Za-z]{0,2} [\\w-]+";

    public final String tutorialGroupName;

    /**
     * Constructs a {@code TutorialGroup}.
     *
     * @param tutorialGroupName A valid tutorial group name.
     */
    public TutorialGroup(String tutorialGroupName) {
        requireNonNull(tutorialGroupName);
        checkArgument(isValidTutorialGroupName(tutorialGroupName), MESSAGE_CONSTRAINTS);
        this.tutorialGroupName = tutorialGroupName;
    }

    /**
     * Returns true if a given string is a valid tutorial group name.
     */
    public static boolean isValidTutorialGroupName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TutorialGroup // instanceof handles nulls
                && tutorialGroupName.equals(((TutorialGroup) other).tutorialGroupName)); // state check
    }

    @Override
    public int hashCode() {
        return tutorialGroupName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tutorialGroupName + ']';
    }

}
