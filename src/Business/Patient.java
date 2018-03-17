package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1


import java.util.ArrayList;
import java.util.Random;



public class Patient {
	private String name;
	private String surName;
	private Integer TCKN;
	private PatientNeeds patientNeeds;
	private Random rand;
	private ArrayList<Pair> hospitalHistory;
	
	public Patient(String name, String surName, Integer tCKN, PatientNeeds patientNeeds) {
		setPatientNeeds(patientNeeds);
		setName(name);
		setSurName(surName);
		setTCKN(tCKN);
		rand = new Random();
		hospitalHistory = new ArrayList<Pair>();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if(name != null && !name.isEmpty())
			this.name = name;
		else{
			System.err.println("Invalid name");
			System.exit(-1);
		}
		
	}

	public String getSurName() {
		return surName;
	}

	private void setSurName(String surName) {
		if(surName != null && !surName.isEmpty())
			this.surName = surName;
		else{
			System.err.println("Invalid Surname");
			System.exit(-1);
		}
	}

	public Integer getTCKN() {
		return TCKN;
	}

	private void setTCKN(Integer tCKN) {
		if (tCKN != null && tCKN > 0) {
			TCKN = tCKN;
		}
		else{
			System.err.println("Invalid TCKN");
			System.exit(-1);
		}
	}

	public String toString() {
		return "Patient [name=" + name + ", surname=" + surName + ", TCKN="
				+ TCKN + " need= "+ patientNeeds + " ]";
	}
	public ArrayList<Pair> getHospitalHistory(){
		return hospitalHistory;
	}
	
	
	public PatientNeeds getPatientNeeds() {
		return patientNeeds;
	}

	public void setPatientNeeds(PatientNeeds patientNeeds) {
		this.patientNeeds = patientNeeds;
	}

	public boolean operation(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.Operation, false));
			return false;
		}
		else{
			hospitalHistory.add(new Pair(PatientNeeds.Operation, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}	
	}
	
	public boolean visit(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.Visit, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair(PatientNeeds.Visit, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}	
	}
	
	public boolean takeMedicine(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.Medicine, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair(PatientNeeds.Medicine, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean giveBloodSample(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.BloodSample, false));
			return false;
		}
		else{
			hospitalHistory.add(new Pair(PatientNeeds.BloodSample, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean goToMRI(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.MRI, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair(PatientNeeds.MRI, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean goToXRay(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair(PatientNeeds.Xray, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair(PatientNeeds.Xray, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
}
