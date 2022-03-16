package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tutorialgroup.TutorialGroup;

/**
 * Jackson-friendly version of {@link TutorialGroup}.
 */
class JsonAdaptedTutorialGroup {

    private final String tagName;

    /**
     * Constructs a {@code JsonAdaptedTutorialGroup} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTutorialGroup(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Converts a given {@code TutorialGroup} into this class for Jackson use.
     */
    public JsonAdaptedTutorialGroup(TutorialGroup source) {
        tagName = source.tagName;
    }

    @JsonValue
    public String getTagName() {
        return tagName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code TutorialGroup} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public TutorialGroup toModelType() throws IllegalValueException {
        if (!TutorialGroup.isValidTutorialGroupName(tagName)) {
            throw new IllegalValueException(TutorialGroup.MESSAGE_CONSTRAINTS);
        }
        return new TutorialGroup(tagName);
    }

}
