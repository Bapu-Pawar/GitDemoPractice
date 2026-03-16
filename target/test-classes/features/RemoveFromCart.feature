Feature: Remove product from cart

Scenario: User remove product from cart successfully
 Given user logs into SauceDemo
 When user adds backpack to cart
 And user opens cart page
 And backpack product should be visible in cart
 And user remove product from cart
 Then cart should be empty

