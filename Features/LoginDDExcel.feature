Feature: Login with multiple credentials from excel

  Scenario: Validate Login with multiple credentials from excel
    Given User launch the browser
    And opens the URL "https://naveenautomationlabs.com/opencart/index.php?route=common/home"
    When User navigates to My Account menu
    And Click on Login option
    Then User navigates to My Account page by passing  Email and Password with excel row "<row_index>"
    
     Examples: 
      | row_index  |
      | 1          |
      | 2          |
      | 3          |
      | 4				   |
      | 5					 |
