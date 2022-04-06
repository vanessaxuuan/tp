package seedu.address.model.tutorialgroup;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a TutorialGroup in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTutorialGroupName(String)}
 */
public class TutorialGroup {

    public static final String MESSAGE_CONSTRAINTS = "Tutorial Groups should consist of a module code, followed by"
        + " a space, then the tutorial name. It should not be blank. The tutorial name can be a single digit (1 - 9) "
        + "or any length of alphanumeric characters with at least 1 digit but it cannot end or start with a hyphen.A "
        + "tutorial group can only have a maximum of 100 characters including whitespace.";
    public static final String VALIDATION_REGEX = "[A-Za-z]{2,3}[1-8]\\d{3}[A-Za-z]{0,2} "
        + "([a-zA-Z]{1,}[0-9]{1,}|[1-9]{1,})([\\w-][^-])*";

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
        if (test.length() >= 100) {
           return false;
        }
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * {@code TutorialGroup}s are equal if they have the same tutorial group name <strong>ignoring cases.</strong>
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TutorialGroup // instanceof handles nulls
                && tutorialGroupName.equalsIgnoreCase(((TutorialGroup) other).tutorialGroupName)); // state check
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
