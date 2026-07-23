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

    // Verify the API successfully returns the task list.
    @Test
    void shouldReturnTaskListSuccessfully() {

        Response response =
                given()
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    // Verify tasks can be filtered by status.
    @Test
    void shouldFilterTasksByStatus() {

        Response response =
                given()
                        .queryParam("status", "Done")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    // Verify tasks can be filtered by priority.
    @Test
    void shouldFilterTasksByPriority() {

        Response response =
                given()
                        .queryParam("priority", "High")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    // Verify tasks can be sorted by due date.
    @Test
    void shouldSortTasksByDueDate() {

        Response response =
                given()
                        .queryParam("sortBy", "dueDate")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    // Verify the tasks are returned in priority order.
    @Test
    void shouldSortTasksByPriority() {

        Response response =
                given()
                        .queryParam("sortBy", "priority")
                        .when()
                        .get(TASKS_ENDPOINT);

        assertEquals(200, response.statusCode());
    }

    // Verify combined status and priority filters -API documentation does not confirm whether multiple filters can be combined.
    @Test
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

    // Verify API behaviour when an unsupported sort field is provided.
    @Test
    void shouldHandleInvalidSortField() {

        Response response =
                given()
                        .queryParam("sortBy", "title")
                        .when()
                        .get(TASKS_ENDPOINT);

        // Expected behaviour (400 error or empty result) is not defined.
    }

    // Verify API behaviour when an unsupported status value is provided.
    @Test
    void shouldHandleInvalidStatusFilter() {

        Response response =
                given()
                        .queryParam("status", "Completed")
                        .when()
                        .get(TASKS_ENDPOINT);

        // Expected behaviour needs clarification as valid status values are not defined in the API documentation.
    }
}
