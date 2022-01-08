package kur.alex.tests.bookstore;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static kur.alex.filters.CustomLogFilter.customLogFilter;
import static org.hamcrest.Matchers.is;

public class BookStoreTests {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
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
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }

    @Test
    void authorizeGenerateTokenWithTemplatesTest() {

        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");

        given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/json")
                .accept("application/json")
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }
}
