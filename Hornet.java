

public class Hornet extends Insect{
	private int attackDamage;
	
	public Hornet( Tile position, int health, int attackDamage) {
		super (position, health);
		this.attackDamage = attackDamage;
		
	}

	@Override
	public boolean takeAction() {
		
		if (getPosition().isHive() && getPosition().getBee()!= null) {
			getPosition().getBee().takeDamage(attackDamage);
			
		return true;
		}
			
		else { 
			if( !getPosition().isHive()) {
				this.getPosition().removeInsect(this);
				this.setPosition(getPosition().towardTheHive());
				getPosition().towardTheHive().addInsect(this);	
			}
			
	
		}
		if ( getPosition() == null) {
			return false;
		}
		return false;
	}
	
	public boolean equals(Object object) {
		if(!(object instanceof Hornet)) {
			return false;
			
			
		}
		Insect insect = (Insect) object;
		if ( super.equals(insect)) {
			Hornet hornet = (Hornet) object;
			if (this.attackDamage == hornet.attackDamage) {
				return true;
			}
		}
		return false;
	}
	
}
