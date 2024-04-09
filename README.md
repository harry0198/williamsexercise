# About
This project utilises multi maven modules with dependencies as follows:
```
Server -> domain <- Desktop
```
![Module architecture drawio](https://github.com/harry0198/williamsexercise/assets/39655189/19fd94c6-9f93-4a9e-b6ba-0ae6c86800e4)
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

# Structure
## Desktop
Uses MVVM
![mvvm drawio](https://github.com/harry0198/williamsexercise/assets/39655189/68c20c7c-dddc-4580-a607-c6f1ab0f569f)

## Server
Uses controller, service and repository layers to conform to spring boot and allow for easy swapping and testing of each component.
![arch](https://github.com/harry0198/williamsexercise/assets/39655189/c9661150-00ad-4acf-ac1a-79d856fc4556)