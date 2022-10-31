# language: es
@TCRP
Característica: Portal Myscouter API - Recovery Password
  La compañía Whiz
  Quiere probar el servicio rest de recuperación de contraseña
  Para validar envío exitoso de email de recuperación de contraseña al usuario registrado

  @TCRP   @TCRP_HP01
  Esquema del escenario:  Servicio Rest para envío de email de recuperación de contraseña con email registrado

    Dado que <name> quiere recuperar la contraseña que olvidó
    Cuando <name> ejecuta el servicio rest para recuperar contraseña indicando email <email> registrado en Myscouter
    Entonces <name> puede ver que el servicio rest se ejecuta de manera correcta

    Ejemplos:
      | email                  | name   |
      | felipe.perez@whiz.one  | Felipe |
      | edelmarydiez@gmail.com | Mary   |

  @TCRP   @TCRP_AP01
  Esquema del escenario:  Servicio Rest para envío de email de recuperación de contraseña con email no registrado

    Dado que <name> quiere recuperar la contraseña que olvidó
    Cuando <name> ejecuta el servicio rest para recuperar contraseña indicando email <email> registrado en Myscouter
    Entonces <name> puede ver que el servicio rest no se ejecuta de manera correcta porque el email no está registrado

    Ejemplos:
      | email                      | name    |
      | serguei.arellano@gmail.com | Serguei |
