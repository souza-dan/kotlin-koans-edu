import kotlinx.coroutines.*
import org.junit.Test
import org.junit.Assert.*

class Tests {
    @Test
    fun testCoroutineScopeForStructuredConcurrency() = runBlocking {
        val processedItems = mutableListOf<String>()
        processItems(processedItems)
        // This assertion fails because the list is empty when the function returns
        assertEquals("Should have processed 2 items.", 2, processedItems.size)
        assertEquals(listOf("Item A processed", "Item B processed"), processedItems.sorted())
    }
}