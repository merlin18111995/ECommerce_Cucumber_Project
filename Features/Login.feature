Feature: Login with Valid credentials

@Sanity @Regression
  Scenario: Successful login with Valid credentials
    Given User launch the browser
    And opens the URL "https://naveenautomationlabs.com/opencart/index.php?route=common/home"
    When User navigates to My Account menu
    And Click on Login option
    And User enters Email as "mtest0626a@gmail.com" and Password as "Mtest@0626"
    And Click on Login button
    Then User navigates to My Account page
    And Click on Logout link
   