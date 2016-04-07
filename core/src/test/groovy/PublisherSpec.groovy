import spock.lang.Specification

class Publisher {
	List<Subscriber> subscribers = []
	void send(String message) {
		subscribers*.receive("Hey $message!")
	}
}

interface Subscriber {
	void receive(String message)
}

class PublisherSpec extends Specification {
	Publisher publisher = new Publisher()
	Subscriber subscriber = Mock()
	Subscriber subscriber2 = Mock()

	def setup() {
		publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
		publisher.subscribers << subscriber2
	}

	def "should send messages to all subscribers"() {
		when:
			publisher.send("Jude")

		then:
			1 * subscriber.receive("Hey Jude!")
			1 * subscriber2.receive("Hey Jude!")
	}
}
