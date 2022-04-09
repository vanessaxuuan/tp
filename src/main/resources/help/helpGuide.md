## A quick Command Summary

1. **Add Student** : `add n/NAME e/EMAIL [t/TELEGRAM] [g/GITHUB] tg/TUTORIAL_GROUP…` <br> 
e.g. `add n/John Smith tg/CS2103T W15-3 e/e0123456@u.nus.edu t/johnsmyname g/johnsmyname`


2. **Add Tutorial Group for Student** : `addtg INDEX tg/TUTORIAL_GROUP…` <br> 
e.g. `addtg 5 tg/CS2100 G08`


3. **Edit Student** : `edit INDEX [n/NAME] [e/EMAIL] [t/TELEGRAM] [g/GITHUB] [tg/TUTORIAL_GROUP]…` <br> 
e.g. `edit 3 n/Mary Sue t/PresentPerfect`


4. **Find Students by name** : `find KEYWORD [ADDTIONAL_KEYWORDS]` <br> 
e.g. `find Jack Jane`


5. **Find Students by Tutorial Group** : `findtg TUTORIAL_GROUP` <br> 
e.g. `findtg CS2101 G08`

6. **Delete Student** : `delete INDEX` <br> 
e.g. `delete 4`


7. **Deleting Tutorial Group from Student** : `deletetg INDEX tg/TUTORIAL_GROUP` <br> 
e.g. `deletetg 4 tg/cs2030s t11`


8. **Deleting Tutorial Group from all Students** : `deletetgall tg/TUTORIAL_GROUP…` <br> 
e.g. `deletetgall tg/CS2106 T08`


9. **List** : `list`


10. **Clear** : `clear`


11. **Help** : `help`
---
---
Refer below for more details about command formats.

## Commands

**Notes about the command format:**

* Words in `UPPER_CASE` are the parameters to be supplied by the user. <br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.<br>


* Items in square brackets are optional. <br>
  e.g. `e/EMAIL [t/TELEGRAM]` can be used as `e/e0123456@u.nus.edu t/JohnSmith` or as `e/e0123456@u.nus.edu`<br><br>

* Items with `…` after them can be added multiple times. <br>
  e.g. `tg/TUTORIAL_GROUP…` can be used as `tg/CS2103 W15-3`, `tg/CS2103 W15-3 tg/CS2100 G08` etc.<br><br>

* Parameters can be in any order. <br>
  e.g. if the command specifies `n/NAME e/EMAIL`, `e/EMAIL n/NAME` is also acceptable.<br><br>

