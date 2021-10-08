public abstract class Character{
	
	private String name;
	private int health;
	private int strength;

	Weapon claws;
	Weapon sword;
	Weapon bow;
	Weapon axe;

	Dialogue dialogue;
	
	
	public Character(String name, int health, int strength){
		//set values
		this.name = name;
		this.health = health;
		this.strength = strength;
		
		//new dialogue
		dialogue = new Dialogue();
		
		//all weapons
		claws = new Weapon("claws,", 10, 0);
		sword = new Weapon("sword", 20, 10);
		bow = new Weapon("bow", 25, 0);
		axe = new Weapon("axe", 30, 20);
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public void setStrength(int strength){
		this.strength = strength;
	}
	
	
	//getters
	public String getName(){
		return this.name;
	}
	public int getHealth(){
		return this.health;
	}
	public int getStrength(){
		return this.strength;
	}
	
	public void attack(Weapon weapon, Character target){
		int damageDone = this.strength + weapon.getDamage();
		System.out.println("---------------------------------------------------");
		takeDamage(target, damageDone);
	}
	//take damage from fight
	public void takeDamage(Character target, int damage){
		target.health -= damage;
		if(target.health > 0){
			System.out.println(target.name +" took " + damage + " damage, and now has " + target.getHealth() + " health.");
		}
		else{
			System.out.println(target.name + " has no more health");
		}
	}
	
}