def fact = { it == 0 ? 1 : call(it - 1) * it } // Self call. 
println(fact(4))
