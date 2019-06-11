import java.util.*;

public class KantineSimulatie {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;
    
    // aantal dagen te simuleren
    //private static final int DAGEN = 0;

    // artikelen
    private static final String[] artikelnamen = new String[]
        {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,
            MIN_ARTIKELEN_PER_SOORT,
            MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
        	
        	//System.out.println("Begin van de dag." );

            // Willekeurig aantal mensen binnen de aangegeven scope
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for(int j = 0; j < aantalpersonen; j++) {
            	
                // maak persoon en dienblad aan, koppel ze
            	Persoon klant = new Persoon();
            	Dienblad dienblad = new Dienblad(klant);
            	
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            
            //System.out.println("Eind van de dag." );
            
            Kassa kassa = kantine.getKassa();
            
            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            double totaalGeld = kassa.hoeveelheidGeldInKassa();
            int totaalAantalArtikelen = kassa.aantalArtikelen();
             	
            System.out.println("Er zijn vandaag " + aantalpersonen + " personen aangekomen." );
            System.out.println("De dagtotalen voor de dag zijn: " + totaalGeld + " euro, " + totaalAantalArtikelen + " producten." );

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }
    }
    
    public static void main(String[] args) {
    	int dagen;
    	
    	if (args.length == 0) {
    		dagen = 7;
    	} else {
    		dagen = Integer.parseInt(args[0]);
    	}
    	
    	KantineSimulatie ks = new KantineSimulatie();
		//ks.simuleer(dagen);
		
		int test = ks.getRandomValue(1, 2);
		
		System.out.println(test);
		
		int[] testing1 = {45, 56, 34, 39, 40, 31};
		double[] testing2 = {567.70, 498.25, 458.90};
		double[] testing3 = {20, 30, 20, 30, 10, 40, 50, 60, 30, 70};
		
		//System.out.println(Administratie.berekenGemiddeldAantal(testing1));
		//System.out.println(Administratie.berekenGemiddeldeOmzet(testing2));
		
		double[] result = Administratie.berekenDagOmzet(testing3);
		
		for(double dik: result) {
			System.out.println(dik);
		}
	}
}