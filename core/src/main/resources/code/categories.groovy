import groovy.time.TimeCategory

use(TimeCategory) {
	def someDate = new Date()
	println someDate - 3.days
	println 1.year.ago
	println((1.year + 3.month).from.now)
}
