package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Email;
import seedu.address.model.person.Student;
import seedu.address.model.person.Telegram;
import seedu.address.model.person.Name;
import seedu.address.model.tutorialgroup.TutorialGroup;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new Telegram("alexyeoh"), new Email("alexyeoh@example.com"),
                new GitHub("alex-yeoh"),
                getTutorialGroupSet("CS2101 G02")),
            new Student(new Name("Bernice Yu"), new Telegram("bernice01"), new Email("berniceyu@example.com"),
                new GitHub("bernice-yu"),
                getTutorialGroupSet("CS2101 G01", "CS2106 T05")),
            new Student(new Name("Charlotte Oliveiro"), new Telegram("@CharlotteO"), new Email("charlotte@example.com"),
                new GitHub("charlotte-oliveiro"),
                getTutorialGroupSet("CS2106 T05")),
            new Student(new Name("David Li"), new Telegram("davidli2020"), new Email("lidavid@example.com"),
                new GitHub("david-li-the-man"),
                getTutorialGroupSet("CS2101 G01")),
            new Student(new Name("Irfan Ibrahim"), new Telegram("irfanIbrahim"), new Email("irfan@example.com"),
                new GitHub("irfan-the-jet-plane"),
                getTutorialGroupSet("CS2101 G01")),
            new Student(new Name("Roy Balakrishnan"), new Telegram("@royBalakrishnan"), new Email("royb@example.com"),
                new GitHub("roy-balakrishnan"),
                getTutorialGroupSet("CS2106 T05"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSamplePersons()) {
            sampleAb.addPerson(sampleStudent);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<TutorialGroup> getTutorialGroupSet(String... strings) {
        return Arrays.stream(strings)
                .map(TutorialGroup::new)
                .collect(Collectors.toSet());
    }

}
