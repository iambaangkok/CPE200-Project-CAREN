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
    @PostMapping(path = "/setcredit") // http:/localhost:8080/shop/setcredit
    public int setCredit(@RequestBody int credit){
        shop.setCurrentCredit(credit);
        return credit;
    }
}
