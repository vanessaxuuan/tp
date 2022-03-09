package seedu.address.model._class;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.person.Person;

/**
 * Represents a Class in a Module
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Class {
    private final ClassName className;
    private final Venue venue;
    private final ZoomLink zoomLink;
    private final Set<Person> persons = new HashSet<>();

    public Class(ClassName className, Venue venue, ZoomLink zoomLink, Set<Person> persons) {
        requireAllNonNull(className, persons);
        this.className = className;
        this.venue = venue;
        this.zoomLink = zoomLink;
        this.persons.addAll(persons);
    }
    
    public ClassName getClassName() {
        return className;
    }

    public Optional<Venue> getVenue() {
        return Optional.ofNullable(venue); //handles case where venue is null
    }

    public Optional<ZoomLink> getZoomLink() {
        return Optional.ofNullable(zoomLink); //handles case where zoomLink is null
    }

    /**
     * Returns an immutable person set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Person> getPersons() {
        return Collections.unmodifiableSet(persons);
    }

    /**
     * Returns true if both classes have the same name.
     * This defines a weaker notion of equality between two classes.
     */
    public boolean isSameClass(Class otherClass) {
        if (otherClass == this) {
            return true;
        }

        return otherClass != null
            && otherClass.getClassName().equals(getClassName());
    }

    /**
     * Returns true if both classes have the same class name, venue, zoom link and persons
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Class)) {
            return false;
        }

        Class otherClass = (Class) other;
        return otherClass.getClassName().equals(getClassName())
            && otherClass.getVenue().equals(getVenue())
            && otherClass.getPersons().equals(getPersons())
            && otherClass.getVenue().equals(getVenue())
            && otherClass.getZoomLink().equals(getZoomLink());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(className, venue, zoomLink, persons);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getClassName());

        if (getVenue().isPresent()) {
            builder.append("; Venue: ").append(getVenue().get());
        }

        if (getZoomLink().isPresent()) {
            builder.append("; ZoomLink: ").append(getZoomLink().get());
        }

        Set<Person> persons = getPersons();
        if (!persons.isEmpty()) {
            builder.append("; Person: ");
            persons.forEach(builder::append);
        }
        return builder.toString();
    }
}
