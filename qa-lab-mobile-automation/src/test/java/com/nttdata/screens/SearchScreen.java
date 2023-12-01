package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchScreen extends PageObject {

    @AndroidFindBy(id = "com.airbnb.android:id/search_bar")
    private WebElement searchInput;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_bottom_sheet_title_title")
    private WebElement resultText;

    @AndroidFindBy(xpath = "//android.widget.GridView[@content-desc=\"Conocer Airbnb\"]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View")
    private List<MobileElement> contenidoResultado;

    public void clickSearchInput(){
        esperaCampo(searchInput);
        searchInput.click();

    }

    public String getResultText(){
        String resultado=normalizarTexto(resultText.getText());
        return resultado;

    }
    public void deslizarPantalla()
    {
        try {
            // Dimensiones de mi emulador
            int screenWidth = 1080;
            int screenHeight = 2400;
            // Obtener las coordenadas del punto medio
            int tapX = screenWidth / 2;
            int tapY = screenHeight / 2;

            // Simular deslizamiento hacia arriba
            swipe(tapX, tapY, tapX, tapY - 500, 600); // Ajusta las coordenadas y la duración según sea necesario
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public int getContenidoResultado(){
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        return contenidoResultado.size();
    }
    public String normalizarTexto(String texto){
        return texto.replaceAll("\\u00A0", " ").trim();
    }

    //esperar el campo del elemento
    public void esperaCampo(WebElement by) {
        getDriver().manage().timeouts().implicitlyWait(444, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(by));
    }
    //Comando para deslizar pantalla
    public static void swipe(int startX, int startY, int endX, int endY, int duration) throws Exception {
        String swipeCmd = String.format("adb shell input touchscreen swipe %d %d %d %d %d", startX, startY, endX, endY, duration);
        Runtime.getRuntime().exec(swipeCmd).waitFor();
    }

}
