package com.co.choucair.tasks;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.InventarioPage.ENLACE_CARRITO;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AbrirCarrito implements Task {

    public static AbrirCarrito deCompras() {

        return Tasks.instrumented(AbrirCarrito.class);

    }

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ENLACE_CARRITO, isClickable())

                        .forNoMoreThan(10).seconds(),

                Click.on(ENLACE_CARRITO)

        );

    }

}
