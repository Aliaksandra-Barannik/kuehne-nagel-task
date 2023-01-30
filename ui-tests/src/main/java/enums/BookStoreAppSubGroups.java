package enums;

public enum BookStoreAppSubGroups {
    LOGIN("Login"),
    BOOK_STORE("Book Store"),
    PROFILE("Profile"),
    BOOK_STORE_API("Book Store Api");

    private String name;

    BookStoreAppSubGroups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
