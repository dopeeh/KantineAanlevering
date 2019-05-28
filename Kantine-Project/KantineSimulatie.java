public class KantineSimulatie {

    private Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for(int i = 0; i < dagen; i++) {

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                kantine.loopPakSluitAan();
            }

            kantine.verwerkRijVoorKassa();

            System.out.println("De dagtotalen van dag " + (i + 1) + " zijn: geld = " + kantine.hoeveelheidGeldInKassa() + ", artikelen = " + kantine.aantalArtikelen());

            kantine.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        
        KantineSimulatie ks = new KantineSimulatie();
        
        ks.simuleer(dagen);
    }
}