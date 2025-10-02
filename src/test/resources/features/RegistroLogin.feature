# language: es
@testingPractica
Característica: Registro en la plataforma

  Como usuario
  Quiero registrarme en la plataforma
  Para acceder a sus funcionalidades

  @registroExitoso
  Escenario: Registro | Usuario se registra exitosamente
    Dado que estoy en la página de registro
    Cuando completo el formulario de registro con datos válidos
    Entonces debería ver un mensaje de confirmación de registro exitoso