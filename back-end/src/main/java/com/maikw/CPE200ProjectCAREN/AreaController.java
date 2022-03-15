package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/area") // http://localhost:8080/area
public class AreaController {
    private Area area;
    private Area area2;
    private Area area3;
    private final GameHandler gameHandler;

    @Autowired
    public AreaController(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    @CrossOrigin
    @PostMapping(path = "/getarea1") // http://localhost:8080/area/getarea1
    public Area getArea1(@RequestBody ApiData_Base data){
        Game game = gameHandler.getGame(data);
        this.area = game.getAreas().get(0);
        return area;
    }

    @CrossOrigin
    @PostMapping(path = "/getarea2") // http://localhost:8080/area/getarea2
    public Area getArea2(@RequestBody ApiData_Base data){
        Game game = gameHandler.getGame(data);
        this.area2 = game.getAreas().get(1);
        return area2;
    }

    @CrossOrigin
    @PostMapping(path = "/getarea3") // http://localhost:8080/area/getarea3
    public Area getArea3(@RequestBody ApiData_Base data){
        Game game = gameHandler.getGame(data);
        this.area3 = game.getAreas().get(2);
        return area3;
    }
}
