package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Telegram;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String telegram;
    private final String email;
    private final String gitHub;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("telegram") String telegram,
            @JsonProperty("email") String email, @JsonProperty("gitHub") String gitHub) {
        this.name = name;
        this.telegram = telegram;
        this.email = email;
        this.gitHub = gitHub;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        email = source.getEmail().value;
        telegram = (source.getTelegram().isEmpty()) ? null : source.getTelegram().get().value;
        gitHub = (source.getGitHub().isEmpty()) ? null : source.getGitHub().get().value;
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

        Telegram telegramTemp;
        if (telegram == null || telegram.equals("")) { //occurs if Person has no telegram
            telegramTemp = null;
        } else if (!Telegram.isValidTelegram(telegram)) {
            throw new IllegalValueException(Telegram.MESSAGE_CONSTRAINTS);
        } else {
            telegramTemp = new Telegram(telegram);
        }
        final Telegram modelTelegram = telegramTemp;

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        GitHub githubTemp;
        if (gitHub == null || gitHub.equals("")) { //occurs if Person has no gitHub
            githubTemp = null;
        } else if (!GitHub.isValidGitHub(gitHub)) {
            throw new IllegalValueException(GitHub.MESSAGE_CONSTRAINTS);
        } else {
            githubTemp = new GitHub(gitHub);
        }
        final GitHub modelGitHub = githubTemp;

        return new Person(modelName, modelTelegram, modelEmail, modelGitHub);
    }
}
