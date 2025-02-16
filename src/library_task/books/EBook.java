package library_task.books;

public class EBook implements Book {
    private String title;
    private String author;
    private int year;
    private int pagesNumber;
    private String fileFormat;

    public EBook(String title, int year, String author, int pagesNumber, String fileFormat) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.pagesNumber = pagesNumber;
        this.fileFormat = fileFormat;
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
        System.out.printf("EBook %s: author = %s, year = %d, file format = %s, this book has %d pages%n", title, author, year, fileFormat, pagesNumber);
    }
}
