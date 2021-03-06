package com.ubicov.app.controller;

import com.ubicov.app.service.*;
import com.ubicov.app.util.geojson.MapInfo;
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
    public List<MapInfo> question1(@PathVariable int id ){
        switch(id){
            case 1: return questionService.getQuestion1();
            case 2: return questionService.getQuestion2();
            case 3: return questionService.getQuestion3();
            case 4: return questionService.getQuestion4();
        }
        return  null;

    }
}
