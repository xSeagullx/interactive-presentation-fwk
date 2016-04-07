def blowStack
blowStack = { if (it < 10_000) blowStack(it + 1) else it }

blowStack(1)
