
public class Patient {
	private String name;
	private String surName;
	private Integer TCKN;
	
	public Patient(String name, String surName, Integer tCKN) {
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
		return "Patient [name=" + name + ", surName=" + surName + ", TCKN="
				+ TCKN + "]";
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
