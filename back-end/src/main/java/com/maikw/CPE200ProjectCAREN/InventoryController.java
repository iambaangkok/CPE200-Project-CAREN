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
        Unit unit = data.getUnit();

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
        switch (unit.getUnitClass()){
            case "Antibody" -> unit.getArea().removeAntibody((Antibody) unit);
            case "Virus" -> unit.getArea().removeVirus((Virus) unit);
        }
        return "Unsuccessful something went wrong.";
    }

    @CrossOrigin
    @PostMapping(path = "/pickupunit")
    public String pickupUnit(@RequestBody ApiData_AreaAndPosition data){
        Area area = data.getArea();
        String type = data.getType();
        double positionX = data.getPositionX();
        double positionY = data.getPositionY();
        Inventory inventory = gameHandler.getGame(data).getInventory();

        if(area.canPlace(positionX, positionY)){
            Antibody ab = UnitFactory.createAntibody(type);

            switch (type) {
                case "melee" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseMeleeCount();
                        area.addAntibody(ab);
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        return "Pick up Melee Success";
                    }
                }
                case "ranged" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseRangedCount();
                        area.addAntibody(ab);
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        return "Pick up Ranged Success";
                    }
                }
                case "aoe" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseAoeCount();
                        area.addAntibody(ab);
                        ab.setPositionX(positionX); ab.setPositionY(positionY);
                        return "Pick up AOE Success";
                    }
                }
            }
        }
        return "Unsuccessful something went wrong";
    }
}
