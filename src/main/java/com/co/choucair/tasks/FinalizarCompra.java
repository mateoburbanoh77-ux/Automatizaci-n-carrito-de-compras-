package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.CheckoutPage;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinalizarCompra implements Task {

    public static FinalizarCompra confirmar() {

        return instrumented(FinalizarCompra.class);

    }

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(CheckoutPage.BOTON_FINALIZAR)

        );

    }

}
