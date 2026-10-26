package com.co.choucair.questions;
import com.co.choucair.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
public class SubtotalCompra implements Question<String> {
    public static SubtotalCompra valor() {
        return new SubtotalCompra();
    }
    @Override
    public String answeredBy(Actor actor) {
        String subtotal = Text.of(CheckoutPage.SUBTOTAL)
                .answeredBy(actor);
        return subtotal.replace("Item total: $", "").trim();
    }
}