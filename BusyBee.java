

public class BusyBee extends HoneyBee {
	
	public BusyBee(Tile position) {
		super (position,2, 5);
		
		
	}

	@Override
	public boolean takeAction() {
		this.getPosition().storeFood(2);
		return true;
	}
	

}
