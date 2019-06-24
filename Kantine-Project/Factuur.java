import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

public class Factuur implements Serializable {
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Column(name = "date")
	private LocalDateTime datumTijd;
	
	//@Column(name = "korting")
	private double korting;
	
	//@Column(name = "totaal")
	private double totaal;
	
	private Dienblad dienblad;
	
	public Factuur() {
	totaal = 0;
	korting = 0;
	}
	
	public Factuur(Dienblad dienblad) 
	{
		this();
		this.datumTijd = LocalDateTime.now();
	
		verwerkBestelling(dienblad);
	}
	
	/**
	* Verwerk artikelen en pas kortingen toe.
	*
	* Zet het totaal te betalen bedrag en het
	* totaal aan ontvangen kortingen.
	*
	* @param klant
	*/
	private void verwerkBestelling(Dienblad dienblad) {
	// method body omitted
	
	}
	
	public double getTotaalMetKorting(Dienblad dienblad) {
		// method body omitted
		
			double totaalEindBedrag = 0;
			totaalEindBedrag = getTotaal(dienblad) - getKorting(dienblad);
			
			
			return totaalEindBedrag;
		}
	
	/*
	* @return het totaalbedrag
	*/
	public double getTotaal(Dienblad dienblad) 
	{
		double totaalPrijs = 0;
    	Iterator iterator = dienblad.getArtikelen().iterator();
    	
    	while(iterator.hasNext()) 
    	{
    		totaalPrijs += ((Artikel) iterator.next()).getPrijs();
    	}
    	
    	this.totaal = totaalPrijs;
    	
    	return totaalPrijs;
	}
	
	
	/**
	* @return de toegepaste korting
	*/
	public double getKorting(Dienblad dienblad) 
	{
		Persoon persoon = dienblad.getKlant();
		
		double kortingsPercentage = 0;
		double kortingsLimiet = 0;
		double kortingInGeld = 0;
		double totaalBedrag = getTotaal(dienblad);
		
		if (dienblad.getKlant() instanceof Docent)
		{
			kortingsPercentage = ((Docent) persoon).geefKortingsPercentage();
			kortingsLimiet = ((Docent) persoon).geefMaximum();
		}
		else if (dienblad.getKlant() instanceof KantineMedewerker)
		{
			kortingsPercentage = ((KantineMedewerker) persoon).geefKortingsPercentage();
			kortingsLimiet = ((KantineMedewerker) persoon).geefMaximum();
		}
		
		kortingInGeld = totaalBedrag*kortingsPercentage;
		if (kortingsLimiet != 0 && kortingInGeld > kortingsLimiet)
		{
			kortingInGeld = kortingsLimiet;
		}
	
		this.korting = kortingInGeld;
	
		return kortingInGeld;
	}
	
	/**
	* @return een printbaar bonnetje
	*/
	public String toString() {
		String bon = "";
		
		for(Artikel artikel : dienblad.getArtikelen()) {
			bon += artikel.getNaam() + " - " + artikel.getPrijs();
		};
		
		bon += "Totaal = " + getTotaal(dienblad) + " betaald op " + datumTijd;
		
		return bon;
	}

}
