package consumables;

import java.util.Random;

public class HealthPotion {

	private static final Random RANDOM = new Random();
	private static final int MAX_HEAL_AMOUNT = 50;
	
	public static final int DROP_CHANCE = 50;
	
	private int healAmount;
	
	public HealthPotion() {
		healAmount = RANDOM.nextInt(MAX_HEAL_AMOUNT);
	}
	
	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
}
