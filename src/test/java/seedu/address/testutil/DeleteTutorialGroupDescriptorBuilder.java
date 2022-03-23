package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2101_G08;

import seedu.address.logic.commands.DeleteTutorialGroupCommand.DeleteTutorialGroupDescriptor;
import seedu.address.model.tutorialgroup.TutorialGroup;

public class DeleteTutorialGroupDescriptorBuilder {

    public static final DeleteTutorialGroupDescriptor VALID_DELETE_TUTORIAL_DESCRIPTOR_CS2101_G08 =
            new DeleteTutorialGroupDescriptorBuilder(VALID_TUTORIAL_GROUP_CS2101_G08).build();

    private DeleteTutorialGroupDescriptor descriptor;

    public DeleteTutorialGroupDescriptorBuilder() {
        descriptor = new DeleteTutorialGroupDescriptor();
    }

    /**
     * Builds a DeleteTutorialGroupDescriptorBuilder based on the tutorial group string.
     *
     * @param tutorialGroup String of the tutorial group
     */
    private DeleteTutorialGroupDescriptorBuilder(String tutorialGroup) {
        descriptor = new DeleteTutorialGroupDescriptor();
        descriptor.setTutorialGroup(new TutorialGroup(tutorialGroup));
    }

    /**
     * Parses the {@code tutorialGroup} and sets it to the {@code DeleteTutorialGroupDescriptor} that we are building.
     * @param tutorialGroup
     * @return
     */
    public DeleteTutorialGroupDescriptorBuilder withTutorialGroup(String tutorialGroup) {
        descriptor.setTutorialGroup(new TutorialGroup(tutorialGroup));
        return this;
    }

    public DeleteTutorialGroupDescriptor build() {
        return descriptor;
    }
}
