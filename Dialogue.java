import java.util.Scanner;

public class Dialogue{
	
	private int choice;
	boolean isValid;
	
	public void speak(int roomID, boolean triedJob){
		Scanner input = new Scanner(System.in);
		
		choice = 0;
		isValid = false;
		//armory
		if(1 == roomID){
			if(!triedJob){
					System.out.printf("Warden: What? you want a job in the guard? Alright, if you can beat that guy over there you got the job." +
									"%nBrutus! come fight this guy.%n");
					System.out.printf("Brutus: Wha'? Tha' tiny runt? Hah, he won' last a secon'!%n");
			}
			else{
				System.out.printf("Warden: Hey, maybe you can protect the princess. Be careful though, she's... in a phase.%n");
			}
		}
		//general store
		if(2 == roomID){
			if(!triedJob){
				System.out.printf("Thug Boss: You want to be in my gang? You couldn't hurt a fly. Tell you what, defeat my strongest guy and you've got a chance.%n");
			}
			else{
				System.out.printf("Thug Boss: Get out of here kid! I can't have the town knowing a flea-ridden runt is beating my best boys!%n");
			}
		}
		if(3 == roomID){
			if(!triedJob){
				System.out.printf("Mittens: Hey, this isn't a charity case! Soup kitchen is that way scrawny!%nWhat, a job? For you? No way! I want a nice " +
								"secretary that will bring me food and ask about my day. You've got a mean look, maybe you should be a pirate.%n");
			}
			else{
				System.out.printf("Listen, I'm sorry you didn't get the job, but who's gonna take me seriously when my secretary looks like an orc?%n");
			}
		}
		//stables
		if(4 == roomID){
			if(!triedJob){
				System.out.printf("Stable Guy: You're looking for a stable job, huh? Well, alright. Let's see your resume.%nNo resume? Okay well do you have " +
									"any skills? The entry level position requires a degree in quantum mechanics and 40+ years experience with PHP.%n" +
									"I don't care how long the language has been out.%nYes I know computers don't exist.%nLook, it's 750 AD, if "+
									"You can't keep up with the times you don't get work. Simple.%n");
			}
			else{
				System.out.printf("Stable Guy: Come back with a degree kid, maybe I'll let you be an unpaid intern.%n");
			}
		}
		//bar
		if(6 == roomID){
			if(!triedJob){
				System.out.printf("Calico: One spot left on the ship. It's between you and that recruit over there. Who can offer me the best labor?%n");
			}
			else{
				System.out.printf("Calico: You'll understand one day. There are 3 sacred things in this world: Booze, Cash Moneys, and a good fish taco.%n");
			}
		}
		//museum
		if(7 == roomID){
			if(!triedJob){
				System.out.printf("Belinda: Hiring? Not now, I work here for my dad while I study. Oh, but if you come back in a few years when I own the place, " +
								"I'll be sure to hire you!%n");
			}
			else{
				System.out.printf("Belinda: Good luck searching%n!");
			}
		}
		if(8 == roomID){
			if(!triedJob){
				System.out.printf("Librarian: Unfortunately we can't afford any staff, my wife is expecting and we need to save money.%nDo you think you could " +
								"convince her of a different name? Peter sounds nice. Well, anything but her current options sounds nice.%n");
			}
			else{
				System.out.printf("Try reading a book to ease your mind%n.");
			}
		}
		if(10 == roomID){
			if(!triedJob){
				System.out.printf("Princess Zooldar: What?? Do I look like I need protection? Get out of here!%n");
			}
			else{
				System.out.printf("Princess Zooldar: If you don't leave me alone, you'll be the new target dummy!%n");
			}
		}
		//Kitten Cove trainer, intro to story
		if(11 == roomID){
			while(!isValid){
				System.out.printf("Sword Trainer:%nHey! Why are you in my cave? You look like a catfish and you've got fleas!%n"+
									"You try to respond, but your body betrays you.%n%n When you open your eyes the sun is shining and" +
									"the smell of fresh steamed fish hits you like a train.%nThe Sword Trainer is holding a piece out to you.");
				System.out.printf("Ship wrecked at sea eh? Well with no parents, no Cash Moneys, and all those fleas you better get a skilled job%n" +
									"What is your speacialty?%n[1]I can cook%n[2]I can fight%n[3]I can program%n");
				choice = input.nextInt();
				if(1 == choice){
					System.out.printf("Cook? well I suppose that's alright. We better teach you some proper hunting skills then. Grab a sword.%n");
					isValid = true;
				}
				else if(2 == choice){
					System.out.printf("That's my boy! Show me what you've got!%n");
					isValid = true;
				}
				else if(3 == choice){
					System.out.printf("Uh, what? You know it's the middle ages right? Like there are no computers.... Okay, you'll be a warrior instead now.%n");
					isValid = true;
				}
				else{
					System.out.println("Enter a valid choice");
					isValid = false;
				}
			}//end validation
			System.out.println("Sword Trainer: Off to the training grounds.");
		}
		//hunting gorund trainer, lets player move freely
		if(12 == roomID){
			System.out.printf("Sword Trainer: You might not be a lost cause, go look for a job. You're going to need money to get rid of those fleas. I can't help you anymore, but "+
								"you can keep those weapons for your battles. Good luck.%n");
		}
		//forest
		if(13 == roomID){
			if(!triedJob){
				System.out.printf("Scruffy: You want a hunting job huh? Well sorry kid, no business here. I'm just looking for dinner.%n");
			}
			else{
				System.out.printf("Scruffy: I will tell you this, the animals in the forest are much better to hunt. The ones in the town's hunting grounds " +
								"are scrawny from over hunting. Too many people are afraid of the fleas to hunt here. Looks like you've already got your share, though.%n");
			}
		}
		//dungeon/end game
		if(14 == roomID){
			System.out.printf("In a fit of furious itching you decide you can no longer go on with these fleas. You just wanted a job to buy Frontline Advantage.%n" +
							"If you have to deal with fleas, everyone else should too.%n in the middle of the night you steal all of the medication from Zooldar's castle, " +
							"and ride off into the night on a stolen donkey. You decide to set up base past Long Flea Forest, where no townscat dare to go.%n");
			System.out.printf("Scruffy: Hey! Where do you think you're going? You can't steal from others just because you aren't in a good situation. I won't let " +
							"you steal that Frontline!%n");							
		}
		
		
	}//end method
	
}//end class