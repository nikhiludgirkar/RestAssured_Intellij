package com.bookstore.tests;

import static io.restassured.RestAssured.*;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;

public class jsonpathtester {
    @Test
    public void test1() throws IOException {
        baseURI = "http://openlibrary.org/api/volumes/brief/isbn/9780525440987.json";
//        baseURI = "http://localhost:3000/quiz";
        Response res =
                given()
                        .when()
                        .get()
                        .then()
                        .extract().response();

        JsonPath jsonPath = res.jsonPath();
        String li = jsonPath.get("records.'/books/OL2842220M'.data.subjects.find{it.name == 'Science fiction'}.url");
        System.out.println(li);
//        String a = jsonPath.get("records.'/books/OL2842220M'.data.authors.findAll{it.name == ''}");
//        System.out.println(a);

        FileReader fr = new FileReader(new File("C:\\Users\\Nikhil_Udgirkar\\test.json"));
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine(); String content = "";
        StringBuilder sb = new StringBuilder();
        while (s!=null){
            content = content + s;
            s = br.readLine();
        }
        List<String> li2 = JsonPath.from(content).get("find{it.name == 'John Smith'}.preferences.find{it.image == 'papaya.jpg'}.dependentPreferences.description");

        System.out.println(li2);


    }
}
