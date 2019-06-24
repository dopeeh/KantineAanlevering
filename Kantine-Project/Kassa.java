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
    	
    	Betaalwijze betaalwijze = dienblad.getKlant().getBetaalwijze();
    	Factuur factuur = new Factuur(dienblad);
    	
    	
    	
    	try {
			betaalwijze.betaal(factuur.getTotaalMetKorting(dienblad));
		} catch (TeWeinigGeldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	geldInKassa += factuur.getTotaalMetKorting(dienblad);
    	totaalArtikelen += getAantalArtikelenDienblad(dienblad);
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