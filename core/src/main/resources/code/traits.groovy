trait ATrait {
	String field = "field"
	String exec() { 'A' }
}
trait BTrait { String exec() { 'B' } }

class C implements ATrait, BTrait {
	//String exec() { ATrait.super.exec() }
}
def c = new C()
println(c.exec())
println(c.field)
