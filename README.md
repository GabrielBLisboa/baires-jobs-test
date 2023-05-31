## A simple project testing the methods of searching for jobs at https://jobs.bairesdev.com/

Given that we have two methods to find job offers:
  a) click in the search box, wait for the dropdown list and then click in a job title/keyword
  b) manually type the search term in the searchbox

They should've return the same results, for example, using "QA" as the search term and clicking the "QA/Testing" dropdwon item. 
But the the second method show less jobs offers than the first.

And if we do the search first and then click the same term shown in the dropdown item, even less offers are shown.

The reports with the tests results can be found:
  a) as a static Cucumber Report snapshot at the root of this repository
  b) in file exported by IntelliJ at "target/cucumber-reports/Test Results - Feature__search.html"
