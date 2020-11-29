

public class TankyBee extends HoneyBee{
	private int attackDamage;
	private int armor;
	
	public TankyBee( Tile position,int attackDamage, int armor) {
		super(position,3, 30);
		this.attackDamage = attackDamage;
		this.armor = armor;
	}

	@Override
	public boolean takeAction() {
		if(getPosition().getNumOfHornets() > 0) {
			getPosition().getHornet().takeDamage(attackDamage);
			return true;
		}
		return false;
	}
	public void takeDamage(int damage) {
		super.takeDamage((int) Math.floor(damage*(100.0/(100.0+armor))));
	}
	public boolean equals(Object object) {
		if (!(object instanceof TankyBee)) {
			return false;
			
		}
		HoneyBee honeybee = (HoneyBee) object;
		if ( super.equals(honeybee)) {
			TankyBee tb = (TankyBee) object;
			if (this.attackDamage == tb.attackDamage && this.armor == tb.armor) {
				return true;
				
			}
			
		}return false;
	
	}
}
