package com.maikw.CPE200ProjectCAREN;



import com.maikw.CPE200ProjectCAREN.apiclasses.GameState;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/game") // http://localhost:8080/game
public class GameController {
    Game game = new Game();

    @CrossOrigin
    @GetMapping(path = "/state") // http://localhost:8080/game/state
    public Game getGame (){
        return game;
    }

    @CrossOrigin
    @PostMapping(path = "/setState")
    public String setGameState(@RequestBody GameState gameState){
        game.setState(gameState.getGameState());

        return ""+gameState.getGameState();
    }



}
