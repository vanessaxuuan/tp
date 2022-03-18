package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddTutorialGroupCommand;
import seedu.address.logic.commands.AddTutorialGroupCommand.AddTutorialGroupDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tutorialgroup.TutorialGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;

public class AddTutorialGroupParser implements Parser<AddTutorialGroupCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddTutorialGroupCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TUTORIAL_GROUP);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTutorialGroupCommand.MESSAGE_USAGE), pe);
        }

        AddTutorialGroupDescriptor addTutorialGroupDescriptor = new AddTutorialGroupCommand.AddTutorialGroupDescriptor();

        parseTagsForEdit(argMultimap.getAllValues(PREFIX_TUTORIAL_GROUP))
                .ifPresent(addTutorialGroupDescriptor::setTutorialGroups);

        if (!addTutorialGroupDescriptor.isAnyFieldEdited()) {
            throw new ParseException(AddTutorialGroupCommand.MESSAGE_NOT_ADDED);
        }

        return new AddTutorialGroupCommand(index, addTutorialGroupDescriptor);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<TutorialGroup>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<TutorialGroup>} containing zero tags.
     */
    private Optional<Set<TutorialGroup>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTutorialGroups(tagSet));
    }
}
