package seedu.address.model.tutorialgroup;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a TutorialGroup in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTutorialGroupName(String)}
 */
public class TutorialGroup {

    public static final String MESSAGE_CONSTRAINTS = "Tutorial Group name should consist of a module code followed by" +
        " a white space and the tutorial name";
    public static final String VALIDATION_REGEX = "[A-Za-z]{2,3}[1-8]\\d{3}[A-Za-z]{0,2} [\\w-]+";

    public final String tagName;

    /**
     * Constructs a {@code TutorialGroup}.
     *
     * @param tagName A valid tag name.
     */
    public TutorialGroup(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTutorialGroupName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = tagName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTutorialGroupName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TutorialGroup // instanceof handles nulls
                && tagName.equals(((TutorialGroup) other).tagName)); // state check
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }

}
