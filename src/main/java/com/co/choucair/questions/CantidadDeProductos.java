package com.co.choucair.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.co.choucair.userinterfaces.CarritoPage.PRODUCTOS;
public class CantidadDeProductos implements Question<Integer> {
    public static CantidadDeProductos enElCarrito() {
        return new CantidadDeProductos();
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return PRODUCTOS.resolveAllFor(actor).size();
    }
}