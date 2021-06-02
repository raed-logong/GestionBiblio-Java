package classesbiblio;

public class Magazine extends Document {
	

	public Magazine(int code, String title, int nbexmp, Localisation loc,int freq) {
		super(code, title, nbexmp, loc);
		this.freq=freq;
	}

	private int freq;
	
	
	
	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	public String toString() {
		
		return "[code="+this.getCode()+"|type=Magazine"+"|titre="+this.getTitle()+
				"|localisation:"+this.getLoc()+"|nbrexmp="+this.getNbexmp()+
				"|nbrempr="+this.getNbempr()+"|frequence="+this.getFreq()+"]\n";
	}
}
