package enemies;

public class Skeleton extends Enemy {

	public Skeleton(float modifier) {
		name = "Skeleton";
		
		maxHealth = (int) (20 * modifier);
		maxDamage = (int) (15 * modifier);
		
		health = getInitialHealth();
		armor = (int) (20 * modifier);
		speed = (int) (10 * modifier);
	}
	
}
