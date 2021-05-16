package enemies;

public class Assassin extends Enemy {

	public Assassin(float modifier) {
		name = "Assassin";

		maxHealth = (int) (30 * modifier);
		maxDamage = (int) (30 * modifier);

		health = getInitialHealth();
		armor = (int) (5 * modifier);
		speed = (int) (50 * modifier);
	}
	
}
