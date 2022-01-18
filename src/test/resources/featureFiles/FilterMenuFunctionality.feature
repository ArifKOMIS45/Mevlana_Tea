Feature:

  @GermanyShop
  Scenario:On the Germany page, products should be filtered according to the selected type
    Given Hover over the Product Button
    Then Click to the Teezubehör Button
    And Click on the filter button
    Then Click on the filtering type
    |popularity|
    |rating|
    |date|
    |price|
    |price-desc|

  @TurkeyAndEnglishShop
  Scenario:On the Turkey and English page, the products should be filtered according to the selected type
    Given Click on the Produkte button
    And Click on the filter button
    Then  Click on the filtering type
      |popularity|
      |rating|
      |date|
      |price|
      |price-desc|