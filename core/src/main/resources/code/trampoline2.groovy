def blowStack
blowStack = { if (it < 10_000) blowStack.trampoline (it + 1) else it }.trampoline()

blowStack(1)
