package com.diakogiannis.metropolitan.paper.service;

import javax.enterprise.context.ApplicationScoped;
import java.text.DecimalFormat;

@ApplicationScoped
public class PaceCalculationService {

    private static DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Return the pace as a String in the format #.## The formula that calculates the pace is (((hours*60)+minutes)*1000)/distance
     * The measurment unit is min/km
     * @param distance
     * @param seconds
     * @return
     */
    public String calculatePaceFormated(double distance, double seconds){

        return df.format(calculatePace(distance, seconds));

    }

    /**
     * The formula that calculates the pace is (((hours*60)+minutes)*1000)/distance
     * The measurment unit is min/km
     * @param distance
     * @param seconds
     * @return
     */
    public Double calculatePace(double distance, double seconds){

        if(distance <= 0 || seconds <= 0){
            return 0d;
        } else {
            return (seconds/60d)/distance;
        }

    }
}
