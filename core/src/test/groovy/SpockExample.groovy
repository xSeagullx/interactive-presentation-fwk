import spock.lang.Specification
import spock.lang.Unroll

class SpockExample extends Specification {
	def fib = { n ->
		n == 1 || n == 2 ? 1 : call(n - 1) + call(n - 2)
	}

	void basics() {
		def a = fib(6)

		expect:
			a == 3
	}

	void strings() {
		def a = "Here we have a little mistaipe"

		expect:
			a == "Here we have a little mistype"
	}

	/** Data-driven */
	@Unroll("fib(#n) == #res")
	void table() {
		expect: fib(n) == res
		where: n || res
					 1 || 1
					 2 || 1 
					 3 || 2
					 4 || 32
					 5 || 5
					 6 || 8
	}
}
