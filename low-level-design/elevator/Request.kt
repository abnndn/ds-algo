package elevator

data class Request(
    val floor: Int,
    val type: RequestType
)