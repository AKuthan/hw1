package Presentation;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1




import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Business.Doctor;
import Business.HospitalStaff;
import Business.Nurse;
import Business.Pair;
import Business.Patient;
import Business.PatientCompanion;
import Business.PatientNeeds;
import DataAccessLayer.DataAccessLayer;


public class MonitorSystem {
	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	private ArrayList<Nurse> nurses;
	private ArrayList<HospitalStaff> hospitalStaffs;
	private ArrayList<PatientCompanion> patientCompanions;
	private Map<PatientNeeds, Integer> probabilities;
	private DataAccessLayer dal;
	private Random random;
	private Scanner keyboard;

	public MonitorSystem(ArrayList<Patient> patients,
			ArrayList<Doctor> doctors, ArrayList<Nurse> nurses,
			ArrayList<PatientCompanion> patientsCompanions) throws IOException {
		this.patients = patients;
		this.doctors = doctors;
		this.nurses = nurses;
		this.patientCompanions = patientsCompanions;
		dal = new DataAccessLayer();
		keyboard = new Scanner(System.in);
		random  = new Random();
		hospitalStaffs = new ArrayList<HospitalStaff>();
		initialProbabilities();
		initialHospitalStaffs();
		
	}
	
	public void initialProbabilities() throws IOException{
		probabilities = dal.readFile();
	}
	private void initialHospitalStaffs(){
		hospitalStaffs.addAll(doctors);
		hospitalStaffs.addAll(nurses);
		hospitalStaffs.addAll(patientCompanions);
	}
	public boolean mainMenu(){
		System.out.println("--Welcome to main menu of hospital---");
		System.out.println("1-)Select patient to cure");
		System.out.println("2-)Random patient to cure");
		System.out.println("3-)Monitor all patient");
		System.out.println("4-)Monitor all hospital staff");
		System.out.println("5-)Dismiis a doctor from hospital");
		System.out.println("6-)Select patient to see hospital history");
		System.out.println("7-)Exit");
		System.out.println("Enter a number Please");
		
		String strChoice = keyboard.next();
		Integer choice;
		try {
			choice = Integer.parseInt(strChoice);
		} catch (Exception e) {
			System.out.println("You should enter a number. Lets try again");
			return mainMenu();
		}
		Patient patient;
		switch(choice){
			case 1:
				patient = selectPatient();
				supplyPatientNeeds(patient);
				break;
			case 2:
				patient = randomPatient();
				supplyPatientNeeds(patient);
				break;
			case 3:
				monitoringAllPatients();
				break;
			case 4:
				monitoringAllHospitalStaff();
				break;
			case 5:
				removeDoctor();
				break;
			case 6:
				patient = selectPatient();
				patientHospitalHistory(patient);
				break;
			case 7:
				System.out.println("Good bye have a nice day");
				return false;
			default:
				System.out.println("You entered wrong number");
				return mainMenu();
		}
		return true;
	}
	
	private boolean supplyPatientNeeds(Patient patient){
		PatientNeeds need = patient.getPatientNeeds();
		switch(need){
		case Operation:
			System.out.println("This patient needs Operation");
			if(operation(patient)){
				System.out.println("Opeation done with SUCCESS");
			}
			else
				System.out.println("Opeation done with FAIL");
			break;
		case Visit:
			System.out.println("This patient needs Visit");
			if(visit(patient)){
				System.out.println("Visit done with SUCCESS");
			}
			else
				System.out.println("Visit done with FAIL");
			break;
		case Medicine:
			System.out.println("This patient needs Medicine");
			if(medicine(patient)){
				System.out.println("Bring medicine to patient done with SUCCESS");
			}
			else
				System.out.println("Bring medicine to patient done with FAIL");
			break;
		case BloodSample:
			System.out.println("This Patient needs to be taken Blood Sample");
			if(bloodSample(patient)){
				System.out.println("Take blood sample to patient done with SUCCESS");
			}
			else
				System.out.println("Take blood sample to patient done with FAIL");
			break;
		case MRI:
			System.out.println("This Patient needs to go MRI");
			if(MRI(patient)){
				System.out.println("Take blood sample to patient done with SUCCESS");
			}
			else
				System.out.println("Take blood sample to patient done with FAIL");
			break;
		case Xray:
			System.out.println("This Patient needs to go X-Ray");
			if(Xray(patient)){
				System.out.println("Take blood sample to patient done with SUCCESS");
			}
			else
				System.out.println("Take blood sample to patient done with FAIL");
			break;
		default:
			System.out.println("You shouldnt be here.");
			break;
		}
		return true;
	}
	
