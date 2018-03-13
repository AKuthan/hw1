
public class Nurse extends HospitalStaff {

	public Nurse(String name, String surname, Integer id) {
		super(name, surname, id);
		}
	
	public boolean bringMedicineToPatient(Patient patient){
		return patient.takeMedicine();
	}
	
	public boolean takeBloodSample(Patient patient){
		return patient.giveBloodSample();
	}

}
