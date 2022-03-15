package com.maikw.CPE200ProjectCAREN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/timemanager") // http://localhost:8080/TimeManager

public class TimeController{
     TimeManager timeManager = new TimeManager();
     @CrossOrigin
     @PostMapping
     public TimeManager getTimeManager() { return timeManager; }

    @CrossOrigin
    @PostMapping(path = "/playbar")
    public String playBar(@RequestBody String type){
         timeManager.setInputType(type);
         return "Now is" +type;

    }
}
