package utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import objects.CsvObj;

public class FileReader {

    public static String getProperty(String file, String propertyName) {
        return getProperties(file).get(propertyName);
    }

    public static Map<String, String> getProperties(String file) {
        Properties prop = new Properties();
        Map<String, String> properties = new HashMap<>();
        InputStream stream = null;
        try {
            stream = FileReader.class.getClassLoader().getResourceAsStream(file);
            if (stream != null) {
                prop.load(new InputStreamReader(stream, StandardCharsets.UTF_8));
                Enumeration<Object> keyValues = prop.keys();

                while (keyValues.hasMoreElements()) {
                    String key = (String) keyValues.nextElement();
                    String value = prop.getProperty(key);
                    properties.put(key, System.getProperty(key, value));
                }
            } else {
                throw new FileNotFoundException("Property file '" + file + "' is not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    public static <T extends CsvObj> T getObjectFromCsvFile(String key, String filePath, Class<T> clazz) {
        List<T> objectList = getObjectsFromScvFile(filePath, clazz);
        List<T> actualObjectList = objectList.stream().filter(obj -> obj.getKey().equals(key)).collect(Collectors.toList());
        return actualObjectList.get(0);
    }

    public static <T extends CsvObj> List<T> getObjectsFromScvFile(String filePath, Class<T> clazz) {
        List<T> csvUsers = new ArrayList<>();
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("objectdata/" + filePath).toURI());
            try (Reader reader = Files.newBufferedReader(path)) {
                CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(clazz)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                csvUsers = csvToBean.parse();
            }
        } catch (URISyntaxException | IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return csvUsers;
    }
}
