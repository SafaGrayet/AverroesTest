Feature: LoginFeature

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following for login
      | username | password      |
      | admin    | Safa1994 |
    And I click login button
    Then I should see the userform page



#  Scenario Outline: Login with correct username and password using scenario outline
#    Given I navigate to the login page
#    And I enter <password> and <username>
#
#    And I click login button
#    Then I should see the userform page
#    Examples:
#      | username | password |
#      | safa     | safa     |
#      | admin    | adddmin  |


