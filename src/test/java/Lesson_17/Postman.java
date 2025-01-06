package Lesson_17;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Postman {
    public Spec requestSpec;
    public Spec responceSpec;

    @BeforeEach
    void setUp(){
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("Проверка GET запроса")
    public void getRequest(){
        given()
                .log().all()
                .contentType("application/json")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.user-agent", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", equalTo("application/json")) // Обновлено
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .statusCode(200);
    }


    @Test
    @DisplayName("Проверка POST Raw Text")
    public void postRawTextTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token",  equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"))
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка Post Form data")
    public void postFromDataTest() {
        given().contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo(""))
                .body("files", equalTo(Map.of()))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token",  equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка PUT запроса")
    public void putRequest() {
        given().log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().put("/put?KeyTest=ValueTest")
                .then().log().body()
                .body("args.KeyTest", equalTo("ValueTest"))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token",  equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put?KeyTest=ValueTest"))
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка PATCH метода")
    public void patchRequest(){
        given().log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().patch("/patch?KeyTest=ValueTest")
                .then().log().body().assertThat()
                .body("args.KeyTest", equalTo("ValueTest"))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token",  equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch?KeyTest=ValueTest"))
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка DELETE метода")
    public void deleteRequest(){
        given().log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete?DeleteTest=Test")
                .then().log().body()
                .body("args.DeleteTest", equalTo("Test"))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete?DeleteTest=Test"))
                .statusCode(200);
    }
}