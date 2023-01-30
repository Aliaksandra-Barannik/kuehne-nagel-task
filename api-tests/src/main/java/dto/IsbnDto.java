package dto;

import java.util.Objects;

public class IsbnDto {

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IsbnDto isbnDto = (IsbnDto) o;
        return Objects.equals(isbn, isbnDto.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "IsbnDto{" +
                "isbn='" + isbn + '\'' +
                '}';
    }

    public static class Builder {

        private IsbnDto isbnDto = new IsbnDto();

        public Builder withIsbn(String isbn) {
            isbnDto.isbn = isbn;
            return this;
        }

        public IsbnDto build() {
            return isbnDto;
        }
    }
}
