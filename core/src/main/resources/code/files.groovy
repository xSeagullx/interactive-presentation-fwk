new File('.').listFiles().grep { it.name.endsWith(".iml") }
println("${ new File('.').listFiles().find { it.file && it.name.contains("gradlew") }?.size() / 1024 } KB.")
new File('gradle').eachFileRecurse {
	println(it.name)
}
