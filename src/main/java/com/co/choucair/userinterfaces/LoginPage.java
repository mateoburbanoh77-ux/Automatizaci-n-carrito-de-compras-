package com.co.choucair.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class LoginPage {
    public static final Target CAMPO_USUARIO =
            Target.the("campo de usuario")
                    .located(By.id("user-name"));
    public static final Target CAMPO_CLAVE =
            Target.the("campo de contraseña")
                    .located(By.id("password"));
    public static final Target BOTON_INGRESAR =
            Target.the("botón de ingreso")
                    .located(By.id("login-button"));
    private LoginPage() {
    }
}