### A simple project testing search methods at https://jobs.bairesdev.com/

Given that we have two methods to find job offers:

	a) click in the search box, wait for the dropdown list and then click in a job title/keyword
	
	b) manually type the search term in the searchbox and then Enter

It seams that they should return the same results, for example, by clicking the "QA/Testing" dropdwon item or using "QA" as the search term. 
But the the second method show less jobs offers than the first.

And if we do the search first and then click the same term shown in the dropdown item, even less offers are shown.

The reports with the tests results can be found at "target/cucumber-reports/:

	- As a static html Cucumber Report
	
	- As files exported by IntelliJ like "Test Results - Feature__search.html"

### Framework: JUnit5 + Cucumber + Selenium WebDriver + Maven
