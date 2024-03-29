# Bank Account Web Application

This project is a web application developed using Spring Boot, React, and Bootstrap for managing banking transactions.


## Introduction
The Bank Account Web Application provides functionalities for managing bank accounts, including creating, updating, deleting, and transferring funds between accounts.

## Entity Structure
The application works with the following entities:

- **Bank**:
  - ID (unique identifier)
  - Name (unique, mandatory)
  - Bank Funds (numeric value)

- **Account Type**:
  - ID (unique identifier)
  - Name (unique, mandatory)
  - Commission (percentage commission for money transfers)

- **Account**:
  - ID (unique identifier)
  - Full Name (mandatory)
  - JMBG (unique identifier)
  - Account Number (mandatory)
  - Account Balance (numeric value)
  - Account Type (relationship with Account Type entity)
  - Bank (relationship with Bank entity)

## REST API
The following REST API endpoints are implemented:

- GET /api/banks: Retrieve all banks
- GET /api/banks/{id}/account-types: Retrieve all account types for a specific bank
- GET /api/accounts: Retrieve all accounts (paginated)
- POST /api/accounts: Add a new account
- GET /api/accounts/{id}: Retrieve an account by ID
- PUT /api/accounts/{id}: Update an existing account
- DELETE /api/accounts/{id}: Delete an existing account

## Validation
At the API level, the following validations are implemented:

- JMBG within an account must be 13 characters long
- Account number must not be empty

## Functionality
The application provides the following functionalities:

- Add a new account with type selection based on bank
- Update account details
- Delete an account (only if the account balance is 0)
- Search for accounts by JMBG and bank
- Paginated display of account data
- Transfer funds between accounts with commission calculation based on the account type

## Implementation Details
The application uses Spring Boot for the backend REST API and React for the frontend user interface. Bootstrap is used for styling and responsiveness.

