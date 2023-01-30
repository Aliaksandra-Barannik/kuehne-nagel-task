package objects;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class Book extends CsvObj {
    @CsvBindByName
    private String title;
    @CsvBindByName
    private String author;
    @CsvBindByName
    private String publisher;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }

    public String toString() {
        return "Book{title='" + this.title + '\'' + ", author='" + this.author + '\'' + ", publisher='" + this.publisher + '\'' + '}';
    }

    public static class Builder {
        private Book newBook = new Book();

        public Book.Builder withTitle(String title) {
            this.newBook.title = title;
            return this;
        }

        public Book.Builder withPublisher(String publisher) {
            this.newBook.publisher = publisher;
            return this;
        }

        public Book.Builder withAuthor(String author) {
            this.newBook.author = author;
            return this;
        }

        public Book build() {
            return this.newBook;
        }
    }

}

