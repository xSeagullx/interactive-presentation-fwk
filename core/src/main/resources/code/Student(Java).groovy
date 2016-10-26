public class Student {
	public enum Gender {
		M, F
	}

	private String name;
	private String lastName;
	private final Gender gender;

	Student(String lastName, String name, Gender gender) {
		this.gender = gender;
		this.lastName = lastName;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	@Override public boolean equals(Object o) {
		if (this.is(o)) return true; // Cheat place. Should be "this == o"
		if (getClass() != o.getClass()) return false;

		code.Student student = (code.Student)o;

		return gender == student.gender &&
			Objects.equals(lastName, student.lastName) &&
			Objects.equals(name, student.name);
	}

	@Override public int hashCode() {
		int result = (name != null ? name.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		return result;
	}

	@Override public String toString() {
		return "Student(name='" + name + "'" +
			", lastName='" + lastName + '\'' +
			", gender=" + gender +
			')';
	}
}
new code.Student("Pavel", "Dionisev", code.Student.Gender.M)
