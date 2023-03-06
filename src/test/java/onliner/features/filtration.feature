Feature: Onliner

  Scenario Outline: FiltrationAutoTest
    Given Go to "https://onliner.by/"
    When I navigate to the "Автобарахолка" page
    Then Click button "<currency>"
    And In the field input "<COST_FIELD_XPATH>"
    Then Choose "Седан" at vehicle checkbox
    Then Choose "Автоматическая" at engine checkbox
    Then Check the correct operation by engine filter

    Examples:
      | currency | COST_FIELD_XPATH |
      | USD      | 100000           |