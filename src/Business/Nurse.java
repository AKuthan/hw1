package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

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
	
	public boolean bringMedicineToPatient(Patient patient, Integer probability){
		return patient.takeMedicine(probability);
	}
	
	public boolean takeBloodSample(Patient patient, Integer probability){
		return patient.giveBloodSample(probability);
	}

}
