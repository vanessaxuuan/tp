package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.HOON;
import static seedu.address.testutil.TypicalPersons.IDA;

import java.util.Arrays;
import java.util.HashSet;

import seedu.address.model.person.Person;
import seedu.address.model.tutgroup.Class;
import seedu.address.model.tutgroup.ClassName;
import seedu.address.model.tutgroup.Venue;
import seedu.address.model.tutgroup.ZoomLink;

public class TypicalClasses {
    private static final Person[] personsForG08 = {ALICE, BENSON};
    private static final Person[] personsForG07 = {ELLE, HOON};
    private static final Person[] personsForG02 = {FIONA, AMY, BOB};
    private static final Person[] personsForW15_3 = {DANIEL, ELLE, HOON};
    private static final Person[] personsForW15_2 = {AMY, ALICE, DANIEL};
    private static final Person[] personsForT04 = {FIONA, ALICE, IDA};
    private static final Person[] personsForT03 = {DANIEL, BENSON, AMY};

    public static final Class G08 = new Class(new ClassName("G08"), null,
        new ZoomLink("https://nus-sg.zoom.us/j/34256312408"), new HashSet<>(Arrays.asList(personsForG08)));
    public static final Class G07 = new Class(new ClassName("G07"), null,
        new ZoomLink("https://nus-sg.zoom.us/j/34256168249"), new HashSet<>(Arrays.asList(personsForG07)));
    public static final Class G02 = new Class(new ClassName("G02"), null,
        new ZoomLink("https://nus-sg.zoom.us/j/34256168243"), new HashSet<>(Arrays.asList(personsForG02)));
    public static final Class W15_3 = new Class(new ClassName("W15-3"), null,
        new ZoomLink("https://nus-sg.zoom.us/j/14352165414"), new HashSet<>(Arrays.asList(personsForW15_3)));
    public static final Class W15_2 = new Class(new ClassName("W15-2"), null,
        new ZoomLink("https://nus-sg.zoom.us/j/14352161451"), new HashSet<>(Arrays.asList(personsForW15_2)));
    public static final Class T04 = new Class(new ClassName("T04"), new Venue("COM01-0113"),
        null, new HashSet<>(Arrays.asList(personsForT04)));
    public static final Class T03 = new Class(new ClassName("T03"), new Venue("COM01-0114"),
        null, new HashSet<>(Arrays.asList(personsForT03)));

    public static final Class T03_WRONG_NAME = new Class(new ClassName("T10"), new Venue("COM01-0114"),
        null, new HashSet<>(Arrays.asList(personsForT03)));
    public static final Class T03_WRONG_VENUE = new Class(new ClassName("T03"), new Venue("I3-AUD"),
        null, new HashSet<>(Arrays.asList(personsForT03)));
    public static final Class T03_WRONG_ZOOMLINK = new Class(new ClassName("T03"), new Venue("COM01-0114"),
        new ZoomLink("https://nus-sg.zoom.us/j/14352161451"), new HashSet<>(Arrays.asList(personsForT03)));
    public static final Class T03_DIFFERENT_PERSON = new Class(new ClassName("T03"), new Venue("COM01-0114"),
        null, new HashSet<>(Arrays.asList(personsForG02)));

    public static final Class T03_SAME_NAME_REST_DIFFERENT = new Class(new ClassName("T03"), new Venue("I3-AUD"),
        new ZoomLink("https://nus-sg.zoom.us/j/14352161451"), new HashSet<>(Arrays.asList(personsForG02)));
    public static final Class T03_NAME_WITH_TRAILING_WHITESPACES =
        new Class(new ClassName("T03"), new Venue("COM01-0114"),
        null, new HashSet<>(Arrays.asList(personsForT03)));
    public static final Class T03_NAME_IN_SMALL_LETTERS = new Class(new ClassName("t03"), new Venue("COM01-0114"),
        null, new HashSet<>(Arrays.asList(personsForT03)));
}
