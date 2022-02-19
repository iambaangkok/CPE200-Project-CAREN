package com.maikw.CPE200ProjectCAREN;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/shop") // http://localhost:8080/shop
public class ShopController {
    Shop shop = new Shop();

    @CrossOrigin
    @GetMapping
    public Shop getShop(){
        return shop;
    }

    @CrossOrigin
    @PostMapping(path = "/buyunit")
    public String buyUnit(@RequestBody String type){
        switch (type) {
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
