import java.io.IOException;
import java.util.ArrayList;


public class HospitalApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Patient patient1 = new Patient("Caner","Karagüler",10, PatientNeeds.Visit);
		Patient patient2 = new Patient("Kuthan","Temimhan",11, PatientNeeds.Visit);
		Patient patient3 = new Patient("Osman","Deli",12, PatientNeeds.Visit);
		Patient patient4 = new Patient("Mahmut","Orhan",13, PatientNeeds.Visit);
		
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);
		patients.add(patient4);
		
		Doctor doctor1 = new Doctor("EKincan","Ufuktepe",101);
		Doctor doctor2 = new Doctor("Yavuz","Sultan", 1453);
		
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		
		doctors.add(doctor1);
		doctors.add(doctor2);
		
		Nurse nurse = new Nurse("Pelinsu","Starbucks",21);
		
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		
		nurses.add(nurse);
		
		PatientCompanion patientcompanion = new PatientCompanion("Tuğkan","Tuğlular",45);
		
		ArrayList<PatientCompanion> patientcompanions = new ArrayList<PatientCompanion>();
		
		patientcompanions.add(patientcompanion);
		
		
		MonitorSystem ms = new MonitorSystem(patients,doctors,nurses,patientcompanions); 
		ms.monitoringPatients();
		ms.monitoringHospitalStaff();
		
		DataAccessLayer dal = new DataAccessLayer();
		//System.out.println(dal.readFile());
		ms.getResult(patient2);
	}

}
