package com.co.choucair.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.Locale;
import static com.co.choucair.userinterfaces.InventarioPage.BOTON_AGREGAR_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
public class AgregarProducto implements Task {
    private final String nombreProducto;
    public AgregarProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public static AgregarProducto llamado(String nombreProducto) {
        return Tasks.instrumented(
                AgregarProducto.class, nombreProducto
        );
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String identificador = nombreProducto
                .toLowerCase(Locale.ROOT)
                .replace(" ", "-");
        Target boton = BOTON_AGREGAR_PRODUCTO.of(identificador);
        actor.attemptsTo(
                WaitUntil.the(boton, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(boton)
        );
    }
}