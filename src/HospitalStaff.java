
abstract class HospitalStaff {
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

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "name=" + name + ", surname=" + surname + ", id="
				+ id ;
	}
}
