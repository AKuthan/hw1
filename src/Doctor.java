
public class Doctor extends HospitalStaff {

	public Doctor(String name, String surname, Integer id) {
		super(name, surname, id);
	}
	
	public boolean performOperation(Patient patient){
		return patient.operation();
	}
	public boolean performVisit(Patient patient){
		return patient.visit();
	}
	public boolean dismissFromHospital(){
		return true;
	}
	
}
