package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedStudent.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Name;
import seedu.address.model.person.Telegram;

public class JsonAdaptedStudentTest {
    private static final String INVALID_GITHUB = " ";
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_TELEGRAM = "+651234";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TUTORIAL_GROUP = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_TELEGRAM = BENSON.getTelegram().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_GITHUB = BENSON.getGitHub().toString();
    private static final List<JsonAdaptedTutorialGroup> VALID_TUTORIAL_GROUP = BENSON.getTags().stream()
            .map(JsonAdaptedTutorialGroup::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedStudent person = new JsonAdaptedStudent(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(INVALID_NAME, VALID_TELEGRAM, VALID_EMAIL, VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(null, VALID_TELEGRAM, VALID_EMAIL,
            VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTelegram_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, INVALID_TELEGRAM, VALID_EMAIL,
                    VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = Telegram.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullTelegram_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME, null, VALID_EMAIL,
            VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Telegram.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM, INVALID_EMAIL,
                    VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM, null,
            VALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidGitHub_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM, VALID_EMAIL, INVALID_GITHUB, VALID_TUTORIAL_GROUP);
        String expectedMessage = GitHub.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullGitHub_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM, VALID_EMAIL,
            null, VALID_TUTORIAL_GROUP);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, GitHub.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTutorialGroup_throwsIllegalValueException() {
        List<JsonAdaptedTutorialGroup> invalidTags = new ArrayList<>(VALID_TUTORIAL_GROUP);
        invalidTags.add(new JsonAdaptedTutorialGroup(INVALID_TUTORIAL_GROUP));
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_TELEGRAM, VALID_EMAIL, VALID_GITHUB, invalidTags);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

}
