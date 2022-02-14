package com.maikw.CPE200ProjectCAREN;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GeneticCodeManager {



    public GeneticCodeManager(){

    }

    /**
     * Combine the genetic code file in to one single string.
     * @param filePath the path to the specified genetic code
     * @return 
     */
    public static String getAsString(String filePath){
        StringBuilder sb = new StringBuilder("");

        try (FileReader fr = new FileReader(filePath); Scanner s = new Scanner(fr);) {
            while(s.hasNextLine()){
                sb.append(s.nextLine());
                sb.append("\n");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found");
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } 

        return sb.toString();
    }
}
