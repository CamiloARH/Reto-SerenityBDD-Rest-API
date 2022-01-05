Feature: Pokedex de los Pokemon del 201 al 300
  Como Maestro Pokemon
  necesito saber la lista de los pokemon en el pokedex
  para poder saber cuales me faltan capturar

  Scenario: Ver la lista de Pokemons
    Given El usuario quiere saber la lista de Pokemons que le faltan
    When el usuario busca en el pokedex
    Then el usuario debera ver una lista de Pokemons

  Scenario: Copiar la lista Pokemon
    Given El usuario quiere copiar la lista de Pokemons que le faltan
    When el usuario intenta copiar desde la pokedex a su computador
    Then el usuario debera ver el error 405