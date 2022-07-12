@API
Feature: Cocktail API test

  Scenario Outline: To verify that the user is able to search the ingredients by name
    Given that user is initializing the cocktail base uri
    When the user search the ingredients as "<ingredients>"
    Then user is able to validate and return the required fields

    Examples:
      | ingredients |
      | vodka       |
      | lemon       |

  Scenario Outline: To verify that user is able to search the cocktails by name
    Given that user is initializing the cocktail base uri
    When the user search the name of "<cocktails>"
    Then the user is able to validate the response and any required schema properties

    Examples:
      | cocktails   |
      | margarita   |
      | margarita11 |

  Scenario Outline: To verify that the user is able to filter the cocktails by nature of alcohol content
    Given that user is initializing the cocktail base uri
    When a user searches for cocktails based on their "<alcoholic content>"
    Then the user is able to validate the response by filtering cocktails api

    Examples:
      | alcoholic content |
      | Alcoholic         |
      | Non_Alcoholic     |

  Scenario: To verify that the user is able to lookup a random cocktail
    Given that user is initializing the cocktail base uri
    When a user lookup for a random cocktail
    Then the user is able to validate the standard schema of the cocktail

