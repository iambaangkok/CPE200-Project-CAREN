package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirusTest {
    Virus virus = UnitFactory.createVirus("melee");
    Antibody antibodyGod = UnitFactory.createAntibody("melee");

    @Test
    void creditReward() {
        while(virus.getCurrentHealth() > 0){
            antibodyGod.attack(virus);
        }
        assertEquals(virus.creditReward(), 50);
    }
}
