package com.co.choucair.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
public class AbrirTienda implements Task {
    public static AbrirTienda enSauceDemo() {
        return Tasks.instrumented(AbrirTienda.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }
}