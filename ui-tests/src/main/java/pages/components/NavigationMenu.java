package pages.components;


import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class NavigationMenu extends Page {

    @FindBy(xpath = "//div[@class='element-group']")
    List<WebElement> groups;

    public void openTab(String groupTab, String subGroupTab) {
        for (WebElement group : groups) {
            String groupHeader = group.findElement(By.xpath(".//span[@class='group-header']")).getText()
                    .replace("\n ", StringUtils.EMPTY);
            if (groupHeader.equals(groupTab)) {
                String attribute = group.findElement(By.xpath(".//div[contains(@class,'list')]")).getAttribute("class");

                if (!attribute.contains("show")) {
                    group.click();
                }

                List<WebElement> subGroups = group.findElements(By.xpath(".//li//span"));
                List<WebElement> subGroupWithSpecificHeaderList = subGroups.stream()
                        .filter(elt -> elt.getText().equals(subGroupTab))
                        .collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(subGroupWithSpecificHeaderList)) {
                    click(subGroupWithSpecificHeaderList.get(0));
                }
            }
        }
    }
}
