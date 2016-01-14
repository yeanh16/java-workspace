
import java.util.ArrayList;
import java.util.Random;

public class SolarSystem {

    FantasySolarSystem fantasySystem = new FantasySolarSystem();

    public String solarName;
    
    double period;
    double mass;
    double distance;

    String name;

    public SolarSystem(String name) {
        solarName = name;
    }
   
    //Create a new Solar System
    public void newSolar() {
        SolarSystem newSolar = new SolarSystem(solarName);
        fantasySystem.system.add(newSolar);
    }

    //Create a New Planet.
    public void addPlanet(SolarSystem toAdd) {
        fantasySystem.system.add(toAdd);
    }

    public SolarSystem(String planetName, double massRound, double distRound, double periodChange) {
        this.name = planetName;
        this.mass = massRound;
        this.distance = distRound;
        this.periodChange = distRound;
    }

    //Generate Random Mass and Distance and round them to 3dp.
    public void roundVals() {
        getMass();
        getDist();

    }

    //Create a Random Number n.
    Random rnd = new Random();
    double n = rnd.nextDouble() + 1;
    
    double massRound;
    double distRound;
    double periodRound;
    double periodChange;
      
    //Get Mass.
    public double getMass() {
        Random rnd1 = new Random();
        double mass = rnd1.nextDouble() * n;
        massRound = Math.round(mass * 1000) / 1000.0;
        return massRound;
    }

    //Get Distance
    public double getDist() {
        Random rnd2 = new Random();
        double distance = rnd2.nextDouble() * n;
        distRound = Math.round(distance * 1000) / 1000.0;
        return distRound;
    }

    public double getPeriod() {

        double period = Math.sqrt(distRound * distRound * distRound);
        periodRound = Math.round(period * 1000) / 1000.0;
        
        if (periodRound > 1){
            periodChange = periodRound; 
        }else if(periodRound < 1){
            periodChange = periodRound * 365.25;
            periodChange = Math.round(periodChange * 1000) / 1000.0;
        }
        return periodChange;
    }
    
    //Print out Planet Details.
    public String toString(String planetName, double massRound, double distRound, double periodChange) {
        if (periodRound > 1) {
            return ("Planet " + planetName + " has a mass of " + massRound + " Earths" + ", is " + distRound
                    + "AU from its star, and orbits in " + periodChange + " years");
        } else{
            return ("Planet " + planetName + " has a mass of " + massRound + " Earths" + ", is " + distRound
                    + "AU from its star, and orbits in " + periodChange + " days");
        }

    }

}
