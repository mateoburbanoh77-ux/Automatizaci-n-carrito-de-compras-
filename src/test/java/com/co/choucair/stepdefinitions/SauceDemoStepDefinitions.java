package com.co.choucair.stepdefinitions;
import com.co.choucair.questions.CantidadDeProductos;
import com.co.choucair.questions.ProductosEnCarrito;
import com.co.choucair.questions.SubtotalCompra;
import com.co.choucair.tasks.AbrirCarrito;
import com.co.choucair.tasks.AbrirTienda;
import com.co.choucair.tasks.AgregarProducto;
import com.co.choucair.tasks.EliminarProducto;
import com.co.choucair.tasks.IniciarSesion;
import com.co.choucair.tasks.IniciarCheckout;
import com.co.choucair.tasks.CompletarCheckout;
import com.co.choucair.tasks.FinalizarCompra;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;
import java.util.Map;
import static com.co.choucair.userinterfaces.CarritoPage.LISTA_CARRITO;
import static com.co.choucair.userinterfaces.CarritoPage.NOMBRES_PRODUCTOS;
import static com.co.choucair.userinterfaces.CheckoutPage.MENSAJE_CONFIRMACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
public class SauceDemoStepDefinitions {
    @Dado("que el cliente inicia sesión en SauceDemo con:")
    public void iniciarSesionEnSauceDemo(DataTable dataTable) {
        Map<String, String> datos = dataTable
                .asMaps(String.class, String.class)
                .get(0);
        OnStage.theActorCalled("Cliente").attemptsTo(
                AbrirTienda.enSauceDemo(),
                IniciarSesion.conCredenciales(
                        datos.get("usuario"),
                        datos.get("clave")
                )
        );
    }
    @Cuando("agrega el producto {string} al carrito")
    public void agregarProductoAlCarrito(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.llamado(nombreProducto)
        );
    }
    @Cuando("abre el carrito")
    public void abrirCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AbrirCarrito.deCompras()
        );
    }
    @Entonces("el carrito contiene el producto {string}")
    public void validarProductoEnCarrito(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_CARRITO, isVisible())
                        .forNoMoreThan(10).seconds(),
                WaitUntil.the(NOMBRES_PRODUCTOS, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ProductosEnCarrito.losNombres(),
                        hasItem(nombreProducto)
                )
        );
    }
    @Cuando("elimina el producto {string} del carrito")
    public void eliminarProductoDelCarrito(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarProducto.llamado(nombreProducto)
        );
    }
    @Entonces("el carrito queda vacío")
    public void validarCarritoVacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LISTA_CARRITO, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        CantidadDeProductos.enElCarrito(),
                        equalTo(0)
                )
        );
    }
    @Cuando("completa los datos de compra:")
    public void completarDatosDeCompra(DataTable dataTable) {
        Map<String, String> datos = dataTable
                .asMaps(String.class, String.class)
                .get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarCheckout.desdeCarrito(),
                CompletarCheckout.conDatos(
                        datos.get("nombre"),
                        datos.get("apellido"),
                        datos.get("codigoPostal")
                )
        );
    }
    @Entonces("el subtotal de la compra es {string}")
    public void validarSubtotalCompra(String subtotalEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        SubtotalCompra.valor(),
                        equalTo(subtotalEsperado)
                )
        );
    }
    @Cuando("confirma la compra")
    public void confirmarCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FinalizarCompra.confirmar()
        );
    }
    @Entonces("ve el mensaje de confirmación {string}")
    public void validarMensajeConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENSAJE_CONFIRMACION, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        Text.of(MENSAJE_CONFIRMACION),
                        equalTo(mensajeEsperado)
                )
        );
    }

}