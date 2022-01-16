package kur.alex.tests.bookstore;

import com.codeborne.selenide.Configuration;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import kur.alex.models.Token;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static kur.alex.filters.CustomLogFilter.customLogFilter;
import static kur.alex.tests.bookstore.Specs.request;
import static kur.alex.tests.bookstore.Specs.responseSpec;
import static org.hamcrest.Matchers.is;


public class BookStoreTests {

//   private Token Token = new Token();

    final static String BASE_URI = "https://demoqa.com";
    final static String BASE_URL = "https://demoqa.com";

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = BASE_URI;
        Configuration.baseUrl = BASE_URL;
    }

    @Test
    void authorizeGenerateTokenWithTemplatesSchemeValidtionSpecsLombokTest() {

        Map<String, String> requestData = new HashMap<>();
        requestData.put("userName", "alex");
        requestData.put("password", "asdsad#frew_DFS2");

//        step("Generate token", () ->
               Token data =  given()
                .spec(request)
                .body(requestData)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .spec(responseSpec)
                .log().all()
                      .extract().as(Token.class);
              assertEquals("Success", data.getStatus());
//                .body(matchesJsonSchemaInClasspath("schemas/GetAuthorizationToken.json"))
//                .body("status", is("Success"))
//                .body("result", is("User authorized successfully."))
//        );
    }

    @Test
    void authorizeGenerateTokenWithTemplatesSchemeValidtionTest() {

        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");

        step("Generate token", () ->
                given()
                        .filter(customLogFilter().withCustomTemplates())
                        .contentType("application/json")
                        .accept("application/json")
                        .body(data)
                        .when()
                        .log().all()
                        .post("/Account/v1/GenerateToken")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath("schemas/GetAuthorizationToken.json"))
                        .body("status", is("Success"))
                        .body("result", is("User authorized successfully."))

        );
    }

    @Test
    void authorizeGenerateTokenWithTemplatesSchemeValidtionSpecsTest() {

        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");

        step("Generate token", () ->
                given()
                        .spec(request)
                        .body(data)
                        .when()
                        .post("/Account/v1/GenerateToken")
                        .then()
                        .spec(responseSpec)
                        .log().all()
                        .body(matchesJsonSchemaInClasspath("schemas/GetAuthorizationToken.json"))
                        .body("status", is("Success"))
                        .body("result", is("User authorized successfully."))
        );
    }

    @Test
    @Disabled
    void authorizeGenerateTokenTest() {
//        String data = "{" +
//                "  \"userName\": \"alex\"," +
//                "  \"password\": \"asdsad#frew_DFS2\"" +
//                "}";

        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");

        given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .accept("application/json")
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("/Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }

    @Test
    @Disabled
    void authorizeGenerateTokenWithTemplatesTest() {

        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");

        step("Generate token", () ->
                given()
                        .filter(customLogFilter().withCustomTemplates())
                        .contentType("application/json")
                        .accept("application/json")
                        .body(data)
                        .when()
                        .log().uri()
                        .log().body()
                        .post("/Account/v1/GenerateToken")
                        .then()
                        .log().body()
                        .body("status", is("Success"))
                        .body("result", is("User authorized successfully."))
        );
        step("Any UI action");
    }

}