	private void monitoringAllPatients(){
		for(Patient patient: patients)
			System.out.println(patient);
	}
	
	private void monitoringAllHospitalStaff(){
		for (HospitalStaff hospialstaff: hospitalStaffs)
			System.out.println(hospialstaff);
	}
	private void patientHospitalHistory(Patient patient){
		if(patient.getHospitalHistory().isEmpty()){
			System.out.println("This patient has no history at this hospital");
		}
		for(Pair history: patient.getHospitalHistory()){
			System.out.println(history);
		}
	}
	
	private boolean visit(Patient patient){
		System.out.println("Do you want to select doctor(y/n) (if answer is 'n' doctor will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		Doctor doctor;
		if(answer.equals("y")){
			doctor = selectDoctor();
		}
		else if(answer.equals("n")){
			doctor = randomDoctor();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return visit(patient);
		}
		return doctor.performVisit(patient, probabilities.get(PatientNeeds.Visit));
	}

	private boolean operation(Patient patient){
		System.out.println("Do you want to select doctor(y/n) (if answer is 'n' doctor will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		Doctor doctor;
		if(answer.equals("y")){
			doctor = selectDoctor();
		}
		else if(answer.equals("n")){
			doctor = randomDoctor();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return operation(patient);
		}
		return doctor.performOperation(patient, probabilities.get(PatientNeeds.Operation));
	}
	private boolean medicine(Patient patient){
		System.out.println("Do you want to select nurse(y/n) (if answer is 'n' nurse will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		Nurse nurse;
		if(answer.equals("y")){
			nurse = selectNurse();
		}
		else if(answer.equals("n")){
			nurse = randomNurse();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return medicine(patient);
		}
		return nurse.bringMedicineToPatient(patient, probabilities.get(PatientNeeds.Medicine));
	}
	
	private boolean bloodSample(Patient patient){
		System.out.println("Do you want to select nurse(y/n) (if answer is 'n' nurse will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		Nurse nurse;
		if(answer.equals("y")){
			nurse = selectNurse();
		}
		else if(answer.equals("n")){
			nurse = randomNurse();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return bloodSample(patient);
		}
		return nurse.takeBloodSample(patient, probabilities.get(PatientNeeds.BloodSample));
	}
	
	private boolean MRI(Patient patient){
		System.out.println("Do you want to select patient companion(y/n) (if answer is 'n' patient companion will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		PatientCompanion patientCompanion;
		if(answer.equals("y")){
			patientCompanion = selectPatientCompanion();
		}
		else if(answer.equals("n")){
			patientCompanion = randomPatientCompanion();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return MRI(patient);
		}
		return patientCompanion.takePatientToMRI(patient, probabilities.get(PatientNeeds.MRI));
	}
	
	private boolean Xray(Patient patient){
		System.out.println("Do you want to select patient companion(y/n) (if answer is 'n' patient companion will selected randomly)");
		String answer = keyboard.next();
		answer.toLowerCase();
		PatientCompanion patientCompanion;
		if(answer.equals("y")){
			patientCompanion = selectPatientCompanion();
		}
		else if(answer.equals("n")){
			patientCompanion = randomPatientCompanion();
		}
		else{
			System.out.println("You should enter 'y' or 'n' lets try again");
			return Xray(patient);
		}
		return patientCompanion.takePatientToXRay(patient, probabilities.get(PatientNeeds.Xray));
	}
	
	
	private Doctor selectDoctor(){
		int i = 1;
		System.out.println("------------------------------------");
		for(Doctor doctor: doctors){
			System.out.println(i+"-)"+ doctor);
			i++;
		}
		System.out.println("Enter doctor number");
		String strNumber = keyboard.next();
		Integer number;
		try {
			number = Integer.parseInt(strNumber);
		} catch (Exception e) {
			System.out.println("You should enter a number. Lets try again");
			return selectDoctor();
		}
		Doctor doctor;
		try {
			doctor = doctors.get(number-1);
			return doctor;
		} catch (Exception e) {
			System.out.println("No doctor at the number you entered. Lets try again");
			return selectDoctor();
		}	
	}
	private Doctor randomDoctor(){
		Integer index = random.nextInt(doctors.size());
		return doctors.get(index);
	}
	private Nurse selectNurse(){
		int i = 1;
		System.out.println("------------------------------------");
		for(Nurse nurse: nurses){
			System.out.println(i+"-)"+ nurse);
			i++;
		}
		System.out.println("Enter nurse number");
		String strNumber = keyboard.next();
		Integer number;
		try {
			number = Integer.parseInt(strNumber);
		} catch (Exception e) {
			System.out.println("You should enter a number. Lets try again");
			return selectNurse();
		}
		Nurse nurse;
		try {
			nurse = nurses.get(number-1);
			return nurse;
		} catch (Exception e) {
			System.out.println("No nurse at the number you entered. Lets try again");
			return selectNurse();
		}
	}
	private Nurse randomNurse(){
		Integer index = random.nextInt(nurses.size());
		return nurses.get(index);
	}
	private PatientCompanion selectPatientCompanion(){
		int i = 1;
		System.out.println("------------------------------------");
		for(PatientCompanion patientCompanion: patientCompanions){
			System.out.println(i+"-)"+ patientCompanion);
			i++;
		}
		System.out.println("Enter Patient Companion number");
		String strNumber = keyboard.next();
		Integer number;
		try {
			number = Integer.parseInt(strNumber);
		} catch (Exception e) {
			System.out.println("You should enter a number. Lets try again");
			return selectPatientCompanion();
		}
		PatientCompanion patientCompanion;
		try {
			patientCompanion = patientCompanions.get(number-1);
			return patientCompanion;
		} catch (Exception e) {
			System.out.println("No patient companion at the number you entered. Lets try again");
			return selectPatientCompanion();
		}
	}
	private PatientCompanion randomPatientCompanion(){
		Integer index = random.nextInt(patientCompanions.size());
		return patientCompanions.get(index);
	}
	private Patient selectPatient(){
		int i = 1;
		System.out.println("------------------------------------");
		for(Patient patient: patients){
			System.out.println(i+"-)"+ patient);
			i++;
		}
		System.out.println("Enter Patient number");
		String strNumber = keyboard.next();
		Integer number;
		try {
			number = Integer.parseInt(strNumber);
		} catch (Exception e) {
			System.out.println("You should enter a number. Lets try again");
			return selectPatient();
		}
		Patient patient;
		try {
			patient = patients.get(number-1);
			return patient;
		} catch (Exception e) {
			System.out.println("No patient at the number you entered. Lets try again");
			return selectPatient();
		}
	}
	private Patient randomPatient(){
		Integer index = random.nextInt(patients.size());
		return patients.get(index);
	}
	
	
	private void removeDoctor(){
		Doctor doctor= selectDoctor();
		if(doctor.dismissFromHospital()){
			doctors.remove(doctor);
		}
		else
			System.out.println("We cant dismiss this Doctor");		
	}
}
