
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Artikel banaan = new Artikel("banaan", 2.60);
//		Artikel appel = new Artikel("appel", 5.50);
//		Persoon koen = new Persoon(120394, "Koen", "Dekker", "14-06-1995", 'm');
//		
//		Dienblad dienblad = new Dienblad(koen);
//		
//		dienblad.voegToe(banaan);
//		dienblad.voegToe(appel);
//		
//		KassaRij kassarij = new KassaRij();
//		Kassa kassa = new Kassa(kassarij);
//		
//		kassa.sluitAchteraan(dienblad);
//		kassa.rekenAf(dienblad);
		
		Datum datum = new Datum(29, 2, 2000);
		
		System.out.println(datum.bestaatDatum(29, 2, 2000));
		
		System.out.println(2000 % 100);
		
	}
}