* Extraneous parameters for commands that do not take in parameters (such as `help`) will be ignored. <br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`. <br>
- `help123` will not be interpreted as `help`.<br><br>

* `INDEX` represents the corresponding student currently displayed in TACH, and it has to be a positive integer.

### Viewing help : `help`

Shows a message explaining how to access the help page.

Format: `help`

### Listing all students: `list`

Shows a list of all students in TACH.

Format: `list`

The students will be sorted in alphabetical order by their names.

### Adding

#### Adding a student: `add`

Adds a student into TACH.

Format: `add n/NAME e/EMAIL [t/TELEGRAM] [g/GITHUB] tg/TUTORIAL_GROUP…`

Note:
* Students with the same names will be considered as duplicate students.
  - e.g. If `Sam` exists in TACH, another `Sam` **cannot be added again** even if their contact details are different.
  - Do manually differentiate them by saving them as `Sam1` and `Sam2` for easier reference.
  - This is because if two `Sam`s  are in the same tutorial group, you might not be able to recognize which `Sam` is which `Sam` in TACH as you most likely will not be able to remember their personal contact details to differentiate them.
  - Thus, names would be used to uniquely identify everyone.

Examples:
* `add n/John Doe tg/CS2100 G08 e/e0123456@u.nus.edu`
* `add n/Michael Tay e/michaelT@gmail.com t/MichaelTay g/michael777 tg/CS2103T W15-3 tg/CS2100 G08`

The following diagram shows the output for the following input: <br>
`add n/Chloe Lee e/chloexlee@gmail.com t/chloe201 g/jchloechloe tg/CS2101 G08`

#### Adding a tutorial group for a student: `addtg`

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

### Finding

#### Finding students by name: `find`

Finds students whose names contain all the given keywords.

Format `find KEYWORD [ADDTIONAL_KEYWORDS]`

* The search is case-insensitive. e.g. `charles` will match `Charles`
* The order of the keywords does not matter. e.g. `Charles Boyle` will match `Boyle Charles`
* Only the name is searched.
* Words can be partially matched e.g. `Char` **WILL** match `Charles`
* Multiple keywords can be partially matched too e.g. `Alex Ko` will match `Alex Koh`
* Only students matching all the keywords will be returned.
  e.g. `Charles Lee` will return `Charles Alex Lee`, not `Charles Tan`

Examples:
* `find Evans Smith` returns `Evans Smith`, `Evans Josh Smith` (if they
  are in the list).

#### Finding students by tutorial group: `findtg`

Finds all students in a particular tutorial group.

Format `findtg TUTORIAL_GROUP`

* The search is case-insensitive. e.g. `cs2101 g08` will match `CS2101 G08`
* The search ignores extra whitespaces. e.g. `cs2101<><><>g08` will match `cs2101<>g08` 
(`<>` illustrates whitespace)
* Only the tutorial group is searched.
* Only the exact tutorial group will be matched e.g. `CS2101 G` **WILL NOT** match `CS2101 G08`
* Students with matching tutorial group will be returned. e.g. `findtg CS2101 G08` will return
  `Charles Martinet` and `Susan Boyle` only if both of them are in the tutorial group `CS2101 G08`
* If there are no students with matching tutorial group, no student will be returned (an empty list).

### Deleting

#### Deleting a student: `delete`

Deletes the specified student from TACH.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the current displayed student list.
* The index **must be a positive number** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd student listed in TACH.
* `find Waldo` followed by `delete 1` deletes the 1st student in the results of the `find` command.
  <br><br>

#### Deleting a tutorial group from a student: `deletetg`

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

#### Deleting tutorial groups from all students: `deletetgall`

Deletes the specified tutorial group from **ALL** students in TACH.

Format: `deletetgall tg/TUTORIAL_GROUP…`

* Deletes the specified tutorial group from **ALL** students stored in TACH.
* The tutorial group must be written **EXACTLY**, but is *case-insensitive*. e.g. `deletetgall tg/cs2040s t03` will
  delete `CS2040S T03` from tutorial groups of all Students, but `deletetgall tg/cs2040s` or `deletetgall tg/cs2040st03` **WILL NOT** successfully delete `CS2040S T03` from students in TACH.
> **NOTE**: After the deletion, you will see all the updated remaining students in TACH.

>**WARNING:**
> 1. Students with 0 tutorial groups after the deletion will automatically be deleted.
> 2. **ALL** students in TACH will be affected. Even those not visible as a result of `find` command.

Example:
* `find Eve` followed by `deletetgall tg/CS2103T W15-3` deletes the tutorial group `CS2103T W15-3` from all students in TACH, including those not visible after the `find Eve` command(i.e. students whose name does not contain `Eve`)
* `deletetgall tg/CS2106 T08 tg/CS2103T W13-3` will remove tutorial groups `CS2106 T08` and `CS2103T W13-3` from all students in TACH. Students with 0 tutorial group will be deleted from TACH.

Note:
- 3 students, `Gwak Seo Hyeon`, `John Smith` and `Pranith Loganathan` are deleted because they have 0 tutorial groups left after `CS2100 T05` is deleted.

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

1. **INDEX** : Must be a positive integer (1, 2, 3, …) 


2. **NAME**  : Must have at least one word, and each word can only have letters and numbers <br> 
e.g. `Edward the 4th`


3. **TUTORIAL_GROUP** : Must start with a valid module code, followed by a space, then a word that can contain letters, numbers, 
underscores and hyphens. It can **NEVER** be empty. <br> 
e.g. `CS2103T W15-3_A` 


4. **EMAIL** : An email consists of three parts in the following order, the local part, the `@` sign, and the domain part. <br> The local part should only contain letters, 
numbers, and these special symbols: `+` `_` `.` `-`. It cannot start or end with the special symbols. It must be at most 64 characters long. <br> There must be an @ sign afterwards, followed by the domain name. <br> 
The domain name must be one of the following: `u.nus.edu` `nus.edu.sg` `gmail.com` `yahoo.com` `outlook.com` `hotmail.com` <br> (Our original intention
is for you to put in your students' NUS emails which are given to you on LumiNUS, but we also provide the freedom to use some of the more popular email providers listed above, should they be more convenient.) <br>
e.g. `e0123456@u.nus.edu` or `jasminelim@gmail.com` <br>


5. **TELEGRAM** : May include `@` at the start. Must be exactly one word that can contain letters, numbers and underscores. It must be between 5 to 32 characters long (inclusive). This does not count the `@` symbol. <br>
e.g. `Dave3` or `@Lorem_ipsum_dolor_sit_amet_12345`


6. **GITHUB** : Must be exactly one word that can contain letters, numbers and hyphens. It must be at most 39 characters long. <br> 
e.g. `12345678` or `cake-is-a-lie77` 

