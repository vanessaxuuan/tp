---
layout: page
title: User Guide
---

TACH is a desktop app that helps CS Teaching Assistants tutoring multiple modules & classes by keeping track of their students and monitoring their progress on their tutorials. It is optimized for CLI users so that frequent tasks can be done faster by typing in commands.

##Table of Contents
[coming soon]

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `tach.jar` from [coming soon]

1. Copy the file to the folder you want to use as the _home folder_ for your TACH.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`add -m CS2103T` : Adds a Module named `CS2103T` to TACH.

   * **`delete`**`delete -c CS2103T W15-3` : Deletes the Class `W15-3` from Module `CS2103T`.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add -m MODULE`, `MODULE` is a parameter which can be used as `add -m CS2103T`.

* Items in square brackets are optional.<br>
  e.g `add -sd NAME e/EMAIL [t/TELEGRAM_HANDLE] [g/GITHUB]` can be used as `add -sd John Smith e/johnsmith@example.com t/JohnSmith g/johnsmyname` or without adding `t/JohnSmith`.

* Extraneous parameters for commands that do not take in parameters (such as `help`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

Format: `help`


### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Editing a person : `edit`

[coming soon]

### Locating persons by name: `find`

[coming soon]

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

#### Getting the zoom link of a class
Format: `get -z MODULE CLASS`

* Gets the zoom link of the class
* **NOTE:** `zoom link not found` will be shown if the zoom link is not present

Example:
* `get -z CS2103T W15-3` gets the zoom link for this class

#### Getting the venue of a class
Format: `get -v MODULE CLASS`

* Gets the venue of the class
* **NOTE:** `venue not found` will be shown if the venue is not present

Example:
* `get -z CS2103T W15-3` gets the zoom link for this class

### Clearing all entries : `clear`

[coming soon]

### Exiting the program : `exit`

[coming soon]

### Saving the data

TACH data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TACH data are saved as a JSON file `[JAR file location]/data/tach.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, TACH will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files 

[coming soon]

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add Module** | `add -m MODULE` <br> `e.g. add -m CS2103T`
**Add Class** | `add -c MODULE CLASS [v/VENUE] [z/ZOOM]` <br> e.g. `add -c CS2103T G08 v/LT27 z/https://nus-sg.zoom.us/j/01`
**Add Student** | `add -s MODULE CLASS STUDENT…` <br> e.g. `add -s CS2103T WS15-3 John Smith`
**Add Student Details** | `add -sd NAME e/EMAIL [t/TELEGRAM_HANDLE] [g/GITHUB]` <br> e.g. `add -sd John Smith e/johnsmith@example.com t/JohnSmith`
**Delete Modules** | `del -m MODULE…` <br> e.g. `del -m CS2103T CS2101`
**Delete Class** | `del -c MODULE CLASS…` <br> e.g. `del -c CS2103T W15-3`
**Delete Student** | `del -s MODULE CLASS s/STUDENT…` <br> e.g. `del -s CS2103T W15-3 s/Jack Smith`
**Get Module Details** | `get -m MODULE` <br> e.g. `get -m CS2103T`
**Get Class Details** | `get -c MODULE CLASS` <br> e.g. `get -c CS2103T W15-3`
**Get Student Details** | `get -s MODULE CLASS s/STUDENT…` <br> e.g. `get -s CS2103T W15-3 s/Jack Smith s/Mary Jane`
**Get zoom link** | `get -z MODULE CLASS` <br> e.g. `get -z CS2103T W15-3`
**Get venue** | `get -v MODULE CLASS` <br> e.g. `get -v CS2103T W15-3`
**List** | [coming soon]
**Help** | `help`
