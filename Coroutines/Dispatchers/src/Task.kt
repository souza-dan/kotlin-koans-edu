import kotlinx.coroutines.*

suspend fun performCpuAndIoWork(threadLog: MutableList<String>) {
    // TODO: Wrap this block with `withContext(Dispatchers.Default)`
    // This block simulates a CPU-intensive task
    threadLog.add(Thread.currentThread().name)
    val result = (1..1_000_000).fold(0L) { acc, i -> acc + i } // heavy calculation

    // TODO: Wrap this block with `withContext(Dispatchers.IO)`
    // This block simulates a blocking I/O operation
    threadLog.add(Thread.currentThread().name)
    delay(100) // Simulating network or file delay
}