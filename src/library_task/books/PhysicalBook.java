package library_task.books;

public class PhysicalBook implements Book {
    private String title;
    private int year;
    private String author;
    private int pagesNumber;

    public PhysicalBook(String title, int year, String author, int pagesNumber) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Physical Book %s: author = %s, year = %d, this book has %d pages%n", title, author, year, pagesNumber);
    }
}
