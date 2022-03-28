---
layout: page
title: User Guide
---

## Introduction

TACH is a desktop app that helps Computer Science (CS) Teaching Assistants (TAs) tutoring multiple tutorial groups by
**managing their students in an organised manner**.

TAs can **add, edit and delete** students and their tutorial groups from their list easily.
TAs can also **find** students by their name or by their tutorial group.

TACH automatically sorts students in alphabetical order, and all the students' contact details are right next to
their names, so that you can get their details in a glance, and you easily know which contacts belong to whom.

TACH works by typing what you want to do as commands. It is optimized for keyboard users, so if you can type fast,
TACH can work even faster.

## How to use this guide

**The goal of this guide is to help you**, the reader, to **understand how to use our app better**, regardless of
whether you are a new user or an experienced user.

If you are a new user and want to learn how to download and set up the app, go to **[Quick Start](#quick-start)**.
<br>If you have already installed the app and want to learn the basics, go to **[Quick Tutorial](#quick-tutorial)**.

If you are an experienced user who wants to use app to its full potential, or you just want a quick refresher on
the commands, you can refer to the list of possible commands available in TACH via **[Commands](#commands)**.

--------------------------------------------------------------------------------------------------------------------

## Table of Contents

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick Start

1. Ensure you have **[Java 11](https://www.oracle.com/java/technologies/downloads/#java11-windows)** or above installed in your Computer.

2. Download the latest `TACH.jar` from [coming soon]

3. Copy the file to the folder you want to use as the _home folder_ for your TACH.

4. Double-click the file to start the app. The app should appear in a few seconds and look similar to the image below. Note how the app contains some sample data.<br><br>
   ![Ui](images/QuickStart.png)

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>

* You can **resize** the app by clicking and dragging the edges of the window to see more users at a time.
You can also **maximise** the window.

</div>

5. You're ready to start using TACH! You can continue to the **[Quick Tutorial](#quick-tutorial)** to learn
how to navigate through the app, and some basic commands.
<br>Or if you're feeling confident, you can dive straight into all the **[Commands](#commands)**.

--------------------------------------------------------------------------------------------------------------------

## Quick Tutorial

Here is a quick summary of all the components of the app:

(Insert image Ui but with callouts here)

(Explain UI elements)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`add n/John Doe e/e0123456@u.nus.edu tg/CS2103T W15-3` : Adds a contact named `John Doe` to TACH.

   * **`delete`**`delete 2` : Deletes the 2nd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

Congratulations! You've learned what each component in the app is, and some basic commands that you can use right now
to get started! If you want more details on what each command does, you can refer to **[Commands](#commands)** for
a better understanding.

--------------------------------------------------------------------------------------------------------------------

## Commands

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g. `e/EMAIL [t/TELEGRAM]` can be used as `e/e0123456@u.nus.edu t/JohnSmith` or as `e/e0123456@u.nus.edu`

* Items with `…` after them can be used multiple times.<br>
  e.g. `tg/TUTORIAL_GROUP…` can be used as `tg/CS2103 W15-3`, `tg/CS2103 W15-3 tg/CS2100 G08` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME e/EMAIL`, `e/EMAIL n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

Format: `help`

### Listing all students: `list`

Shows a list of all students in the address book.

Format: `list`

### Adding a student: `add`

Adds a student into TACH.

Format: `add n/NAME e/EMAIL [t/TELEGRAM] [g/GITHUB] tg/TUTORIAL_GROUP…`

Examples:
* `add n/John Doe tg/CS2100 G08 e/e0123456@u.nus.edu`
* `add n/Michael Tay e/michaelT@gmail.com t/MichaelTay g/michael777 tg/CS2103T W15-3 tg/CS2100 G08`

### Adding a tutorial group for a student: `addtg`

Adds a tutorial group for a student already in TACH.

Format: `addtg INDEX tg/TUTORIAL_GROUP…`

* Adds a tutorial group for the student at the specified `INDEX`. The index refers to the index number
shown in the current displayed student list. The index **must be a positive number** 1, 2, 3, …
* Adding of tutorial groups is cumulative; existing tutorial groups of the specified student will
remain unchanged.

Example:
* `list` followed by `addtg 2 tg/CS2040S T03` adds the tutorial group `CS2040S T03` for the 2nd student listed in TACH.
* `find Dave` followed by `addtg 1 tg/CS2040S T03 tg/CS3230 T01` adds the tutorial groups `CS2040S T03` and
`CS3230 T01` for the 1st student in the results of the `find` command.

### Editing a student : `edit`

Edits an existing student in TACH.

Format: `edit INDEX [n/NAME] [e/EMAIL] [t/TELEGRAM] [g/GITHUB] [tg/TUTORIAL_GROUPS]…`

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the current displayed
student list. The index **must be a positive number** 1, 2, 3, …
* At least one of the optional details (Name/NUS email/Telegram/GitHub) must be provided.
* Any detail entered in the `edit` command will replace the original detail of the student.
* Details not entered in the `edit` command will stay the same and not be replaced.
>*Note*:
> 1. Tutorial groups **CANNOT** be empty.
`edit 1 tg/` is **NOT** allowed.
>2. GitHub and Telegram **CAN** be empty.
`edit 1 g/  t/` is allowed and will set GitHub and Telegram to empty strings.

Examples:
* `list` followed by `edit 2 t/DaveHunter g/Hunter02` edits the 2nd student listed in TACH. Their Telegram will be
edited to `DaveHunter` and their GitHub will be edited to `Hunter02`.
* `find Robert` followed by `edit 1 n/Bobby Smiles` edits the 1st student in the results of the `find` command. Their
name will be edited to `Bobby Smiles`.

### Finding students by name: `find`

Finds students whose names contain all the given keywords.

Format `find KEYWORD [ADDTIONAL_KEYWORDS]`

* The search is case-insensitive. e.g. `charles` will match `Charles`
* The order of the keywords does not matter. e.g. `Charles Boyle` will match `Boyle Charles`
* Only the name is searched.
* Only full words will be matched e.g. `Char` **WILL NOT** match `Charles`
* Only students matching all the keywords will be returned.
e.g. `Charles Lee` will return `Charles Alex Lee`, not `Charles Tan`

Examples:
* `find Evans Smith` returns `Evans Smith`, `Evans Josh Smith` (if they
are in the list).

### Finding students by tutorial group: `findtg`

Finds all students in a particular tutorial group.

Format `findtg TUTORIAL_GROUP`

* The search is case-insensitive. e.g. `cs2101 g08` will match `CS2101 G08`
* Only the tutorial group is searched.
* Only the exact tutorial group will be matched e.g. `CS2101 G` **WILL NOT** match `CS2101 G08`
* Students with matching tutorial group will be returned. e.g. `findtg CS2101 G08` will return
`Charles Martinet` and `Susan Boyle` only if both of them are in the tutorial group `CS2101 G08`
* If there are no students with matching tutorial group, no student will be returned (an empty list).

### Deleting a student: `delete`

Deletes the specified student from TACH.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the current displayed student list.
* The index **must be a positive number** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd student listed in TACH.
* `find Waldo` followed by `delete 1` deletes the 1st student in the results of the `find` command.

### Deleting a tutorial group from a student: `deletetg`

Deletes the specified tutorial group from the specified student.

Format: `deletetg INDEX tg/TUTORIAL_GROUP`

* Deletes the specified tutorial group of the student at the specified `INDEX`. The index refers to the index
number shown in the current displayed student list. The index **must be a positive number** 1, 2, 3, …
* The tutorial group must be written **EXACTLY**, but is *case-insensitive*. e.g. `deletetg 1 tg/cs2040s t03` will
delete `CS2040S T03` if that person has that tutorial group, but `deletetg 1 tg/cs2040s` or `deletetg 1 tg/cs2040st03`
**WILL NOT** successfully delete it.
* The tutorial group **cannot be deleted** if it is the **only** tutorial group a student has. e.g. A student with only
one tutorial group `CS2040S T03` cannot have their tutorial group deleted.

Examples:
* `list` followed by `deletetg 2 tg/CS2103T W15-3` deletes the tutorial group `CS2103T W15-3` of the 2nd student listed
in TACH (only if the 2nd student had more than one tutorial group).
* `find Carmen` followed by `deletetg 1 tg/cs2100 g01` deletes the tutorial group `CS2100 G01` of the 1st student in the
results of the `find` command (only if the 1st student had more than one tutorial group).

### Deleting tutorial groups from all students: `deletetgall`

Deletes the specified tutorial group from **ALL** students in TACH.

Format: `deletetgall tg/TUTORIAL_GROUP…`

* Deletes the specified tutorial group in **ALL** students stored in TACH.
* The tutorial group must be written **EXACTLY**, but is *case-insensitive*. e.g. `deletetgall tg/cs2040s t03` will
  delete `CS2040S T03` from tutorial groups of all Students, but `deletetgall tg/cs2040s` or `deletetgall tg/cs2040st03` **WILL NOT** successfully delete `CS2040S T03` from students in TACH.
>**WARNING:** Students with 0 tutorial groups after the deletion will automatically be deleted.

Example:
* `deletetgall tg/CS2106 T08 tg/CS2103T W13-3` will remove tutorial groups `CS2106 T08` and `CS2103T W13-3` from all students in TACH. Students with 0 tutorial group will be deleted from TACH.

### Clearing all entries : `clear`

Clears all entries from TACH.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

## Input Requirements

There are **parameters** (like Names, NUS Emails, and GitHub usernames for example) that must follow certain
requirements so that TACH recognises them as valid parameters. Here is a list of requirements of every parameter to
easier understand which parameters are invalid when typing a command.

In the list, a **word** is defined as a bunch of *characters* (letters, numbers, punctuation, etc.) separated by spaces.
e.g. `There A_RE 4 w0-rd_s.` has 4 words.

| Parameter          | Requirements                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **INDEX**          | Must be a positive integer (1, 2, 3, …)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **NAME**           | Must have at least one word, and each word can only have letters and numbers <br> e.g. `Edward the 4th`                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **TUTORIAL_GROUP** | Must start with a valid module code, followed by a space, then a word that can contain letters, numbers, underscores and hyphens. It can **NEVER** be empty. <br> e.g. `CS2103T W15-3_A`                                                                                                                                                                                                                                                                                                                                                      |
| **EMAIL**          | An email consists of two parts, the local part before the `@` sign, and the domain part after the `@` sign. In other words, `{LOCAL}@{DOMAIN}`<br> The local part should only contain letters, numbers, and these special symbols: `+` `_` `.` `-`. They cannot start or end with the special symbols. <br> There must be an @ sign, followed by the domain name. The domain name is made up of domain labels separated by periods. <br> e.g. `e0123456@u.nus.edu` or `jasminelim@gmail.com` <br><br> (Basically, just put in a valid email!) |
| **TELEGRAM**       | May include `@` at the start. Must be exactly one word that can contain letters, numbers and underscores. It must be between 5 to 32 characters long (inclusive). This does not count the `@` symbol. <br> e.g. `Dave3` or `@Lorem_ipsum_dolor_sit_amet_12345`                                                                                                                                                                                                                                                                                |
| **GITHUB**         | Must be exactly one word that can contain letters, numbers and hyphens. It must be at most 39 characters long. <br> e.g. `12345678` or `cake-is-a-lie77`                                                                                                                                                                                                                                                                                                                                                                                      |

## Saving the data

TACH data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

## Editing the data file

TACH data are saved as a JSON file `[JAR file location]/data/tach.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, TACH will discard all data and start with an empty data file at the next run.
</div>

## Archiving data files

[coming soon]

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous TACH home folder.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

| Action                                   | Format, Examples                                                                                                                                               |
|------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Student**                          | `add n/NAME e/EMAIL [t/TELEGRAM] [g/GITHUB] tg/TUTORIAL_GROUP…` <br> e.g. `add n/John Smith tg/CS2103T W15-3 e/e0123456@u.nus.edu t/johnsmyname g/johnsmyname` |
| **Add Tutorial Group for Student**       | `addtg INDEX tg/TUTORIAL_GROUP…` <br> e.g. `addtg 5 tg/CS2100 G08`                                                                                             |
| **Edit Student**                         | `edit INDEX [n/NAME] [e/EMAIL] [t/TELEGRAM] [g/GITHUB] [tg/TUTORIAL_GROUP]…` <br> e.g. `edit 3 n/Mary Sue t/PresentPerfect`                                    |
| **Find Students by name**                | `find KEYWORD [ADDTIONAL_KEYWORDS]` <br> e.g. `find Jack Jane`                                                                                                 |
| **Find Tutorial Group**                  | `findtg TUTORIAL_GROUP` <br> e.g. `findtg CS2101 G08`                                                                                                          |
| **Delete Student**                       | `delete INDEX` <br> e.g. `delete 4`                                                                                                                            |
| **Deleting Tutorial Group from Student** | `deletetg INDEX tg/TUTORIAL_GROUP` <br> e.g. `deletetg 4 tg/cs2030s t11`                                                                                       |
| **List**                                 | `list`                                                                                                                                                         |
| **Clear**                                | `clear`                                                                                                                                                        |
| **Help**                                 | `help`                                                                                                                                                         |
