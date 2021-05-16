package display;

import consumables.HealthPotion;
import enemies.Enemy;
import player.Player;

public interface GameActions {

	public void welcomeAction();
	
	public void selectGameDifficultyAction();
	
	public void playerReceivedExperienceAction(Player player, int experience);
	
	public void playerLevelUpAction(Player player);
	
	public void fightOptionsAction(Player player, Enemy enemy);
	
	public void startNewDungeonRoomAction();
	
	public void enemyAppearedAction(Enemy enemy);
	
	public void playerDefeatedAction(Player player, Enemy enemy);
	
	public void enemyDefeatedAction(Player player, Enemy enemy);
	
	public void runAwayAction(Player player, Enemy enemy);
	
	public void takeHealthPotionAction(Player player, HealthPotion potion);
	
	public void noHealthPotionsLeftAction(Player player);
	
	public void healthPotionFoundAction(Player player, Enemy enemy, HealthPotion potion);
	
	public void afterFightActions(Player player);
	
	public void invalidInputAction();
	
	public void nextFightAction(Player player, Enemy enemy);
	
	public void exitDungeonAction();
	
	public void leaveDungeonRoomAction();
	
	public void attackEnemyAction(Player player, Enemy enemy, int damage);
	
	public void enemyAttackAction(Player player, Enemy enemy, int damage);
	
	public void damageTakenAction(Player player, int damage);
	
	public void gameEndAction();
	
	
	
}
