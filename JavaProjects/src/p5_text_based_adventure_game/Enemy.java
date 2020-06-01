package p5_text_based_adventure_game;

import java.util.Random;

public class Enemy {
	//Monsters: skeleton, zombie, warrior, assassin
	//all have hp and attack
	
	private int hp;
	private int attack;
	private String type;
	private String[] enemyTypes = {"Skeleton", "Zombie", "Warrior", "Assassin"};
	Random r = new Random();
	
	public Enemy() {
		int t = r.nextInt(4);
		this.type = this.enemyTypes[t];
		
		int h = r.nextInt(100);
		this.hp = h;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public String getType() {
		return this.type;
	}

	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public void randomAttack() {
		this.attack = r.nextInt(100);
	}

	public void attack(Hero h) {
		randomAttack();
		h.setHP(h.getHP() - this.attack);
		
		System.out.println("> The " + this.type + " did " + this.attack + " damage!");
		
		
		if(h.getHP() <= 0) {
			h.gameOver();
			System.exit(0);
		}
		else {
			//System.out.println("> The player now has " + h.getHP() + " HP.");
		}
	}
	
}
