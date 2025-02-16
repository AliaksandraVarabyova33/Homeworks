package library_task;

import library_task.books.EBook;
import library_task.books.PhysicalBook;
import library_task.library.Library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        EBook book1 = new EBook("Муму", 2012, "Тургенев", 150, "fb2");
        PhysicalBook book2 = new PhysicalBook("Atomic Kotlin", 2020, "Bruce Eckel", 525);
        lib.addBook(book1);
        lib.addBook(book2);
        lib.displayBooks();
    }
}
