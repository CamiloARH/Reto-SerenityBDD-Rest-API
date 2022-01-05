Feature: Actualizar y borrar información en la pagina Reqres
  Como usuario registrado del sistema
  quiero actualizar mi informacion y borrarla
  para poder saber que este la informacion correcta

  Scenario: Actualizar informacion
    Given el usuario esta en la pagina y desea actualizar su informacion
    When el usuario escribe y presiona put
    Then el usuario vera que su informacion fue actualizada

  Scenario: Borrar informacion
    Given el usuario esta en la pagina y desea borrar su informacion
    When el usuario presiona delete
    Then el usuario vera que su informacion fue borrada con la respuesta 204