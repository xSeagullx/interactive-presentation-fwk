//@groovy.transform.TailRecursive
def blowStack(it) {
	if (it >= 10_000) it else blowStack(it + 1)
}

blowStack(1)
