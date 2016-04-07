@Singleton
class Neo {
	void dodgeThis(List bullets) { println("Hahahahaha!") }
}

def chousenOne = Neo.instance
chousenOne.dodgeThis([])
