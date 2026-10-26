# language: es
@reto
Característica: Eliminación de productos del carrito
  Como cliente de la tienda
  Quiero eliminar productos del carrito
  Para comprar únicamente los que necesito
  Escenario: Eliminar el único producto del carrito
    Dado que el cliente inicia sesión en SauceDemo con:
      | usuario       | clave        |
      | standard_user | secret_sauce |
    Cuando agrega el producto "Sauce Labs Backpack" al carrito
    Y abre el carrito
    Entonces el carrito contiene el producto "Sauce Labs Backpack"
    Cuando elimina el producto "Sauce Labs Backpack" del carrito
    Entonces el carrito queda vacío