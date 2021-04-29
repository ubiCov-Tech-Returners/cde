package com.ubicov.app.controller;

import com.ubicov.app.service.*;
import com.ubicov.app.util.geojson.MapInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionsController {

    private QuestionService questionService;


    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;

    }

/**
* Will use CovidData dataset & FurloughData Dataset
*/
    @GetMapping("/questions/{id}/")
    public Object question1(@PathVariable int id ){
        Object response = null;
        switch(id){
            case 1: response = questionService.getQuestion1(); break;
            case 2: response = questionService.getQuestion2(); break;
            case 3: response =  questionService.getQuestion3(); break;
            case 4: response = questionService.getQuestion4(); break;
        }
        return (response != null)? response:
                                  (new ResponseEntity<Void>(HttpStatus.NO_CONTENT)) ;

    }
}
