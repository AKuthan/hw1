
public class PatientCompanion extends HospitalStaff {

	public PatientCompanion(String name, String surname, Integer id) {
		super(name, surname, id);
		}
	
	public boolean takePatientToMRI(Patient patient){
		return patient.goToMRI();
	}
	
	public boolean takePatientToXRay(Patient patient){
		return patient.goToXRay();
	}

}
