package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends PageObject {
    //@AndroidFindBy(accessibility = "Cerrar")
    //@AndroidFindBy(className = "android.widget.ImageButton")

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Cerrar\"]")
    private WebElement btnClose;

    public void clickClose(){

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(btnClose));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        btnClose.click();


    }

}
