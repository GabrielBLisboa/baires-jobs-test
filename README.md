### Testing search methods at https://jobs.bairesdev.com/

Given that we have two methods to find job offers:

	a) click in the search box, wait for the dropdown list and then click in a job title/keyword
	
	b) manually type the search term in the search box and then Enter

I inferred that they would return the same results, for example, by clicking the "QA/Testing" drop-down item or using "QA" as the search term. 
But the second method shows fewer job offers than the first.

If we combine the two methods, do the search first and then click the same term shown in the dropdown item, we got a another result.

The reports with the tests results can be found at https://github.com/GabrielBLisboa/baires-jobs-test/tree/main/BairesTestes/target/cucumber-reports

	- As a static html Cucumber Report
	
	- As files exported by IntelliJ like "Test Results - Feature__search.html"

### Framework: JUnit5 + Cucumber + Selenium WebDriver + Maven
