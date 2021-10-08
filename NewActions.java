import java.util.Scanner;

public class NewActions{
	//jobs Gannon tries to get
	boolean calicoJob;
	boolean gangJob;
	boolean zooldarsGuardJob;
	boolean royalArmoryJob;
	boolean huntingJob;
	boolean mittensSecretaryJob;
	boolean museumJob;
	boolean stableJob;
	boolean libraryJob;
	//if all are completed
	boolean allJobs;
	
	
	//check positions
	private Room currentPosition;
	private Room newPosition;
	
	//check if first interaction - eliminates repeating dialouge
	private boolean firstInteraction;
	
	//finish game boolean
	private boolean mainQuest;
	
	//constructor, set values
	public NewActions(){
		//set current position to Kitten Cove		
		this.currentPosition = TragedyOfGannon.kittenCove;
		
		//set first interaction to true
		firstInteraction = true;
		//set main quest to true(game is running)
		mainQuest = true;

	}
	
	//get exits prompts the players for exits AND executes actions
	public boolean getExitsActions(){
		//make scanner
		Scanner input = new Scanner(System.in);
		
		//initialize choices
		String choice = "";
		int intChoice = 50;   //gives integer value of the string choice
		
		//room ID number to switch
		int roomID = this.currentPosition.getRoomID();
		
		
		switch(roomID){
			//city gates, access to outside only if not wanted criminal
			case 0:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.cityGates.getName() + ":%n");
				}
				System.out.printf("[1]Inspect the gate%n[2]Go north, to the stables%n[3]Go south, to the " +
								"Armory%n[4]Go to the City Center%n[5]Go to the hunting grounds%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else{
					if(1 == intChoice){
						System.out.printf("The gates are ornate, but no one is here to guard them. Maybe you could get a job protecting them.%n");
					}
					else if(2 == intChoice){
						this.newPosition = this.currentPosition.moveNorth();
					}
					else if(3 == intChoice){
						this.newPosition = this.currentPosition.moveSouth();
					}
					else if(4 == intChoice){
						this.newPosition = TragedyOfGannon.cityCenter;
					}
					else if(5 == intChoice){
						this.newPosition = TragedyOfGannon.huntingGrounds;
					}
					else{
						System.out.println("Enter a valid choice.");
					}
				}
				
				checkInterction();
				setNewPosition();
			break;
			//armory, can look around etc
			case 1:
				
				if(firstInteraction){
				System.out.printf(TragedyOfGannon.royalArmory.getName() + ":%n");
				}
				System.out.printf("[1]Ask the Warden for a job%n[2]Go north, to the city gates%n[3]Go east, to the General Store%n[4]Go to the City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else{
					if(1 == intChoice){
						TragedyOfGannon.brutus.dialogue.speak(1, royalArmoryJob);
						//if player hasn't tried armory job
						if(!royalArmoryJob){
							combat(TragedyOfGannon.brutus, TragedyOfGannon.brutus.claws);
							//if gannon runs out of health
							if(TragedyOfGannon.gannon.getHealth() < 0){
								System.out.println("You are too weak to fight, go hunt for food.");
							}
							//if enemy runs out of health
							else{
								System.out.printf("Warden: Sorry kid, you're a good fighter but I need a tough brute to guard that there gate. The other guy is just too friendly. " +
												"I need to even it out. I wouldn't have put you through the trouble, but I didn't expect you to win....%n");
								royalArmoryJob = true;
							}
						}
						else{
							System.out.printf("You're a tough kid, maybe you could protect the princess. Talk to her about that. Careful though, she's in a phase...");
						}
					}
					else if(2 == intChoice){
						this.newPosition = TragedyOfGannon.royalArmory.moveNorth();
					}
					else if(3 == intChoice){
						this.newPosition = TragedyOfGannon.royalArmory.moveEast();
					}
					else if(4 == intChoice){
						this.newPosition = TragedyOfGannon.cityCenter;
					}
					else{
						System.out.println("Enter a valid choice.");
					}
				}
				
