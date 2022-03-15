package com.maikw.CPE200ProjectCAREN;


import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Wave;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/waveManager") // http://localhost:8080/waveManager
public class WaveManagerController  {
    GameHandler gameHandler;

    public WaveManagerController(GameHandler gameHandler){
        this.gameHandler = gameHandler ;

    }

    @PostMapping(path = "/getcurrentwave") //http://localhost:8080/waveManager/getcurrentwave
    public int getCurrentWave(@RequestBody ApiData_Wave data){
        Game game  = gameHandler.getGame(data);
        WaveManager waveManager = game.getWaveManager();
       return  waveManager.getCurrentWaveCount();

    }

}
