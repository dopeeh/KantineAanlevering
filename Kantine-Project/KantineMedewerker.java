
public class KantineMedewerker extends Persoon implements KortingskaartHouder{
	
	public int medewerkernummer;
	public boolean kassatoegestaan;
	

	public KantineMedewerker(int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht, Betaalwijze betaalwijze, int medewerkernummer, boolean kassatoegestaan) {
		super(BSN, voornaam, achternaam, geboortedatum, geslacht, betaalwijze);
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


	@Override
	public double geefKortingsPercentage() {
		return 0.35;
	}

	@Override
	public boolean heeftMaximum() {
		return false;
	}

	@Override
	public double geefMaximum() {
		return 0;
	}

	
	

}
