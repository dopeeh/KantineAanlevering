import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {
	
	ArrayList<Dienblad> rij;

    /**
     * Constructor
     */
    public KassaRij() {
        rij = new ArrayList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        rij.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        Dienblad klantAanDeBeurt = rij.get(0);
        rij.remove(0);
        return klantAanDeBeurt;
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if(rij.size() > 0)
        	return true;
        return false;
    }
}