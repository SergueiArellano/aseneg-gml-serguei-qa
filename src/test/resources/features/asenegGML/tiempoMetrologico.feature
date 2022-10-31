# language: es
@TiempoMetrologico
Característica: Consulta Municipios en Sistema Tiempo Metrologico
  Yo como QA Automation Engineer
  Quiero realizar la consulata de Municipios en el sistema Tiempo Metrologico
  Para poder demostrar a través de este proyecto automatizado que soy la persona adecuada para el cargo ofrecido

  @TiempoMetrologico   @TiempoMetrologico_HP01
  Escenario:  Servicio Soap para consulta de Municipios

    Dado que el usuario indica la provincia y el municipio
    Cuando el usuario ejecuta el servicio soap para la consulta de municipios en el sistema Tiempo Metrologico
    Entonces el usuario puede ver que el servicio soap se ejecuta de manera correcta
