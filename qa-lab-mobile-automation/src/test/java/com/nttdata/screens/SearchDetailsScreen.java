package com.nttdata.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchDetailsScreen extends PageObject {

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Buscar destinos\"]")
    private WebElement searchDetailInput;
    @AndroidFindBy(id="com.airbnb.android:id/input_bar_input")
    private WebElement searchDetailInputText;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_simple_search_footer_link")
    private WebElement skipButton;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    private WebElement searchButton;

    public void enterSearchInput(String place){
        searchDetailInput.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchDetailInput));
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchDetailInputText.sendKeys(place);


        String cmd = "adb shell input keyevent 66";
        try {
            Runtime.getRuntime().exec(cmd);
        }catch(Exception e) {

        }
    }


    public void clickSkip(){
        skipButton.click();
    }

    public void clickSearch(){
        searchButton.click();
    }
}
