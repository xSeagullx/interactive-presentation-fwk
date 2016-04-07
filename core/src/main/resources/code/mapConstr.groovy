import groovy.transform.ToString

@ToString(includeNames = true)
class Person {
	String name
	int age
}

println(new Person())
println(new Person(name: "Pavel", age: 22))
