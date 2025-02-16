package kotlinhw

class Author(
    private val name: String,
    private val birthYear: Int
) {
    fun getName(): String = name

    fun getBirthYear(): Int = birthYear
    override fun toString(): String = "Author(name='$name', birthYear=$birthYear)"

}