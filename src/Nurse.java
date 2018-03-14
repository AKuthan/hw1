
public class Nurse extends HospitalStaff {
	
	

	@Override
	public String toString() {
		String print = super.toString();
		return "Nurse [" + print +
				"]";
	}

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
