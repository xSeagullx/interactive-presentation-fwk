class CallTest {
	def foo(Map map, String arg, Closure last) {
		println("$map $arg ${ last() }")
	}
}
new CallTest().foo(i_am_key: 1, "I'm arg", i_am_key_2: 2) { "I'm a closure" }
