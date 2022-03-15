package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_Base;
import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_BuyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/shop") // http://localhost:8080/shop
public class ShopController {
    private final GameHandler gameHandler;

    @Autowired
    public ShopController(GameHandler gameHandler){
        this.gameHandler = gameHandler;
    }

    @CrossOrigin
    @PostMapping(path = "/getshop")
    public Shop getShop(@RequestBody ApiData_Base data){
        Shop shop = gameHandler.getGame(data).getShop();
        return shop;
    }

    @CrossOrigin
    @PostMapping(path = "/buyunit")
    public String buyUnit(@RequestBody ApiData_BuyUnit data){
        Shop shop = gameHandler.getGame(data).getShop();
        switch (data.getType()) {
            case "melee" -> {
                shop.buyMelee();
                return "Buy Melee Success";
            }
            case "ranged" -> {
                shop.buyRanged();
                return "Buy Ranged Success";
            }
            case "aoe" -> {
                shop.buyAOE();
                return "Buy AOE Success";
            }
        }
        return "Unsuccessful something went wrong";
    }
}
