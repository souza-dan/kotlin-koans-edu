## Async and await

When you have multiple independent suspending operations that can be performed concurrently, you can use `async` and `await` to run them in parallel instead of sequentially.

The `async` function starts a coroutine and returns a `Deferred` object. You can call `await()` on the `Deferred` to get the result. The key benefit is that multiple `async` calls can run concurrently.

### Sequential vs Concurrent

```kotlin
// Sequential - takes ~2 seconds
suspend fun sequential() {
    val result1 = fetchData1() // 1 second
    val result2 = fetchData2() // 1 second
    return result1 + result2
}

// Concurrent - takes ~1 second  
suspend fun concurrent() {
    val deferred1 = async { fetchData1() } // start immediately
    val deferred2 = async { fetchData2() } // start immediately
    return deferred1.await() + deferred2.await() // wait for both
}
```

### Task

Currently, the `fetchUserDataAndPermissions` function is too slow because it waits for the first network call to complete before starting the second one.

Modify the function to use `async` to start both `fetchUserData` and `fetchPermissions` concurrently. Then use `await` to get their results and combine them.

The total execution time should be roughly the time of the longest call (~1 second), not the sum of both (~2 seconds).

<div class="hint">
Use `async { fetchUserData(userId) }` and `async { fetchPermissions(userId) }` to start both operations concurrently, then call `.await()` on both deferred objects to get the results.
</div>