### Functionality
------
 * Create a user with a RESTful API
 * View all current users with a RESTful API


### Build instructions
------
* use Android Studio to build & run

### Demo of Functionality
* Handles errors of empty and/or duplicate emails
* Viewing the list of users, create a user, and see the updated list with newly created user

### Technology Used
------
* *Retrofit2* for networking
* *jsonschema2pojo* to quickly build a Java class to model a JSON schema
* *MVVM* for design pattern, separation of logic, testability
* *Data Binding* to bind Java object data to the UI, or vice versa (user inputs data into POJO)
* *Constraint Layout* to reliably and efficiently create custom layouts with many child views
* *RecyclerView* to view data as a list
* *Postman* to play around with the RESTful API and check validity of networking calls

### Things to note
------
* The *MainActivity* is the `CreateUserActivity.java`
* All the UI logic of the `CreateUserActivity.java` is in the `CreateUserViewModel.java`;
  the MVVM design allows the separation of view and viewmodel
* The code is roughly well-documented for ease of understanding.
  One should not struggle to read a teammate's code.

### Assumptions
------
* UI/unit tests/frameworks not needed, usability testing done instead.
* Emphasis on funcitonality, organization, modify-ability, and documentation - not on design.
  For a project with high emphasis on __custom__ design, please see [this repository instead](https://github.com/iAutoparkCars/StaffPickVideos/blob/master/README.md)
