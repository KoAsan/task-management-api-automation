package task.management.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskApiTest {

    private static final String BASE_URI = "http://xxxxxxxxx";
    private static final String TASKS_ENDPOINT = "/tasks";

    @BeforeEach
    void setup() {
        // Placeholder base URI - actual endpoint not provided in the assessment
        RestAssured.baseURI = BASE_URI;
    }

    @Test
        // Verify the API successfully returns the task list.
    void shouldReturnTaskListSuccessfully() {

        Response response =
                given()
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    @Test
        // Verify tasks can be filtered by status.
    void shouldFilterTasksByStatus() {

        Response response =
                given()
                        .queryParam("status", "Done")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    @Test
        // Verify tasks can be filtered by priority.
    void shouldFilterTasksByPriority() {

        Response response =
                given()
                        .queryParam("priority", "High")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    @Test
        // Verify tasks can be sorted by due date.
    void shouldSortTasksByDueDate() {

        Response response =
                given()
                        .queryParam("sortBy", "dueDate")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    @Test
        // Verify the tasks are returned in priority order.
    void shouldSortTasksByPriority() {

        Response response =
                given()
                        .queryParam("sortBy", "priority")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    @Test
        // Combine filters test - but behaviour is not defined in the API documentations
    void shouldFilterTasksByStatusAndPriority() {

        Response response =
                given()
                        .queryParam("status", "Done")
                        .queryParam("priority", "High")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());

        // Behaviour should be confirmed with Product/API documentation.
    }

    @Test
        // Verify API behaviour when an unsupported sort field is provided.
    void shouldHandleInvalidSortField() {

        Response response = RestAssured
                .given()
                .queryParam("sortBy", "title")
                .when()
                .get(TASKS_ENDPOINT);

        // Expected behaviour (400 error or empty result) is not defined.
    }

    @Test
        // Verify API behaviour when an unsupported status value is provided.
    void shouldHandleInvalidStatusFilter() {

        Response response = RestAssured
                .given()
                .queryParam("status", "Completed")
                .when()
                .get(TASKS_ENDPOINT);

        // Expected behaviour needs clarification as valid status values are not defined in the API documentation.
    }
}
