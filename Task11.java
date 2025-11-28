public class Task11 {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Smith", 2021, 39.99);
        Book book2 = new Book("Python Basics", "Jane Doe", 2020, 29.99);
        Book book3 = new Book("C++ Essentials", "Michael Johnson", 2019, 49.99);
        
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
    }
}

class Book {
    private static int bookCount = 0;
    private int id;
    public String title;
    public String author;
    public int yearPublished;
    public double price;

    Book(String title, String author, int yearPublished, double price) {

        bookCount++;
        this.id = bookCount;

        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book " + this.id + ": " + "\nTitle: \"" + this.title + "\"\nAuthor: \"" + author + "\"\nYear Published: " + yearPublished + "\nPrice: " + "$" + price + "\n";
    }
}
