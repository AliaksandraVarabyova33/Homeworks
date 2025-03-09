package tasks

//Напишите расширение для типа Int, которое возвращает true, если число четное, и false, если нечетное.

fun main() {
    val a = 4
    val b = 5
    println(a.checkIfEven())
    println(b.checkIfEven())
}

fun Int.checkIfEven(): Boolean {
    return if (this % 2 == 0)
        true
    else false
}