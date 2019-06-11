public class Administratie {
	
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
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while() {
                temp[i] += omzet[i + 7 * j];

                // omitted

            }
        }
        return temp;
    }
}
