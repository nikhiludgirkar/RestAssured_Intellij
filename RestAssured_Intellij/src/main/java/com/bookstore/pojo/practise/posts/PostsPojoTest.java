package com.bookstore.pojo.practise.posts;

import static io.restassured.RestAssured.*;

import com.bookstore.meta.HeaderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostsPojoTest {

    @Test
    public void test1() throws IOException {
        baseURI = "http://localhost:3000/";
        Response res =
                given()
                        .basePath("/posts")
                        .headers(HeaderConfig.getHeaders())
                        .body(PostsPayloadGen.getPostsData())
                        .log()
                        .all()
                        .when()
                        .post()
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();
        System.out.println(res.asString());

    }
}
