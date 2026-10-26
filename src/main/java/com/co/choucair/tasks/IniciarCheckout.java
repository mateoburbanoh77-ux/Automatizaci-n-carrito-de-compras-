package com.co.choucair.tasks;
import com.co.choucair.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class IniciarCheckout implements Task {
    public static IniciarCheckout desdeCarrito() {
        return instrumented(IniciarCheckout.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CarritoPage.BOTON_CHECKOUT)
        );
    }
}