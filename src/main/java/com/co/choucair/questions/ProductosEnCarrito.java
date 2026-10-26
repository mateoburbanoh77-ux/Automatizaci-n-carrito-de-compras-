package com.co.choucair.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import java.util.ArrayList;
import java.util.List;
import static com.co.choucair.userinterfaces.CarritoPage.NOMBRES_PRODUCTOS;
public class ProductosEnCarrito implements Question<List<String>> {
    public static ProductosEnCarrito losNombres() {
        return new ProductosEnCarrito();
    }
    @Override
    public List<String> answeredBy(Actor actor) {
        return new ArrayList<>(
                Text.ofEach(NOMBRES_PRODUCTOS).answeredBy(actor)
        );
    }
}