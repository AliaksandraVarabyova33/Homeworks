package kotlinhw

data class Book(
    private val title: String,
    private val author: Author,
    private val year: Int
) {
    override fun toString(): String {
        return String.format("Book: author = %s, title = %s, year = %d", author, title, year)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book
        return if (title != other.title) false else author.getName() == other.author.getName() && author.getBirthYear() == other.author.getBirthYear()
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }
}