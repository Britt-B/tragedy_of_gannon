# Tragedy of Gannon
***
## Task
This is the second part of the intro to Java final project. It is a sequel to Legend of Cat. The changes were made to optimize the program (less intermediate function calls, restructuring of classes).
***
## Criteria
* Game must be Java based
* Create "Room" objects that the player can navigate
* Include some form of comabt
* Fabricate a story or theme
***
## Summary
This game summarizes course work on object-oriented programming, including inheritance and polymorphism. The story explains the events before Legend of Cat takes place.
***
## Functionality
The interface is similar to the previous game. The user selects numbers correlating to their desired action, "d" for diary, and "q" to quit. Story progression is more linear in this game, but combat is greatly enhanced.
***
## Design
A lot of code was reused, but you will notice it is also condensed and divided into several other classes. My original issue was trying to restructure everything so many times, variables become duplicates or useless. So I scrapped the first game down to it's guts (methods) and strted pushing things into new classes. I wasn't trying to preserve any dialogue or items, so I was able to give the game a  more flexible structure. My goal this time was to reduce the Actions class to switch statements and methods. Some of the repetative actions were changed to methods as well.For exmple, choiceCheker() will take each input and check if [d]iary or [q]uit was entered. If neither, it will try to parse the string into an integer. If this does not work (in the case of the user entering some other letter or decimal), the method makes use of try/catch NumberFormatException.

New classes:
	Character:
		This is the super class for both Npc and Gannon. It contains all of the variables(health, name, etc...), and methods(attack, takeDamage, etc...) shared by the subclasses. It also contains all weapon objects the characters use.
	Gannon (formerly Hero):
		Gannon has a method to hunt and gain health. Hunting in the forest yields higher rewards. The max health allowed is 250 to keep the final fight balanced.
		
	Room: 
		Not much changed here, but a room has-an Npc character object (or two).
	
	Dialogue: 
		Each character has-a dialogue with a speak method, which varies depending on the room they are in. This takes a lot of clutter away from the actions class.
		
	This version is a lot shorter than Legend of Cat, but I belive it is more structured and easier to follow. Also, I didn't have as much time to write in a complex story. I'm sure there are bugs somewhere but I'm out of time to try and break this game anymore, so just spray Raid on your computer and hope for the best.
***
## Run Locally
* On a machine with JDK, open the terminal in the file location with TragedyOfGannon.java
* javac TragedyOfGannon.java
* java TragedyOfGannon
