package com.maikw.CPE200ProjectCAREN;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/Game_api") // http://localhost:8080/api/v1/Game_api
public class APIGame {


//    @GetMapping
//    public List<String> getExample(){
//        List<String> exampleReturnData = new ArrayList<>();
//        exampleReturnData.add("this");
//        exampleReturnData.add("works");
//        return exampleReturnData;
//
//    }


    @GetMapping()
    public List<Integer> getShowExample(){

        Game g = new Game();
        g.getScreen();


        return g.getScreen() ;
    }



}
