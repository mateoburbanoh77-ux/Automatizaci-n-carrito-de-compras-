package com.co.choucair.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class CheckoutPage {
    public static final Target CAMPO_NOMBRE =
            Target.the("campo de nombre")
                    .located(By.id("first-name"));
    public static final Target CAMPO_APELLIDO =
            Target.the("campo de apellido")
                    .located(By.id("last-name"));
    public static final Target CAMPO_CODIGO_POSTAL =
            Target.the("campo de código postal")
                    .located(By.id("postal-code"));
    public static final Target BOTON_CONTINUAR =
            Target.the("botón continuar")
                    .located(By.id("continue"));
    public static final Target SUBTOTAL =
            Target.the("subtotal de la compra")
                    .located(By.className("summary_subtotal_label"));
    public static final Target BOTON_FINALIZAR =
            Target.the("botón finalizar compra")
                    .located(By.id("finish"));
    public static final Target MENSAJE_CONFIRMACION =
            Target.the("mensaje de confirmación")
                    .located(By.className("complete-header"));
    private CheckoutPage() {
    }
}