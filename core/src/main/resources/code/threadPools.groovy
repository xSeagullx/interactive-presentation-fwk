import java.util.concurrent.Callable
import java.util.concurrent.Executors

@groovy.transform.Canonical class Student {
	String name
	String prepareQuestion() { "$name's question" }
}

def students = [new Student("Anna"), new Student("John"), new Student("Henry")]
List<Callable<String>> tasks = students.collect { student ->
	new Callable<String>() {
		@Override String call() {
			student.prepareQuestion()
		}
	}
}

def questions = Executors.newFixedThreadPool(8).invokeAll(tasks).collect { it.get() }

for (question in questions) println(question)
