#language: es
@testfeature
Característica: generacion de certificado
  Yo, como usuario
  Quiero, generar un certificado  
  Para realizar una compra

  @test
  Escenario: Navegar por las opciones de Banistmo
    Dado que me encuentro en la pagina principal de Banistmo
    Cuando hago click en el boton Aprender es facil
    Y hago click en el boton Descubre mas del apartado Legales
    Y hago click en el boton Descubre mas del apartado FATCA y CRS
    Y hago click en el boton PDF del documento PJ Autocertificacion
    Entonces valido que el documento PDF se haya descargado correctamente

