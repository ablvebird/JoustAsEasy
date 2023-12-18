package org.data;

public class DataGenerator {

    //STATS
    public static double generateCasualtiesPerBout(){
        return Math.random()*4.0+0.0;
    }
    public static double generateRansomsPerBout(){
        return Math.random()*5000.0+0.0;
    }
}
