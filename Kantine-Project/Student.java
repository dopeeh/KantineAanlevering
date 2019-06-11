
public class Student extends Persoon {
	
	public int studentnummer;
	public String studierichting;

	public Student(int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht) {
		super(BSN, voornaam, achternaam, geboortedatum, geslacht);
		// TODO Auto-generated constructor stub
		
		this.studentnummer = studentnummer;
		this.studierichting = studierichting;
		
	}

	public Student() {
		// TODO Auto-generated constructor stub
		this.studentnummer = 0;
		this.studierichting = "default";
	}
	
	public void setStudentnummer(int studentnummer) {
		this.studentnummer = studentnummer;
	}
	
	public void setStudierichting() {
		this.studierichting = studierichting;
	}

	
	public int getStudentnummer() {
		return studentnummer;
	}
	
	public String getStudierichting() {
		return studierichting;
	}
}
