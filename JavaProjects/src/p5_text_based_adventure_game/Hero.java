package p5_text_based_adventure_game;

import java.util.Random;

public class Hero {

	//Hero has hp, attack, has 3 potions, and can run
	
	private int hp;
	private int attack;
	private int potions;
	private int ran;
	private String name;
	Random r = new Random();
	
	public Hero(String name) {
		this.name = name;
		this.hp = 100;
		this.potions = 3;
		this.attack = 50;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPotions() {
		return this.potions;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public boolean runAway() {
		this.ran = r.nextInt(3);
		
		if(ran == 0)
			return false;
		
		else
			return true;
	}
	
	public void usePotion() {
		if(this.potions == 0) {
			System.out.println("> You have no more potions.");
		}
		else {
			this.hp += 50;
			this.potions--;
			System.out.println("> You healed and now have " + this.hp + " HP. You have " + this.potions + " potions left.");
		}
		
	}

	public void attack(Enemy e) {
		//enemy loses HP
		e.setHP(e.getHP() - 50);
		
		System.out.println("> You did " + this.attack + " damage!");
		
		//change attack
		
		if(e.getHP() <= 0) {
			enemyDefeated(e);
		}
		else {
			//System.out.println("> The " + e.getType() + " now has " + e.getHP() + " HP.");
		}
	}
	
	public void enemyDefeated(Enemy e) {
		if(r.nextInt(100) < 50) {
			System.out.println("> The " + e.getType() + " dropped a  potion! ");
			this.potions++;
		}
		
		if(e.getHP() <= 0) {
			System.out.println("> The " + e.getType() + " lost all its health and has been defeated!");
			
			
		}
	}
	
	public void gameOver() {
		System.out.println("Oh no! You ran out of HP. GAME OVER !!!");
	}
	
}
