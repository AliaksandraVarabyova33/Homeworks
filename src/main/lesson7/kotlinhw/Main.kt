package kotlinhw

fun main() {
    //task2/month enum test
    Month.entries.forEach { month -> println("Is ${month.name} winter month? - ${month.isWinter()}") }

    //task1/3 check
    val a1 = Author("Sasha", 1992)
    val a2 = Author("Sasha", 1992)
    val b1 = Book("test", a1, 2001)
    val b2 = Book("test", a2, 2005)
    println(b1 == b2);

    //task4 check
    val businessUser = Role.USER
    val developer = Role.ADMIN
    val tester = Role.ADMIN
    println(businessUser.customEquals(developer))
    println(tester.customEquals(developer))
}