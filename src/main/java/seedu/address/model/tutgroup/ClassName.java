package seedu.address.model.tutgroup;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a className of a Class
 * Guarantees: immutable; is valid as declared in {@link #isValidClassName(String)}
 */
public class ClassName {

    public static final String MESSAGE_CONSTRAINTS =
        "ClassName should be alphanumeric and can have hyphens and underscores. It should not be blank.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^\\w+(-\\w+)*$";

    public final String className;

    /**
     * Constructs a {@code ClassName}.
     *
     * @param className A valid ClassName.
     */
    public ClassName(String className) {
        requireNonNull(className);
        checkArgument(isValidClassName(className), MESSAGE_CONSTRAINTS);
        this.className = className;
    }

    /**
     * Returns true if a given string is a valid className.
     */
    public static boolean isValidClassName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return className;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassName // instanceof handles nulls
                && this.className.equals(((ClassName) other).className)); // state check
    }

    @Override
    public int hashCode() {
        return className.hashCode();
    }

}
