package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TelegramHandleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TelegramHandle(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidTelegramHandle = "";
        assertThrows(IllegalArgumentException.class, () -> new TelegramHandle(invalidTelegramHandle));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> TelegramHandle.isValidPhone(null));

        // invalid phone numbers
        assertFalse(TelegramHandle.isValidPhone("")); // empty string
        assertFalse(TelegramHandle.isValidPhone(" ")); // spaces only
        assertFalse(TelegramHandle.isValidPhone("911")); // less than 5 characters
        assertFalse(TelegramHandle.isValidPhone("91")); // less than 5 characters
        assertFalse(TelegramHandle.isValidPhone("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(TelegramHandle.isValidPhone("phone")); // non-numeric
        assertTrue(TelegramHandle.isValidPhone("9011p041")); // alphabets within digits
        assertTrue(TelegramHandle.isValidPhone("benso")); // 5 characters
        assertTrue(TelegramHandle.isValidPhone("93121534"));
        assertTrue(TelegramHandle.isValidPhone("124293842033123")); // long phone numbers
    }
}
