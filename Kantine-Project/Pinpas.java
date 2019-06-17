
public class Pinpas extends Betaalwijze {

    private double kredietlimiet;
    
    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        // method body omitted
    	this.kredietlimiet = kredietlimiet;
    }
	
    /**
     * Methode om betaling af te handelen
     */
    
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        // method body omitted
    	if (saldo >= tebetalen && kredietlimiet >= tebetalen){
    		saldo = saldo-tebetalen; 
    	}
    	System.out.println("Betaling mislukt");
    	throw new TeWeinigGeldException("Betaling mislukt. Te laag saldo!");
    }
}
