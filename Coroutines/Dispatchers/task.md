## Dispatchers

Dispatchers in Kotlin coroutines determine what thread or threads the coroutines use for execution. Different dispatchers are optimized for different types of work:

- **Dispatchers.Default** - optimized for CPU-intensive work that uses multiple CPU cores
- **Dispatchers.IO** - optimized for I/O operations like network calls, file operations, or database queries  
- **Dispatchers.Main** - for UI operations (main thread in Android/UI frameworks)
- **Dispatchers.Unconfined** - not confined to any specific thread (rarely used)

### Switching Context with withContext

You can switch the execution context of a coroutine using `withContext`:

```kotlin
suspend fun loadUserData() {
    // Switch to IO dispatcher for network call
    val userData = withContext(Dispatchers.IO) {
        fetchFromNetwork() // runs on IO thread pool
    }
    
    // Switch to Default dispatcher for processing
    val processed = withContext(Dispatchers.Default) {
        processData(userData) // runs on Default thread pool  
    }
}
```

### Task

The `performCpuAndIoWork` function currently runs both CPU-intensive and I/O-bound tasks on the same thread. This is inefficient.

Use `withContext` to run the appropriate code on the correct dispatchers:
1. Run the CPU-bound calculation on `Dispatchers.Default`
2. Run the I/O-bound operation on `Dispatchers.IO`

<div class="hint">
Wrap the CPU calculation (the `fold` operation) with `withContext(Dispatchers.Default) { ... }` and wrap the delay operation with `withContext(Dispatchers.IO) { ... }`.
</div>