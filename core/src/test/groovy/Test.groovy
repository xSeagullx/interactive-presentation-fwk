import groovy.transform.Canonical

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

public class Test implements Runnable
{
	public void run()
	{
		'thread intro'()
		'thread example'()
		completableFuture()
	}

	private static void 'thread example'()
	{
// TODO add a setting here (Making Coffee?)
		// Do pre action
		println("Prepare")
		def task = Thread.start {
			// do something time consuming
			println("Start")
			sleep(1000)
			println("End")
		}
		// Do something else
		println("!")
		task.join() // Wait for coffee.
		println("?")
	}

	def "Thread Pool Example"() {
		def pool = Executors.newFixedThreadPool(8)
		pool.submit { println("Task 1 ${ Thread.currentThread().name }") }
		pool.submit { println("Task 2 ${ Thread.currentThread().name }") }
		pool.shutdown()
	}

	def completableFuture() {
		CompletableFuture.runAsync { println("boil water") }.thenRun { println("brew coffee") }.thenAccept { println("Coffe is here") }
		new URL("http://ais-grid-2016.jinr.ru/img/logo.gif").bytes
	}

//	def akkaExample() {
//		ActorSystem.()
//	}
}
