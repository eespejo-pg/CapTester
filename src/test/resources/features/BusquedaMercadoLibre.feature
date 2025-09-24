# language: es
@testingPractica
Característica: Búsqueda en Mercado Libre

  Como usuario
  Quiero buscar un artículo en Mercado Libre
  Para encontrar resultados relevantes sobre productos y servicios

  @mercadoLibre
  Escenario: MercadoLibre | Buscar artículo en Mercado Libre
    Dado que abro Mercado Libre
    Cuando busco "zapatillas" en Mercado Libre
    Entonces valido que entro en la categoría correspondiente