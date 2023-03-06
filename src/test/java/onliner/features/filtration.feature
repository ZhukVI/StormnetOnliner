Feature: Onliner

  Scenario:
    Given Go to "https://onliner.by/"
    When I navigate to the "Автобарахолка" page
    Then Click "USD" button
    And Input "100000$" in the fielg
    Then Choose "Седан" at vehicle checkbox
    Then Choose "Автоматическая" at engine checkbox
    Then Check the correct operation by engine filter