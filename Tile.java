

public class Tile {
	private int food;
	private boolean fullbeehive;
	private boolean fullnest;
	private boolean path;
	private Tile nexttobeehive;
	private Tile nexttonest;
	private HoneyBee honeybee;
	private SwarmOfHornets swarmofhornets;
	
	public Tile () {
		this.food = 0;
		this.fullbeehive = false;
		this.nexttobeehive = null;
		this.path = false;
		this.nexttobeehive = null;
		this.fullnest = false;
		this.honeybee = null;
		this.swarmofhornets = new SwarmOfHornets();
		
	}
	
	
	public Tile(int food, boolean fullbeehive, boolean fullnest, boolean path, Tile nexttobeehive, Tile nexttonest,
			HoneyBee honeybee, SwarmOfHornets swarmofhornets) {
		this.food = food;
		this.fullbeehive = fullbeehive;
		this.fullnest = fullnest;
		this.path = path;
		this.nexttobeehive = nexttobeehive;
		this.nexttonest = nexttonest;
		this.honeybee = honeybee;
		this.swarmofhornets = swarmofhornets;
	}
	
	public boolean isHive() {
		
		return fullbeehive;
		
	}
	public boolean isNest() {
		return fullnest;
		
	}
	public void buildHive() {
		this.fullbeehive = true;
	}
	public void buildNest() {
		this.fullnest = true;
		
	}
	public boolean isOnThePath() {
		return path;
		
	}
	public Tile towardTheHive() {
		if ( this.path == true) {
			return nexttobeehive;
		}
		else {
			return null;
		}
	}
	public Tile towardTheNest() {
		if(this.path) {
			return nexttonest;
		}
		else return null;
	}
	public void createPath(Tile nexttobeehive , Tile nexttonest) {
		this.nexttobeehive = nexttobeehive;
		this.nexttonest = nexttonest;
		this.path = true;
		
	}
	public int collectFood() {
		int temp = food;
		 food = 0;
		 return temp;
		 
		
	}
	public void storeFood(int food) {
		this.food += food;
		
		
	}
	public HoneyBee getBee() {
		return honeybee;
		
	}
	public Hornet getHornet() {
		return swarmofhornets.getFirstHornet();
		
		
	}
	public int getNumOfHornets() {
		//if ( swarmofhornets == null) {
			//return 0;
		//}
		return swarmofhornets.sizeOfSwarm();
	}
	public boolean addInsect(Insect insect) {
		if(insect instanceof HoneyBee && this.honeybee == null && this.fullnest == false) {
			//if(((HoneyBee)insect ).getCost() <= this.food){
			//	this.food = this.food - ((HoneyBee)insect ).getCost();
				this.honeybee = (HoneyBee)insect;
				
				insect.setPosition(this);
				return true;	
			//}
			
			
		}else  if(insect instanceof Hornet && (this.isHive()|| this.isNest() || this.isOnThePath())){
			this.swarmofhornets.addHornet((Hornet) insect);
			insect.setPosition(this);
			//this.fullnest = true;//TODO
			
			return true;
			
			
		}
		return false;
	}
	public boolean removeInsect(Insect insect) {
		if(insect instanceof HoneyBee) {
			//if(this.fullbeehive) {
				if(insect == this.honeybee) {
//					this.fullbeehive = false;
					this.honeybee = null;
					return true;
				}
//			}
		}
		if (insect instanceof Hornet) {
//			if(this.fullnest) { //TODO 
				return swarmofhornets.removeHornet((Hornet)insect);
	//		}
			
		}
		return false;
	}
}
