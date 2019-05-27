import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    Persoon klant;
    double totaalPrijs;

    /**
     * Constructor
     */
    public Dienblad() {
    	artikelen = new ArrayList<>();
    }
    
    public Dienblad(Persoon klant) {
    	this();
    	
    	this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
//      Iterator iterator = artikelen.iterator();
    	totaalPrijs = 0.00;
    	
//      for (Artikel artikel: artikelen) {
//      	totaalPrijs += artikel.getPrijs();
//      }
    	
//    	while(iterator.hasNext()) {
//    		totaalPrijs += ((Artikel) iterator.next()).getPrijs();
//    	}
    	
    	artikelen.forEach((a) -> {
    		totaalPrijs += a.getPrijs();
    	});
    	
    	
        return totaalPrijs;
    }
    
    public void setKlant(Persoon klant) {
    	this.klant = klant;
    }
    
    public Persoon getKlant() {
    	return klant;
    }
}

