package com.co.choucair.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.co.choucair.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class IniciarSesion implements Task {
    private final String usuario;
    private final String clave;
    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public static IniciarSesion conCredenciales(
            String usuario, String clave) {
        return Tasks.instrumented(
                IniciarSesion.class, usuario, clave
        );
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPO_USUARIO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(usuario).into(CAMPO_USUARIO),
                Enter.theValue(clave).into(CAMPO_CLAVE),
                Click.on(BOTON_INGRESAR)
        );
    }
}