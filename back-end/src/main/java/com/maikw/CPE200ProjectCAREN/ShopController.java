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
}
