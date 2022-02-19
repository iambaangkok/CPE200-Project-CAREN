package com.maikw.CPE200ProjectCAREN;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {
    Inventory inventory = new Inventory();

    @CrossOrigin
    @GetMapping
    public Inventory getInventory(){
        return inventory;
    }

    @CrossOrigin
    @PostMapping(path = "/storeunit")
    public String storeUnit(@RequestBody Unit unit){
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
            case "Antibody" -> unit.area.removeAntibody((Antibody) unit);
            case "Virus" -> unit.area.removeVirus((Virus) unit);
        }
        return "Unsuccessful something went wrong.";
    }

    @CrossOrigin
    @PostMapping(path = "/pickupunit")
    public String pickupUnit(@RequestBody String type, Area area, double positionX, double positionY){
        if(area.canPlace(positionX, positionY)){
            Antibody ab = UnitFactory.createAntibody("",type);
            ab.setArea(area);
            area.addAntibody(ab);
            ab.setPositionX(positionX); ab.setPositionY(positionY);
            switch (type) {
                case "melee" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseMeleeCount();
                        return "Pick up Melee Success";
                    }
                }
                case "ranged" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseRangedCount();
                        return "Pick up Ranged Success";
                    }
                }
                case "aoe" -> {
                    if(inventory.canPickup(type)){
                        inventory.decreaseAoeCount();
                        return "Pick up AOE Success";
                    }
                }
            }
        }
        return "Unsuccessful something went wrong";
    }
}
