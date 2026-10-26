# language: es
@reto
Característica: Compra de productos en SauceDemo
  Como cliente de la tienda
  Quiero comprar un producto
  Para recibir la confirmación de mi pedido
  Escenario: Comprar un producto exitosamente
    Dado que el cliente inicia sesión en SauceDemo con:
      | usuario       | clave        |
      | standard_user | secret_sauce |
    Cuando agrega el producto "Sauce Labs Backpack" al carrito
    Y abre el carrito
    Entonces el carrito contiene el producto "Sauce Labs Backpack"
    Cuando completa los datos de compra:
      | nombre  | apellido | codigoPostal |
      | Mateo | Burbano   | 110111       |
    Entonces el subtotal de la compra es "29.99"
    Cuando confirma la compra
    Entonces ve el mensaje de confirmación "Thank you for your order!"