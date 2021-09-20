Feature: Ejercicios de Automatizacion

  @testPruebaweb001 @testPruebaGeneral
  Scenario Outline: Como Usuario deseo registrame en la plataforma
    Given demoBlazex se encuentra abierto
    When el seleciona la opcion "Sign up" en el Header en la pantalla del Home
    And el ingresa "<username>" como usuario y "<contrasena>" como contraseña en el modal de regsitro
    And selecciona el boton "Sign up" para registra al usuario en el modal de registro
    Then se muestra el mensaje de confirmacion "<mensajeRegistro>" en el modal de registro

    Examples:
      | username         | contrasena       | mensajeRegistro     |
      | PRUEBA001TEST001 | PRUEBA001TEST001 | Sign up successful. |

  @testPruebaweb002 @testPruebaGeneral
  Scenario Outline: Como Usuario deseo loguear y desloguearme de la pagina
    Given demoBlazex se encuentra abierto
    When el seleciona la opcion "Log in" en el Header en la pantalla del Home
    And el ingresa "<username>" como usuario y "<contrasena>" como contraseña en el modal de Login
    And selecciona el boton "Log in" para registra al usuario en el modal de registro
    Then se muestra el mensaje de bienvenida "<mensajeRegistro>" en el home
    When el seleciona la opcion "Log out" en el Header en la pantalla del Home

    Examples:
      | username         | contrasena       | mensajeRegistro         |
      | PRUEBA001TEST001 | PRUEBA001TEST001 | Welcome PRUEBA001TEST001 |

  @testPruebaweb003 @testPruebaGeneral
  Scenario Outline: Como Usuario deseo seleccionar un producto y agregarlo al carrito, despues validarlo en el carrito
    Given demoBlazex se encuentra abierto
    When el seleciona la categoria "<categoria>" en la pantalla del Home
    And el selecciona el producto "<producto>" en la categoria del Home
    And el agrega el producto al carrito de compras en el detalle de producto
    Then se muestra el mensaje de confirmacion "<mensaje>" en el detalle de producto
    When el seleciona la opcion "Cart" en el Header en la pantalla del Home
    Then se muestra el producto "<producto>" en el carrito de compras
    And se muestra el precio del producto "<precio>" en el carrito de compra

    Examples:
      | categoria | producto     | mensaje       | precio |
      | Laptops   | Sony vaio i5 | Product added | 790    |