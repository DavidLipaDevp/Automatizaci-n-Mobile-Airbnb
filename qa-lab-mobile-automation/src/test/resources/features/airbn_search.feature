@AllTest
Feature: Búsqueda en Airbnb

  @Busqueda
  Scenario: Búsqueda de hospedaje a Vichayito

    Given que me enuentro en el login de Airbnb
    When busco "Vichayito"
    Then muestra el texto "Más de 1000 alojamientos"
    And los resultados son mayor a 1