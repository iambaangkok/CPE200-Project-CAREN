package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    Shop shop = new Shop();
    Inventory inventory = new Inventory();

    @Test
    void buyMelee() {
        shop.setInventory(inventory);
        int baseCredit = shop.getCurrentCredit();
        shop.buyMelee(); shop.buyMelee();
        assertEquals(shop.getCurrentCredit(), baseCredit - (2*shop.getMeleePrice()));
    }

    @Test
    void buyRanged() {
        shop.setInventory(inventory);
        int baseCredit = shop.getCurrentCredit();
        shop.buyRanged(); shop.buyRanged();
        assertEquals(shop.getCurrentCredit(), baseCredit - (2*shop.getRangedPrice()));
    }

    @Test
    void buyAOE() {
        shop.setInventory(inventory);
        int baseCredit = shop.getCurrentCredit();
        shop.buyAoe(); shop.buyAoe();
        assertEquals(shop.getCurrentCredit(), baseCredit - (2*shop.getAoePrice()));
    }

    @Test
    void canBuy() {
        shop.setInventory(inventory);
        assertTrue(shop.canBuy("melee")); // can buy melee : have enough credit
        shop.setCurrentCredit(100);
        assertFalse(shop.canBuy("ranged")); // can't buy ranged : don't have enough credit
    }
}
