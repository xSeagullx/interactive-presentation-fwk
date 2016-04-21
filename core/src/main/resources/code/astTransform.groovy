import groovy.util.logging.Log

@Log @Singleton
class Neo {
	void dodgeThis(List bullets) { log.warning("Hahahahaha!") }
}

def chosenOne = Neo.instance
chosenOne.dodgeThis([])
