@SearchEngine
Feature: Search Engine
    As visitor you should be able to:
      - Find jobs with entering a word through the search field
      - Find jobs with keywords suggested after clicking the search field
    The results have to be the same with the two methods

  @Scenario1
  @Smoke
  Scenario: find jobs with the suggested keywords
    Given Im at "https://jobs.bairesdev.com/"
    When click in the search field
    And click the "QA" dropdown item
    Then it should show me the job offers
    And the number of offers in the "first" scenario

  @Scenario2
  @Smoke
  Scenario: find jobs using the search field
    Given Im at "https://jobs.bairesdev.com/"
    When input "QA" in the search field
    Then it should show me the job offers
    And the number of offers in the "second" scenario
    And I am still at "https://jobs.bairesdev.com/"

  @Scenario3
  @Smoke
  Scenario: click the suggest keyword after using the search field
    Given the job offers shown with the search field
    When click in the search field and the "QA" dropdown item
    Then it should show me the job offers
    And the number of offers in the "third" scenario

  @ExpectResults
  @Regression
  Scenario: the Scenarios should return the same offers
    Given that we have a different number of offers for each scenario
    And the results contain the same offers within different subsets
    Then these are the offers left behind from the first to the second
    And these are the offers left behind from the second to the third