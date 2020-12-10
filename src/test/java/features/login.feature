Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And User clicks on Login Button to land on Sign page
When User enters <username> and <password> and logs in
Then Verify that user get error msg
And Close browsers

Examples:
|username		|password|
|abc@			|1234	 |
|xyz@			|3456	 |