package objects;

import com.opencsv.bean.CsvBindByName;

public class CsvObj {
    @CsvBindByName
    private String key;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
