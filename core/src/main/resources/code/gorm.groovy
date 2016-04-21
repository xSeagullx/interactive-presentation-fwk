class User {
	String name
	int age
	boolean active
}

new User(name: "Pavel", age: 23).save()

User.get(1) // fetch by ID
User.findAllByName("Pavel") // Query
User.findAllByAgeBetween(1, 2) // 2 arg criteria
User.findAllByActive() // 0 arg criteria
User.findAllByAgeBetweenAndNameLike(1, 2, '%ave%') // Complex criteria
