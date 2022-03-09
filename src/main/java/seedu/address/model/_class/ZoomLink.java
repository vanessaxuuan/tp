package seedu.address.model._class;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents location of where the online Class is going to be conducted at.
 * Guarantees: immutable; is valid as declared in {@link #isValidZoomLink(String)}
 */
public class ZoomLink {
    
    public static final String MESSAGE_CONSTRAINTS =
        "ZoomLink should be of the format https://nus-sg.zoom.us/j/encodedNumbers and "
        + "adhere to the following constraints \n"
        + "1. it must have the following \"https://nus-sg.zoom.us/j/\"\n"
        + "2. this is followed by 10 digits \n"
        + "3. there must be zero whitespaces in the input\n";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "https?:\\/\\/nus-sg\\.zoom\\.us\\/j\\/\\d{11}.*";
    
    public final String zoomLink;
    
    public ZoomLink(String zoomLink) {
        requireNonNull(zoomLink);
        checkArgument(isValidZoomLink(zoomLink), MESSAGE_CONSTRAINTS);
        this.zoomLink = zoomLink;
    }

    /**
     * Returns true if a given string is a valid zoomLink.
     */
    public static boolean isValidZoomLink(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return zoomLink;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ZoomLink // instanceof handles nulls
            && this.zoomLink.equals(((ZoomLink) other).zoomLink)); // state check
    }

    @Override
    public int hashCode() {
        return zoomLink.hashCode();
    }
}
