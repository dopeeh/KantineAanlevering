
public class KantineMedewerker extends Persoon {
	
	public int medewerkernummer;
	public boolean kassatoegestaan;
	

	public KantineMedewerker(int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht) {
		super(BSN, voornaam, achternaam, geboortedatum, geslacht);
		// TODO Auto-generated constructor stub
		
		this.medewerkernummer = medewerkernummer;
		this.kassatoegestaan = kassatoegestaan;
	}

	public KantineMedewerker() {
		// TODO Auto-generated constructor stub
		this.medewerkernummer = 0;
		this.kassatoegestaan = true;
	}
	
	public void setMedewerkernummer(int medewerkernummer) {
		this.medewerkernummer = medewerkernummer;
	}
	
	public void setKassatoegestaan() {
		this.kassatoegestaan = kassatoegestaan;
	}

	
	public int getMedewerkernummer() {
		return medewerkernummer;
	}
	
	public boolean getKassatoegestaan() {
		return kassatoegestaan;
	}
	}

}
