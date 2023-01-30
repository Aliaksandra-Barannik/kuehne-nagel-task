package enums;

public enum Columns {
    IMAGE("Image"),
    TITLE("Title"),
    AUTHOR("Author"),
    PUBLISHER("Publisher"),
    ACTION("Action");

    private String value;

    Columns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
