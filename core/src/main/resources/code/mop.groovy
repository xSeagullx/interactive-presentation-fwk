class A {
	def ownProp = "own property"
	void methodMissing(String name, args) { 
		println("$name $args")
	}

	def propertyMissing(String name) { "synt-prop: $name" }
	def propertyMissing(String name, def arg) {
		println("setting $name to $arg")
	}
}

def a = new A()
a.hello("World")
println(a.hello)
println(a.ownProp)
a.world = "Vilnius"
