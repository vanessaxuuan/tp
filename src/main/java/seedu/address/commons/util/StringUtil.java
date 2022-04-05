package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Arrays;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");

        String preppedSentence = sentence;
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
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
     * Returns true if {@code s} represents a nonZero unsigned integer that is less than {@code Integer.MAX_VALUE}
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroSignedIntegerLessThanIntegerLimit(String s) {
        try {
            BigInteger parsedInteger = new BigInteger(s);
            Integer maxInt = Integer.MAX_VALUE;
            String maxIntString = maxInt.toString();
            if (parsedInteger.compareTo(new BigInteger("2147483647")) != -1) {  //check for overflow
                return false;
            }
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Returns true if {@code s} represents a nonZero unsigned integer that is less than {@code Integer.MAX_VALUE}
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string," 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonNegativeUnsignedIntegerThatDoesNotOverflow(String s) throws ParseException {
        requireNonNull(s);

        try {
            BigInteger parsedInteger = new BigInteger(s);
            Integer maxInt = Integer.MAX_VALUE;
            String maxIntString = maxInt.toString();
            if (parsedInteger.compareTo(new BigInteger(maxIntString)) != -1) {  //check for overflow
                return false;
            }
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
