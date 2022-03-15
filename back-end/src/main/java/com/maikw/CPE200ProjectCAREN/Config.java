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
    public static int ragnedAttackRange;
    public static int aoeAttackRange;
    public static int meleeMoveSpeed;
    public static int ragnedMoveSpeed;
    public static int aoeMoveSpeed;

    public static void readFile(String path){
        try (FileReader fr = new FileReader(path);
             Scanner s = new Scanner(fr)) {
            int n = s.nextInt();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
