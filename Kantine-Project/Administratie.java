public class Administratie {
	final static int DAYS_IN_WEEK = 7;
	
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
    	double result = 0;
    	int counter = 0;
        for(int i: aantal) {
        	counter += 1;
        	result += i;
        }
        return result / counter;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
    	double result = 0;
    	int counter = 0;
        for(double i: omzet) {
        	counter += 1;
        	result += i;
        }
        return result / counter;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        
        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            int counter = 0;
            while( omzet.length > (i + DAYS_IN_WEEK * j) ) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                
                j++;
                counter++;
            }
            temp[i] = temp[i] / counter;
        }
        return temp;
    }
}
