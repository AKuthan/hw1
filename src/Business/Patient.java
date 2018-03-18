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
	private ArrayList<Pair<PatientNeeds, Boolean>> hospitalHistory;
	
	public Patient(String name, String surName, Integer tCKN, PatientNeeds patientNeeds) {
		setPatientNeeds(patientNeeds);
		setName(name);
		setSurName(surName);
		setTCKN(tCKN);
		rand = new Random();
		hospitalHistory = new ArrayList<Pair<PatientNeeds, Boolean>>();
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
	public ArrayList<Pair<PatientNeeds, Boolean>> getHospitalHistory(){
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
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Operation, false));
			return false;
		}
		else{
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Operation, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}	
	}
	
	public boolean visit(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Visit, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Visit, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}	
	}
	
	public boolean takeMedicine(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Medicine, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Medicine, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean giveBloodSample(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.BloodSample, false));
			return false;
		}
		else{
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.BloodSample, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean goToMRI(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.MRI, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.MRI, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
	
	public boolean goToXRay(Integer probability){
		Integer randomNumber = rand.nextInt(100);
		if (randomNumber > probability){
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Xray, false));
			return false;
		}
		else {
			hospitalHistory.add(new Pair<PatientNeeds, Boolean>(PatientNeeds.Xray, true));
			patientNeeds = PatientNeeds.values()[rand.nextInt(PatientNeeds.values().length)];
			return true;
		}
	}
}
