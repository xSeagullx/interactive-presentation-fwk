class Student {
	enum Gender {
		M, F
	}

	String name
	String lastName
	Gender gender

	Student(String name, String lastName, Gender gender) {
		this.name = name
		this.lastName = lastName
		this.gender = gender
	}

	@Override boolean equals(o) {
		if (this.is(o)) return true
		if (getClass() != o.getClass()) return false

		code.Student student = (code.Student) o

		gender == student.gender &&
			name == student.name &&
			lastName == student.lastName
	}

	@Override int hashCode() {
		int result = name?.hashCode() ?: 0
		result = 31 * result + (lastName?.hashCode() ?: 0)
		result = 31 * result + (gender?.hashCode() ?: 0)
		result
	}

	@Override String toString() {
		"Student(name='$name', lastName='$lastName', gender=$gender)"
	}
}
new code.Student("Pavel", "Dionisev", code.Student.Gender.M)
