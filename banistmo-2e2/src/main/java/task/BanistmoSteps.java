package task;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BanistmoHomePage;
import ui.AprenderEsFacilPage;
import ui.FatcaPage;

import java.time.Duration;

public class BanistmoSteps {

    WebDriver driver;

    public BanistmoSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPaginaPrincipal() {
        driver.manage().window().maximize();
        driver.get("https://www.banistmo.com/wps/portal/banistmo/personas/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(BanistmoHomePage.entendidoButton)).click();
        } catch (Exception e) {
            // Si no aparece el popup, continuar
        }
    }

    public void clickAprenderEsFacil(){
        Serenity.takeScreenshot();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        org.openqa.selenium.WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(BanistmoHomePage.aprenderEsFacilLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }

    public void clickDescubreMasLegales(){
        Serenity.takeScreenshot();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        org.openqa.selenium.WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(AprenderEsFacilPage.descubreMasLegalesButton));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickDescubreMasFatca(){
        Serenity.takeScreenshot();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        org.openqa.selenium.WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(AprenderEsFacilPage.descubreMasFatcaButton));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }

    public void clickPdfAutocertificacion(){
        Serenity.takeScreenshot();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        for (int i = 0; i < 5; i++) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            try { Thread.sleep(700); } catch (InterruptedException e) {}
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        org.openqa.selenium.WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(FatcaPage.pdfAutocertificacionLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        Serenity.takeScreenshot();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }

    public boolean validarPdfDescargado(){
        try {
            Thread.sleep(3000);
            java.util.Set<String> handles = driver.getWindowHandles();
            if (handles.size() > 1) {
                String originalWindow = driver.getWindowHandle();
                for (String handle : handles) {
                    if (!handle.equals(originalWindow)) {
                        driver.switchTo().window(handle);
                        break;
                    }
                }
            }
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains(".pdf") || currentUrl.contains("Autocertificacion") || currentUrl.contains("PJ_Autocertificacion");
        } catch (InterruptedException e) {
            return false;
        }
    }

}
