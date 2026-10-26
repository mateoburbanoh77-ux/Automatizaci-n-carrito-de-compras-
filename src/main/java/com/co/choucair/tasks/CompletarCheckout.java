package com.co.choucair.tasks;
import com.co.choucair.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class CompletarCheckout implements Task {
    private final String nombre;
    private final String apellido;
    private final String codigoPostal;
    public CompletarCheckout(String nombre,
                             String apellido,
                             String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }
    public static CompletarCheckout conDatos(
            String nombre,
            String apellido,
            String codigoPostal) {
        return instrumented(
                CompletarCheckout.class,
                nombre,
                apellido,
                codigoPostal
        );
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre)
                        .into(CheckoutPage.CAMPO_NOMBRE),
                Enter.theValue(apellido)
                        .into(CheckoutPage.CAMPO_APELLIDO),
                Enter.theValue(codigoPostal)
                        .into(CheckoutPage.CAMPO_CODIGO_POSTAL),
                Click.on(CheckoutPage.BOTON_CONTINUAR)
        );
    }
}