package com.bookstore.pojo.practise.quiz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuizTest {
    public static void main(String[] args) throws JsonProcessingException {
        Q1 q = new Q1();
        Sport sport = new Sport();
        Quiz quiz = new Quiz();
        QuizPojo pojo = new QuizPojo();
        pojo.setQuiz(quiz);
        quiz.setSport(sport);
        sport.setQ1(q);
        q.setQuestion("What is the capital of India?");
        q.setAnswer("New Delhi");
        String[] options = {"Mumbai", "New Delhi", "Chennai", "Kolkata"};
        q.setOptions(options);
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(pojo);
        System.out.println(str);
    }
}
