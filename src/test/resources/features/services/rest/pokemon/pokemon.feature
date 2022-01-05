Feature: Pokedex de los Pokemon del 1 al 10
  Como Maestro Pokemon
  necesito saber la lista de los pokemon en el pokedex
  para poder saber cuales me faltan capturar

  Scenario: Ver la lista de Pokemons
    Given El usuario quiere saber la lista de Pokemons que le faltan
    When el usuario busca en el pokedex
    Then el usuario debera ver una lista de Pokemons

  Scenario: Borrar un pokemon de la lista Pokemon
    Given El usuario quiere borrar un Pokemon
    When el usuario intenta borrar un pokemon de la pokedex
    Then el usuario debera ver el error 404