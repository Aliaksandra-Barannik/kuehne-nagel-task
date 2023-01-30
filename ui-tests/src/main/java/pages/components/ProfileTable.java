package pages.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfileTable extends Table {

    public void removeBook(String title) {
        WebElement removeIcon = getRow(title).findElement(By.xpath(".//span[contains(@id,'delete')]"));
        removeIcon.click();
    }
}
