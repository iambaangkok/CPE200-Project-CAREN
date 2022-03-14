package com.maikw.CPE200ProjectCAREN;


import java.util.Map;
import java.util.Random;

public class GameHandler {


    protected String id ;
    protected Map<String,Thread> map ;

    public GameHandler(String id){
        this.id = id ;

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Game());

    }


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

    public void runGame(String id ){
        if(map.containsKey(id)){
            map.get(id).start();
        }else{
            map.put(id,new Thread(new Game()));
            map.get(id).start();
        }
    }

}
