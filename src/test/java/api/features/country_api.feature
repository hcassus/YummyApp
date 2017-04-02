Feature: Consume country API

  Scenario: Required countries are present in the list
    Given I have an API with a country list
    When I retrieve the list of countries
    And I check the following countries are successfully retrieved
    |GB|
    |DE|
    |US|

  Scenario Outline: Retrieved country contains required information
    Given I have an API with country information to consume
    When I consume the country <country>
    Then I verify the data retrieved respects the expected structure

  Examples:
  |country|
  |GB     |
  |DE     |
  |US     |

  Scenario: Adding a new country to the list
    Given I have an API to create a new country
    When I create a new country with the following data
    |name       |Testistan|
    |alpha2_code|TT       |
    |alpha3_code|TTN      |
    And I consume the country TT
    Then I verify the data retrieved respects the expected structure
