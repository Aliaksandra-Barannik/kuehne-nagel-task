package enums;

public enum NavigationGroups {
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS("Alerts, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APP("Book Store Application");

    private String name;

    NavigationGroups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
