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
    private final Address address;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, TelegramHandle telegramHandle, Email email, Address address) {
        requireAllNonNull(name, email, address);
        this.name = name;
        this.telegramHandle = telegramHandle;
        this.email = email;
        this.address = address;
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

    public Address getAddress() {
        return address;
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
                && otherPerson.getAddress().equals(getAddress());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, telegramHandle, email, address);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        String str;
        if (getTelegramHandle().isEmpty()) {
            str = "";
        } else {
            str = getTelegramHandle().get().toString();
        }
        builder.append(getName())
                .append("; TelegramHandle: ")
                .append(str)
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress());

        return builder.toString();
    }

}
