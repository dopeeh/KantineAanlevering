
public class Docent extends Persoon {

	String afdeling;
	String vierLetterCode;
	
	public Docent(int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht, String afdeling, String vierLetterCode) 
	{
		super(BSN, voornaam, achternaam, geboortedatum, geslacht);
		this.afdeling = afdeling;
		this.vierLetterCode = vierLetterCode;
	}

	public Docent() 
	{
	}

	public String getAfdeling() {
		return afdeling;
	}

	public String getVierLetterCode() {
		return vierLetterCode;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	public void setVierLetterCode(String vierLetterCode) {
		this.vierLetterCode = vierLetterCode;
	}

}
