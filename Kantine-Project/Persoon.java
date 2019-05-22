
public class Persoon {
	private int BSN;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private char geslacht;
	
	public Persoon  (int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht) {
		this.BSN = BSN;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
	}
	
	public Persoon() {
		this.BSN = 0;
		this.voornaam = "default";
		this.achternaam = "default";
		this.geboortedatum = "dd-mm-jjjj";
		this.geslacht = 0;
	}
	
	public void setBSN (int BSN) {
		this.BSN = BSN;
	}
	
	public void setVoornaam (String voornaam) {
		this.voornaam = voornaam;
	}
	
	public void setAchternaam (String achterrnaam) {
		this.achternaam = achternaam;
	}
	
	public void setGeboortenaam (String geboortenaam) {
		this.geboortenaam = geboortenaam;
	}
	
	public void setGeslacht (char geslacht) {
		this.geslacht = geslacht;
	}
	
	public int getBSN() {
		return BSN;
	}
	
	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}
	
	public String getGeboortedatum(Datum datum) {
		return getDatumAsString;
	}
	
	public char getGeslacht() {
		return geslacht;
	}
	
	// Control for geslacht
	/** 
	 * if( geslacht.equals("v")||geslacht.equals("V") {
    		System.out.println("Een vrouw" );
		}
	else if( geslacht.equals("m")||geslacht.equals("M") {
    		System.out.println("Een man");
		}
	else {
    		System.out.println("Onbekend");
		}
	 */
}
