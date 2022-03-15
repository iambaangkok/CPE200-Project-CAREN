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

    protected String id ;
    protected Map<String,Thread> map ;
    protected Map<String, Game> gameMap;

    @Autowired
    public GameHandler(String id){
        this.id = id ;
        map = new HashMap<>();
        gameMap = new HashMap<>();
    }


    //api
    @CrossOrigin
    @PostMapping(path = "/checkid") // http://localhost:8080/gamehandler/checkid
    public String checkId(String id){
        for(String ID : map.keySet()){
            if(id.equals(ID)){
                System.out.println("You have id na");
                break;
            }else{
                Random random = new Random();
                id = Integer.toString(random.nextInt());
                return id ;
            }
        }
        return id;
    }


    @CrossOrigin
    @PostMapping(path = "/runGame") // http://localhost:8080/gamehandler/runGame
    public void runGame(String id ){
        if(map.containsKey(id)){
            map.get(id).start();
        }else{
            Game game = new Game();
            gameMap.put(id, game);
            map.put(id,new Thread(game));
            map.get(id).start();
        }
    }

    @CrossOrigin
    @PostMapping(path = "/getGame") // http://localhost:8080/gamehandler/getGame
    public Game getGame(@RequestBody ApiData_Base  data){
        if(!map.containsKey(data.getId())){
            runGame(data.getId());
        }
        return gameMap.get(data.getId());
    }

}
