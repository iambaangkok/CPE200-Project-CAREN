package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_BuyUnit;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_SpeedMultiplierReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/timemanager") // http://localhost:8080/TimeManager

public class TimeController{
    private final GameHandler gameHandler;

    @Autowired
    public TimeController(GameHandler gameHandler){
        this.gameHandler = gameHandler;
    }

//    @CrossOrigin
//    @PostMapping(path = "/playbar")
//    public String playBar(@RequestBody String type){
//         timeManager.setInputType(type);
//         return "Now is" +type;
//    }

    @CrossOrigin
    @PostMapping(path = "/getspeedmultiplier")
    public ApiData_SpeedMultiplierReturnData getSpeedMultiplier(@RequestBody ApiData_Base data){
        Game game = gameHandler.getGame(data);
        TimeManager timeManager = game.getTimeManager();

        ApiData_SpeedMultiplierReturnData returnData = new ApiData_SpeedMultiplierReturnData();
        returnData.setType(timeManager.getInputType());
        String type = returnData.getType();
        switch (type) {
            case "pause":
                returnData.setMultiplier(0);
                break;
            case "fastforward":
                returnData.setMultiplier(timeManager.getFastForwardMuliplier());
                break;
            case "slowdown":
                returnData.setMultiplier(timeManager.getSlowDownMultiplier());
                break;
            default:
                returnData.setType("normal");
                returnData.setMultiplier(0);
                break;
        }
        return returnData;
    }

    @CrossOrigin
    @PostMapping(path = "/setspeedmultiplier")
    public void setSpeedMultiplier(@RequestBody ApiData_BuyUnit data){
        Game game = gameHandler.getGame(data);
        TimeManager timeManager = game.getTimeManager();
        timeManager.setInputType(data.getType());
    }
}
