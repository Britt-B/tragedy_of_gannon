import java.util.ArrayList;
import java.util.List;

public class Diary{
	//name of item
	private List<String> currentInteractions;
	private boolean[] jobOffers;
	
	public Diary(){
		currentInteractions = new ArrayList<>(List.of("-Join Calico's pirate crew", "-Become a gang member", "-Protect Princess Zooldar", "-Enlist in the royal guard",
		"-Be a hunter/fur trader", "-Secretary of the mayor", "-Museum staff", "-Stable Hand", "-Librarian"));
	}
	
	//show items
	public void showDiary(boolean[] jobs){
		this.jobOffers = jobs;
		String gannonsMood = (checkMood());
		
		
		//prints formatted inventory (easier to read)
		System.out.println("\u001b[34m\u001b[47m*************************\u001B[0m");
		System.out.println(gannonsMood);
		System.out.printf("Possible Jobs:%n");
		
		for(int i =0; i < jobOffers.length; i++){
			if(!jobOffers[i]){
				System.out.println(currentInteractions.get(i));
			}
		}
		System.out.println("\u001b[34m\u001b[47m*************************\u001B[0m");
		
	}
	
	public String checkMood(){
		int totalInteractions = 0;
		String mood = "";
		
		for(int i = 0; i < jobOffers.length; i++){
			if(jobOffers[i]){
				totalInteractions++;
			}
		}
		//has 2 or less interactions, not to mad
		if(totalInteractions <= 2){
			mood = "Dear diary, I need a job soon. These darn fleas are itchy, I can't bear it.";
		}
		//has 3-5 interactions, ticked off
		else if(totalInteractions >= 3 && totalInteractions <= 5){ 
			mood = "Dear diary, these cats are exasperating. I only seek a simplecat's work. My search continues.";
		}
		//has 5 or more interactios, going psycho
		else{
			mood = "Dear diary, I have reached my limits. The catfolk of this land are maddening. I will not tolerate them much longer.";
		}
		return mood;
		
	}
}
