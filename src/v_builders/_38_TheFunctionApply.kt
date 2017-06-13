package v_builders.examples

fun todoTask38(): Nothing = TODO(
        """
        Task 38.
        The previous examples can be rewritten with the library function 'apply' (see examples below).
        Write your own implementation of the function 'apply' named 'myApply'.
    """
)

fun <T> T.myApply(f: T.() -> Unit): T {
    return apply(f)
}

fun buildString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun buildMap(): Map<Int, String> {
    return hashMapOf<Int, String>().apply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun str(): List<Int> {
    return mutableListOf(1,2,3).apply { add(4) }
}