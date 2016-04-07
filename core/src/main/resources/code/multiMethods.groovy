class MultiMethod {
	def foo(Object a) { "Call foo as Object" }
	def foo(String a) { "Call foo as String" }
}

def multiMethod = new MultiMethod()
println multiMethod.foo("hello")
println multiMethod.foo(5)
println()

//["hello", 5].each { Object it ->
//	println multiMethod.foo(it)
//}
