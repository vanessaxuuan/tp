package seedu.address.model.module;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tutgroup.Class;

public class Module {
    private final ModuleName moduleName;
    private final Set<Class> classes = new HashSet<>();

    /**
     * Constructor for Module
     *
     * @param moduleName Name of the module, must not be null.
     * @param classes Set representing classes under the module, can be empty.
     */
    public Module(ModuleName moduleName, Set<Class> classes) {
        requireAllNonNull(moduleName, classes);
        this.moduleName = moduleName;
        this.classes.addAll(classes);
    }

    public ModuleName getModuleName() {
        return moduleName;
    }

    /**
     * Returns an immutable person set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Class> getClasses() {
        return Collections.unmodifiableSet(classes);
    }

    /**
     * Returns true if both modules have the same name.
     */
    public boolean isSameModule(Module otherModule) {
        if (otherModule == this) {
            return true;
        }

        return otherModule != null
            && otherModule.getModuleName().equals(getModuleName());
    }

    /**
     * Returns true if both classes have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Module)) {
            return false;
        }

        Module otherModule = (Module) other;
        return otherModule.getModuleName().equals(getModuleName())
            && otherModule.getClasses().equals(getClasses());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(moduleName, classes);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getModuleName());

        Set<Class> classes = getClasses();
        if (!classes.isEmpty()) {
            builder.append("; Class: ");
            classes.forEach(builder::append);
        }
        return builder.toString();
    }

}
