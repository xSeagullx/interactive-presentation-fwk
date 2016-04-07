String var = null // "value"
if (var)
	println("var is $var")
else
	println("var is ${ var == null ? "null" : "empty" }")

