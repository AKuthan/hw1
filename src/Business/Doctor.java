package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

public class Doctor extends HospitalStaff {
	
	
	@Override
	public String toString() {
		String print = super.toString();
		return "Doctor [" + print +
				"]";
	}

	public Doctor(String name, String surname, Integer id) {
		super(name, surname, id);
	}
	
	public boolean performOperation(Patient patient, Integer probability){
		return patient.operation(probability);
	}
	public boolean performVisit(Patient patient, Integer probability){
		return patient.visit(probability);
	}
	public boolean dismissFromHospital(){
		return true;
	}
	
}
