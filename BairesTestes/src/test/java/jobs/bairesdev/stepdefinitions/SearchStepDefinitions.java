package jobs.bairesdev.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jobs.bairesdev.Hooks;
import jobs.bairesdev.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SearchStepDefinitions {
    WebDriver driver = Hooks.getDriver();
    HomePage home = new HomePage();
    String staticURL = "https://jobs.bairesdev.com/";
    String staticKeyword = "QA";
    List<String> listJobsScenario1, listJobsScenario2, listJobsScenario3;

    @Given("Im at {string}")
    public void were_at_home(String url){
        driver.get(url);
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("input {string} in the search field")
    public void search_input(String search){
        home.searchField(search, driver);
    }

    @Then("it should show me the job offers")
    public void show_jobs() {
        List<String> jobsList = get_jobs();
        for (String job : jobsList) {
            System.out.println(job);
        }
    }
    public List<String> get_jobs() {
        return home.returnResults(driver);
    }

    @When("click in the search field")
    public void wait_dropdown(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        home.clickSearchField(driver);
    }

    @And("click the {string} dropdown item")
    public void click_dropdown(String keyword){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        home.clickKeyword(driver, keyword);
    }

    @And("the number of offers in the {string} scenario")
    public void printTheOffers(String scenario) {
        System.out.println("The total of offers in the " + scenario + " scenario is: " + number_of_offers());
        System.out.println("---------------------------");
    }

    public String number_of_offers() {
        return home.showTheNumberOfOffers(driver);
    }

    @Given("the job offers shown with the search field")
    public void Scenario2(){
        were_at_home(staticURL);
        home.searchField(staticKeyword, driver);
    }

    @When("click in the search field and the {string} dropdown item")
    public void Scenario1(String keyword){
        home.clickSearchField(driver);
        wait_dropdown();
        click_dropdown(keyword);
    }

    @Given("that we have a different number of offers for each scenario")
    public void sameResutls() {
        List<Integer> results = Arrays.asList(resultsOfScenario1(), resultsOfScenario2(), resultsOfScenario3());
//      It would return 1 if all elements were equal
        assertTrue((results.stream().distinct().count() != 1));
    }
        public Integer resultsOfScenario1() {
            driver.get(staticURL);
            Scenario1(staticKeyword);
            printTheOffers("first");
            listJobsScenario1 = get_jobs();
            return Integer.valueOf(number_of_offers());
        }
    public Integer resultsOfScenario2() {
        were_at_home(staticURL);
        home.searchField(staticKeyword, driver);
        printTheOffers("second");
        listJobsScenario2 = get_jobs();
        return Integer.valueOf(number_of_offers());
    }
        public Integer resultsOfScenario3() {
            Scenario2();
            Scenario1(staticKeyword);
            printTheOffers("third");
            listJobsScenario3 = get_jobs();
            return Integer.valueOf(number_of_offers());
        }

    @And("the results contain the same offers within different subsets")
    public void listContains(){
        assertTrue(listJobsScenario1.containsAll(listJobsScenario2));
        assertTrue(listJobsScenario1.containsAll(listJobsScenario3));
        assertTrue(listJobsScenario2.containsAll(listJobsScenario3));

    }

    @Then ("these are the offers left behind from the first to the second")
    public void differencesFirstToSecond(){
        System.out.println();
        List<String> leftBehind = home.getDifferences(listJobsScenario1,listJobsScenario2);
        System.out.println("The difference between Scenarios 1 (Dropdown) and 2 (Search) are: " + leftBehind.size() +" offers");
        System.out.println("---------------------------");
        System.out.println("Here we can see that a job without \"QA\" in its title, the offer will not appear in the second scenario");
        System.out.println("---------------------------");
        Collections.sort(leftBehind);
        for (String job : leftBehind) {
            System.out.println(job);
        }

    }
    @And ("these are the offers left behind from the second to the third")
    public void differencesSecondtoThird(){
        System.out.println();
        List<String> leftBehind = home.getDifferences(listJobsScenario2,listJobsScenario3);
        System.out.println("The difference between Scenarios 2 (Search) and 3 (Search+DropdownItem) are: " + leftBehind.size() +" offers");
        System.out.println("---------------------------");
        System.out.println("Why they were excluded considering that the Scenario 1 (DropdownItem) \n" +
                " is actually more inclusive than the Scenario 2 (Search)?");
        System.out.println("---------------------------");
        Collections.sort(leftBehind);
        for (String job : leftBehind) {
            System.out.println(job);
        }
    }

    @And("I am still at {string}")
    public void stillAt(String url){
        assertTrue(driver.getCurrentUrl().contains(url));
    }

}
