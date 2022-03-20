package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TUTORIAL_GROUP_DESC;
import static seedu.address.logic.commands.CommandTestUtil.TUTORIAL_GROUP_DESC_CS2103T_W15_3;
import static seedu.address.logic.commands.CommandTestUtil.TUTORIAL_GROUP_DESC_CS2101_G08;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.AddTutorialGroupDescriptorBuilder.VALID_DESCRIPTOR_BOB;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_STUDENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTutorialGroupCommand;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddTutorialGroupCommand.AddTutorialGroupDescriptor;
import seedu.address.model.tutorialgroup.TutorialGroup;

public class AddTutorialGroupParserTest {

    private static final String TUTORIAL_GROUP_EMPTY = " " + PREFIX_TUTORIAL_GROUP;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTutorialGroupCommand.MESSAGE_USAGE);

    private AddTutorialGroupParser parser = new AddTutorialGroupParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, TUTORIAL_GROUP_DESC_CS2101_G08, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", MESSAGE_INVALID_FORMAT);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + TUTORIAL_GROUP_DESC_CS2103T_W15_3, MESSAGE_INVALID_FORMAT);

        // zero
        assertParseFailure(parser, "0" + TUTORIAL_GROUP_DESC_CS2103T_W15_3, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        // empty tutorial group
        assertParseFailure(parser, "1"
                + TUTORIAL_GROUP_EMPTY, TutorialGroup.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "-1" + INVALID_TUTORIAL_GROUP_DESC, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        // valid index and tutorial group
        Index targetIndex = INDEX_SECOND_STUDENT;
        String input = targetIndex.getOneBased() + TUTORIAL_GROUP_DESC_CS2101_G08 + TUTORIAL_GROUP_DESC_CS2103T_W15_3;

        AddTutorialGroupDescriptor desc = VALID_DESCRIPTOR_BOB;
        AddTutorialGroupCommand expectedCommand = new AddTutorialGroupCommand(targetIndex, desc);

        assertParseSuccess(parser, input, expectedCommand);
    }
}
