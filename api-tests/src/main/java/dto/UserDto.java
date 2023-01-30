package dto;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private String userId;
    private String username;
    private List<BookDto> books;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(userId, userDto.userId) &&
                Objects.equals(username, userDto.username) &&
                Objects.equals(books, userDto.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, books);
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public static class Builder {

        private UserDto user = new UserDto();

        public Builder withUserId(String userId) {
            user.userId = userId;
            return this;
        }

        public Builder withUserName(String username) {
            user.username = username;
            return this;
        }

        public Builder withBooks(List<BookDto> books) {
            user.books = books;
            return this;
        }

        public UserDto build() {
            return user;
        }
    }
}
