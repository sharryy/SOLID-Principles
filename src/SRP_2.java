public class SRP_2 {
    public static void main(String[] args) {
        Book book = new Book("lorem", "ipsum", "color", "met", true);
        Book book2 = new Book("lorem", "ipsum", "color", "met", false);
        book.downloadBook(book);
        book2.printPage(book2, new PrintXMLOutput());
    }
}

class Book {
    private String title;
    private String author;
    private String ISBN;
    private String page;
    public DownloadBook downloadAndPersistBook;

    public Book(String title, String author, String ISBN, String page) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.page = page;
    }

    public Book(String title, String author, String ISBN, String page, boolean downloadBook) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.page = page;
        if (downloadBook)
            this.downloadAndPersistBook = new DownloadBook();
    }

    public void downloadBook(Book book) {
        this.downloadAndPersistBook.download(book);
    }

    public void printPage(Book book, IPrintBook print) {
        print.printBook(book);
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

class DownloadBook {
    public String download(Book book) {
         /*
        Code to download book from web
        and then persist it in local storage
        using some sort of file handling or DB.
         */
        return "Book Downloaded and Saved Locally";
    }
}

interface IPrintBook {
    Object printBook(Book book);
}

class PrintHTMLOutput implements IPrintBook {

    @Override
    public Object printBook(Book book) {
        /*
        Use some third-party software to print
        whole book or individual pages.
         */
        return "HTML OUTPUT PRINTED";
    }
}

class PrintXMLOutput implements IPrintBook {

    @Override
    public Object printBook(Book book) {
        /*
        Use some third-party software to print
        whole book or individual pages.
         */
        return "XML OUTPUT PRINTED";
    }
}

