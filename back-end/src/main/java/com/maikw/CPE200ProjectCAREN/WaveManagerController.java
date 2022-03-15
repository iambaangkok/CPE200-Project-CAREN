package com.maikw.CPE200ProjectCAREN;


import com.maikw.CPE200ProjectCAREN.apiclasses.APIData_Area;
import com.maikw.CPE200ProjectCAREN.apiclasses.APIData_NumberOfVirus;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Wave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/wavemanager") // http://localhost:8080/waveManager
public class WaveManagerController {
    GameHandler gameHandler;

    @Autowired
    public WaveManagerController(GameHandler gameHandler) {
        this.gameHandler = gameHandler;

    }

    @CrossOrigin
    @PostMapping(path = "/getcurrentwave") //http://localhost:8080/waveManager/getcurrentwave
    public int getCurrentWave(@RequestBody ApiData_Wave data) {
        Game game = gameHandler.getGame(data);
        WaveManager waveManager = game.getWaveManager();
        return waveManager.getCurrentWaveCount();

    }


    @CrossOrigin
    @PostMapping(path = "/getwavenumberandnumberofvirus")
//http://localhost:8080/waveManager/getwavenumberandnumberofvirus
    public APIData_NumberOfVirus getWavenumberAndnumberofVirus(@RequestBody ApiData_Wave data) {
        Game game = gameHandler.getGame(data);
        APIData_Area area1 = new APIData_Area();
        APIData_Area area2 = new APIData_Area();
        APIData_Area area3 = new APIData_Area();
        List<Virus> listVirus1 = game.areas.get(0).getViruses();
        List<Virus> listVirus2 = game.areas.get(1).getViruses();
        List<Virus> listVirus3 = game.areas.get(2).getViruses();
        APIData_NumberOfVirus result = new APIData_NumberOfVirus();

        coutAllvirusinarea(area1,listVirus1);
        coutAllvirusinarea(area2,listVirus2);
        coutAllvirusinarea(area3,listVirus3);

        result.setArea1(area1);
        result.setArea2(area2);
        result.setArea3(area3);
        return result;
    }


    public void coutAllvirusinarea(APIData_Area area ,List<Virus> listVirus){
        int countmelee = 0;
        int countranged = 0;
        int countaoe = 0;
        int total;
        for (Virus virus : listVirus) {
            if (virus.getType().equals("melee")) {
                countmelee += 1;
            } else if (virus.getType().equals("ranged")) {
                countranged += 1;
            } else if (virus.getType().equals("aoe")) {
                countaoe += 1;
            } else {
                System.out.println("Someting of Type is wong");
            }
        }
        total = countmelee + countranged + countaoe;
        area.setMelee(countmelee);
        area.setRanged(countranged);
        area.setAoe(countaoe);
        area.setTotal(total);
    }



}

