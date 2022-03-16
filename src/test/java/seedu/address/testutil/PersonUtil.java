package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_GITHUB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Student;
import seedu.address.model.tutorialgroup.TutorialGroup;

/**
 * A utility class for Student.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code student}.
     */
    public static String getAddCommand(Student student) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(student);
    }

    /**
     * Returns the part of command string for the given {@code student}'s details.
     */
    public static String getPersonDetails(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + student.getName().fullName + " ");
        sb.append(PREFIX_TELEGRAM + student.getTelegram().value + " ");
        sb.append(PREFIX_EMAIL + student.getEmail().value + " ");
        sb.append(PREFIX_GITHUB + student.getGitHub().value + " ");
        student.getTags().stream().forEach(
            s -> sb.append(PREFIX_TUTORIAL_GROUP + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getTelegram().ifPresent(phone -> sb.append(PREFIX_TELEGRAM).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getGitHub().ifPresent(address -> sb.append(PREFIX_GITHUB).append(address.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<TutorialGroup> tutorialGroups = descriptor.getTags().get();
            if (tutorialGroups.isEmpty()) {
                sb.append(PREFIX_TUTORIAL_GROUP);
            } else {
                tutorialGroups.forEach(s -> sb.append(PREFIX_TUTORIAL_GROUP).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
