package com.bookstore.pojo.practise.instructor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class InstructorPojoTest {
    public static void main(String[] args) throws JsonProcessingException {
        List<Courses.WebAutomation> webs = new ArrayList<Courses.WebAutomation>();
        List<Courses.ApiAutomation> apis = new ArrayList<Courses.ApiAutomation>();
        List<Courses.MobileAutomation> mobiles = new ArrayList<Courses.MobileAutomation>();

        Courses.WebAutomation selenium = new Courses.WebAutomation();
        Courses.WebAutomation protractor = new Courses.WebAutomation();
        Courses.ApiAutomation restassured  = new Courses.ApiAutomation();
        Courses.MobileAutomation appium = new Courses.MobileAutomation();

        selenium.setCourseTitle("Selenium");
        selenium.setPrice("500");

        protractor.setCourseTitle("Protractor");
        protractor.setPrice("333");

        restassured.setCourseTitle("Rest Assured API Automation");
        restassured.setPrice("344.00");

        appium.setCourseTitle("Appium");
        appium.setPrice("4555");
        webs.add(selenium);
        webs.add(protractor);
        apis.add(restassured);
        mobiles.add(appium);

        Courses courses = new Courses();
        courses.setMobileAutomation(mobiles);
        courses.setWebAutomation(webs);
        courses.setApiAutomation(apis);
        InstructorPojo pojo = new InstructorPojo();
        pojo.setInstructor("Nikhil Udgirkar");
        pojo.setCourses(courses);
        pojo.setUrl("www.google.com");
        pojo.setServices("Test Automation Service");
        pojo.setExpertise("Testing");
        pojo.setLinkedIn("linkedIn");

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(pojo);
        System.out.println(str);
    }
}
