package classesbiblio;

import java.util.Date;

public class Article extends Document {
	
	private String writername;
	private Date datepub;
	public Article(int i, String title, int nbexmp, Localisation loc, 
			String writername,Date datepub) {
		super(i, title, nbexmp, loc);
		this.writername=writername;
		this.datepub=datepub;
		
	}
	public String getWritername() {
		return writername;
	}
	
	public void setWritername(String writername) {
		this.writername = writername;
	}
	public Date getDatepub() {
		return datepub;
	}
	public void setDatepub(Date datepub) {
		this.datepub = datepub;
	}
	public String toString() {
		return "[code="+this.getCode()+"|type=Article"+"|titre="+this.getTitle()+
				"|localisation:"+this.getLoc()+"|nbrexmp="+this.getNbexmp()+
				"|nbrempr="+this.getNbempr()+"|auteur="+this.getWritername()+
				"|date de publication="+this.getDatepub()+"]\n";
	}
}
