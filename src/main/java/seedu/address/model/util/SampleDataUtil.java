package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.GitHub;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Telegram;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Telegram("87438807"),
                new Email("alexyeoh@example.com"), new GitHub("Blk 30 Geylang Street 29, #06-40")),
            new Person(new Name("Bernice Yu"), new Telegram("99272758"),
                new Email("berniceyu@example.com"), new GitHub("Blk 30 Lorong 3 Serangoon Gardens, #07-18")),
            new Person(new Name("Charlotte Oliveiro"), new Telegram("93210283"),
                new Email("charlotte@example.com"), new GitHub("Blk 11 Ang Mo Kio Street 74, #11-04")),
            new Person(new Name("David Li"), new Telegram("91031282"),
                new Email("lidavid@example.com"), new GitHub("Blk 436 Serangoon Gardens Street 26, #16-43")),
            new Person(new Name("Irfan Ibrahim"), new Telegram("92492021"),
                new Email("irfan@example.com"), new GitHub("Blk 47 Tampines Street 20, #17-35")),
            new Person(new Name("Roy Balakrishnan"), new Telegram("92624417"),
                new Email("royb@example.com"), new GitHub("Blk 45 Aljunied Street 85, #11-31"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

}
