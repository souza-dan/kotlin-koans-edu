import kotlinx.coroutines.*
import org.junit.Test
import org.junit.Assert.*

class Tests {
    @Test
    fun testDispatchersForContextSwitching() = runBlocking {
        val threadNames = mutableListOf<String>()
        performCpuAndIoWork(threadNames)

        println("Threads used for work: $threadNames")
        assertTrue("CPU work should run on Dispatchers.Default", 
                   threadNames[0].contains("DefaultDispatcher") || threadNames[0].contains("Default"))
        assertTrue("I/O work should run on Dispatchers.IO", 
                   threadNames[1].contains("DefaultDispatcher") || threadNames[1].contains("IO"))
    }
}