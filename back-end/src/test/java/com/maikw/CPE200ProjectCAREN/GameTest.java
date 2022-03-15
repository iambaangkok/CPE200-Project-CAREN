package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Antibody a = UnitFactory.createAntibody("melee");
    Antibody b = UnitFactory.createAntibody("melee");
    Antibody c = UnitFactory.createAntibody("melee");
//    a.positionX= 10.0;
//    a.positionY = 0.0;
//    queueAntibobyArea1.add(a);
//    b.positionX= 10.0;
//    b.positionY = 0.0;
//    queueAntibobyArea2.add(b);
//    c.positionX= 10.0;
//    c.positionY = 0.0;
//    queueAntibobyArea3.add(c);



    @Test
    void startGameLoop() {

    }

    @Test
    void putVirusToArea() {
    }

    @Test
    void run() {
    }


    @Test
    void getSpawn() {
        //เช็คโดยการที่มันเข้าไปเเล้วทำให้ค่านี้เปลี่ยนไปไหม
    }

    @Test
    void getTimeManager() {
        // เทสเวลา ของ Slow จะต้องช้ากว่า Fast  ของ fsat ทำกลับกัน
    }

    @Test
    void getInventory() {
        // เทียบจำนวนตัวใน Inventory
    }

    @Test
    void getAreas() {
        //มีการเข้าถึง Areas หรือ วางUnit แล้วมันเพิ่มตามที่มันต้องเป็นไหม
    }

    @Test
    void getWaveManager() {
    }

    @Test
    void getShop() {
        //ลองซื้อตัว ละเงินลดไหม
    }


}