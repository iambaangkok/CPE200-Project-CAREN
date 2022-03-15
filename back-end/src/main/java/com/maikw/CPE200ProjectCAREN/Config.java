package com.maikw.CPE200ProjectCAREN;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Config {
    public static int radius;
    public static int maxWave;
    public static int[] meleeCountPerWave;
    public static int[] rangedCountPerWave;
    public static int[] aoeCountPerWave;
    public static int detectRange;
    public static int dangerRange;
    public static int startCredit;
    public static int meleePrice;
    public static int rangedPrice;
    public static int aoePrice;
    public static int moveCost;
    public static int antibodyHealth;
    public static int virusHealth;
    public static int antibodyMeleeDamage;
    public static int antibodyRangedDamage;
    public static int antibodyAoeDamage;
    public static int virusMeleeDamage;
    public static int virusRangedDamage;
    public static int virusAoeDamage;
    public static int lifeSteal;
    public static int creditReward;
    public static int meleeAttackRange;
    public static int rangedAttackRange;
    public static int aoeAttackRange;
    public static int meleeMoveSpeed;
    public static int rangedMoveSpeed;
    public static int aoeMoveSpeed;

    public static void readFile(String path){
        try (FileReader fr = new FileReader(path);
             Scanner s = new Scanner(fr)) {
            radius = s.nextInt(); // set radius
            int n = s.nextInt();
            maxWave = n; // set maxWave
            meleeCountPerWave = new int[n]; // set meleeCountPerWave
            for(int i = 0 ; i < n ; i++){ // set meleeCount to every wave
                meleeCountPerWave[i] = s.nextInt();
            }
            rangedCountPerWave = new int[n]; // set rangedCountPerWave
            for(int i = 0 ; i < n ; i++){ // set rangedCount to every wave
                rangedCountPerWave[i] = s.nextInt();
            }
            aoeCountPerWave = new int[n]; // set aoeCountPerWave
            for(int i = 0 ; i < n ; i++){ // set aoeCount to every wave
                aoeCountPerWave[i] = s.nextInt();
            }
            detectRange = s.nextInt(); // set detectRange
            dangerRange = s.nextInt(); // set dangerRange
            startCredit = s.nextInt(); // set startCredit
            meleePrice = s.nextInt(); // set meleePrice
            rangedPrice = s.nextInt(); // set rangedPrice
            aoePrice = s.nextInt(); // set aoePrice
            moveCost = s.nextInt(); // set moveCost
            antibodyHealth = s.nextInt(); // set antibodyHealth
            virusHealth = s.nextInt(); // set virusHealth
            antibodyMeleeDamage = s.nextInt(); // set antibodyMeleeDamage
            antibodyRangedDamage = s.nextInt(); // set antibodyRangedDamage
            antibodyAoeDamage = s.nextInt(); // set antibodyAoeDamage
            virusMeleeDamage = s.nextInt(); // set virusMeleeDamage
            virusRangedDamage = s.nextInt(); // set virusRangedDamage
            virusAoeDamage = s.nextInt(); // set virusAoeDamage
            lifeSteal = s.nextInt(); // set lifeSteal
            creditReward = s.nextInt(); // set creditReward
            meleeAttackRange = s.nextInt(); // set meleeAttackRange
            rangedAttackRange = s.nextInt(); // set rangedAttackRange
            aoeAttackRange = s.nextInt(); // set aoeAttackRange
            meleeMoveSpeed = s.nextInt(); // set meleeMoveSpeed
            rangedMoveSpeed = s.nextInt(); // set rangedMoveSpeed
            aoeMoveSpeed = s.nextInt(); // set aoeMoveSpeed
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
