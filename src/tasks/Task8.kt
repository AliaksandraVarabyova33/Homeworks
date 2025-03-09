package tasks

//Создайте расширение для типа String, которое возвращает количество гласных в строке.

fun main() {
    print("Hi Earth".countVowels())
}

fun String.countVowels(): Int {
    return this.lowercase().count { it in "aeiouy" }
}