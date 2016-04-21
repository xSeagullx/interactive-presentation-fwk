square_root = { Math.sqrt(it) }
sum = { a, b -> a + b }

def show(action) {
	new Object() {
		def of(def ... args) { println(action(*args)) }
	}
}

// equivalent to: show(square_root).of(100)
show square_root of 100
// equivalent to: show(sum).of(13, 42)
show sum of 13, 42
