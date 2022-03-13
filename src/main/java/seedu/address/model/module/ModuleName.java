package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ModuleName {
    public static final String MESSAGE_CONSTRAINTS =
        "ModuleNames can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^\\w+(-\\w+)*$";

    public final String moduleName;

    /**
     * Constructs a {@code ModuleName}.
     *
     * @param moduleName A valid ModuleName.
     */
    public ModuleName(String moduleName) {
        requireNonNull(moduleName);
        checkArgument(isValidModuleName(moduleName), MESSAGE_CONSTRAINTS);
        this.moduleName = moduleName;
    }

    /**
     * Returns true if a given string is a valid moduleName.
     */
    public static boolean isValidModuleName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return moduleName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ModuleName // instanceof handles nulls
            && this.moduleName.equals(((ModuleName) other).moduleName)); // state check
    }

    @Override
    public int hashCode() {
        return moduleName.hashCode();
    }
}
