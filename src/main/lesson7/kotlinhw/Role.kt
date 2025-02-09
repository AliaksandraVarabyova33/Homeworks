package kotlinhw

enum class Role(val token: String) {

    ADMIN("1cvn_admin_token"),
    MODERATOR("3cvm_mod_token"),
    USER("2cvn_admin_token");

    fun customEquals(other: Any?): Boolean {
        if (this == other) return true
        if (javaClass != other?.javaClass) return false

        other as Role
        return token == other.token
    }
}