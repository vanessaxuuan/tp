package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    /**
     * Returns true if the {@code name} contains the {@code keys}.
     *   Ignores case, but white space in {@code keys} must match {@code name}'s.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "abd d") == true
     *       containsWordIgnoreCase("ABc def", "abcd") == false // whitespace does not tally
     *       containsWordIgnoreCase("ABc def", "abc defg") == false // not a substring
     *       </pre>
     * @param name cannot be null
     * @param keys cannot be null, cannot be empty
     */
    public static boolean containsWordIgnoreCase(String name, String keys) {
        requireNonNull(name);
        requireNonNull(keys);

        String capitalizedName = name.toUpperCase();
        String capitalizedKeys = keys.toUpperCase();
        checkArgument(!keys.isEmpty(), "keys cannot be empty");
        return capitalizedName.contains(capitalizedKeys);
    }

    /**
     * Returns true if the {@code sentence1} contains the {@code sentence2}.
     *   Ignores case, but a full sentence match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc def") == true
     *       containsWordIgnoreCase("ABc def", "abc DEF") == true
     *       containsWordIgnoreCase("ABc def", "ABc") == false //not a full sentence match
     *       </pre>
     * @param sentence1 cannot be null
     * @param sentence2 cannot be null, cannot be empty
     */
    public static boolean containsSentenceIgnoreCase(String sentence1, String sentence2) {
        requireNonNull(sentence1);
        requireNonNull(sentence2);

        checkArgument(!sentence2.isEmpty(), "sentence2 parameter cannot be empty");
        return sentence1.equalsIgnoreCase(sentence2);
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
