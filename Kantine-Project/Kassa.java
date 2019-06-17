import java.util.Iterator;

public class Kassa {
	KassaRij kassarij;
	int totaalArtikelen = 0;
	double geldInKassa;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {    	
    	//Daadwerkelijke berekeningen
    	Persoon persoon = dienblad.getKlant();
    	Betaalwijze betaalwijze = persoon.getBetaalwijze();
    	
    	double kortingsPercentage = 0;
    	double kortingsLimiet = 0;
    	double kortingInGeld = 0;
    	double totaalTeBetalenNaKorting = 0;
    	
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
    	
    	kortingInGeld = (getTotaalPrijsDienblad(dienblad)*(kortingsPercentage));
    	if (kortingsLimiet != 0 && kortingInGeld > kortingsLimiet)
    	{
    		kortingInGeld = kortingsLimiet;
    	}
    	totaalTeBetalenNaKorting = getTotaalPrijsDienblad(dienblad) - kortingInGeld;
    	try {
			betaalwijze.betaal(totaalTeBetalenNaKorting);
		} catch (TeWeinigGeldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	geldInKassa += totaalTeBetalenNaKorting;
    	totaalArtikelen += getAantalArtikelenDienblad(dienblad);
    }
    
    /**
     * Berekent de totaalprijs van de artikelen in het gegeven dienblad.
     * 
     * @param dienblad
     * @return totaalprijs van het dienblad
     */
    public double getTotaalPrijsDienblad(Dienblad dienblad) {
    	double totaalPrijs = 0;
    	Iterator iterator = dienblad.getArtikelen().iterator();
    	
    	while(iterator.hasNext()) {
    		totaalPrijs += ((Artikel) iterator.next()).getPrijs();
    	}
    	return totaalPrijs;
    }
    
    /**
     * Geeft het aantal artikelen in het dienblad terug.
     * 
     * @param dienblad
     * @return integer voor het aantal artikelen.
     */
    public int getAantalArtikelenDienblad(Dienblad dienblad) {
    	int aantalArtikelen = 0;
    	Iterator iterator = dienblad.getArtikelen().iterator();
    	
    	while(iterator.hasNext()) {
    		iterator.next();
    		aantalArtikelen++;
    	}
    	return aantalArtikelen;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return totaalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        totaalArtikelen = 0;
        geldInKassa = 0;
    }
    
    public void sluitAchteraan(Dienblad dienblad) {
    	kassarij.sluitAchteraan(dienblad);
    }
}