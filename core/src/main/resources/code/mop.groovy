class A {
	void methodMissing(String name, args) { 
		println(name + args)
	} 
}

new A().hello("World")
// Same for property ==> dynamic objects.
