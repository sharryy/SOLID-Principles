/*
Now this example seems reasonable for small scale project.
When scope of project increases, it will result into spaghetti
code as Physical Characteristics of Book are intermingled with
formatting logic like print-book and core logic like downloading
a book. So it makes code difficult to read, understand and change.
Moreover, if there is a requirement to change printing format like
HTML or JSON or PRETTY Format , then it is difficult to modify as
all responsibilities are assigned to same class violating SINGLE-RESPONSIBILITY PRINCIPLE.
let us segregate it into classes and interfaces..
 */

public class SRP_2 {
    public static void main(String[] args) {
        Book book = new Book("lorem", "ipsum", "color", "met");
        System.out.println(book.getAuthor());
        book.downloadBook();
        book.printPage(book);
    }
}

class Book {
    private String title;
    private String author;
    private String ISBN;
    private String page;

    public Book(String title, String author, String ISBN, String page) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.page = page;
    }

    public String downloadBook() {
        /*
        Code to download book from web
        and then persist it in local storage
        using some sort of file handling or DB.
         */
        return "Book Downloaded and Saved Locally";
    }

    public Object printPage(Book book) {
        /*
        Use some third-party software to print
        whole book or individual pages.
         */
        return "PRINTED";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
