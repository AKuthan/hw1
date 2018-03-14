import java.util.ArrayList;


public class MonitorSystem {
	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	private ArrayList<Nurse> nurses;
	private ArrayList<PatientCompanion> patientsCompanions;
	public MonitorSystem(ArrayList<Patient> patients,
			ArrayList<Doctor> doctors, ArrayList<Nurse> nurses,
			ArrayList<PatientCompanion> patientsCompanions) {
		this.patients = patients;
		this.doctors = doctors;
		this.nurses = nurses;
		this.patientsCompanions = patientsCompanions;
	}
	public void monitoringPatients(){
		System.out.println(patients);
	}
	public void monitoringHospitalStaff(){
		System.out.println(doctors);
		System.out.println(nurses);
		System.out.println(patientsCompanions);
	}
	public boolean getResult(Patient patient){
		System.out.println(patient.getPatientNeeds());
		
		return true;
	}
	
}
