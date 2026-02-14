package ui;

import org.openqa.selenium.By;

public class AprenderEsFacilPage {

    //Localizadores de cards en Aprender es Fácil
    public static By descubreMasLegalesButton = By.xpath("/html/body/div[2]/main/div/div/section[2]/div/div/div/div[5]/div/div[2]/div[4]/div/button/span");
    public static By descubreMasFatcaButton = By.xpath("//h3[contains(text(),'Autocertificación fiscal FATCA')]/ancestor::div[@data-testid='ml-card']//button[@aria-label='Descubre más']");

}
