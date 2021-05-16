package player;

import java.util.List;
import java.util.Random;

import consumables.HealthPotion;
import game.Difficulty;

public class Player {

	private static final Random RANDOM = new Random();

	private int maxHealth;
	private int health;
	
	private int armor;
	private int speed;
	private int maxDamage;
	
	private int level = 1;
	
	private int experience = 0;
	private int experienceToNextLevel = 100;

	public Player(int health, int armor, int speed, int maxDamage, List<HealthPotion> healthPotions) {
		this.maxHealth = health;
		this.health = health;
		this.armor = armor;
		this.speed = speed;
		this.maxDamage = maxDamage;
		this.healthPotions = healthPotions;
	}
	
	public void receiveExperience(Difficulty difficulty, int gainedExperience) {
		
		int pooledExceperience = experience + gainedExperience;
		
		while(pooledExceperience > experienceToNextLevel) {
			pooledExceperience -= experienceToNextLevel;
			level++;
			maxHealth += difficulty == Difficulty.EASY ? (maxHealth + 30) : difficulty == Difficulty.MEDIUM ? (maxHealth + 20) : (maxHealth + 10);
			health = maxHealth;
			armor += difficulty == Difficulty.EASY ? (armor + 3) : difficulty == Difficulty.MEDIUM ? (armor + 2) : (armor + 1);
			speed += difficulty == Difficulty.EASY ? (speed + 5) : difficulty == Difficulty.MEDIUM ? (speed + 3) : (speed + 2);
			maxDamage += difficulty == Difficulty.EASY ? (maxDamage + 15) : difficulty == Difficulty.MEDIUM ? (maxDamage + 10) : (maxDamage + 5);
			experienceToNextLevel += experienceToNextLevel;
		}
		
		experience = pooledExceperience;		
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public int getLevel() {
		return level;
	}

	public int getExperience() {
		return experience;
	}
	
	public int getExperienceToNextLevel() {
		return experienceToNextLevel;
	}

	public int attack() {
		return RANDOM.nextInt(maxDamage);
	}

	public int takeDamage(int damage) {

		damage = calculateDamageTaken(damage);

		health -= damage;
		return health;
	}

	public int calculateDamageTaken(int damage) {
		return damage - armor > 0 ? damage - armor : 0;
	}


	public int heal(int healAmount) {
		
		health = health + healAmount > maxHealth ? maxHealth : health + healAmount;
		return health;
	}

	public boolean isDefeated() {
		return health < 1;
	}

	private List<HealthPotion> healthPotions;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public List<HealthPotion> getHealthPotions() {
		return healthPotions;
	}

	public void setHealthPotions(List<HealthPotion> numberofHealthPotions) {
		this.healthPotions = numberofHealthPotions;
	}

}
