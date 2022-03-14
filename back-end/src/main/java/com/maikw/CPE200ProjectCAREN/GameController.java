package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_GeneticCodeReturnData;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_GeneticCodeUpload;
import com.maikw.CPE200ProjectCAREN.apiclasses.GameState;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
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
    public int setGameState(@RequestBody GameState gameState){
        game.setState(gameState.getGameState());

        return gameState.getGameState();
    }

    @CrossOrigin
    @PostMapping(path = "/uploadGeneticCode")
    public ApiData_GeneticCodeReturnData setGameState(@RequestBody ApiData_GeneticCodeUpload data){
        //Game game = GameHandler.getGame(data.getPlayerId())
        ApiData_GeneticCodeReturnData result = new ApiData_GeneticCodeReturnData();

        String type = data.getType();
        String gCode = data.getGeneticCode();

        try{
            Unit unit = new Unit("genetic code upload tester", type, gCode);
            BehaviorEvaluator be = new BehaviorEvaluator(gCode, unit);
            be.parseProgram();

            switch (type) {
                case "melee" -> {
                    game.getGeneticCodeManager().setAntibodyMelee(gCode);
                    result.setCompiledResult("success");
                }
                case "ranged" -> {
                    game.getGeneticCodeManager().setAntibodyRanged(gCode);
                    result.setCompiledResult("success");
                }
                case "aoe" -> {
                    game.getGeneticCodeManager().setAntibodyAOE(gCode);
                    result.setCompiledResult("success");
                }
                default -> result.setCompiledResult("failed");
            }
        }catch(SyntaxError e){
            result.setCompiledResult("failed");
        }

        return result;
    }
}
