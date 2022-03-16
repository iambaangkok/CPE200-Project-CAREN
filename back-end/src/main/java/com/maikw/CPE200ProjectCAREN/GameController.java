package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_GeneticCodeReturnData;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_GeneticCodeUpload;
import com.maikw.CPE200ProjectCAREN.apiclasses.GameState;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/game") // http://localhost:8080/game
public class GameController {
    private final GameHandler gameHandler;
    private final boolean DEBUG = true;

    @Autowired
    GameController(GameHandler gameHandler){
        this.gameHandler = gameHandler;
    }

    @CrossOrigin
    @PostMapping(path = "/state") // http://localhost:8080/game/state
    public int getGameState (@RequestBody ApiData_Base data){
        Game game = gameHandler.getGame(data);
        return game.getState();
    }

    @CrossOrigin
    @PostMapping(path = "/setstate")
    public int setGameState(@RequestBody GameState data){
        Game game = gameHandler.getGame(data);
        game.setState(data.getGameState());
        return data.getGameState();
    }

    @CrossOrigin
    @PostMapping(path = "/uploadgeneticcode")
    public ApiData_GeneticCodeReturnData uploadGeneticCode(@RequestBody ApiData_GeneticCodeUpload data){
        if(DEBUG){
            System.out.println(data.getId() + " " + data.getType() + " " +data.getGeneticCode());
        }
        ApiData_Base data2 = new ApiData_Base();
        data2.setId(data.getId());
        Game game = gameHandler.getGame(data2);
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
