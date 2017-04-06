import groovy.transform.Canonical

@Canonical
class ScottishPerson {
	String name
	int born
}

def maxwell = new ScottishPerson("J.C.Maxwell", 1831)
def rowling = new ScottishPerson("J.K.Rowling", 1965)

ScottishPerson oldest(ScottishPerson a, ScottishPerson b) {
	synchronized (a) {
		println("$a is locked")
		sleep(100)
		synchronized (b) {
			return a.born < b.born ? a : b
		}
	}
}

int ageDifference(ScottishPerson a, ScottishPerson b) {
	synchronized (a) {
		println("$a is locked")
		sleep(100)
		synchronized (b) {
			return Math.abs(a.born - b.born)
		}
	}
}

def t1 = Thread.start {
	println("Oldest is " + oldest(maxwell, rowling))
}

def t2 = Thread.start {
	println("Age difference: " + ageDifference(maxwell, rowling))
}

t1.join()
t2.join()

println("Done")
