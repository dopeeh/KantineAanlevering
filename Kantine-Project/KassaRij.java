import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KassaRij {
	
	Queue<Dienblad> rij;

    /**
     * Constructor
     */
    public KassaRij() {
        rij = new LinkedList<>();
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
        return rij.poll();
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if(rij.peek() != null)
        	return true;
        return false;
    }
    
    public int getSize() {
    	return rij.size();
    }
}