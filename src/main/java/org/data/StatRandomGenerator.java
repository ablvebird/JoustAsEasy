package org.data;

import org.entities.House;

import java.util.Scanner;

public class StatRandomGenerator {

    //Beheadings, guttings, maimings
    public static double generateCasualtiesPerBout(){
        return Math.random()*4.0+0.0;
    }

    //Ransom money
    public static double generateRansomsPerBout(){
        return Math.random()*5000.0+0.0;
    }
}
