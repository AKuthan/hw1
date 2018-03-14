
public class Patient {
	private String name;
	private String surName;
	private Integer TCKN;
	private PatientNeeds patientNeeds;
	
	public Patient(String name, String surName, Integer tCKN, PatientNeeds patientNeeds) {
		this.patientNeeds = patientNeeds;
		this.name = name;
		this.surName = surName;
		TCKN = tCKN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Integer getTCKN() {
		return TCKN;
	}

	public void setTCKN(Integer tCKN) {
		TCKN = tCKN;
	}

	public String toString() {
		return "Patient [name=" + name + ", surname=" + surName + ", TCKN="
				+ TCKN + "]";
	}
	
	
	public PatientNeeds getPatientNeeds() {
		return patientNeeds;
	}

	public void setPatientNeeds(PatientNeeds patientNeeds) {
		this.patientNeeds = patientNeeds;
	}

	public boolean operation(){
		return true;
	}
	
	public boolean visit(){
		return true;
	}
	
	public boolean takeMedicine(){
		return true;
	}
	
	public boolean giveBloodSample(){
		return true;
	}
	
	public boolean goToMRI(){
		return true;
	}
	
	public boolean goToXRay(){
		return true;
	}
}
