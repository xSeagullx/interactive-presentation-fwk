def stat = [:].withDefault { 0 }
def fib
fib = { n ->
	stat[n]++ // Count call count.
	n == 1 || n == 2 ? 1 : fib(n - 1) + fib(n - 2)
}//.memoize()

fib(5)

// Print Stats
println "Call statistics"
println(stat.collect { "\tfib($it.key): $it.value" }.join("\n"))
