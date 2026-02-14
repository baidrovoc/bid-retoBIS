package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import task.BanistmoSteps;

public class BanistmoStepsDef {

    @Managed
    WebDriver driver;

    BanistmoSteps banistmoSteps;

    @Given("que me encuentro en la pagina principal de Banistmo")
    public void que_me_encuentro_en_la_pagina_principal_de_Banistmo() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        banistmoSteps.abrirPaginaPrincipal();
    }

    @When("hago click en el boton Aprender es facil")
    public void hago_click_en_el_boton_aprender_es_facil() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        banistmoSteps.clickAprenderEsFacil();
    }

    @When("hago click en el boton Descubre mas del apartado Legales")
    public void hago_click_en_el_boton_descubre_mas_del_apartado_legales() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        banistmoSteps.clickDescubreMasLegales();
    }

    @When("hago click en el boton Descubre mas del apartado FATCA y CRS")
    public void hago_click_en_el_boton_descubre_mas_del_apartado_fatca_y_crs() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        banistmoSteps.clickDescubreMasFatca();
    }

    @When("hago click en el boton PDF del documento PJ Autocertificacion")
    public void hago_click_en_el_boton_pdf_del_documento_pj_autocertificacion() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        banistmoSteps.clickPdfAutocertificacion();
    }

    @Then("valido que el documento PDF se haya descargado correctamente")
    public void valido_que_el_documento_pdf_se_haya_descargado_correctamente() {
        if (banistmoSteps == null) {
            banistmoSteps = new BanistmoSteps(driver);
        }
        boolean pdfDescargado = banistmoSteps.validarPdfDescargado();
        Assert.assertTrue("El PDF no se descargó correctamente", pdfDescargado);
    }
}