				checkInterction();
				setNewPosition();
			break;
			//general store, gain gemstone
			case 2:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.generalStore.getName() + ":%n There is a mean looking cat with gold chains around his neck, puffing a cigar%n");
				}
				System.out.printf("[1]Talk to owner for a job%n[2]Go east, to Mayor Mitten's Mansion%n" + 
								"[3]Go west, to the Armory%n[4]Go to the City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else{
					if(1 == intChoice){
						TragedyOfGannon.mobBoss.dialogue.speak(2, gangJob);
						//fight for job
						if(!gangJob){
							combat(TragedyOfGannon.mobNinja, TragedyOfGannon.mobNinja.bow);
							//if gannon runs out of health
							if(TragedyOfGannon.gannon.getHealth() < 0){
								System.out.println("You are too weak to fight, go hunt for food.");
							}
							//if enemy runs out of health
							else{
								System.out.printf("Thug Boss: Alright alright enough! You're tough, I get it. There's no room in te gang though. We already split " +
												"the profits too thinly. Don't go getting any ideas about a rival gang either!%n");
								gangJob = true;
							}
						}
					}
					else if(2 == intChoice){
						this.newPosition = TragedyOfGannon.generalStore.moveEast();
					}
					else if(3 == intChoice){
						this.newPosition = TragedyOfGannon.generalStore.moveWest();
					}
					else if(4 == intChoice){
						this.newPosition = TragedyOfGannon.cityCenter;
					}
					else{
						System.out.println("Enter a valid choice.");
					}
				}
				
				checkInterction();
				setNewPosition();
			break;
			//mayor mittens, if has Taco can go to Zooldar
			case 3:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.mayorMittens.getName() + ":%nA young cat sits stuffing his face with candy.%n");
				}
				System.out.printf("[1]Ask Mayor Mittens for a job%n[2]Go north to Furstone Library%n[3]Go east to Zooldar's castle%n" +
								"[4]Go west to the general store%n[5]Go to the City Center%n");
								
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
						TragedyOfGannon.mittens.dialogue.speak(3, mittensSecretaryJob);
						mittensSecretaryJob = true;
						
				}
				else if(2 == intChoice){
					this.newPosition = TragedyOfGannon.mayorMittens.moveNorth();
				}
				else if(3 == intChoice){
					this.newPosition = TragedyOfGannon.mayorMittens.moveEast();
				}
				else if(4 == intChoice){
					this.newPosition = TragedyOfGannon.mayorMittens.moveWest();
				}
				else if(5 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//stable, can get bow after talking to librarian
			case 4:
				
				System.out.printf("[1]Talk to stable guy%n[2]Pet the donkey%n[3]Can I buy a horse?%n[4]Go east, to Backtail Alley%n[5]Go south, to the city gates%n" +
									"[6]Go to City Center%n");
				choice = input.next();
				//check for quit/inventory, parse to int value
				intChoice = choiceChecker(choice);
				
				if(50 == intChoice){
					//nothing to do, diary or quit slected to do here, quit or inventory was selected
				}
				if(1 == intChoice){
					TragedyOfGannon.stableGuy.dialogue.speak(4, stableJob);
					stableJob = true;
				}
				else if(2 == intChoice){
					System.out.printf("The donkey is indifferent.%n");
				}
				else if(3 == intChoice){
					System.out.printf("A horse? But you don't understand quantum mechanics, how could you ride a horse? Come back with an engineering degree," +
										"maybe you can ride the donkey.%n");
				}
				else if(4 == intChoice){
					this.newPosition = TragedyOfGannon.stables.moveEast();
				}
				else if(5 == intChoice){
					this.newPosition = TragedyOfGannon.stables.moveSouth();
				}
				else if(6 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				
				else{
					System.out.println("Enter a valid choice");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//backtail alley, can leave through here if wanted
			case 5:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.backtailAlley.getName() + ":%nIf you can't find a job, maybe you can grab a box and live here!%n");
				}
				System.out.printf("[1]Go east to Tom Cat Bar%n[2]Go west to the stables%n[3]Go to City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
						this.newPosition = TragedyOfGannon.backtailAlley.moveEast();
				}
				else if(2 == intChoice){
					this.newPosition = TragedyOfGannon.backtailAlley.moveWest();
				}
				else if(3 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//Tom cat bar, can get location of Taco's
			case 6:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.tomCatBar.getName() + ":%nSailors are crowded around a tables, signing on to what seems to be a captain's crew.%n");
				}
				System.out.printf("[1]Sign up for the crew%n[2]Go east to PawPrint Museum%n[3]Go west to Backtail alley%n[4]Go to City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
					TragedyOfGannon.recruit.dialogue.speak(6, calicoJob);
					if(!calicoJob){
						combat(TragedyOfGannon.recruit, TragedyOfGannon.recruit.claws);
						//if gannon runs out of health
						if(TragedyOfGannon.gannon.getHealth() < 0){
							System.out.println("You are too weak to fight, go hunt for food.");
						}
						//if enemy runs out of health
						else{
							System.out.printf("recruit: Wait! I'm useful! I can uh, serve rum. I've got a liquor license....%n");
							System.out.printf("Calico: Hired. Sorry son, he's a valuable resource.%n");
							
							calicoJob = true;
						}
					}
				}
				else if(2 == intChoice){
					this.newPosition = TragedyOfGannon.tomCatBar.moveEast();
				}
				else if(3 == intChoice){
					this.newPosition = TragedyOfGannon.tomCatBar.moveWest();
				}
				else if(4 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//give gemston, get oars
			case 7:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.pawprintMuseum.getName() + ":%nA girl sits reading a book.%n");
				}
				System.out.printf("[1]Look around%n[2]Talk to the girl%n[3]Ask for a job%n[4]Go east to Furstone Library%n[5]Go west to Tom Cat Bar%n" +
								"[6]Go to City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
					System.out.printf("The museum is small and quaint. It is nice but there is hardly any upkeep, it is unlikely they are hiring.%n");
				}
				else if(2 == intChoice){
					System.out.printf("Belinda: Hello! I'm the daughter of the curator, so when I grow up I'm going to own this place. If you want to know " +
									"about the exhibits I can tell you everything!%n");
				}
				else if(3 == intChoice){
					TragedyOfGannon.belinda.dialogue.speak(7, museumJob);
					museumJob = true;
				}
				else if(4 == intChoice){
					this.newPosition = TragedyOfGannon.pawprintMuseum.moveEast();
				}
				else if(5 == intChoice){
					this.newPosition = TragedyOfGannon.pawprintMuseum.moveWest();
				}
				else if(6 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//library
			case 8:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.furstoneLibrary.getName() + ":%nThe library has a warm glow to it. A man tends to the books while " +
											"a women is looking through a book of baby names.%n");
				}
				System.out.printf("[1]Talk to librarian%n[2]Talk to woman%n[3]Read a book%n[4]Go west to Pawprint Museum%n" +
								"[5]Go south to Mayor Mitten's House%n[6]Go to the City Center%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
						TragedyOfGannon.librarian.dialogue.speak(8, libraryJob);
						libraryJob = true;
				}
				else if(2 == intChoice){
					System.out.printf("Oh, tell me, what sounds more honorable, Cheech or Chong? I want my baby boy to be respected by everyone!%n");
				}
				else if(3 == intChoice){
					System.out.printf("You asked the librarian for the best book he has and he gives you The Silmarillion. Is it bad that you like Melkor..?%n");
				}
				else if(4 == intChoice){
					this.newPosition = TragedyOfGannon.furstoneLibrary.moveWest();
				}
				else if(5 == intChoice){
					this.newPosition = TragedyOfGannon.furstoneLibrary.moveSouth();
				}
				else if(6 == intChoice){
					this.newPosition = TragedyOfGannon.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;
			//city center, serves as quick portal around city, can get tacos once location i known
			case 9:
				System.out.printf(TragedyOfGannon.cityCenter.getName() + ":%n%n[1]Go to city gates%n[2]Go to Royal Cat Armory%n" +
								"[3]Go to the General Store%n[4]Go to Mayor Mitten's house%n[5]Go to Furstone Library%n[6]Go to " +
								"Paw Print Museum%n[7]Go to Tom Cat Bar%n[8]Go to Backtail alley%n[9]Go to the stables%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				if(intChoice == 1){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("0");
				}
				else if(intChoice == 2){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("1");
				}
				else if(intChoice == 3){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("2");
				}
				else if(intChoice == 4){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("3");
				}
				else if(intChoice == 5){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("8");
				}
				else if(intChoice == 6){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("7");
				}
				else if(intChoice == 7){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("6");
				}
				else if(intChoice == 8){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("5");
				}
				else if(intChoice == 9){
					this.newPosition = TragedyOfGannon.cityCenter.getNewPosition("4");
				}
				else{
					System.out.println("Enter a valid choice");
				}
				setNewPosition();
			break;
			//Zooldar
			case 10:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.princessZooldar.getName() + ":%nA girl clad in black is throwing daggers in the courtyard.%n");
				}
				System.out.printf("[1]Ask for the princess%n[2]Ask for a job protectecting the princess%n[3]Go west to Mittens's house.%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
						System.out.printf("Princess Zooldar: I am the princess! Just because I'm not dressed in pink throwing flowers over my shoulder " +
										"doesn't mean I'm not a princess! And it's not a phase!!!%n");
				}
				else if(2 == intChoice){
					TragedyOfGannon.zooldar.dialogue.speak(10, zooldarsGuardJob);
					zooldarsGuardJob = true;
				}
				else if(3 == intChoice){
					this.newPosition = TragedyOfGannon.princessZooldar.moveWest();
				}
				else{
					System.out.println("Enter a valid choice.");
				}
				
				checkInterction();
				setNewPosition();
			break;						
			//cove, beginning of game
			case 11:
				//beginning of game, player explores to find trainer
				while(3 != intChoice){
					System.out.printf("[1]Look around%n[2]Go to trees%n[3]Go to cliffs%n");
				
					choice = input.next();
					intChoice = choiceChecker(choice);
					if(50 == intChoice){
						//nothing to do, diary or quit slected
					}
					if(1 == intChoice){
						System.out.printf("To your left you see a group of trees, the rain has no trouble getting through the canopy.%nTo your right is " +
											"a cave in the cliff that offers protection from the wind.%n");
						System.out.println("---------------------------------------------------");
					}
					else if(2 == intChoice){
						System.out.printf("You fight the wind to get to the trees only to be hit by leaves and debris.%n");
						System.out.println("---------------------------------------------------");
					}
				}
				if(3 == intChoice){
					System.out.printf("As you stagger into the cave, a soft glow comes from deep within. Well, what have you got to loose? Check it out.%n");
					System.out.println("---------------------------------------------------");
				}
				//talk to trainer
				TragedyOfGannon.swordTrainer.dialogue.speak(11, false);
				//fight Trainer
				combat(TragedyOfGannon.swordTrainer, TragedyOfGannon.swordTrainer.sword);
				
				//if gannon runs out of health
				if(TragedyOfGannon.gannon.getHealth() < 0){
					System.out.println("You are too weak to fight, go hunt for food.");
				}
				//if enemy runs out of health, move to hunting grounds
				this.newPosition = TragedyOfGannon.huntingGrounds;
				setNewPosition();
				TragedyOfGannon.swordTrainer.dialogue.speak(12, false);
			break;
			//hunting grounds
			case 12:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.huntingGrounds.getName() + ":%n");
				}
				System.out.printf("[1]Hunt Animals for food (increases health)%n[2]Go east to the forest%n[3]Go to capitol gates%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
					TragedyOfGannon.gannon.hunt(1);
				}
				else if(2 == intChoice){
					this.newPosition = this.currentPosition.moveEast();
				}
				else if(3 == intChoice){
					this.newPosition = this.currentPosition.moveSouth();
				}
				
				checkInterction();
				setNewPosition();
			break;
			//forest, talk to scruffy about hunting job
			case 13:
				
				if(firstInteraction){
					System.out.printf(TragedyOfGannon.longFleaForest.getName() + ":%nSitting on a sunny rock is a young scruffy cat sharpening his knife.%n");
				}
				System.out.printf("[1]Talk to the cat%n[2]hunt%n[3]Go west to the Hunting Grounds%n");
				choice = input.next();
				intChoice = choiceChecker(choice);
				if(50 == intChoice){
					//nothing to do, diary or quit slected
				}
				else if(1 == intChoice){
					TragedyOfGannon.scruffy.dialogue.speak(13, huntingJob);
					huntingJob = true;
				}
				else if(2 == intChoice){
					TragedyOfGannon.gannon.hunt(2);
				}
				else if(3 == intChoice){
					this.newPosition = this.currentPosition.moveWest();
				}
				
				checkInterction();
				setNewPosition();
			default:
				//System.out.println("Please enter a valid input");
				//getExitsActions();	
			break;
			
		}//end switch
		
		return mainQuest;	
	}//end getExitsActions
	
	
	public boolean endGame(){
		boolean gameOn = true;
		if(checkAllJobs()){
			//move to dungeon location
			this.currentPosition = TragedyOfGannon.dungeonFight;
			//talk to scruffy
			TragedyOfGannon.scruffy.dialogue.speak(14, allJobs);
			//fight scruffy
			combat(TragedyOfGannon.scruffy, TragedyOfGannon.swordTrainer.axe);
			//run away to dungeon
			if(TragedyOfGannon.scruffy.getHealth() <= 0){
				System.out.printf("Scruffy: You're making a mistake! We will come for you, and if we cannot defeat you we will train our children!%n Be warned!");
				gameOn = false;
			}
			else{
				System.out.printf("Scruffy is too powerful, you can't beat him. So you run into the forest, eventually losing his trail. It's time to set up " +
								"a base, this is not the end of Gannon cat....");
				gameOn = false;
			}
			
		}
		return gameOn;
	}
	public boolean checkAllJobs(){
		if(calicoJob && gangJob && zooldarsGuardJob && royalArmoryJob && huntingJob && mittensSecretaryJob && museumJob && stableJob && libraryJob){
			allJobs = true;
		}
		return allJobs;
	}
	
	//set position to new area
	public void setNewPosition(){
		this.currentPosition = this.newPosition;
	}
	
	
	
	//checks if choice is inventory or quit, parses integer, checks for bad string input
	public int choiceChecker(String choice){
		int intValue = 50;
		
		if(choice.equals("q")){
			this.mainQuest = false;
			intValue = 50;
		}
		else if(choice.equals("d")){
			boolean[] jobs = {calicoJob, gangJob, zooldarsGuardJob, royalArmoryJob, huntingJob, mittensSecretaryJob, museumJob, stableJob, libraryJob};
			TragedyOfGannon.gannon.diary.showDiary(jobs);
			this.newPosition = this.currentPosition;
			intValue = 50;
		}
					
		//check fo bad parsing
		else{
			try{
				intValue = Integer.parseInt(choice);
			}
			catch(NumberFormatException nfe){
				System.out.println("enter valid option");
			}
		}			
		return intValue;
	}
	
	
	//set firstinteraction variable to true or false
	public void checkInterction(){
		if(this.currentPosition != this.newPosition){
			firstInteraction = true;
		}
		else{
				firstInteraction = false;
		}
	}
	
	
	//take in enemy and weapon choice
	public void combat(Npc enemy, Weapon enemyWeapon){
		boolean validChoice = false;
		//create weapon and scanner
		Scanner input = new Scanner(System.in);
		Weapon weaponChoice = null;

		while((enemy.getHealth() > 0) && (TragedyOfGannon.gannon.getHealth() > 0)){
			
			System.out.printf("[1]Attack with your claws%n[2]Attack with sword%n[3]Attack with bow%n[4]Attack with axe%n");
			int intChoice = input.nextInt();
			
			while(!validChoice){
				
				if(1 == intChoice){
					weaponChoice = TragedyOfGannon.gannon.claws;
					validChoice = true;
				}
				else if(2 == intChoice){
					weaponChoice = TragedyOfGannon.gannon.sword;
					validChoice = true;
				}
				else if(3 == intChoice){
					weaponChoice = TragedyOfGannon.gannon.bow;
					validChoice = true;
				}
				else if(4 == intChoice){
					weaponChoice = TragedyOfGannon.gannon.axe;
					validChoice = true;
				}
				else{
					System.out.println("Enter a valid choice.");
					validChoice = false;
				}
			}
			TragedyOfGannon.gannon.attack(weaponChoice, enemy);
			//if enemy lives, attack
			if(enemy.getHealth() > 0){
				enemy.attack(enemyWeapon, TragedyOfGannon.gannon);
			}
		}
		
		if(enemy.getHealth() <= 0){
			System.out.println("You defeated " + enemy.getName() + ".");
		}
		else{
			System.out.println(enemy.getName() + " defeated you.");
		}
	}

}