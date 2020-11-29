

public class SwarmOfHornets {
	private Hornet hornets[];
	private int size;
	public SwarmOfHornets() {
		size = 0;
		
		hornets = new Hornet[10];
		
	}
	public int sizeOfSwarm() {
		return size;
	}
	
	public Hornet[] getHornets() {
		Hornet newhornets[];
		newhornets = new Hornet[size];
		for(int i=0; i< size; i++) {
			newhornets[i] = hornets[i];
			
		}
		return newhornets;
			
			
		
		
	}
	public Hornet getFirstHornet() {
		if (size == 0) {
			return null;
			
		} else {
		return hornets[0];
		}	
	}
	public void addHornet(Hornet hornet) {
		if (size < hornets.length) {
			hornets[size] = hornet;
			size++;
			
		}else {
			Hornet newhornets[] = new Hornet[size*2];
			for (int i=0; i<size; i++) {
				newhornets[i] = hornets[i];
				
			}
			newhornets[size] = hornet;
			hornets = newhornets;
			size ++;
			
		}
		
		
		
		
	}
	public boolean removeHornet(Hornet hornet) {
		for( int i =0 ; i<size ; i++) {
			if(hornet == hornets[i]) {
				for( int k= i; k<size-1; k++) {
					hornets[k] = hornets[k+1];
					
					
				}
				size--;
				return true;
			}
		}
	
	return false;	
	}
	
}
