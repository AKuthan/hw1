
public class PatientCompanion extends HospitalStaff {
	
	
	@Override
	public String toString() {
		String print = super.toString();
		return "Patient Companion [" + print +
				"]";
	}

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
