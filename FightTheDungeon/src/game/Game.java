package game;

import java.util.Random;

import consumables.HealthPotion;
import display.GameActions;
import enemies.Enemy;
import enemies.EnemyFactory;
import player.Player;
import player.PlayerFactory;
import userInput.UserAfterFightInputTypes;
import userInput.UserFightInputTypes;
import userInput.UserInput;

public class Game {

	private static final Random RAND = new Random();
	
	private GameActions displayActions;
	private UserInput userInput;
	
	private Player player;
	private Enemy enemy;
	
	private Difficulty difficulty;
	private int numberOfDefeatedEnemies = 0;
	
	private boolean gameActive = true;
	
	public Game(GameActions displayActions, UserInput userInput) {
		this.displayActions = displayActions;
		this.userInput = userInput;
	}
	
	public void run() {
		
		displayActions.welcomeAction();
		
		displayActions.selectGameDifficultyAction();
		difficulty = userInput.getGameDifficulty();

		player = PlayerFactory.getPlayerBasedOnDifficulty(difficulty);
		
		while (gameActive) {
			displayActions.startNewDungeonRoomAction();

			createEnemy();

			fightEnemy();

			handleAfterFightActions();
		}

		displayActions.gameEndAction();
	}
	
	private void createEnemy() {
		enemy = EnemyFactory.getRandomEnemy(difficulty, numberOfDefeatedEnemies);
		displayActions.enemyAppearedAction(enemy);
	}
	
	private void fightEnemy() {
		boolean keepFighting = true;
		while (keepFighting && !enemy.isDefeated() && !player.isDefeated()) {
			displayActions.fightOptionsAction(player, enemy);

			UserFightInputTypes userAction = userInput.getFightInput();

			switch (userAction) {
			case FIGHT:
				processCombatRound();
				break;
			case TAKE_HEALTH_POTION:
				takeHealthPotion();
				break;
			case RUN:
				displayActions.runAwayAction(player, enemy);
				keepFighting = false;
				break;
			}

		}
	}

	private void handleAfterFightActions() {

		if(enemy.getHealth() > 0) {
			return;
		}
		
		displayActions.enemyDefeatedAction(player, enemy);

		receiveExperience();
		
		findLoot();

		displayActions.afterFightActions(player);

		UserAfterFightInputTypes userAction = userInput.getAfterFightInput();

		switch (userAction) {
		case NEXT_ROOM:
			displayActions.leaveDungeonRoomAction();
			break;
		case EXIT_DUNGEON:
			displayActions.exitDungeonAction();
			gameActive = false;
		}

	}

	private void receiveExperience() {
		
		int experience = enemy.getExperience(difficulty);
		displayActions.playerReceivedExperienceAction(player, experience);
		
		int level = player.getLevel();
		player.receiveExperience(difficulty, experience);
		
		if(level < player.getLevel()) {
			displayActions.playerLevelUpAction(player);
		}
		
	}

	private void findLoot() {
		if (RAND.nextInt(100) < HealthPotion.DROP_CHANCE) {
			HealthPotion potion = new HealthPotion();
			player.getHealthPotions().add(potion);
			displayActions.healthPotionFoundAction(player, enemy, potion);
		}
	}
	
	private void processCombatRound() {

		if (player.getSpeed() > enemy.getSpeed()) {
			int damageDealt = player.attack();
			enemy.takeDamage(damageDealt);
			
			displayActions.attackEnemyAction(player, enemy, damageDealt);

			if (enemy.getHealth() > 0) {
				int damageTaken = enemy.attack();
				player.takeDamage(damageTaken);
				
				displayActions.enemyAttackAction(player, enemy, damageTaken);
				displayActions.damageTakenAction(player, damageTaken);
			}
		} else {
			int damageTaken = enemy.attack();
			player.takeDamage(damageTaken);
			
			displayActions.enemyAttackAction(player, enemy, damageTaken);
			displayActions.damageTakenAction(player, damageTaken);

			if (player.getHealth() > 0) {
				int damageDealt = player.attack();
				enemy.takeDamage(damageDealt);
				
				displayActions.attackEnemyAction(player, enemy, damageDealt);
			}
		}

		if (player.isDefeated()) {
			displayActions.playerDefeatedAction(player, enemy);
			gameActive = false;
		}
	}
	
	private void takeHealthPotion() {
		int amountOfHealthPotions = player.getHealthPotions().size();
		if (amountOfHealthPotions > 0) {
			HealthPotion potion = player.getHealthPotions().remove(amountOfHealthPotions - 1);
			player.heal(potion.getHealAmount());

			displayActions.takeHealthPotionAction(player, potion);
			
		} else {
			displayActions.noHealthPotionsLeftAction(player);
		}
	}
	
}
