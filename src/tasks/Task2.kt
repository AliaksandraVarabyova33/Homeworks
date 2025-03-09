package tasks

//Напишите код, который создает объект класса Book и выводит информацию о нем, используя run.

fun main() {
    Book("Atomic Kotlin", "Eckel").run {
        println(title)
        println(author)
    }
}

class Book(var title: String, val author: String)