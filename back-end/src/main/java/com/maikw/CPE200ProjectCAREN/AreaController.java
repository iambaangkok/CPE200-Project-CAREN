package com.maikw.CPE200ProjectCAREN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/area") // http://localhost:8080/area
public class AreaController {
    private final Area area;
    private final Area area2;
    private final Area area3;

    @Autowired
    public AreaController(Game game) {
        this.area = game.areas.get(0);
        this.area2 = game.areas.get(1);
        this.area3 = game.areas.get(2);
    }

    @CrossOrigin
    @GetMapping(path = "/getarea1") // http://localhost:8080/area/getarea1
    public Area getArea1(){
        return area;
    }

    @CrossOrigin
    @GetMapping(path = "/getarea2") // http://localhost:8080/area/getarea2
    public Area getArea2(){
        return area2;
    }

    @CrossOrigin
    @GetMapping(path = "/getarea3") // http://localhost:8080/area/getarea3
    public Area getArea3(){
        return area3;
    }
}
