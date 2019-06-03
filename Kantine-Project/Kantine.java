public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        // method body omitted
    	//Dienblad dienblad = new Dienblad(persoon);
    	
    	for(String artikelnaam: artikelnamen) 
    	{
    	dienblad.voegToe(kantineaanbod.getArtikel(artikelnaam));
    	}

    	kassarij.sluitAchteraan(dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
    	int lengteRij = kassarij.getSize();
    	for(int i = 0; i < lengteRij; i++) {
    		kassa.rekenAf(kassarij.eerstePersoonInRij());
    	}
//        while(kassarij.erIsEenRij()) {
//        	System.out.println(kassarij.erIsEenRij());
//        	kassa.rekenAf(kassarij.eerstePersoonInRij());
//        }
    }
    
    /**
     * Getter voor de kassa voor het doorgeven van variabelen.
     * 
     * @return kassa
     */
    public Kassa getKassa() {
    	return kassa;
    }
    
    public KassaRij getKassaRij() {
    	return kassarij;
    }
    
    public void setKantineAanbod(KantineAanbod kantineaanbod) {
    	this.kantineaanbod = kantineaanbod;
    }
    
    public KantineAanbod getKantineAanbod() {
    	return kantineaanbod;
    }

//    /**
//     * Deze methode telt het geld uit de kassa
//     *
//     * @return hoeveelheid geld in kassa
//     */
//    public double hoeveelheidGeldInKassa() {
//       // method body omitted
//    	return kassa.hoeveelheidGeldInKassa();
//    }
//
//    /**
//     * Deze methode geeft het aantal gepasseerde artikelen.
//     *
//     * @return het aantal gepasseerde artikelen
//     */
//    public int aantalArtikelen() {
//        // method body omitted
//    	return kassa.aantalArtikelen();
//    }
//
//    /**
//     * Deze methode reset de bijgehouden telling van
//     * het aantal artikelen en "leegt" de inhoud van de kassa.
//     */
//    public void resetKassa() {
//        // method body omitted
//    	kassa.resetKassa();
//    }
}