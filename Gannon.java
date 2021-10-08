import java.util.Random;

public class Gannon extends Character{
	
	//create diary/log
	Diary diary;
	
	//hold weapon spot
	
	//basic constructor
	public Gannon(){
		//assign values for character variables
		super("Gannon", 100, 40);
		//create diary/log
		diary = new Diary();
	}
	
	public void hunt(int multiplier){
		int healthRestored = 0;
		//generate chance to catch animals
		Random random = new Random();
		int rNum = 100*(random.nextInt());
		
		if(getHealth() < 250){
			//50% bird, 25 health
			if(rNum < 50){
				healthRestored = (25*multiplier);
				System.out.println("You hunted a bird, and restored " + healthRestored + " health.");
			}
			//35% rabbit, 75 health
			else if(rNum >= 50 && rNum <= 85){
				healthRestored = (75*multiplier);
				System.out.println("You hunted a rabbit, and restored " + healthRestored + " health.");
			}
			//15% deer, 150 health
			else if(rNum > 85){
				healthRestored = (150*multiplier);
				System.out.println("You hunted a deer, and restored " + healthRestored + " health.");
			}
			//give player health
			setHealth(getHealth() + healthRestored);
			
			//max player health
			if(getHealth() > 250){
				setHealth(250);
			}
		}
		else{
			System.out.println("You are full.");
		}
		//print health
		
		System.out.println("You have " + getHealth() + " health.");
	}
}