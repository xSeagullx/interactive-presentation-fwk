boolean stop = false

def thread2 = Thread.start {
	while(!stop)
		println("I'm running and I'm happy")
}

def thread1 = Thread.start {
	stop = true
	// do something else
}

thread1.join()
thread2.join()
