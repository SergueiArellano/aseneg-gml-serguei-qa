# language: es
@TiempoMetrologico
Característica: Consulta Municipios en Sistema Tiempo Metrologico
  Yo como QA Automation Engineer
  Quiero realizar la consulata de Municipios en el sistema Tiempo Metrologico
  Para poder demostrar a través de este proyecto automatizado que soy la persona adecuada para el cargo ofrecido

  @TiempoMetrologico   @TiempoMetrologico_HP01
  Esquema del escenario: Servicio Soap para consulta de Municipios

    Dado que Serguei indica la provincia <provincia> y el municipio <municipio>
    Cuando Serguei ejecuta el servicio soap para la consulta de municipios en el sistema Tiempo Metrologico
    Entonces Serguei puede ver que el servicio soap se ejecuta de manera correcta

    Ejemplos:
      | provincia  | municipio |
      | PONTEVEDRA | VIGO      |