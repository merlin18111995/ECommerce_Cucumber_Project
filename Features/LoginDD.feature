Feature: Login with multiple credentials from parameters 

  Scenario Outline: Validate Login with multiple credentials from parameters
    Given User launch the browser
    And opens the URL "https://naveenautomationlabs.com/opencart/index.php?route=common/home"
    When User navigates to My Account menu
    And Click on Login option
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then User navigates to My Account page
    
		
		Examples:
		 	 |email 							 |password   |
       |mtest0626a@gmail.com |Mtest@0626 |
       |mtest0626c@gmail.com |Mtest@0626 |
       |mtest0626b@gmail.com |Mtest@0626 |
			

	
		

