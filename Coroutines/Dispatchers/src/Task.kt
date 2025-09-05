import kotlinx.coroutines.*

suspend fun performCpuAndIoWork(threadLog: MutableList<String>) {
    // TODO: Wrap this block with `withContext(Dispatchers.Default)`
    val result = simulateCpuIntensiveTask(threadLog)

    // TODO: Wrap this block with `withContext(Dispatchers.IO)`
    simulateBlockingIoOperation(threadLog)
}

suspend fun simulateBlockingIoOperation(threadLog: MutableList<String>) {
    threadLog.add(Thread.currentThread().name)
    delay(100) // Simulating network or file delay
}

suspend fun simulateCpuIntensiveTask(threadLog: MutableList<String>): Long {
    threadLog.add(Thread.currentThread().name)
    return (1..1_000_000).fold(0L) { acc, i -> acc + i }
}
