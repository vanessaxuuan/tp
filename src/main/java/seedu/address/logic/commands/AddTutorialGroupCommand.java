package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Email;
import seedu.address.model.student.GitHub;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.Telegram;
import seedu.address.model.tutorialgroup.TutorialGroup;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDENTS;

/**
 * Adds tutorial group to a student identified using it's displayed index from the address book
 */
public class AddTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "addtg";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds tutorial groups to the student identified "
            + "by the index number used in the displayed student list. "
            + "Adding of tutorial groups is cumulative.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_TUTORIAL_GROUP + "TUTORIAL_GROUP]...\n"
            + "Example: " + COMMAND_WORD + " 1 " + PREFIX_TUTORIAL_GROUP + "CS2101 G08";

    public static final String MESSAGE_ADD_TUTORIAL_GROUP_SUCCESS = "Added Tutorial Group: %1$s";
    public static final String MESSAGE_NOT_ADDED = "At least one tutorial group to add must be provided.";
    public static final String MESSAGE_DUPLICATE_TUTORIAL_GROUP = "This module already exists under this student.";

    private final Index index;
    private final AddTutorialGroupDescriptor addTutorialGroupDescriptor;

    /**
     * @param index of the student in the filtered student list to edit
     * @param details to edit the student with
     */
    public AddTutorialGroupCommand(Index index, AddTutorialGroupDescriptor details) {
        requireNonNull(index);
        requireNonNull(details);

        this.index = index;
        this.addTutorialGroupDescriptor = new AddTutorialGroupDescriptor(details);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Student> lastShownList = model.getFilteredStudentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        }
        Student studentToEdit = lastShownList.get(index.getZeroBased());

        // identify duplicate modules
        if(studentToEdit.tutorialGroupExists(addTutorialGroupDescriptor.tutorialGroups)) {
            throw new CommandException(MESSAGE_DUPLICATE_TUTORIAL_GROUP);
        }

        Student updatedStudent = updateStudent(studentToEdit, addTutorialGroupDescriptor);
        model.setStudent(studentToEdit, updatedStudent);
        model.updateFilteredStudentList(PREDICATE_SHOW_ALL_STUDENTS);
        return new CommandResult(String.format(MESSAGE_ADD_TUTORIAL_GROUP_SUCCESS, studentToEdit));
    }

    /**
     * Update and returns {@code studentToEdit}
     * edited with {@code editStudentDescriptor}.
     */
    private static Student updateStudent(Student studentToEdit, AddTutorialGroupDescriptor addTutorialGroupDescriptor) {
        assert studentToEdit != null;

        Set<TutorialGroup> newTutorialGroups = addTutorialGroupDescriptor.getTutorialGroups()
                .orElse(studentToEdit.getTutorialGroups());
        return studentToEdit.addTutorialGroup(newTutorialGroups);
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

            return getTutorialGroups().equals(e.getTutorialGroups());
        }
    }
}