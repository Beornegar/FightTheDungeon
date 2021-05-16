package display;

import consumables.HealthPotion;
import enemies.Enemy;
import player.Player;

public class ConsoleDisplay implements GameActions {

	@Override
	public void welcomeAction() {
		System.out.println("Welcome to the Dungeon");
	}

	@Override
	public void enemyAppearedAction(Enemy enemy) {
		System.out.println("\t# " + enemy.getName() + " appeared! #\n");
	}

	@Override
	public void playerDefeatedAction(Player player, Enemy enemy) {
		System.out.println("You limp out of the dungeon, weak from battle.");
	}

	@Override
	public void enemyDefeatedAction(Player player, Enemy enemy) {
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println(" # " + enemy.getName() + " was defeated! # ");
		System.out.println(" # You have " + getHealthString(player) + " left. #");
	}

	@Override
	public void healthPotionFoundAction(Player player,Enemy enemy, HealthPotion potion) {
		System.out.println(" # The" + enemy.getName() + " dropped a health potion! #");
		System.out.println(" # You have " + player.getHealthPotions().size() + " health potion(s). #");
		System.out.println();
	}

	@Override
	public void afterFightActions(Player player) {
		System.out.println("------------------------------------------------------");
		System.out.println("What would you like to do now?");
		System.out.println("1. Continue fighting");
		System.out.println("2. Exit dungeon\n");
	}

	@Override
	public void invalidInputAction() {
		System.out.println("\tInvalid command!");
	}

	@Override
	public void nextFightAction(Player player, Enemy enemy) {
		System.out.println("You contine on your adventure.");
	}

	@Override
	public void exitDungeonAction() {
		System.out.println("You exit the dungeon, sucessful from your adventures!");
	}

	@Override
	public void attackEnemyAction(Player player, Enemy enemy, int damage) {
		int damageDone = enemy.calculateDamageTaken(damage);
		System.out.println("\t> You strike the " + enemy.getName() + " for " + damage + " Damage!");
		System.out.println("\t> He blocked " + enemy.getArmor() + " Damage and receives " + damageDone + " Damage!");
	}

	@Override
	public void enemyAttackAction(Player player, Enemy enemy, int damage) {
		
		System.out.println("\t> The " + enemy.getName() + " attacks you for " + damage + " Damage!");
	}

	@Override
	public void damageTakenAction(Player player, int damage) {
		int damageTaken = player.calculateDamageTaken(damage);
		System.out.println("\t> You blocked " + player.getArmor() + " Damage and receive " + damageTaken + " Damage!\n");
	}

	@Override
	public void gameEndAction() {
		System.out.println("#######################");
		System.out.println("# Thanks for playing #");
		System.out.println("#######################");
	}

	@Override
	public void startNewDungeonRoomAction() {
		System.out.println("------------------------------------------------------");
	}

	@Override
	public void runAwayAction(Player player, Enemy enemy) {
		System.out.println("\tYou run away from the " + enemy.getName() + " !");
	}

	@Override
	public void leaveDungeonRoomAction() {
		System.out.println("You contine on your adventure.");
	}

	@Override
	public void fightOptionsAction(Player player, Enemy enemy) {
		System.out.println("\tHP: " + getHealthString(player));
		System.out.println("\t" + enemy.getName() + "'s HP:" + enemy.getHealth());
		System.out.println("\t Health potions: " + player.getHealthPotions().size());
		System.out.println("\n\tWhat would you like to do?");
		System.out.println("\t1. Attack");
		System.out.println("\t2. Drink health potion");
		System.out.println("\t3. Run!");
	}

	@Override
	public void takeHealthPotionAction(Player player, HealthPotion potion) {
		
		System.out.println("\t> You drink a health potion, healing yourself for " + potion.getHealAmount() + "."
				+ "\n\t You now have " + getHealthString(player) + "\n\t You have " + (player.getHealthPotions())
				+ " health potions left.");
	}

	@Override
	public void noHealthPotionsLeftAction(Player player) {
		System.out.println("\t> You have no health potions left. Defeat enemies for a chance to get one!");
	}

	@Override
	public void selectGameDifficultyAction() {
		System.out.println("\n\tPlease select a difficulty.");
		System.out.println("\t1. Easy");
		System.out.println("\t2. Medium");
		System.out.println("\t3. Hard");
	}

	@Override
	public void playerReceivedExperienceAction(Player player, int experience) {
		
		System.out.println("------------------------------------------------------");
		System.out.println("\tYou received " + experience + " Experience!");
		
	}

	@Override
	public void playerLevelUpAction(Player player) {
		System.out.println("\tYou leveled up!");
		displayPlayerStats(player);
	}

	private String getHealthString(Player player) {
		return "HP: " + player.getHealth() + "/" + player.getMaxHealth() + " HP";
	}
	
	private void displayPlayerStats(Player player) {
		System.out.println("\t" + getHealthString(player));
		System.out.println("\tArmor: " + player.getArmor());
		System.out.println("\tSpeed: " + player.getSpeed());
		System.out.println("\tMax. Damage: " + player.getMaxDamage());
		System.out.println("\tExperience: " + player.getExperience() + "/" + player.getExperienceToNextLevel());
	}
	
}
