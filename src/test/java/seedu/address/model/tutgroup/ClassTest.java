package seedu.address.model.tutgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalClasses.G07;
import static seedu.address.testutil.TypicalClasses.G08;
import static seedu.address.testutil.TypicalClasses.T03;
import static seedu.address.testutil.TypicalClasses.T03_DIFFERENT_PERSON;
import static seedu.address.testutil.TypicalClasses.T03_NAME_IN_SMALL_LETTERS;
import static seedu.address.testutil.TypicalClasses.T03_SAME_NAME_REST_DIFFERENT;
import static seedu.address.testutil.TypicalClasses.T03_WRONG_NAME;
import static seedu.address.testutil.TypicalClasses.T03_WRONG_VENUE;
import static seedu.address.testutil.TypicalClasses.T03_WRONG_ZOOMLINK;
import static seedu.address.testutil.TypicalClasses.T04;
import static seedu.address.testutil.TypicalClasses.W15_2;
import static seedu.address.testutil.TypicalClasses.W15_3;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;

public class ClassTest {
    @Test
    public void getZoomLink_nullZoomLink_isEmpty() {
        assertTrue(() -> T03.getZoomLink().isEmpty());
        assertTrue(() -> T04.getZoomLink().isEmpty());
    }
    
    @Test
    public void getVenue_nullVenue_isEmpty() {
        assertTrue(() -> W15_2.getVenue().isEmpty());
        assertTrue(() -> W15_3.getVenue().isEmpty());
        assertTrue(() -> G07.getVenue().isEmpty());
    }
    
    @Test
    public void isSameClass() {
        // same object -> returns true
        assertTrue(G07.isSameClass(G07));

        // null -> returns false
        assertFalse(G07.isSameClass(null));

        // same name, all other attributes different -> returns false
        assertFalse(T03.equals(T03_SAME_NAME_REST_DIFFERENT));

        // different name, all other attributes same -> returns false
        assertFalse(T03.isSameClass(T03_WRONG_NAME));

        // name differs in case, all other attributes same -> returns false
        assertFalse(T03.isSameClass(T03_NAME_IN_SMALL_LETTERS));

    }

   @Test
    public void equals() {
        // same values -> returns true
        Person[] personsForG08 = {ALICE, BENSON};
        Class G08Copy =  new Class(new ClassName("G08"), null,
           new ZoomLink("https://nus-sg.zoom.us/j/34256312408"), new HashSet<>(Arrays.asList(personsForG08)));
        assertTrue(G08.equals(G08Copy));

        // same object -> returns true
        assertTrue(W15_2.equals(W15_2));

        // null -> returns false
        assertFalse(W15_2.equals(null));

        // different type -> returns false
        assertFalse(W15_2.equals(10));

        // different class -> returns false
        assertFalse(W15_2.equals(W15_3));

        // different class name -> returns false
        assertFalse(T03.equals(T03_WRONG_NAME));

        // different venue -> returns false
        assertFalse(T03.equals(T03_WRONG_VENUE));

        // different zoom link -> returns false
        assertFalse(T03.equals(T03_WRONG_ZOOMLINK));

        // different persons -> returns false
        assertFalse(T03.equals(T03_DIFFERENT_PERSON));

    }
}
