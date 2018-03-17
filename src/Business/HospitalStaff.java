package Business;

//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

public class HospitalStaff {
	private String name;
	private String surname;
	private Integer id;
	
	public HospitalStaff(String name, String surname, Integer id) {
		setName(name);
		setSurname(surname);
		setId(id);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			System.err.println("Invalid name");
			System.exit(-1);
		}
	}

	public String getSurname() {
		return surname;
	}

	private void setSurname(String surname) {
		if(surname != null && !surname.isEmpty()){
			this.surname = surname;
		}
		else{
			System.err.println("Invalid surname");
			System.exit(-1);
		}
	}

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		if(id !=null && id > 0)
			this.id = id;
		else{
			System.err.println("Invalid surname");
			System.exit(-1);
		}
	}

	public String toString() {
		return "name=" + name + ", surname=" + surname + ", id="
				+ id ;
	}
}
