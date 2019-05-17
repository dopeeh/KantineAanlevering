public class Artikel {
	private String naam;
	private double prijs;
	
	public Artikel(String naam, double prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}
	public Artikel() {
		this.naam = "default";
		this.prijs = 0.00;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public double getPrijs() {
		return prijs;
	}
	
	public String getNaam() {
		return naam;
	}
}
