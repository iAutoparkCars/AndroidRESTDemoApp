### Functionality with Restful API
------
 * Create a user. Done by pressing the '+' `Image Button`
 * View all current users in a list. Done by pressing the "crowd" `Image Button` 
  *Update*: There should really be a progress dialog/fragment after "crowd" button is clicked, 
   and before list fragment is displayed.

### Build instructions
------
* use Android Studio to build & run

### Demo of Functionality
* `@Bindable` used to display errors of empty/invalid emails and
  network response handling for non-unique emails
  > ![error checking regifed](https://user-images.githubusercontent.com/14288932/37560085-31b9efd6-2a08-11e8-9fa9-a53ff215cf24.gif)

* Description of GIF below: 
  Viewing the list of users, create a unique user with email `helloUNIQUE@gmail.com`, sucessful network response is Toasted, 
  and see the updated list with newly created user with `id=2424`
  > ![creating viewing gif](https://user-images.githubusercontent.com/14288932/37560073-d990b97a-2a07-11e8-9dea-bb88a7e47556.gif)
  
### Technology Used
------
> 1. *Retrofit2* for networking
> 2. *jsonschema2pojo* to quickly build a Java class to model a JSON schema
> 3. *MVVM* for design pattern, separation of logic, testability
> 4. *Data Binding* to bind Java object data to the UI, or vice versa (user inputs data into POJO)
> 5. *ConstraintLayout* to reliably and efficiently create custom layouts with many child views
> 6. *RecyclerView* to view data as a list
> 7. *Postman* to play around with the RESTful API and check validity of networking calls

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
