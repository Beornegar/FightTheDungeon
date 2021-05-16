package enemies;

import java.util.Random;

import game.Difficulty;

public abstract class Enemy {

	protected static Random random = new Random();

	protected int maxHealth;
	protected int maxDamage;

	protected int health;

	protected String name;
	protected int armor;
	protected int speed;

	public int getInitialHealth() {
		return random.nextInt(maxHealth);
	}
	
	public boolean isDefeated() {
		return health < 1;
	}

	public int takeDamage(int damage) {
		
		damage = calculateDamageTaken(damage);
		
		health -= damage;
		return health;
	}
	
	public int calculateDamageTaken(int damage) {
		return damage - armor > 0 ? damage - armor : 0;
	}
	
	public int attack() {
		return random.nextInt(maxDamage);
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getExperience(Difficulty difficulty) {
		
		int modifier = switch(difficulty) {
			case EASY -> 1;
			case MEDIUM -> 2;
			case HARD -> 3;
		};
		
		return (health + armor + maxDamage) * modifier;
	}

}
