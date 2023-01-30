package utils;

public class Configuration {

    private static final String CONFIG_FILE_PATH = "config.properties";

    private Configuration() {
    }

    public static String getDefaultPassword() {
        return FileReader.getProperty(CONFIG_FILE_PATH, "password");
    }

    public static String getUrl() {
        return FileReader.getProperty(CONFIG_FILE_PATH, "baseUrl");
    }
}
