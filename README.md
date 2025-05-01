# FinalProject
Final Project Vehicle Rental System



The vehicle rental system is a platform where customers can rent and return vehicles such as cars and motorcycles, and employees can manage those vehicles. Customers can see what’s on their dashboard and their car’s details and employees can see what cars are in their fleet. After requesting to rent a car, the system shows the rental cost and checks the car’s availability, which is changed once the car is rented. 


The system offers multiple services based on the user type, customer or employee:

1. Customer

View available vehicles: A list of all vehicles not currently rented, showing model, year, type, and rate.

Search for vehicles: A refined list matching search criteria (e.g., cars after 2020, motorcycles < $30/day).

Rent a vehicle: Confirmation message with rental summary: vehicle info, rental days, and total cost.

Return a vehicle: Success message showing return confirmation.

View rental history: A list of previously rented vehicles with dates and costs.

View rental receipt: Receipt showing rental ID, vehicle, total cost, and rental period.






	
	2.  Employee

Add a new vehicle: Success message: "Vehicle [plate] added successfully."

Remove a vehicle: Confirmation message with vehicle details removed.

Update vehicle information: Confirmation showing updated data (e.g., new rate or availability).

View all vehicles: Full list of fleet with status (rented / available), model type, and rate.

View rented vehicles: list of vehicles currently rented, including renter’s name or ID.

Sort vehicles: Ordered list based on selected criteria (e.g., rate, year, status).

Save fleet data: Message: "Fleet data saved to file successfully."

Load fleet data: Message: "Fleet data loaded from file successfully."

View rental logs: A list of all past rental transactions, including customer name, vehicle, rental period, and total cost. If no logs are available, display: "No rental logs found."



Hierarchies:

User hierarchy:
User (abstract super class): generic system user + attributes 
Customer (subclass): can search, rent, return, and view vehicles
Employee (subclass): can add, remove, update, view, and manage vehicles
Vehicle hierarchy:
Vehicle (abstract super class): defines common vehicle attributes
Car (subclass): extra car attributes
Motorcycle (subclass): extra motorcycle attributes

The rentable interface is needed in this project because it’s a single method to calculate rental costs for the different types of vehicles and the interface promotes polymorphism. It also simplifies the process if ever another type of vehicle were to be added, ensuring the core functionality of the code. 


Runtime polymorphism is used twice in this project: In the rentable interface and in the calculateRentalCost method


In this project, textIO is used in the VehicleRentalSystem class to save fleet data, where it writes vehicle details to a file and load fleet data, where it reads vehicle details from a file. TextIO is also used in the RentalService class to save rental logs, writing them to a file, and loading rental logs, to read them from a file. \


Comparable will be implemented in the Vehicle class and Comparator will be used in the VehicleRentalSystem class


For deliverable 2 (50%), I will implement the skeleton for User and Vehicle classes and subclasses, meaning the attributes, the setters and getters, equals method, toString and constructors as well as the comparable interface and the basic methods/actions for the users and vehicles. 
