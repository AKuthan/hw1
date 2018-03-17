package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

public class Pair {

  private final PatientNeeds pc;
  private final Boolean b;

  public Pair(PatientNeeds pc, Boolean b) {
    this.b = b;
    this.pc = pc;
  }
  public String toString() {
	return pc + "," +b;
}	
  

}