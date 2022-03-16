package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's telegram in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTelegram(String)}
 */
public class Telegram {


    public static final String MESSAGE_CONSTRAINTS =
        "Telegram may begin with a \"{@}\" character, followed by between 5 to 32 alphanumerical " +
        "characters, can be blank";
    public static final String VALIDATION_REGEX = "@?\\w{5,32}";
    public final String value;

    /**
     * Constructs a {@code Telegram}.
     *
     * @param telegram A valid telegram.
     */
    public Telegram(String telegram) {
        if (telegram == null) {
            value = "";
        } else {
            checkArgument(isValidTelegram(telegram), MESSAGE_CONSTRAINTS);
            value = telegram;
        }
    }

    /**
     * Returns true if a given string is a valid telegram.
     */
    public static boolean isValidTelegram(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Telegram // instanceof handles nulls
                && value.equals(((Telegram) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
