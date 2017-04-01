@groovy.transform.Canonical class Student {
	String name
	String prepareQuestion() { "$name's question" }
}

def students = [new Student("Anna"), new Student("John"), new Student("Henry")]
def questions = []
students.each { student ->
	Thread.start { questions.add(student.prepareQuestion()) }
}

sleep(1000)
for (question in questions) println(question)
