@groovy.transform.Canonical class Student {
	String name
	String prepareQuestion() { "$name's question" }
}

def students = [new Student("Саша"), new Student("Даша"), new Student("Кеша")]
def questions = []
students.each { student ->
	Thread.start { questions.add(student.prepareQuestion()) }
}

sleep(1000)
for (question in questions) println(question)
