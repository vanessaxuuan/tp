package seedu.address.model.student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tutorialgroup.TutorialGroup;

/**
 * Represents a Student in the address book.
 * Guarantees: details except telegram and gitHub are present and not null  field values are validated, immutable.
 * Telegram and GitHub will be empty strings if the user command does not include them.
 */
public class Student {

    // Identity fields
    private final Name name;
    private final Telegram telegram;
    private final Email email;
    private final GitHub gitHub;

    // Data field
    private final Set<TutorialGroup> tutorialGroups = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Student(Name name, Telegram telegram, Email email, GitHub gitHub, Set<TutorialGroup> tutorialGroups) {
        requireAllNonNull(name, email, telegram, gitHub, tutorialGroups);
        this.name = name;
        this.telegram = telegram;
        this.email = email;
        this.gitHub = gitHub;
        this.tutorialGroups.addAll(tutorialGroups);
    }

    public Name getName() {
        return name;
    }

    public Telegram getTelegram() {
        return telegram;
    }

    public Email getEmail() {
        return email;
    }

    public GitHub getGitHub() {
        return gitHub;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<TutorialGroup> getTutorialGroups() {
        return Collections.unmodifiableSet(tutorialGroups);
    }

    /**
     * Returns true if both students have the same name.
     * This defines a weaker notion of equality between two students.
     */
    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getName().equals(getName());
    }

    /**
     * Returns true if both students have the same identity and data fields.
     * This defines a stronger notion of equality between two students.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getTelegram().equals(getTelegram())
                && otherStudent.getEmail().equals(getEmail())
                && otherStudent.getGitHub().equals(getGitHub())
                && otherStudent.getTutorialGroups().equals(getTutorialGroups());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, telegram, email, gitHub, tutorialGroups);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Telegram: ")
                .append(getTelegram())
                .append("; Email: ")
                .append(getEmail())
                .append("; GitHub: ")
                .append(getGitHub());

        Set<TutorialGroup> tutorialGroups = getTutorialGroups();
        if (!tutorialGroups.isEmpty()) {
            builder.append("; Tags: ");
            tutorialGroups.forEach(builder::append);
        }
        return builder.toString();
    }

}