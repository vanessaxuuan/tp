>*Note*:
>If you wish to copy and paste example commands do open up our full user guide
in a browser using the URL above, this document is for viewing only.

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


