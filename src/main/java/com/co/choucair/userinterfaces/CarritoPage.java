package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class CarritoPage {

    public static final Target LISTA_CARRITO =

            Target.the("lista del carrito")

                    .located(By.className("cart_list"));

    public static final Target NOMBRES_PRODUCTOS =

            Target.the("nombres de los productos del carrito")

                    .located(By.cssSelector(

                            ".cart_list .cart_item .inventory_item_name"

                    ));

    public static final Target PRODUCTOS =

            Target.the("productos del carrito")

                    .located(By.cssSelector(".cart_list .cart_item"));

    public static final Target BOTON_ELIMINAR =

            Target.the("botón para eliminar el producto {0}")

                    .locatedBy(

                            "//*[@id='cart_contents_container']"

                                    + "//button[@id='remove-{0}']"

                    );

    public static final Target BOTON_CHECKOUT =

            Target.the("botón para iniciar la compra")

                    .located(By.id("checkout"));



    private CarritoPage() {

    }

}
 