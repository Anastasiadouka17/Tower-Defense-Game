

public abstract class Insect {

	private Tile position;
	private int health;
	
	public Insect(Tile position, int health) {
		if (this instanceof HoneyBee) {
			if (position.getBee() != null){
				throw new IllegalArgumentException();
				
			}
			if (position.isNest()) {
				throw new IllegalArgumentException();
				
			}
		
		}
		else {
			if(this instanceof Hornet) {
				if(! position.isHive() && !position.isNest() && !position.isOnThePath()) {
					throw new IllegalArgumentException();
				}
			}
		}
		this.position = position;
		
		this.health = health;
		
		this.position.addInsect(this);
		
		
	
		
	}
	public final Tile getPosition() {
		return position;
		
	}
	public final int getHealth() {
		return health;
	}
	public void setPosition(Tile position) {
		this.position = position;
	}

	public void takeDamage(int damage) {
		if (position.isHive() && this.equals(position.getBee())) {
			damage = (int) (damage - (0.1 *damage));
			this.health  = this.health - damage;
		}
		else {
			this.health = this.health - damage;
		}
		if (this.health <= 0) {
			this.position.removeInsect(this);
		}
	}
	
	
	public abstract boolean takeAction();
	
	public boolean equals(Object object) {
		if (!(object instanceof Insect)) {
			return false;
		}
		Insect obj = (Insect) object;
		if (obj.health == this.health && obj.position == this.position ) {
			if (this instanceof TankyBee && object instanceof TankyBee) {
				return true;
				
			}
			if(this instanceof BusyBee && object instanceof BusyBee) {
				return true;
				
			}
			if(this instanceof StingyBee && object instanceof StingyBee) {
				return true;
			
			}
			if(this instanceof Hornet && object instanceof Hornet) {
				return true;
				
			}
			
			
		} return false;
		
	}
	
}

