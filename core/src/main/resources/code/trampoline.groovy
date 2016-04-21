def blowStack
// BTW, can you see it?
blowStack = { it >= 10_000 ? it : blowStack(it + 1) }

blowStack(1)
