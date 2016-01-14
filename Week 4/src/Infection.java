
public class Infection
{

	public static void main(String[] args)
	{
		Person p = new Person();
		System.out.println(p); // well person
		
		p.setInfected(true);
		System.out.println(p);  // sick person
		
		Population pop = new Population(100, 0.1, 0.85, 0.2);
		System.out.println(pop);  // population of 100 people
		System.out.println(pop.howManyInfected()); // about 10
		
		//run simulation for several time steps
		for(int i = 0; i < 40; i++)
		{
			System.out.println(pop.proportionInfected());
			pop.update();
		}
		
		//new population with deathrate
		Population pop2 = new Population(200,0.1,0.85,0.2,0.5);
		System.out.println(pop2);  // population of 200 people
		System.out.println(pop2.howManyInfected()); // about 20
		//testing get and set deathrate
		pop2.setDeathrate(0.3);
		System.out.println("get deathrate: " + pop2.getDeathrate());
		//run simulation for several time steps
		for(int i = 0; i < 40; i++)
		{		
			System.out.println(pop2 +" | Infected: "+ pop2.howManyInfected() + " | Proportion infected: " + pop2.proportionInfected());
			pop2.update();
		}
		System.out.println("Final " + pop2);
	}
};