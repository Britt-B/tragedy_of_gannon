import java.util.Scanner;

public class TragedyOfGannon{
	//create gannon
	static Gannon gannon = new Gannon();
	
	//create Npc chracters
	static Npc swordTrainer = new Npc("Sword Trainer", 85, 25);
	static Npc brutus = new Npc("Brutus the bully", 75, 20);
	static Npc mobBoss = new Npc("Mob Gang Boss", 80, 40);
	static Npc mobNinja = new Npc("Mob Gang Ninja", 100, 30);
	static Npc mittens = new Npc("Lil Mittens", 0, 0);
	static Npc stableGuy = new Npc("Stable hand", 0, 0);
	static Npc recruit = new Npc("Crew recruit", 75, 75);
	static Npc calico= new Npc("Capn' Calico", 80, 100);
	static Npc belinda = new Npc("Belinda", 0, 0);
	static Npc librarian = new Npc("Librarian", 0, 0);
	static Npc wife = new Npc("Librarian's wife", 0, 0);
	static Npc zooldar = new Npc("Princess Zooldar", 0, 0);
	static Npc scruffy = new Npc("Scruffy", 175, 40);
	
	//rooms
	static Room cityGates = new Room("City Gates", 0, null, null);
	static Room royalArmory = new Room("Royal Cat Armory", 1, brutus, null);
	static Room generalStore = new Room("General Store", 2, mobBoss, mobNinja);
	static Room mayorMittens = new Room("Mayor Mittens's House", 3, mittens, null);
	static Room stables = new Room("stables", 4, stableGuy, null);
	static Room backtailAlley = new Room("Backtail Alley", 5, null, null);	
	static Room tomCatBar = new Room("Tom Cat Bar", 6, calico, recruit);
	static Room pawprintMuseum = new Room("Pawprint Museum", 7, belinda, null);
	static Room furstoneLibrary = new Room("Furstone Library", 8, librarian, wife);
	static Room cityCenter = new Room("city center", 9, null, null);
	static Room princessZooldar = new Room("Princess Zooldar's Castle", 10, zooldar, null);
	static Room kittenCove = new Room("Kitten Cove", 11, swordTrainer, null);
	static Room huntingGrounds = new Room("Hunting Grounds", 12, null, null);
	static Room longFleaForest = new Room("Long Flea Forest", 13, scruffy, null);
	static Room dungeonFight = new Room("Gannon's future dungeon", 14, scruffy, null);
	
	//decides if game is running
	private static boolean mainQuest = true;
	
	
	public static void main(String [] args)throws InterruptedException{
		
		cityGates.setExits(stables, null, null, royalArmory);
		royalArmory.setExits(cityGates, generalStore, null, null);
		generalStore.setExits(null, mayorMittens, royalArmory, null);
		mayorMittens.setExits(furstoneLibrary, princessZooldar, generalStore, null);
		princessZooldar.setExits(null, null, mayorMittens, null);
		furstoneLibrary.setExits(null, null, pawprintMuseum, mayorMittens);
		pawprintMuseum.setExits(null, furstoneLibrary, tomCatBar, null);
		tomCatBar.setExits(null, pawprintMuseum, backtailAlley, null);
		backtailAlley.setExits(null, tomCatBar, stables, null);
		stables.setExits(null, backtailAlley, null, cityGates);
		huntingGrounds.setExits(null, longFleaForest, null, cityGates);
		longFleaForest.setExits(null, null, huntingGrounds, null);
		
		//player selection variable
		int choice = 0;
		//ensure valid choice is selected
		boolean validChoice = false;
		//create scanner
		Scanner input = new Scanner(System.in);
		

			//introduction
			System.out.printf("Long ago, there existed a kingdom where%n");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.printf("Huh? You've already played this game?%nWait! Don't go! I'm lonely. How about this, I'll give you a story " +
								"untold by the locals here.%nAh, it seems I've got you're attention now! Prepare yourself, for the kind catfolk " +
								"you've come to love are about to break your fragile human heart.%n");

			System.out.println("On a stromy winter night, an orphaned cat washed onto the shores of Kitten Cove. He crawled through the sand, fur " +
								"matted with salt. He needs to find shelter...");
				
						
			//loop main quest area (no more introduction play, allow movement in city etc)
			NewActions performActions = new NewActions();
			
			//hide diary and quit until first area is finished
			boolean firstLoop = true;
			while(mainQuest){
				System.out.println("---------------------------------------------------");
				
				System.out.printf("Press [d] to view diary%nPress [q] to quit%n");
								
				//provide feedback for current area
				mainQuest = performActions.getExitsActions();
				mainQuest = performActions.endGame();
			}
			System.out.printf("And that is the story of why Gannon cat became te terrible fiend he is today. Can't blame him, can you? He was just a poor cat trying to " +
							"find a decent job in a bad economy.%n");
	}//end main method
	
}