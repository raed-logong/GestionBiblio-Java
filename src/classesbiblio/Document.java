package classesbiblio;



public class Document {

	private int code;
	private String title;
	private int nbexmp;
	private Localisation loc;
	private int nbempr;
	private int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Document() {

	}
	public Document(int code,String title,int nbexmp,Localisation loc) {
		this.code=code;
		this.title=title;
		this.nbexmp=nbexmp;
		this.loc=loc;
		this.nbempr=0;
		this.total=0;
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNbexmp() {
		return nbexmp;
	}
	public void setNbexmp(int nbexmp) {
		this.nbexmp = nbexmp;
	}
	public Localisation getLoc() {
		return loc;
	}
	public void setLoc(Localisation loc) {
		this.loc = loc;
	}
	public int getNbempr() {
		return nbempr;
	}
	public void setNbempr(int nbempr) {
		this.nbempr = nbempr;
	}
	public String toString() {
		if(this.title==null) {
			return"";
		}
		return "code="+this.getCode()+"|titre="+this.getTitle()+
				"|localisation:"+this.getLoc()+"|nbrexmp="+this.getNbexmp()+
				"|nbremprencours="+this.getNbempr()+"\n";
	}

}
