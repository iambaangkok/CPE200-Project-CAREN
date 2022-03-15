package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Inventory inventory = new Inventory();

    @Test
    void increaseMeleeCount() {
        inventory.increaseMeleeCount();
        inventory.increaseMeleeCount();
        inventory.increaseMeleeCount();
        assertEquals(inventory.getMeleeCount(), 3);
    }

    @Test
    void decreaseMeleeCount() {
        // increase
        inventory.increaseMeleeCount();
        inventory.increaseMeleeCount();
        inventory.increaseMeleeCount();

        // decrease
        inventory.decreaseMeleeCount();
        inventory.decreaseMeleeCount();
        assertEquals(inventory.getMeleeCount(), 1);
    }

    @Test
    void increaseRangedCount() {
        inventory.increaseRangedCount();
        inventory.increaseRangedCount();
        inventory.increaseRangedCount();
        assertEquals(inventory.getRangedCount(), 3);
    }

    @Test
    void decreaseRangedCount() {
        // increase
        inventory.increaseRangedCount();
        inventory.increaseRangedCount();
        inventory.increaseRangedCount();

        // decrease
        inventory.decreaseRangedCount();
        inventory.decreaseRangedCount();
        assertEquals(inventory.getRangedCount(), 1);
    }

    @Test
    void increaseAoeCount() {
        inventory.increaseAoeCount();
        inventory.increaseAoeCount();
        inventory.increaseAoeCount();
        assertEquals(inventory.getAoeCount(), 3);
    }

    @Test
    void decreaseAoeCount() {
        // increase
        inventory.increaseAoeCount();
        inventory.increaseAoeCount();
        inventory.increaseAoeCount();

        // decrease
        inventory.decreaseAoeCount();
        inventory.decreaseAoeCount();
        assertEquals(inventory.getAoeCount(), 1);
    }

    @Test
    void canPickup() {
        // can pick up : there are unit in inventory
        inventory.increaseMeleeCount();
        inventory.increaseRangedCount();
        inventory.increaseAoeCount();
        assertTrue(inventory.canPickup("melee"));
        assertTrue(inventory.canPickup("ranged"));
        assertTrue(inventory.canPickup("aoe"));

        // can't pick up : there is no unit in inventory
        inventory.decreaseMeleeCount();
        inventory.decreaseRangedCount();
        inventory.decreaseAoeCount();
        assertFalse(inventory.canPickup("melee"));
        assertFalse(inventory.canPickup("ranged"));
        assertFalse(inventory.canPickup("aoe"));
    }
}
