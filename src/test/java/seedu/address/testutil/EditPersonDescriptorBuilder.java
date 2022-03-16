package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.person.Telegram;
import seedu.address.model.tutorialgroup.TutorialGroup;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code student}'s details
     */
    public EditPersonDescriptorBuilder(Student student) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(student.getName());
        descriptor.setTelegram(student.getTelegram());
        descriptor.setEmail(student.getEmail());
        descriptor.setGitHub(student.getGitHub());
        descriptor.setTutorialGroups(student.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Telegram} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withTelegram(String telegram) {
        descriptor.setTelegram(new Telegram(telegram));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code GitHub} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withGitHub(String gitHub) {
        descriptor.setGitHub(new GitHub(gitHub));
        return this;
    }

    /**
     * Parses the {@code tutorialGroups} into a {@code Set<TutorialGroup>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTutorialGroup(String... tutorialGroups) {
        Set<TutorialGroup> tutorialGroupSet = Stream.of(tutorialGroups).map(TutorialGroup::new).collect(Collectors.toSet());
        descriptor.setTutorialGroups(tutorialGroupSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
