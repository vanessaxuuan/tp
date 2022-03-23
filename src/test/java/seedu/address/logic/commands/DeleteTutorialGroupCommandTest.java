package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2101_G08;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2103_W13_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2106_T02;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showStudentAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_STUDENT;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteTutorialGroupCommand.DeleteTutorialGroupDescriptor;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.student.Student;
import seedu.address.model.tutorialgroup.TutorialGroup;
import seedu.address.testutil.DeleteTutorialGroupDescriptorBuilder;
import seedu.address.testutil.StudentBuilder;

public class DeleteTutorialGroupCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_invalidStudentIndex_failure() {
        // index out of bounds
        showStudentAtIndex(model, INDEX_FIRST_STUDENT);
        Index outOfBoundIndex = INDEX_SECOND_STUDENT;
        // ensures that outOfBoundIndex is still in bounds of address book lit
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getStudentList().size());

        DeleteTutorialGroupCommand deleteTutorialGroupCommand = new DeleteTutorialGroupCommand(
                outOfBoundIndex,
                new DeleteTutorialGroupDescriptorBuilder()
                        .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2101_G08).build());

        assertCommandFailure(deleteTutorialGroupCommand, model, Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    @Test
    public void execute_deleteTutorialGroup_success() {
        Index indexSecondStudent = INDEX_SECOND_STUDENT;
        Student secondStudent = model.getFilteredStudentList().get(indexSecondStudent.getZeroBased());

        StudentBuilder studentInList = new StudentBuilder(secondStudent);
        Student editedStudent = studentInList.withTutorialGroup(VALID_TUTORIAL_GROUP_CS2103_W13_2).build();

        DeleteTutorialGroupDescriptor descriptor = new DeleteTutorialGroupDescriptorBuilder()
                .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2106_T02).build();

        DeleteTutorialGroupCommand deleteTutorialGroupCommand =
                new DeleteTutorialGroupCommand(indexSecondStudent, descriptor);

        String expectedMessage = String.format(DeleteTutorialGroupCommand.MESSAGE_DELETE_TUTORIAL_GROUP_SUCCESS,
                                               editedStudent);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setStudent(secondStudent, editedStudent);

        assertCommandSuccess(deleteTutorialGroupCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noSuchTutorialGroup_failure() {
        Index indexSecondStudent = INDEX_SECOND_STUDENT;

        DeleteTutorialGroupDescriptor descriptor = new DeleteTutorialGroupDescriptorBuilder()
                .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2101_G08).build();

        DeleteTutorialGroupCommand deleteTutorialGroupCommand =
                new DeleteTutorialGroupCommand(indexSecondStudent, descriptor);

        assertCommandFailure(deleteTutorialGroupCommand, model,
                DeleteTutorialGroupCommand.MESSAGE_NO_SUCH_TUTORIAL_GROUP);
    }

    @Test
    public void execute_onlyTutorialGroup_failure() {
        Index indexFirstStudent = INDEX_FIRST_STUDENT;

        DeleteTutorialGroupDescriptor descriptor = new DeleteTutorialGroupDescriptorBuilder()
                .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2103_W13_2).build();

        DeleteTutorialGroupCommand deleteTutorialGroupCommand =
                new DeleteTutorialGroupCommand(indexFirstStudent, descriptor);

        assertCommandFailure(deleteTutorialGroupCommand, model,
                DeleteTutorialGroupCommand.MESSAGE_CANNOT_DELETE_ONLY_TUTORIAL_GROUP);
    }

    @Test
    public void equals() {
        DeleteTutorialGroupDescriptor descriptor = new DeleteTutorialGroupDescriptor();
        descriptor.setTutorialGroup(new TutorialGroup(VALID_TUTORIAL_GROUP_CS2101_G08));
        final DeleteTutorialGroupCommand standardCommand =
                new DeleteTutorialGroupCommand(INDEX_FIRST_STUDENT, descriptor);

        // same values -> return true
        DeleteTutorialGroupDescriptor copyDescriptor = new DeleteTutorialGroupDescriptor();
        copyDescriptor.setTutorialGroup(new TutorialGroup(VALID_TUTORIAL_GROUP_CS2101_G08));
        DeleteTutorialGroupCommand commandWithSameValues =
                new DeleteTutorialGroupCommand(INDEX_FIRST_STUDENT, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new DeleteTutorialGroupCommand(INDEX_SECOND_STUDENT, copyDescriptor)));

        // different descriptor -> returns false
        DeleteTutorialGroupDescriptor differentDescriptor = new DeleteTutorialGroupDescriptor();
        differentDescriptor.setTutorialGroup(new TutorialGroup(VALID_TUTORIAL_GROUP_CS2103_W13_2));
        assertFalse(standardCommand.equals(new DeleteTutorialGroupCommand(INDEX_FIRST_STUDENT, differentDescriptor)));

    }
}
