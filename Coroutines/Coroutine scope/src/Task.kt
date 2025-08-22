import kotlinx.coroutines.*

suspend fun processItems(items: MutableList<String>) {
    // TODO: Replace GlobalScope.launch with coroutineScope
    GlobalScope.launch {
        delay(200)
        items.add("Item B processed")
    }
    GlobalScope.launch {
        delay(100)
        items.add("Item A processed")
    }
    delay(50) // A small delay to make the race condition more likely to fail the test
}