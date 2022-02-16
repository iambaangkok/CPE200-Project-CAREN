package com.maikw.CPE200ProjectCAREN;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/area") // http://localhost:8080/area
public class AreaController {
    Area area = new Area("Area1");
    Area area2 = new Area("Area2");
    Area area3 = new Area("Area3");


    @GetMapping(path = "/getarea1")
    public Area getArea1(){
        return area;
    }

    @GetMapping(path = "/getarea2")
    public Area getArea2(){
        return area2;
    }
}
