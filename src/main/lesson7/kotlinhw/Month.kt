package kotlinhw

enum class Month(val isWinterMonth: Boolean) {
    JANUARY(true),
    FEBRUARY(true),
    MARCH(false),
    APRIL(false),
    MAY(false),
    JUNE(false),
    JULY(false),
    AUGUST(false),
    SEPTEMBER(false),
    OCTOBER(false),
    NOVEMBER(false),
    DECEMBER(true);

    fun isWinter() = isWinterMonth
}