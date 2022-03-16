package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GITHUB_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GITHUB_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2101_G08;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_CS2103T_W15_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Student;

/**
 * A utility class containing a list of {@code Student} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Student ALICE = new PersonBuilder().withName("Alice Pauline")
            .withGitHub(null).withEmail("alice@example.com")
            .withTelegram("@APauline")
            .withTutorialGroup("CS2103 W13-2").build();
    public static final Student BENSON = new PersonBuilder().withName("Benson Meier")
            .withGitHub("bensonguy")
            .withEmail("johnd@example.com").withTelegram(null)
            .withTutorialGroup("CS2106 T02", "CS2103 W13-2").build();
    public static final Student CARL = new PersonBuilder().withName("Carl Kurz").withTelegram("@CarlJr")
            .withEmail("heinz@example.com").withGitHub("JrCarl").withTutorialGroup("CS2106 T02").build();
    public static final Student DANIEL = new PersonBuilder().withName("Daniel Meier").withTelegram("@DanieltheName")
            .withEmail("cornelia@example.com").withGitHub("Dan-iel").withTutorialGroup("CS2103 W13-2").build();
    public static final Student ELLE = new PersonBuilder().withName("Elle Meyer").withTelegram("@Elle20")
            .withEmail("werner@example.com").withGitHub("ELLE").withTutorialGroup("CS2106 T02", "CS2103 W13-2").build();
    public static final Student FIONA = new PersonBuilder().withName("Fiona Kunz").withTelegram("@Fiona14")
            .withEmail("lydia@example.com").withGitHub("Fiona-14").withTutorialGroup("CS2106 T02").build();
    public static final Student GEORGE = new PersonBuilder().withName("George Best").withTelegram("@George11")
            .withEmail("anna@example.com").withGitHub("George-Not-Bush").withTutorialGroup("CS2106 T02").build();

    // Manually added
    public static final Student HOON = new PersonBuilder().withName("Hoon Meier").withTelegram("@Hooooon")
            .withEmail("stefan@example.com").withGitHub("hoon-meier-14").withTutorialGroup("CS2106 T02").build();
    public static final Student IDA = new PersonBuilder().withName("Ida Mueller").withTelegram("@idaida10")
            .withEmail("hans@example.com").withGitHub("mueller-ida-20").withTutorialGroup("CS2103 W13-2").build();

    // Manually added - Student's details found in {@code CommandTestUtil}
    public static final Student AMY = new PersonBuilder().withName(VALID_NAME_AMY).withTelegram(VALID_TELEGRAM_AMY)
            .withEmail(VALID_EMAIL_AMY).withGitHub(VALID_GITHUB_AMY)
            .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2101_G08).build();
    public static final Student BOB = new PersonBuilder().withName(VALID_NAME_BOB).withTelegram(VALID_TELEGRAM_BOB)
            .withEmail(VALID_EMAIL_BOB).withGitHub(VALID_GITHUB_BOB)
            .withTutorialGroup(VALID_TUTORIAL_GROUP_CS2103T_W15_3, VALID_TUTORIAL_GROUP_CS2101_G08).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Student student : getTypicalPersons()) {
            ab.addPerson(student);
        }
        return ab;
    }

    public static List<Student> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
