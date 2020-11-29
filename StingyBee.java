

public class StingyBee extends HoneyBee{
	private int attackDamage;
	public StingyBee( Tile position,int attackDamage) {
		super( position,1, 10);
		this.attackDamage = attackDamage;
	}
	@Override
	public boolean takeAction() {
		if(!getPosition().isHive() && !getPosition().isOnThePath()) {
			return false;
			
		}
		else {
			int numhornets = getPosition().getNumOfHornets();
			Tile currentile = getPosition();
			while(numhornets == 0 && !currentile.isNest()) {
				currentile = getPosition().towardTheNest();
				numhornets = currentile.getNumOfHornets();
				
			}
			if (!currentile.isNest() ) {
				currentile.getHornet().takeDamage(attackDamage);
				return true;
			}
		}
		return false;
	}
	public boolean equals(Object object) {
		if (!(object instanceof StingyBee)) {
			return false;
			
		}
		HoneyBee honeybee = (HoneyBee) object;
		if ( super.equals(honeybee)) {
			StingyBee sb = (StingyBee) object;
			if (this.attackDamage == sb.attackDamage) {
				return true;
			}
		}return false;
	
	}
}
