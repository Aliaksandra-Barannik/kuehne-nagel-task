package dto;

import static dto.Constants.TIME_FORMAT_PATTERN;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.util.Objects;

public class BookDto {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT_PATTERN, timezone = "UTC")
    private Instant publish_date;
    private String publisher;
    private int pages;
    private String description;
    private String website;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getPublishDate() {
        return publish_date;
    }

    public void setPublishDate(Instant publishDate) {
        this.publish_date = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookDto bookDto = (BookDto) o;
        return pages == bookDto.pages &&
                Objects.equals(isbn, bookDto.isbn) &&
                Objects.equals(title, bookDto.title) &&
                Objects.equals(subTitle, bookDto.subTitle) &&
                Objects.equals(author, bookDto.author) &&
                Objects.equals(publisher, bookDto.publisher) &&
                Objects.equals(description, bookDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subTitle, author, publisher, pages, description);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private BookDto bookDto = new BookDto();

        public Builder withIsbn(String isbn) {
            bookDto.isbn = isbn;
            return this;
        }

        public Builder withTitle(String title) {
            bookDto.title = title;
            return this;
        }

        public Builder withSubTitle(String subTitle) {
            bookDto.subTitle = subTitle;
            return this;
        }

        public Builder withAuthor(String author) {
            bookDto.author = author;
            return this;
        }

        public Builder withPublisher(String publisher) {
            bookDto.publisher = publisher;
            return this;
        }

        public Builder withPages(int pages) {
            bookDto.pages = pages;
            return this;
        }

        public Builder withDescription(String description) {
            bookDto.description = description;
            return this;
        }

        public Builder withWebsite(String website) {
            bookDto.website = website;
            return this;
        }

        public Builder withWebsite(Instant publish_date) {
            bookDto.publish_date = publish_date;
            return this;
        }

        public BookDto build() {
            return bookDto;
        }
    }
}
