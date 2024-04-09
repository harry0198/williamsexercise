# About
This project utilises multi maven modules with dependencies as follows:
```
Server -> domain <- Desktop
```
- Domain has shared records (dtos)
- Server provides parsing and exposing data via API (localhost:8080)
- Desktop accesses data from the server using requests.

The reasoning is because this allows a reduction of code duplication and the projects can still be built independently using some maven goals.

## Limitations
- Desktop app does not use asynchronous code, to keep with time restraints I didn't implement this but would be simple with completable future.
- Desktop app is ugly!
- Parser only splits for commas on csv - a library was not used to accommodate all csv features.

# Run
To run:
- Load project using IntelliJ IDEA
- Run Server Module (Main class -> src/main/java/me/harrydrummond/server/Williamsf1Application)
- Run Desktop Module (Main class -> src/main/java/me/harrydrummond/desktop/FXApplication)

If a message appears in the desktop module saying you need javafx runtimes, it is a common problem but a quick google search will quickly resolve.
