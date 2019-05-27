public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	  /**
	   * Constructor
	   */
	public Datum(int dag, int maand, int jaar) {
		this();
		
		if (bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		} 
	}
	
	public Datum(String datum) {
		this();
		//Pak datum als string en split op "-"
		String[] datumAsArray = datum.split("\\-");
		
		if ( bestaatDatum( Integer.parseInt(datumAsArray[0]), Integer.parseInt(datumAsArray[1]), Integer.parseInt(datumAsArray[2]) ) ) {
			this.dag = Integer.parseInt(datumAsArray[0]);
			this.maand = Integer.parseInt(datumAsArray[1]);
			this.jaar = Integer.parseInt(datumAsArray[2]);
		}
	}
	
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	
	public boolean bestaatDatum(int dag, int maand, int jaar){
		//generieke controle op valide ints
		if (dag >= 1 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
			
			//Maanden met 31 dagen
			if ((maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12 ) && dag <= 31) {
				return true;
				
			//Maand met 29 of 28 dagen
			} else if(maand == 2) {
				if (jaar % 4 == 0 && dag <= 29) {
					return true;
				} else if (dag <= 28){
					return true;
				}
				
			//OVerige maanden met 30 dagen
			} else if (dag <= 30) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		String result = "";
		if (dag < 10) { 
			result += "0" + dag;
		} else {
			result += dag;
		}
		
		result += "-";
		
		if (maand < 10) {
			result += "0" + maand;
		} else {
			result += maand;
		}
		
		result += "-" + jaar;
		
		return result;
		}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
}
