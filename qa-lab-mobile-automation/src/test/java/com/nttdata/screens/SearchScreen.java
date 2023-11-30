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

    @AndroidFindBy(xpath = "//android.view.View[ends-with(@content-desc, ', botón. ')]")
    private List<MobileElement> contenidoResultado;

    public void clickSearchInput(){
        esperaCampo(searchInput);
        searchInput.click();

    }

    public String getResultText(){
        String resultado=normalizarTexto(resultText.getText());
        return resultado;

    }
    public int getContenidoResultado(){
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


}
