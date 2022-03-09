package seedu.address.testutil;

import static seedu.address.testutil.TypicalClasses.G08;
import static seedu.address.testutil.TypicalClasses.G07;
import static seedu.address.testutil.TypicalClasses.G02;
import static seedu.address.testutil.TypicalClasses.T03;
import static seedu.address.testutil.TypicalClasses.T04;
import static seedu.address.testutil.TypicalClasses.W15_2;
import static seedu.address.testutil.TypicalClasses.W15_3;

import java.util.Arrays;
import java.util.HashSet;

import seedu.address.model._class.Class;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;


/**
 * A utility class containing a list of {@code Modules} objects to be used in tests.
 */
public class TypicalModules {
    private static final Class[] classesForCs2100 = {T03, T04};
    private static final Class[] classesForCs2103t = {W15_2, W15_3};
    private static final Class[] classesForCs2101 = {G02, G07, G08};

    private static final ModuleName cs2100Name = new ModuleName("CS2100");
    private static final ModuleName cs2103tName = new ModuleName("CS2103T");
    private static final ModuleName cs2101Name = new ModuleName("CS2101");

    private static final ModuleName cs2100Name_WithTrailingSpaces = new ModuleName("CS2100  ");
    private static final ModuleName cs2103tName_WithTrailingSpaces = new ModuleName("CS2103T  ");
    private static final ModuleName cs2101Name_WithTrailingSpaces = new ModuleName("CS2101  ");

    public static final Module CS2103T = new Module(cs2103tName, new HashSet<Class>(Arrays.asList(classesForCs2103t)));
    public static final Module CS2100 = new Module(cs2100Name, new HashSet<Class>(Arrays.asList(classesForCs2100)));
    public static final Module CS2101 = new Module(cs2103tName, new HashSet<Class>(Arrays.asList(classesForCs2101)));
    public static final Module CS2100_WITH_WRONG_NAME = new Module(cs2103tName,
        new HashSet<Class>(Arrays.asList(classesForCs2100)));
    public static final Module CS2100_WITH_WRONG_CLASS = new Module(cs2103tName,
        new HashSet<Class>(Arrays.asList(classesForCs2103t)));
    public static final Module CS2101_WITH_TRAILING_SPACES = new Module(cs2103tName_WithTrailingSpaces,
        new HashSet<Class>(Arrays.asList(classesForCs2101)));
}
