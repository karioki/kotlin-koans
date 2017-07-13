package iv_properties

import util.TODO

class LazyProperty(val initializer: () -> Int) {

    private var _lazy: Int = -1
    private var inited = false

    val lazy: Int
        get() {
//            if (_lazy == -1)
//                _lazy = initializer()
//            return _lazy
            if (inited == true) {
                return _lazy
            }
            inited = true
            _lazy = initializer()
            return _lazy;
        }
}

fun todoTask33(): Nothing = TODO(
        """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties yet!
    """,
        references = { LazyProperty({ 42 }).lazy }
)
