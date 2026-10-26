package com.co.choucair.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.Locale;
import static com.co.choucair.userinterfaces.CarritoPage.BOTON_ELIMINAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
public class EliminarProducto implements Task {
    private final String nombreProducto;
    public EliminarProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static EliminarProducto llamado(String nombreProducto) {
        return Tasks.instrumented(
                EliminarProducto.class, nombreProducto
        );
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String identificador = nombreProducto
                .toLowerCase(Locale.ROOT)
                .replace(" ", "-");
        Target boton = BOTON_ELIMINAR.of(identificador);
        actor.attemptsTo(
                WaitUntil.the(boton, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(boton),
                WaitUntil.the(boton, isNotPresent())
                        .forNoMoreThan(10).seconds()
        );
    }
}