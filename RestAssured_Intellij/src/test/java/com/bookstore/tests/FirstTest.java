package com.bookstore.tests;

import com.bookstore.meta.HeaderConfig;
import com.bookstore.resources.Endpoints;
import com.bookstore.payloadgen.IsbnPayloadGenerator;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class FirstTest {
    @Test
    public void getBookDetailsTest() {
        baseURI = "https://demoqa.com/";
        Response res =
                given()
                        .basePath(Endpoints.apiPath.getBookDetails)
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        System.out.println("time is "+res.getTime());
        System.out.println(res.getStatusLine());
        System.out.println("header is "+ res.getHeader("Content-Type"));
        JsonPath jsonPath = res.jsonPath();
        System.out.println("*" + res.asString());
        String bookTitle = jsonPath.get("books.find{it.isbn == '9781449325862'}.title");
        List<String> booksTitles = jsonPath.get("books.findAll{it.pages > 300}.title");
        List<String> lengthOfBooks = jsonPath.get("books.findAll{it.pages > 300}.title");
        System.out.println(booksTitles);
    }

    @Test
    public void postBookDetailsTest() throws IOException {
        baseURI = "https://demoqa.com/";
        Response res =
                given()
                        .basePath(Endpoints.apiPath.getBookDetails)
                        .headers(HeaderConfig.getHeaders())
                        .body(IsbnPayloadGenerator.getIsbnData())
                        .log()
                        .all()
                        .when()
                        .post()
                        .then()
                        .statusCode(401)
                        .extract()
                        .response();
        System.out.println(res.asString());
    }

    @Test
    public void getQueryParamDemo() {
        baseURI = "https://api.agify.io/";
        Response res =
                given()
                        .queryParam("name", "Ganesh")
                        .headers(HeaderConfig.getHeaders())
                        .log()
                        .all()
                        .when()
                        .get("")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        System.out.println(res.asString());
    }

    @Test
    public void schemaValidationTest() {
        baseURI = "https://api.agify.io/";
        given()
                .queryParam("name", "Ganesh")
                .headers(HeaderConfig.getHeaders())
                .log()
                .all()
                .when()
                .get("")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(System.getProperty("user.dir") + "/src/main/java/com/bookstore/schema/AgeSchema.json"));
    }

    @Test
    public void putPathParamExample() {
        baseURI = "https://demoqa.com/";
        Map<String, String> requestPayload = new HashMap<String, String>();
        requestPayload.put("userId", "nikhil");
        requestPayload.put("isbn", "nikhil420");
        Response res =
                given()
                        .headers(HeaderConfig.getHeaders())
                        .basePath(Endpoints.apiPath.getBookDetails + "{ISBN}")
                        .pathParam("ISBN", "india")
                        .body(requestPayload)
                        .log()
                        .all()
                        .when()
                        .put()
                        .then()
                        .statusCode(404)
                        .extract()
                        .response();
        System.out.println(res.asString());
    }
}