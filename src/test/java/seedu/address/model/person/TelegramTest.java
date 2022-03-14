package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TelegramTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Telegram(null));
    }

    @Test
    public void constructor_invalidTelegram_throwsIllegalArgumentException() {
        String invalidTelegramHandle = "";
        assertThrows(IllegalArgumentException.class, () -> new Telegram(invalidTelegramHandle));
    }

    @Test
    public void isValidTelegram() {
        // null telegram
        assertThrows(NullPointerException.class, () -> Telegram.isValidTelegram(null));

        // invalid telegram
        assertFalse(Telegram.isValidTelegram("")); // empty string
        assertFalse(Telegram.isValidTelegram(" ")); // spaces only
        assertFalse(Telegram.isValidTelegram("911")); // less than 5 characters
        assertFalse(Telegram.isValidTelegram("91")); // less than 5 characters
        assertFalse(Telegram.isValidTelegram("9312 1534")); // spaces within digits

        // valid telegram
        assertTrue(Telegram.isValidTelegram("phone")); // non-numeric
        assertTrue(Telegram.isValidTelegram("9011p041")); // alphabets within digits
        assertTrue(Telegram.isValidTelegram("benso")); // 5 characters
        assertTrue(Telegram.isValidTelegram("93121534"));
        assertTrue(Telegram.isValidTelegram("amy293842033123")); // long telegram
    }
}
