package javahw;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public boolean isWinter() {
        return this == DECEMBER || this == JANUARY || this == FEBRUARY;
    }
}
