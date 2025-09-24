# language: es
@testingPractica
Característica: Inicio de sesión

  Como usuario
  Quiero iniciar sesión en la web
  Para corroborar el acceso a mi cuenta

  @inicioSesion
  Escenario: Iniciar sesión en la web
    Dado que abro la página de login del ejercicio
    Cuando ingreso con las credenciales válidas
    Entonces valido que el login es exitoso con el mensaje de bienvenida