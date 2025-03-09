package tasks

//Используя sequenceOf, создайте последовательность, содержащую квадратные числа от 1 до 5.

fun main(){
    sequenceOf(1, 2, 3, 4, 5)
        .map {it * it}
        .forEach { print("$it ") }
}