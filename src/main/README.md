# Car Dealership Application

## Project Description

This is a Java console-based Car Dealership application developed as part of an Object-Oriented Programming (OOP) workshop.

The application allows a car dealership to manage its vehicle inventory. Users can search for vehicles using different criteria, view available vehicles, add new vehicles, and remove existing vehicles.

Vehicle information is stored in an `inventory.csv` file, allowing inventory changes to be saved and accessed when the application is restarted.

## Technologies Used

- Java
- IntelliJ IDEA
- Maven
- Git and GitHub
- CSV file handling

## Features

The application allows users to:

1. Search for vehicles within a price range.
2. Search for vehicles by make and model.
3. Search for vehicles within a year range.
4. Search for vehicles by color.
5. Search for vehicles within a mileage range.
6. Search for vehicles by type (car, truck, SUV, van).
7. Display all available vehicles.
8. Add a new vehicle to the inventory.
9. Remove a vehicle from the inventory.
10. Exit the application.

## Project Structure

```text
CarDealership/
│
├── src/
│   └── main/
│       └── java/
│           ├── Program.java
│           ├── Vehicle.java
│           ├── Dealership.java
│           ├── DealershipFileManager.java
│           └── UserInterface.java
│
├── inventory.csv
├── pom.xml
└── README.md
```

## Java Classes

### 1. Program.java
Contains the `main()` method that starts the application.

### 2. Vehicle.java
Stores vehicle information, including VIN, year, make, model, vehicle type, color, mileage, and price.

### 3. Dealership.java
Manages the vehicle inventory using an `ArrayList`. Contains methods for searching, adding, and removing vehicles.

### 4. DealershipFileManager.java
Reads vehicle information from `inventory.csv` and saves inventory changes to the file.

### 5. UserInterface.java
Displays the application menu, receives user input using `Scanner`, and calls the appropriate dealership methods.

## How to Run the Application

1. Clone or download this GitHub repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java is installed and the Maven project is loaded.
4. Confirm that `inventory.csv` is located in the main project folder alongside `pom.xml`.
5. Open `Program.java`.
6. Run the `main()` method.
7. Select an option from the menu.

## Example Menu

```text
=== CAR DEALERSHIP ===

1 - Find vehicles by price range
2 - Find vehicles by make/model
3 - Find vehicles by year range
4 - Find vehicles by color
5 - Find vehicles by mileage range
6 - Find vehicles by type
7 - List all vehicles
8 - Add a vehicle
9 - Remove a vehicle
99 - Quit

Choose an option:
```

## Inventory File

The application uses an `inventory.csv` file to store dealership and vehicle information.

The file uses a pipe (`|`) as the separator between values.

Example:

```text
D & B Used Cars|111 Old Benbrook Rd|817-555-5555
101121|1993|Ford|Explorer|SUV|Red|525123|995.00
37846|2001|Ford|Ranger|truck|Yellow|172544|1995.00
44901|2012|Honda|Civic|car|Gray|103221|6995.00
```

The first line contains dealership information. The remaining lines contain individual vehicle records.

## Object-Oriented Programming Concepts

This project demonstrates:

- **Classes and Objects:** Representing vehicles and dealerships.
- **Constructors:** Initializing objects with information.
- **Encapsulation:** Using private fields with getters and setters.
- **ArrayList:** Storing and managing multiple vehicles.
- **Methods:** Organizing the application into smaller tasks.
- **Loops:** Searching through vehicle inventory.
- **Conditional Statements:** Checking vehicle information against search criteria.
- **Switch Statements:** Handling user menu selections.
- **File Handling:** Reading and writing vehicle information using Java.

## Challenges and Learning Experience

One of the main challenges was understanding how different Java classes communicate with each other.

Separating the application into multiple classes helped me understand how object-oriented programming organizes code and assigns responsibilities.

Working with the CSV file also helped me understand how to read data, convert strings into the correct data types, and save changes.

Through this project, I strengthened my understanding of Java classes, constructors, methods, ArrayLists, loops, and file handling.

## Future Improvements

Possible improvements include:

- Adding more input validation.
- Allowing users to update existing vehicle information.
- Improving the console interface.
- Adding more vehicle search options.

## Author

Developed as part of a Java Object-Oriented Programming workshop.
