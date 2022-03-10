package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.TelegramHandle;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String telegramHandle;
    private final String email;
    private final String gitHub;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("TelegramHandle") String telegramHandle,
            @JsonProperty("email") String email, @JsonProperty("gitHub") String gitHub) {
        this.name = name;
        this.telegramHandle = telegramHandle;
        this.email = email;
        this.gitHub = gitHub;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        email = source.getEmail().value;
        if (source.getTelegramHandle().isEmpty() || source.getTelegramHandle().get().equals("")) {
            telegramHandle = null;
        } else {
            telegramHandle = source.getTelegramHandle().get().value;
        }
        if (source.getGitHub().isEmpty() || source.getGitHub().get().equals("")) {
            gitHub = null;
        } else {
            gitHub = source.getGitHub().get().value;
        }
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        TelegramHandle telegramHandleTemp;
        if (telegramHandle != null && telegramHandle != "" && !TelegramHandle.isValidPhone(telegramHandle)) {
            throw new IllegalValueException(TelegramHandle.MESSAGE_CONSTRAINTS);
        } else if (telegramHandle == null || telegramHandle == "") {
            telegramHandleTemp = null;
        } else {
            telegramHandleTemp = new TelegramHandle(telegramHandle);
        }
        final TelegramHandle modelTelegramHandle = telegramHandleTemp;

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        GitHub githubTemp;
        if (gitHub != null && gitHub != "" && !GitHub.isValidAddress(gitHub)) {
            throw new IllegalValueException(GitHub.MESSAGE_CONSTRAINTS);
        } else if (gitHub == null || gitHub == "") {
            githubTemp = null;
        } else {
            githubTemp = new GitHub(gitHub);
        }
        final GitHub modelGitHub = githubTemp;
        return new Person(modelName, modelTelegramHandle, modelEmail, modelGitHub);
    }
}
