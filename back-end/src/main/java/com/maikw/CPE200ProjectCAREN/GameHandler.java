package com.maikw.CPE200ProjectCAREN;


import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@RestController
@RequestMapping(path = "/gamehandler") // http://localhost:8080/gamehandler
public class GameHandler {

    protected Map<String,Thread> map ;
    protected Map<String, Game> gameMap;

    @Autowired
    public GameHandler(){
        map = new HashMap<>();
        gameMap = new HashMap<>();
    }


    //api
    @CrossOrigin
    @PostMapping(path = "/checkid") // http://localhost:8080/gamehandler/checkid
    public String checkId(@RequestBody ApiData_Base data){
        String id = data.getId();

        if(map.containsKey(id)){
            System.out.println("This id [" + id + "] already exist.");
        }else{
            Random random = new Random(10000);
            id = Integer.toString(random.nextInt());
            System.out.println("id = " + id);
            while (map.containsKey(id)){
                System.out.println("id = " + id);
                id = Integer.toString(random.nextInt());
            }
            return id ;
        }
        return id;
    }


    @CrossOrigin
    @PostMapping(path = "/runGame") // http://localhost:8080/gamehandler/runGame
    public void runGame(@RequestBody ApiData_Base data ){
        String id = data.getId();
        if (!map.containsKey(id)) {
            Game game = new Game();
            gameMap.put(id, game);
            map.put(id, new Thread(game));
        }
        System.out.println("thread state : " + map.get(id).getState());
        if(!map.get(id).isAlive()){
            map.get(id).setDaemon(true);
            map.get(id).start();
        }
    }

    @CrossOrigin
    @PostMapping(path = "/getGame") // http://localhost:8080/gamehandler/getGame
    public Game getGame(@RequestBody ApiData_Base  data){
        if(!map.containsKey(data.getId())){
            runGame(data);
        }
        return gameMap.get(data.getId());
    }

}
