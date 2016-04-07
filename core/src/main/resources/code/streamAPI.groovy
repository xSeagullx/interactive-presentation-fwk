(1..5).toList()
	.stream()
	.map({ (1..it).toList().permutations() })
	.collect { it.size() }
