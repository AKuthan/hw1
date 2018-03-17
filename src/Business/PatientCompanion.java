package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

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
	
	public boolean takePatientToMRI(Patient patient, Integer probability){
		return patient.goToMRI(probability);
	}
	
	public boolean takePatientToXRay(Patient patient, Integer probability){
		return patient.goToXRay(probability);
	}

}
