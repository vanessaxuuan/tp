package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;
import seedu.address.model.tutorialgroup.TutorialGroup;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDENTS;

public class AddTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "addtg";

    /**
     * to be updated
     */
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the student identified "
            + "by the index number used in the displayed student list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_TUTORIAL_GROUP + "TUTORIAL_GROUP]...\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    /**
     * to be updated
     */
    public static final String MESSAGE_ADD_TUTORIAL_GROUP_SUCCESS = "Added Tutorial Group: %1$s";
    public static final String MESSAGE_NOT_ADDED = "At least one tutorial group to add must be provided.";
    public static final String MESSAGE_DUPLICATE_TUTORIAL_GROUP = "This tutorial group already exists under the student.";

    /**
     * to be updated
     */
    private final Index index;
    private final AddTutorialGroupDescriptor addTutorialGroupDescriptor;

    public AddTutorialGroupCommand(Index index, AddTutorialGroupDescriptor addtg) {
        requireNonNull(index);
        requireNonNull(addtg);

        this.index = index;
        this.addTutorialGroupDescriptor = new AddTutorialGroupDescriptor(addtg);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Student> lastShownList = model.getFilteredStudentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        }

        Student studentToEdit = lastShownList.get(index.getZeroBased());
        Student editedStudent = createEditedPerson(studentToEdit, addTutorialGroupDescriptor);

        // identify duplicate tutorial groups
        if (!studentToEdit.isSameStudent(editedStudent) && model.hasStudent(editedStudent)) {
            throw new CommandException(MESSAGE_DUPLICATE_STUDENT);
        }

        // update student to edit
        model.setStudent(studentToEdit, editedStudent);
        model.updateFilteredStudentList(PREDICATE_SHOW_ALL_STUDENTS);
        return new CommandResult(String.format(MESSAGE_EDIT_STUDENT_SUCCESS, editedStudent));
    }

    /**
     * Stores the details to edit the student with. Each non-empty field value will replace the
     * corresponding field value of the student.
     */
    public static class AddTutorialGroupDescriptor {
        private Set<TutorialGroup> tutorialGroups;

        public AddTutorialGroupDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tutorialGroups} is used internally.
         */
        public AddTutorialGroupDescriptor(AddTutorialGroupDescriptor toCopy) {
            setTutorialGroups(toCopy.tutorialGroups);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(tutorialGroups);
        }

        /**
         * Sets {@code tutorialGroups} to this object's {@code tutorialGroups}.
         * A defensive copy of {@code tutorialGroups} is used internally.
         */
        public void setTutorialGroups(Set<TutorialGroup> tutorialGroups) {
            this.tutorialGroups = (tutorialGroups != null) ? new HashSet<>(tutorialGroups) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tutorialGroups} is null.
         */
        public Optional<Set<TutorialGroup>> getTutorialGroups() {
            return (tutorialGroups != null)
                    ? Optional.of(Collections.unmodifiableSet(tutorialGroups)) : Optional.empty();
        }

        /**
         * to be updated
         */
        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof AddTutorialGroupDescriptor)) {
                return false;
            }

            // state check
            AddTutorialGroupDescriptor e = (AddTutorialGroupDescriptor) other;

            return getTutorialGroups().equals(e.getTutorialGroups();
        }
    }
}