
# Task Management API Automation

## Overview

This project demonstrates API automation test coverage for the Task Management System QA assessment.

The automation focuses on TASK-103 (Filter and Search) and TASK-104 (Sort Tasks), as API documentation was provided for the list/filter/sort functionality.

---

## Technology Stack

- Java
- JUnit 5
- Rest Assured
- Maven
- IntelliJ IDEA

---

## Project Structure
task-management-api-testing

├── README.md

├── pom.xml

└── src

    └── test

        └── java

            └── task.management.test

                └── TaskApiTest.java

---

## Automated Test Coverage

### TASK-103: Filter and Search

Automated scenarios:

- Verify tasks can be retrieved successfully
- Verify tasks can be filtered by status
- Verify tasks can be filtered by priority
- Verify multiple filters can be applied together

Example API requests:

GET /tasks

GET /tasks?status=Done

GET /tasks?priority=High


---

### TASK-104: Sort Tasks

Automated scenarios:
- Verify tasks can be sorted by due date
- Verify tasks can be sorted by priority

Example API requests:

GET /tasks?sortBy=dueDate

GET /tasks?sortBy=priority



---

## Assumptions

- The API base URL was not provided, so a placeholder URL has been used.
- Authentication requirements were not provided.
- Test data is assumed to already exist.
- API response schema was not provided.

---

## Known Gaps / Clarifications Required

The following items would need confirmation before implementing full assertions:

- Sorting direction is not defined:
    - Due date: ascending or descending?
    - Priority: High → Medium → Low or another order?

- API response structure is not documented.

- Search functionality is included in TASK-103 but no search API parameter is provided.

- Create, update, and delete APIs are not provided for TASK-101 and TASK-102.

---

## Running Tests

Run using Maven: mvn test

## Future Improvements

If a running API environment was available:

- Add response body validations.
- Add schema validation.
- Add negative API tests.
- Add authentication handling if required.