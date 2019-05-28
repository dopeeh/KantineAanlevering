import java.util.Iterator;

public class Kassa {
	KassaRij kassarij;
	double totaalGeld;
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
    public void rekenAf(Dienblad klant) {
    	System.out.println("Er zitten " + getAantalArtikelenDienblad(klant) + " aantal artikelen in " + klant.getKlant() + " zijn dienblad.");
    	
    	//Daadwerkelijke berekeningen
    	totaalArtikelen += getAantalArtikelenDienblad(klant);
    	totaalGeld += getTotaalPrijsDienblad(klant);
    	geldInKassa += getTotaalPrijsDienblad(klant);
    	
    	System.out.println("Het totaal zit nu op: " + totaalGeld);
    }
    
    public double getTotaalPrijsDienblad(Dienblad dienblad) {
    	double totaalPrijs = 0;
    	Iterator iterator = dienblad.getArtikelen().iterator();
    	
    	while(iterator.hasNext()) {
    		totaalPrijs += ((Artikel) iterator.next()).getPrijs();
    	}
    	return totaalPrijs;
    }
    
    public int getAantalArtikelenDienblad(Dienblad dienblad) {
    	int aantalArtikelen = 0;
    	Iterator iterator = dienblad.getArtikelen().iterator();
    	
    	while(iterator.hasNext()) {
    		aantalArtikelen += dienblad.getArtikelen().size();
    	}
    	return 0;
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