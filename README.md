# automation
TechStack used:
Java,
Selenium Webdriver,
Cucumber,
JUnit,
log4j2

Reporting:
There are two reports generated for a run and can be found under the target folder:
1>Extent reports 
2>Cucumber reports

Highlights:
>POM design pattern has been used for the framework.
>Reports are generated at the end of the test run. (target\cucumber-reports> report.html, target\cucumber-reports> index.html)
>Logging is generated in the console using log4j2.
>Screenshots are captured for test failures (target\test-report)

Note*:
One test run report is present on the location (target\cucumber-reports> report.html)
