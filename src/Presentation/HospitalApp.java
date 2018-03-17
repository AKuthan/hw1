package Presentation;
//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1


import java.io.IOException;
import java.util.ArrayList;

import Business.Doctor;
import Business.Nurse;
import Business.Patient;
import Business.PatientCompanion;
import Business.PatientNeeds;



public class HospitalApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Patient patient1 = new Patient("Caner","Karagüler", 210201008, PatientNeeds.BloodSample);
		Patient patient2 = new Patient("Kuthan","Temimhan", 210201016, PatientNeeds.Operation);
		Patient patient3 = new Patient("Usman","Aga", 74081, PatientNeeds.Visit);
		Patient patient4 = new Patient("Susak","Sinan", 83637, PatientNeeds.Medicine);
		Patient patient5 = new Patient("Safiye","Susak", 62386, PatientNeeds.MRI);
		Patient patient6 = new Patient("Minoset","Plus", 23432, PatientNeeds.Xray);
		Patient patient7 = new Patient("Cem","Yılmaz", 23452, PatientNeeds.BloodSample);
		Patient patient8 = new Patient("Mahmut","Tuncer", 232332, PatientNeeds.Operation);
		Patient patient9 = new Patient("David","Galetaunu", 2342352, PatientNeeds.Visit);
		Patient patient10 = new Patient("Justin","Biber", 2343742, PatientNeeds.Medicine);
		Patient patient11= new Patient("Ayça","Güzel", 2335322, PatientNeeds.MRI);
		Patient patient12 = new Patient("Aleyna","Fox", 234352, PatientNeeds.Xray);
		
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);
		patients.add(patient4);
		patients.add(patient5);
		patients.add(patient6);
		patients.add(patient7);
		patients.add(patient8);
		patients.add(patient9);
		patients.add(patient10);
		patients.add(patient11);
		patients.add(patient12);
		
		Doctor doctor1 = new Doctor("EKincan","Ufuktepe",355);
		Doctor doctor2 = new Doctor("Fatih Sultan","Mehmet", 1453);
		Doctor doctor3 = new Doctor("Canan","Karatay", 3534);
		
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		
		doctors.add(doctor1);
		doctors.add(doctor2);
		doctors.add(doctor3);
		
		Nurse nurse = new Nurse("Pelinsu","Starbucks",21);
		Nurse nurse1 = new Nurse("Berkecan","Starbucks",54);
		Nurse nurse2 = new Nurse("Şebnem","Ferah",35);
		Nurse nurse3 = new Nurse("Obama","Thousandladin",1243);
		Nurse nurse4 = new Nurse("Katarina","Nerf",25131);
		Nurse nurse5 = new Nurse("Xin","Zhaoa",2121);
		
		
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		
		nurses.add(nurse);
		nurses.add(nurse1);
		nurses.add(nurse2);
		nurses.add(nurse3);
		nurses.add(nurse4);
		nurses.add(nurse5);
		
		PatientCompanion patientcompanion = new PatientCompanion("Annie","Bear",214);
		PatientCompanion patientcompanion1 = new PatientCompanion("Mark","Zuckerberg",4125);
		PatientCompanion patientcompanion2 = new PatientCompanion("Adam","Apple",41425);
		PatientCompanion patientcompanion3 = new PatientCompanion("Meryem","Ana",347);
		PatientCompanion patientcompanion4 = new PatientCompanion("Jesus","Tanrıkulu",42436);
		PatientCompanion patientcompanion5 = new PatientCompanion("Ben","Deniz",264);
		
		ArrayList<PatientCompanion> patientcompanions = new ArrayList<PatientCompanion>();
		
		patientcompanions.add(patientcompanion);
		patientcompanions.add(patientcompanion1);
		patientcompanions.add(patientcompanion2);
		patientcompanions.add(patientcompanion3);
		patientcompanions.add(patientcompanion4);
		patientcompanions.add(patientcompanion5);
		
		
		MonitorSystem ms = new MonitorSystem(patients,doctors,nurses,patientcompanions);
		
		int processCount = 0;
		while(ms.mainMenu()){
			processCount++;
		}
		System.out.println("while loob retuns "+ processCount + "times");
		System.exit(1);
	}

}
