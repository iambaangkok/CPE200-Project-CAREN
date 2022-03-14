package com.maikw.CPE200ProjectCAREN;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class GameHandler {


    protected String id ;
    protected Map<String,Thread> map ;
    protected Map<String, Game> gameMap;

    public GameHandler(String id){
        this.id = id ;
        map = new HashMap<>();
        gameMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Game());

    }

    //api
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

    //api
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

    public Game getGame(String id){
        if(!map.containsKey(id)){
            runGame(id);
        }
        return gameMap.get(id);
    }

}
