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
    public static int antibodyMeleeHealth;
    public static int antibodyRangedHealth;
    public static int antibodyAoeHealth;
    public static int virusMeleeHealth;
    public static int virusRangedHealth;
    public static int virusAoeHealth;
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
            s.next();
            radius = s.nextInt(); s.next(); // set radius
            int n = s.nextInt(); s.next();
            maxWave = n; // set maxWave
            meleeCountPerWave = new int[n]; // set meleeCountPerWave
            for(int i = 0 ; i < n ; i++){ // set meleeCount to every wave
                meleeCountPerWave[i] = s.nextInt(); s.next();
            }
            rangedCountPerWave = new int[n]; // set rangedCountPerWave
            for(int i = 0 ; i < n ; i++){ // set rangedCount to every wave
                rangedCountPerWave[i] = s.nextInt(); s.next();
            }
            aoeCountPerWave = new int[n]; // set aoeCountPerWave
            for(int i = 0 ; i < n ; i++){ // set aoeCount to every wave
                aoeCountPerWave[i] = s.nextInt(); s.next();
            }
            detectRange = s.nextInt(); s.next(); // set detectRange
            dangerRange = s.nextInt(); s.next(); // set dangerRange
            startCredit = s.nextInt(); s.next(); // set startCredit
            meleePrice = s.nextInt(); s.next(); // set meleePrice
            rangedPrice = s.nextInt(); s.next(); // set rangedPrice
            aoePrice = s.nextInt(); s.next(); // set aoePrice
            moveCost = s.nextInt(); s.next(); // set moveCost
            antibodyMeleeHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            antibodyRangedHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            antibodyAoeHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            virusMeleeHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            virusRangedHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            virusAoeHealth = s.nextInt(); s.next(); // set antibodyMeleeHeath
            antibodyMeleeDamage = s.nextInt(); s.next(); // set antibodyMeleeDamage
            antibodyRangedDamage = s.nextInt(); s.next(); // set antibodyRangedDamage
            antibodyAoeDamage = s.nextInt(); s.next(); // set antibodyAoeDamage
            virusMeleeDamage = s.nextInt(); s.next(); // set virusMeleeDamage
            virusRangedDamage = s.nextInt(); s.next(); // set virusRangedDamage
            virusAoeDamage = s.nextInt(); s.next(); // set virusAoeDamage
            lifeSteal = s.nextInt(); s.next(); // set lifeSteal
            creditReward = s.nextInt(); s.next(); // set creditReward
            meleeAttackRange = s.nextInt(); s.next(); // set meleeAttackRange
            rangedAttackRange = s.nextInt(); s.next(); // set rangedAttackRange
            aoeAttackRange = s.nextInt(); s.next(); // set aoeAttackRange
            meleeMoveSpeed = s.nextInt(); s.next(); // set meleeMoveSpeed
            rangedMoveSpeed = s.nextInt(); s.next(); // set rangedMoveSpeed
            aoeMoveSpeed = s.nextInt(); // set aoeMoveSpeed
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found <- From Config");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
