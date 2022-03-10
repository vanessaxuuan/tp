package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final TelegramHandle telegramHandle;
    private final Email email;

    // Data fields
    private final GitHub gitHub;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, TelegramHandle telegramHandle, Email email, GitHub gitHub) {
        requireAllNonNull(name, email);
        this.name = name;
        this.telegramHandle = telegramHandle;
        this.email = email;
        this.gitHub = gitHub;
    }

    public Name getName() {
        return name;
    }

    public Optional<TelegramHandle> getTelegramHandle() {
        if (telegramHandle == null) {
            return Optional.empty();
        } else {
            return Optional.of(telegramHandle);
        }
    }

    public Email getEmail() {
        return email;
    }

    public Optional<GitHub> getGitHub() {
        if (gitHub == null) {
            return Optional.empty();
        } else {
            return Optional.of(gitHub);
        }
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getTelegramHandle().equals(getTelegramHandle())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getGitHub().equals(getGitHub());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, telegramHandle, email, gitHub);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        String telegramHandleString;
        if (getTelegramHandle().isEmpty()) {
            telegramHandleString = "";
        } else {
            telegramHandleString = getTelegramHandle().get().toString();
        }
        String githubString;
        if (getGitHub().isEmpty()) {
            githubString = "";
        } else {
            githubString = getGitHub().get().toString();
        }
        builder.append(getName())
                .append("; TelegramHandle: ")
                .append(telegramHandleString)
                .append("; Email: ")
                .append(getEmail())
                .append("; GitHub: ")
                .append(githubString);

        return builder.toString();
    }

}
