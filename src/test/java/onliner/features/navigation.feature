Feature: Onliner

  Scenario:
    Given Go to "https://onliner.by/"
    When I navigate to the "Каталог" page
    And Select "Компьютеры и сети" from the navigation menu
    And In the submenu navigate to "Ноутбуки, компьютеры, планшеты"
    And Go to the "Игровые ноутбуки"