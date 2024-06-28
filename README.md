# :books: Library API task:

------------------------------

### 1.Technology Used
	
1.1 Accomplished goals

### 2. Project Structure

### 3. DataInitializer class

### 4.Endpoints showcase

4.1 Add book

4.2 Get all books

4.3 Get book by id

4.4 Update a Book

4.5 Delete a Book

4.6 Add a Customer

4.7 Get All Customers

4.8 Get Customer by ID

4.9 Customer update

4.10 Delete Customer

4.11 Borrow a Book

4.12 Return a book

### 5. Tesiting

5.1 Mock Testing

5.2 Integration Tests

### 6.Custom Exception Handling

6.1 No resource/book/customer

----------------------------------

## 1.Technology Used
- Java
- Spring framework
- MongoDB

### 1.1 Accomplished goals
- CRUD operations for books and customers
- An endpoint to record when a book is borrowed or returned
- Mock Tests
- Integration Tests
- Exception handling

## 2. Project Structure

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/fe5a9610-bbfa-49ad-bf8b-97d82c9932e3)

- Controller: Contains the endpoints for managing books, customers, and loans.
-exceptions: allows to define how specific errors should be handled and what information should be provided to the user or the developer.
- model: This package contains the data models that represent the entities in the application
- repository: This package contains the repository interfaces that extend Spring Data MongoDB repositories for CRUD operations.
- service: This package contains the service classes that encapsulate the business logic of the application.
- LibraryApp.java: The main application class that bootstraps the Spring Boot application.
- resources: This directory contains the application configuration files.

## 3. DataInitializer class

Initializes database with default books and customers if there is no data

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/1ad50814-c278-41b7-9225-e963efa5a572)

## 4.Endpoints showcase

### 4.1 Add book

•	Method: POST
•	URL: http://localhost:8083/api/addBook

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/c93fcabf-a8ec-4198-a33a-ba5ecfb3f3db)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/23100975-5514-4ae2-b46c-0a0772ebc95e)

### 4.2 Get all books
•	Method: GET
•	URL: http://localhost:8083/api/books

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/a47f4916-9992-4fdc-bfac-090e0f346b67)

### 4.3 Get book by id
•	Method: GET
•	URL: http://localhost:8083/api/books/{id}
•	Path Variable: Replace {id} with the actual book ID.
![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/f0000df5-8ba3-49d7-8ac0-4b872d2987d8)

### 4.4 Update a Book
•	Method: PUT
•	URL: http://localhost:8083/api/UpdateBook/{id}
•	Path Variable: Replace {id} with the actuall book ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/c7cd0bb3-f66a-40ac-958e-c16570009042)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/674701e2-a2fc-4b43-ac21-8642398174f1)

### 4.5 Delete a Book
•	Method: DELETE
•	URL: http://localhost:8085/api/DeleteBook/{id}
•	Path Variable: Replace {id} with the actual book ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/2d69b2c3-f3a5-4f41-92af-f059c5852f47)

### 4.6 Add a Customer
•	Method: POST
•	URL: http://localhost:8085/api/AddCustomer

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/a127ac87-58f8-49de-a12b-405127164f24)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/2ba71721-25b7-403f-b0c6-276acbee52cb)

### 4.7 Get All Customers
•	Method: GET
•	URL: http://localhost:8085/api/customers

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/fda0de6f-c1c6-4a97-8c49-0845677941d5)

### 4.8 Get Customer by ID	
•	Method: GET
•	URL: http://localhost:8083/api/customers/{id}
•	Path Variable: Replace {id} with the actual customer ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/86df34df-34a3-4593-95fd-f6835a7a2b76)

### 4.9 Customer update
Method: PUT
URL: http://localhost:8085/api/UpdateCustomer/{id}
Path Variable: Replace {id} with the actual customer ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/b05eae9a-b202-4390-bb99-e11080cc8b52)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/22e363a9-4a34-47bc-8509-7d741507cfa4)

### 4.10 Delete Customer
•	Method: DELETE
•	URL: http://localhost:8085/api/DeleteCustomer/{id}
•	Path Variable: Replace {id} with the actual customer ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/62ab0f9a-3e9e-4495-b438-f9fcd51b2e70)

### 4.11 Borrow a Book
•	Method: POST
•	URL: http://localhost:8085/api/loans
•	Parameters: bookId and customerId
•	Example: http://localhost:8085/api/loans?bookId={bookId}&customerId={customerId}

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/8c964597-9fae-4b7a-9d60-0d41aa61a168)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/c11777ee-bd9b-448d-bfc5-90b7183b89e1)

### 4.12 Return a book
•	Method: POST
•	URL: http://localhost:8085/api/loans/{loanId}/return
•	Path Variable: Replace {loanId} with the actual loan ID.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/24fa8e55-40ce-439d-a9c8-61bd37b219eb)

Result:

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/0ba46ffb-a9e5-4331-b33e-2dffadd92441)

## 5. Tesiting

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/4716ec24-4b5a-4288-9e0a-092ea995ae96)

### 5.1 Mock Testing

Using mocked dependencies to ensure that the controller methods handle HTTP requests correctly without actually interacting with the underlying service or database.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/80a151d0-c372-4bfa-9d10-a96754a654b8)

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/e62a21c4-5666-47e0-8fd0-10a1776ea86b)

•	testAddBook: Adds a book and verifies its addition.

•	testGetAllBooks: Adds a book and verifies it can be retrieved.

•	testGetBookById: Adds a book and verifies it can be retrieved by ID.

•	testDeleteBook: Adds and deletes a book, then verifies its deletion.

### 5.2 Integration Tests

Integration tests aim to verify that different components of the application work together correctly. They test the full application stack, including the database layer.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/a96ebde7-82fb-4d99-9803-6e044aa969ce)

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/22e96913-6574-4339-a13d-da36af1b950f)

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/05c34b9d-8228-4ed3-a1a1-be4f02bb08dd)

### Book Tests
### testAddBook:
•	Action: Adds a book to the repository.
•	Verification: Checks if the book is successfully added and its attributes are correct.

### testGetAllBooks:
•	Action: Retrieves all books from the repository after adding one.
•	Verification: Ensures the list contains the added book with the correct title.

### testGetBookById:
•	Action: Saves a book and retrieves it by ID.
•	Verification: Confirms the retrieved book matches the added book's attributes.

### testDeleteBook:
•	Action: Saves a book and then deletes it by ID.
•	Verification: Ensures the book no longer exists in the repository.

### Customer Tests
### testAddCustomer:
•	Action: Adds a customer to the repository.
•	Verification: Checks if the customer is successfully added and its attributes are correct.


### testGetAllCustomers:
•	Action: Retrieves all customers from the repository after adding one.
•	Verification: Ensures the list contains the added customer with the correct name.

## 6.Custom Exception Handling
Custom exception handling is used to manage and respond to errors in a controlled, consistent, and user-friendly manner.

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/bbc4680c-2a52-4f4d-91a3-2ac65b4154cb)

### 6.1 No resource/book/customer

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/5f32fb02-47be-4343-acba-8b35dc31bd0c)

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/a86efd36-89fd-47eb-9933-1559f078862a)

![image](https://github.com/LukaszKrolicki/LibraryApi/assets/54467678/d5485f16-9818-488f-beb8-fed18cef5d11)











