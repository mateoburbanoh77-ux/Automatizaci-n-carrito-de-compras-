package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class InventarioPage {

    public static final Target BOTON_AGREGAR_PRODUCTO =
            Target.the("botón para agregar el producto {0}")
                    .locatedBy("//*[@id='add-to-cart-{0}']");

    public static final Target ENLACE_CARRITO =

            Target.the("enlace al carrito")

                    .located(By.className("shopping_cart_link"));

    private InventarioPage() {

    }

}
