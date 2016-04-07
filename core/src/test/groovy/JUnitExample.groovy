import org.junit.Test
import static org.junit.Assert.*

class JUnitExample {
	@Test void "expres    siv eness"() {
		def var = false
		assertNotNull(null)
		assert "Hello".bytes == "hello".bytes
		assertArrayEquals("Hello".bytes, "hello".bytes)
		assert var == true
		assertTrue(var)
		assertFalse(!var)
	} 
}
