def sum = { a, b -> a + b }
def sub = { a, b -> a - b }
println("1 + 2 = " + sum(1, 2))
println("3 - 1 = " + sub(3, 1))

def calc = { a, b, op -> op(a, b) }
calc(4, 15, sub)
