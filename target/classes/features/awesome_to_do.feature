Feature: Insert a item in To DO list

  Background: Access Awesome To-Do List
    Given i access the Awesome To-Do List http://awesome-todo.azurewebsites.net/

  Scenario Outline: Insert a valid item in To-DO List
    When i insert a task title <title>
    And add the task
    Then the task with <title> must be on the list

  Examples:
    | title                       |
    | Estudar para a certificacao |


  Scenario: Mark item as done
    And i have items in the list
    When mark the first task of the list as done
    Then the mark icon must be changed


  #Cenário feito para falhar
  Scenario Outline: Insert a empty title item in To-Do List
    When i add an item without title
    Then an alert message should be displayed with <message>

  Examples:
    | message                                                    |
    | E necessario inserir um titulo para criar um item na lista |