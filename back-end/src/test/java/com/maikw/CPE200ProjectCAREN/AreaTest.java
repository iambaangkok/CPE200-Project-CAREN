package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AreaTest {
    Area area = new Area("Area1");
    Antibody[] abs_melee = {UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee")};
    Antibody[] abs_ranged = {UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged")};
    Antibody[] abs_aoe = {UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe")};
    Virus[] vs_melee = {UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee")};
    Virus[] vs_ranged = {UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged")};
    Virus[] vs_aoe = {UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe")};
    int size = 9;
    List<Virus> viruses = new ArrayList<Virus>();
    List<Antibody> antibodies = new ArrayList<Antibody>();
    List<Unit> units = new ArrayList<Unit>();

    @Test
    void addVirus() {
        for(int i = 0 ; i < 3 ; i++){
            area.addVirus(vs_melee[i]);
            assertEquals(vs_melee[i].getArea(),area);
            area.addVirus(vs_ranged[i]);
            assertEquals(vs_ranged[i].getArea(),area);
            area.addVirus(vs_aoe[i]);
            assertEquals(vs_aoe[i].getArea(),area);
        }
        assertEquals(area.viruses.size(),size);
    }

    @Test
    void addAllVirus() {
        for(int i = 0; i < 3 ; i++){
            viruses.add(vs_melee[i]);
            viruses.add(vs_ranged[i]);
            viruses.add(vs_aoe[i]);
        }
        area.addAllVirus(viruses);
        for(Virus vs : viruses){
            assertEquals(vs.getArea(),area);
        }
        assertEquals(area.getViruses(),viruses);
    }

    @Test
    void addAntibody() {
        for(int i = 0 ; i < 3 ; i++){
            area.addAntibody(abs_melee[i]);
            assertEquals(abs_melee[i].getArea(),area);
            area.addAntibody(abs_ranged[i]);
            assertEquals(abs_ranged[i].getArea(),area);
            area.addAntibody(abs_aoe[i]);
            assertEquals(abs_aoe[i].getArea(),area);
        }
        assertEquals(area.antibodies.size(),size);
    }

    @Test
    void addAllAntibody() {
        for(int i = 0; i < 3 ; i++){
            antibodies.add(abs_melee[i]);
            antibodies.add(abs_ranged[i]);
            antibodies.add(abs_aoe[i]);
        }
        area.addAllAntibody(antibodies);
        for(Antibody ab : antibodies){
            assertEquals(ab.getArea(),area);
        }
        assertEquals(area.getAntibodies(),antibodies);
    }

    @Test
    void removeVirus() {
        // add
        for(int i = 0; i < 3 ; i++){
            viruses.add(vs_melee[i]);
            viruses.add(vs_ranged[i]);
            viruses.add(vs_aoe[i]);
        }
        area.addAllVirus(viruses);

        // remove
        area.removeVirus(vs_melee[0]);
        assertNull(vs_melee[0].getArea());
        area.removeVirus(vs_ranged[0]);
        assertNull(vs_ranged[0].getArea());
        area.removeVirus(vs_aoe[0]);
        assertNull(vs_aoe[0].getArea());
        assertEquals(area.getViruses().size(), size-3);
    }

    @Test
    void removeAntibody() {
        // add
        for(int i = 0; i < 3 ; i++){
            antibodies.add(abs_melee[i]);
            antibodies.add(abs_ranged[i]);
            antibodies.add(abs_aoe[i]);
        }
        area.addAllAntibody(antibodies);

        // remove
        area.removeAntibody(abs_melee[0]);
        assertNull(abs_melee[0].getArea());
        area.removeAntibody(abs_ranged[0]);
        assertNull(abs_ranged[0].getArea());
        area.removeAntibody(abs_aoe[0]);
        assertNull(abs_aoe[0].getArea());
        assertEquals(area.getAntibodies().size(), size-3);
    }

    @Test
    void alertLevel() {
        assertEquals(area.alertLevel(),2); // red light -> area is taken

        // yellow light -> antibody:virus = 1:3
        area.addAntibody(abs_melee[1]);
        area.addAntibody(abs_ranged[1]);
        area.addAntibody(abs_aoe[1]);
        for(int i = 0 ; i < 3 ; i++){
            area.addVirus(vs_melee[i]);
            area.addVirus(vs_ranged[i]);
            area.addVirus(vs_aoe[i]);
        }
        assertEquals(area.alertLevel(), 1);

        // all good -> antibody:virus = 2:3
        area.addAntibody(abs_melee[0]);
        area.addAntibody(abs_ranged[0]);
        area.addAntibody(abs_aoe[0]);
        assertEquals(area.alertLevel(), 0);
    }

    @Test
    void canPlace() {
        // add
        for(int i = 0; i < 3 ; i++){
            viruses.add(vs_melee[i]);
            viruses.add(vs_ranged[i]);
            viruses.add(vs_aoe[i]);
        }
        area.addAllVirus(viruses);
        for(int i = 0; i < 3 ; i++){
            antibodies.add(abs_melee[i]);
            abs_melee[i].setPositionX(0.0+i); abs_melee[i].setPositionY(0.0-i);
            antibodies.add(abs_ranged[i]);
            abs_ranged[i].setPositionX(0.0+(2*i)); abs_ranged[i].setPositionY(0.0-(2*i));
            antibodies.add(abs_aoe[i]);
            abs_aoe[i].setPositionX(0.0+(3*i)); abs_aoe[i].setPositionY(0.0-(3*i));
        }
        area.addAllAntibody(antibodies);
        units = area.getUnits();

        assertEquals(area.canPlace(0.0, 0.0), false); // can't place because abs_melee[0] is there
        assertEquals(area.canPlace(5.5, -28.6), true); // can place, nothing there
    }

    @Test
    void isTaken() {
        // alert level() = red light -> area is taken
        assertEquals(area.isTaken(), true);
    }

    @Test
    void snapViruses() {
        for(int i = 0; i < 3 ; i++){
            viruses.add(vs_melee[i]);
            viruses.add(vs_ranged[i]);
            viruses.add(vs_aoe[i]);
        }
        area.addAllVirus(viruses);
        assertEquals(area.getViruses(), viruses);
        
        // snap
        area.snapViruses();
        
        assertEquals(area.getViruses().size(), 0);
    }
}
