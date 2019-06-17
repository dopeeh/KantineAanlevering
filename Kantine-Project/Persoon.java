
public class Persoon {
	private int BSN;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
	private Betaalwijze betaalwijze;
	
	public Persoon  (int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht) {
		this.BSN = BSN;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = new Datum(geboortedatum);
		this.geslacht = geslacht;
	}
	
	public Persoon() {
		this.BSN = 0;
		this.voornaam = "default";
		this.achternaam = "default";
		this.geboortedatum = new Datum();
		this.geslacht = 0;
		
	}
	
	public void setBSN (int BSN) {
		this.BSN = BSN;
	}
	
	public void setVoornaam (String voornaam) {
		this.voornaam = voornaam;
	}
	
	public void setAchternaam (String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setGeboortedatum (String geboortedatum) {
		this.geboortedatum = new Datum(geboortedatum);
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
	
	public String getGeboortedatum() {
		return geboortedatum.getDatumAsString();
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
