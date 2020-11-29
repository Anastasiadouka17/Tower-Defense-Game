

public abstract class HoneyBee extends Insect {
	private int cost;
	public HoneyBee(Tile position,int cost, int health) {
		super(position, health);
		this.cost = cost;
		
	}
	public int getCost() {
		return cost;
	}
	
	public boolean equals (Object object) {
		if (!(object instanceof HoneyBee)) {
			return false;
			
		}
		Insect insect = (Insect) object;
		if ( super.equals(insect)) {
			HoneyBee h = (HoneyBee) object;
			if (this.cost == h.cost) {
				return true;
			}
		}return false;
	}
}
