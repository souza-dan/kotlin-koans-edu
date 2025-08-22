import kotlinx.coroutines.*

private suspend fun fetchUserData(userId: String): String {
    delay(1000) // Simulate network latency
    return "User($userId)"
}

private suspend fun fetchPermissions(userId: String): String {
    delay(1000) // Simulate network latency
    return "Permissions(Admin)"
}

suspend fun fetchUserDataAndPermissions(userId: String): String {
    // TODO: Use async/await to run both calls concurrently
    val userData = fetchUserData(userId)
    val permissions = fetchPermissions(userId)
    return "$userData, $permissions"
}