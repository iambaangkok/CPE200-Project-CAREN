package com.maikw.CPE200ProjectCAREN;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/area") // http://localhost:8080/area
public class AreaController {
    Area area = new Area("Area1");
    Area area2 = new Area("Area2");
    Area area3 = new Area("Area3");

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
