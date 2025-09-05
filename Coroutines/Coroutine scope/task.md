## Coroutine Scope

One of the key principles of coroutines is **structured concurrency**. This means that when you start coroutines, they should have a clear parent-child relationship and the parent should wait for all children to complete.

### The Problem with GlobalScope

Using `GlobalScope.launch` is considered bad practice because:
- The launched coroutines live as long as the application
- The function that launches them returns immediately without waiting
- This is called "unstructured concurrency" and can lead to resource leaks

### The Solution: coroutineScope

The `coroutineScope` function creates a new scope and waits for all child coroutines launched within it to complete:

```kotlin
suspend fun processItems() {
    coroutineScope {
        launch { /* work 1 */ }
        launch { /* work 2 */ }
        // Function will not return until both launches complete
    }
}
```

### Task

The current `processItems` function uses `GlobalScope.launch`, which means the function returns before the background jobs finish. This is unstructured concurrency.

Modify the function to use `coroutineScope` instead. The `coroutineScope` block will suspend the function and wait for all child coroutines launched within it to complete.

<div class="hint">
Replace the `GlobalScope.launch` calls with `launch` inside a `coroutineScope { }` block. Remove the final `delay(50)` as it won't be needed.
</div>