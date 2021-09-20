package hitoriaDeUsuario.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import util.Driver;

public class DemoBlazeSteps extends Driver{
    @Given("^demoBlazex se encuentra abierto$")
    public void demoblazexSeEncuentraAbierto() throws Exception  {
        Assert.assertTrue("No se encuentra abierto DemoBlaze", demoBlazeHomePage.irPantallaDemoBlaze());
    }

    @When("^el seleciona la opcion \"([^\"]*)\" en el Header en la pantalla del Home$")
    public void elSelecionaLaOpcionEnElHeaderEnLaPantallaDelHome(String btonHeader) throws Throwable {
        demoBlazeHomePage.clickBottonHeader(btonHeader);
    }

    @And("^el ingresa \"([^\"]*)\" como usuario y \"([^\"]*)\" como contraseña en el modal de regsitro$")
    public void elIngresaComoUsuarioYComoContraseñaEnElModalDeRegsitro(String name, String contrasena) throws Throwable {
        demoBlazeHomePage.ingresarDatoInputName(name);
        demoBlazeHomePage.ingresarDatoInputPassword(contrasena);
    }

    @And("^selecciona el boton \"([^\"]*)\" para registra al usuario en el modal de registro$")
    public void seleccionaElBotonParaRegistraAlUsuarioEnElModalDeRegistro(String btnText) throws Throwable {
        demoBlazeHomePage.clickButtonElement(btnText);
    }

    @Then("^se muestra el mensaje de confirmacion \"([^\"]*)\" en el modal de registro$")
    public void seMuestraElMensajeDeConfirmacionEnElModalDeRegistro(String mensajeRegistro) throws Throwable {
        Assert.assertTrue("No se encuentra el mensaje de exito", demoBlazeHomePage.compararMensajeExito(mensajeRegistro));
    }

    @And("^el ingresa \"([^\"]*)\" como usuario y \"([^\"]*)\" como contraseña en el modal de Login$")
    public void elIngresaComoUsuarioYComoContraseñaEnElModalDeLogin(String name, String contrasena) throws Throwable {
        demoBlazeHomePage.ingresarDatoInputLogin(name,contrasena);
    }

    @Then("^se muestra el mensaje de bienvenida \"([^\"]*)\" en el home$")
    public void seMuestraElMensajeDeBienvenidaEnElHome(String mensaje) throws Throwable {
        Assert.assertTrue("No se encuentra el mensaje de Login", demoBlazeHomePage.mensajeBienvenida(mensaje));
    }

    @When("^el seleciona la categoria \"([^\"]*)\" en la pantalla del Home$")
    public void elSelecionaLaCategoriaEnLaPantallaDelHome(String categoria) throws Throwable {
        demoBlazeHomePage.clickCategoria(categoria);
    }

    @And("^el selecciona el producto \"([^\"]*)\" en la categoria del Home$")
    public void elSeleccionaElProductoEnLaCategoriaDelHome(String producto) throws Throwable {
        demoBlazeHomePage.clickProducto(producto);
    }

    @And("^el agrega el producto al carrito de compras en el detalle de producto$")
    public void elAgregaElProductoAlCarritoDeComprasEnElDetalleDeProducto() throws InterruptedException {
        demoBlazeHomePage.clickAddProductoCarrito();
    }

    @Then("^se muestra el mensaje de confirmacion \"([^\"]*)\" en el detalle de producto$")
    public void seMuestraElMensajeDeConfirmacionEnElDetalleDeProducto(String mensaje) throws Throwable {
        Assert.assertTrue("No se encuentra el mensaje de exito", demoBlazeHomePage.compararMensajeAddCart(mensaje));
    }

    @Then("^se muestra el producto \"([^\"]*)\" en el carrito de compras$")
    public void seMuestraElProductoEnElCarritoDeCompras(String producto) throws Throwable {
        Assert.assertTrue("No se encuentra el producto en el Carrito", demoBlazeHomePage.productosCarrito(producto));
    }

    @And("^se muestra el precio del producto \"([^\"]*)\" en el carrito de compra$")
    public void seMuestraElPrecioDelProductoEnElCarritoDeCompra(String precio) throws Throwable {
        Assert.assertTrue("No se encuentra el precio del producto", demoBlazeHomePage.productosCarrito(precio));
    }
}