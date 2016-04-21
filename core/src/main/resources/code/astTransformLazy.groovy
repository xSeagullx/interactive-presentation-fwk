class LazyField {
	//@Lazy
	int answer = { 
		sleep(1000)
		42
	}()
}

def bench = {
	def start = System.currentTimeMillis()
	it()
	println(System.currentTimeMillis() - start)
}

def field
bench { field = new LazyField() }
bench { field.answer }
