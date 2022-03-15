package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_AreaAndPosition;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {
    private final GameHandler gameHandler;

    @Autowired
    public InventoryController(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    @CrossOrigin
    @PostMapping(path = "/getinventory")
    public Inventory getInventory(@RequestBody ApiData_Base data){
        Inventory inventory = gameHandler.getGame(data).getInventory();
        return inventory;
    }

    @CrossOrigin
    @PostMapping(path = "/storeunit")
    public String storeUnit(@RequestBody ApiData_Unit data){
        Inventory inventory = gameHandler.getGame(data).getInventory();
        Area area1 = gameHandler.getGame(data).getAreas().get(0);
        Area area2 = gameHandler.getGame(data).getAreas().get(1);
        Area area3 = gameHandler.getGame(data).getAreas().get(2);
        String name = data.getUnitName();
        Unit unit = null;
        for(Unit u : area1.getUnits()){
            if(u.getName().equals(name)) unit = u;
        }
        if(unit == null) {
            for (Unit u : area2.getUnits()) {
                if (u.getName().equals(name)) unit = u;
            }
            if(unit == null){
                for(Unit u : area3.getUnits()){
                    if(u.getName().equals(name)) unit = u;
                }
            }
        }

        switch (unit.getType()) {
            case "melee" -> {
                inventory.increaseMeleeCount();
                return "Store Melee Success";
            }
            case "ranged" -> {
                inventory.increaseRangedCount();
                return "Store Ranged Success";
            }
            case "aoe" -> {
                inventory.increaseAoeCount();
                return "Store AOE Success";
            }
        }
        if (unit.getUnitClass().equals("Antibody")) {
            unit.setToSpawn(false);
            Area area = unit.getArea();
            area.removeAntibody((Antibody) unit);
        }
        return "Unsuccessful something went wrong.";
    }

    @CrossOrigin
    @PostMapping(path = "/pickupunit")
    public String pickupUnit(@RequestBody ApiData_AreaAndPosition data){
        int areaNumber = data.getArea();
        String type = data.getType();
        double positionX = data.getPositionX();
        double positionY = data.getPositionY();
        Game game = gameHandler.getGame(data);
        Inventory inventory = game.getInventory();
        Area area = null;
        if(areaNumber == 1){
            area = game.getAreas().get(0);
        }else if(areaNumber == 2){
            area = game.getAreas().get(1);
        }else if(areaNumber == 3){
            area = game.getAreas().get(2);
        }

        assert area != null;
        if(area.canPlace(positionX, positionY)){
            Antibody ab = UnitFactory.createAntibody(type);

            switch (type) {
                case "melee" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseMeleeCount();
                        if(areaNumber == 1){
//                            System.out.println("q1");
                            game.getQueueAntibobyArea1().add(ab);
//                            System.out.println(game.getQueueAntibobyArea1());
//                            System.out.println(game.getAreas().get(0).getAntibodies());
//                            game.getAreas().get(0).addAllAntibody(game.getQueueAntibobyArea1());
//                            System.out.println(game.getQueueAntibobyArea1());
//                            System.out.println(game.getAreas().get(0).getAntibodies());
                        }else if(areaNumber == 2){
                            game.getQueueAntibobyArea2().add(ab);
                        }else if(areaNumber == 3){
                            game.getQueueAntibobyArea3().add(ab);
                        }
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        ab.setToSpawn(true);
                        return "Pick up Melee Success";
                    }
                }
                case "ranged" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseRangedCount();
                        if(areaNumber == 1){
                            game.getQueueAntibobyArea1().add(ab);
                        }else if(areaNumber == 2){
                            game.getQueueAntibobyArea2().add(ab);
                        }else if(areaNumber == 3){
                            game.getQueueAntibobyArea3().add(ab);
                        }
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        ab.setToSpawn(true);
                        return "Pick up Ranged Success";
                    }
                }
                case "aoe" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseAoeCount();
                        if(areaNumber == 1){
                            game.getQueueAntibobyArea1().add(ab);
                        }else if(areaNumber == 2){
                            game.getQueueAntibobyArea2().add(ab);
                        }else if(areaNumber == 3){
                            game.getQueueAntibobyArea3().add(ab);
                        }
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        ab.setToSpawn(true);
                        return "Pick up AOE Success";
                    }
                }
            }
        }
        return "Unsuccessful something went wrong";
    }
}
