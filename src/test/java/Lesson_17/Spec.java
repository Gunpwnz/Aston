package Lesson_17;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Spec {
    public static RequestSpecification requestSpec = given()
            .baseUri("https://postman-echo.com");

    public static ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .then().log().all()
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.x-request-start", notNullValue())
            .body("headers.connection", equalTo("close"))
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("headers.x-forwarded-port", equalTo("443"))
            .body("headers.x-amzn-trace-id", notNullValue())
            .body("headers.content-type", equalTo("application/json")) //
            .body("headers.user-agent", notNullValue())
            .body("headers.accept", equalTo("*/*"))
            .body("headers.postman-token", equalTo(null))
            .body("headers.accept-encoding", equalTo("gzip,deflate"))
            .body("headers.cookie", equalTo(null));
}
