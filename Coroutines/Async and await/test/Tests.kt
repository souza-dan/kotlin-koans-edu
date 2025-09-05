import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import org.junit.Test
import org.junit.Assert.*

class Tests {
    @Test
    fun testAsyncAwaitForConcurrency() = runBlocking {
        val time = measureTimeMillis {
            val result = fetchUserDataAndPermissions("user-id-42")
            assertEquals("User(user-id-42), Permissions(Admin)", result)
        }
        println("testAsyncAwaitForConcurrency completed in $time ms")
        assertTrue("Execution should take ~1 second, not 2 seconds! Actual: ${time}ms", 
                   time in 900..1500)
    }
}