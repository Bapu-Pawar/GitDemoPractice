Feature: Add Product To Cart

  Scenario: User adds Sauce Labs Backpack to cart successfully
    Given user logs into SauceDemo
    When user adds backpack to cart
    And user opens cart page
    Then backpack product should be visible in cart