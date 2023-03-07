Feature: Onliner

  Scenario:
    Given Go to "https://onliner.by/"
    When I navigate to the "Автобарахолка" page
    And Click button "USD"
    And In the field input "100000"
    And Choose "Седан" at vehicle checkbox
    And Choose "Автоматическая" at engine checkbox
    And Check the correct operation by engine filter
