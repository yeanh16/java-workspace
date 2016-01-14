
import java.util.ArrayList;
import java.util.Scanner;

public class FantasySolarSystem {

     public static ArrayList<SolarSystem> system = new ArrayList<SolarSystem>();

    public static void main(String[] args) {
        String solarName;
        String planetName;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the solar system: ");
        solarName = in.nextLine();
        SolarSystem create = new SolarSystem(solarName);

        System.out.println("Now enter planet names - type 'done' to finish");

        do {
            System.out.print("Enter name: ");
            planetName = in.nextLine();
            if (planetName.equals("done")) {

            } else {

                double massRound = create.getMass();
                double distRound = create.getDist();
                double periodRound = create.getPeriod();
                create.roundVals();
                SolarSystem toAdd = new SolarSystem(planetName,massRound ,distRound, periodRound);
                system.add(toAdd);
                System.out.println(create.toString(planetName, massRound, distRound,periodRound));

            }      
               
        } while (!planetName.equals("done"));

        FantasySolarSystem print = new FantasySolarSystem();
        print.printTable();
    }
    
    public void printTable() {
        System.out.println("Name" + "\t" + "Mass" + "\t" + "Distance" + "\t" + "Period (years) \n");
        for(int i = 0; i< system.size();i++) 
        {
        	double years = system.get(i).periodChange;
            System.out.println(system.get(i).name + "\t" + system.get(i).mass +"\t" + system.get(i).distance + "\t         " + years);
        }
    }

}
