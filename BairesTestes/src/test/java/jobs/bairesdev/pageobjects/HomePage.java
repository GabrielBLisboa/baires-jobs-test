package jobs.bairesdev.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class HomePage {

    String searchBoxPath = "/html/body/div/div/div/main/section[2]/div/div[1]/div/form/input";
    String totalOffersSelector = "#__layout > div > main > section.section-jobops.relative.mt-16.md\\:mb-20.mb-16 > div > div.paginator-wrapper > div > div.hidden.sm\\:flex-1.sm\\:flex.sm\\:items-center.sm\\:justify-between > div:nth-child(1) > p > span:nth-child(3)";
    String nextPageSelector = "/html/body/div/div/div/main/section[2]/div/div[18]/div/div[2]/div[2]/nav/a[2]";


    String dropdownKeyword = "";
    String totalOffers;
    WebElement searchBox;
    List<WebElement> listResults;


    public void searchField(String search, WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        searchBox =  driver.findElement(By.xpath(searchBoxPath));
        searchBox.sendKeys(search.toLowerCase(Locale.ROOT));
        searchBox.sendKeys(Keys.RETURN);
    }

    public void clickSearchField(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        searchBox =  driver.findElement(By.xpath(searchBoxPath));
        searchBox.click();
    }

    public void clickKeyword(WebDriver driver, String keyword){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       List<WebElement> dropdownKeywords = driver.findElements(By.className("v-list-item__title"));
       for (WebElement item : dropdownKeywords){
           if (item.getText().contains(keyword)){
               item.click();
           }
       }
    }

    public List<String> returnResults(WebDriver driver){
        WebElement botaoNext = driver.findElement(By.xpath(nextPageSelector));
        listResults = driver.findElements(By.tagName("h4"));
        List<String> listText = new ArrayList<>();
        for (WebElement item : listResults){
            listText.add(item.getText());
        }
        String classeBotao = String.valueOf(botaoNext.getAttribute("class"));
         while (!classeBotao.contains("cursor-not-allowed")) {
             botaoNext.click();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
             listResults = driver.findElements(By.tagName("h4"));
             for (WebElement item : listResults){
                 listText.add(item.getText());
             }
             classeBotao = String.valueOf(botaoNext.getAttribute("class"));
         };
            return listText;
        }

        public List<String> getDifferences(List<String> biggerList, List<String> smallerList){
            List<String> leftBehind = biggerList.stream()
                    .filter(element -> !smallerList.contains(element))
                    .collect(Collectors.toList());
        return leftBehind;
        }
    public List<String> getSame(List<String> biggerList, List<String> smallerList){
        List<String> equals = biggerList.stream()
                .filter(smallerList::contains)
                .collect(Collectors.toList());
        return equals;
    }

    public String showTheNumberOfOffers (WebDriver driver){
        return driver.findElement(By.cssSelector(totalOffersSelector)).getText();
    }
}
