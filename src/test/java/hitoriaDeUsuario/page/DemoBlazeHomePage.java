package hitoriaDeUsuario.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class DemoBlazeHomePage extends BasePage {

    public @FindBy(xpath = "//*[@id='nava']/img") WebElement imgLogoDemoBlaze;
    public @FindBy(xpath = "//li/a[text()='@label']") WebElement btnHeaderGenerico;
    //ModalRegistro
    public @FindBy(id = "sign-username") WebElement inputUserNameR;
    public @FindBy(id = "sign-password") WebElement inputPasswordUserR;
    public @FindBy(xpath = "//button[text()='@label']") WebElement btnElementeGenerico;
    //Modal Login
    public @FindBy(id = "loginusername") WebElement inputUserNameL;
    public @FindBy(id = "loginpassword") WebElement inputPasswordUserL;
    public @FindBy(id = "nameofuser") WebElement etiquetaBienvenida;

    //categorias
    public @FindBy(xpath = "//a[@class='list-group-item'][text()='@label']") WebElement btnCategoriaGenerica;
    public @FindBy(xpath = "//h4/a[text()='@label']") WebElement etiquetaProducto;
    //detalle de producto
    public @FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a") WebElement buttonAddToCart;
    public @FindBy(xpath = "//td[text()='@label']") WebElement etiquetaProductoCart;

    public DemoBlazeHomePage() throws IOException {
        super();
    }

    public boolean irPantallaDemoBlaze() {
        boolean okPage = false;
        getDriver().get("https://www.demoblaze.com/index.html");
        if(WaitUntilWebElementIsVisible(imgLogoDemoBlaze))
            okPage=true;
        return okPage;
    }

    public void clickBottonHeader(String textHeader) throws InterruptedException {
        String xpathTituloHeader= replaceLabelXpath(btnHeaderGenerico,textHeader);
        waitAndClickElementsUsingByLocator(By.xpath(xpathTituloHeader));
    }

    public void ingresarDatoInputName(String inputRegistro) throws Exception {
        sendKeysToWebElement(inputUserNameR,inputRegistro);
    }

    public void ingresarDatoInputPassword(String inputRegistro) throws Exception {
        sendKeysToWebElement(inputPasswordUserR,inputRegistro);
    }

    public void clickButtonElement(String txtButton) throws InterruptedException {
        String xpathButtonGenerico= replaceLabelXpath(btnElementeGenerico,txtButton);
        waitAndClickElementsUsingByLocator( By.xpath(xpathButtonGenerico));
        Thread.sleep(2000);
    }

    public boolean compararMensajeExito(String mensajeText) {
        boolean mensajeOK = false;
        Alert alert = driver.switchTo().alert();
        String mensajeRegistro = alert.getText();
        System.out.println("Mensaja de Registro: "+mensajeRegistro);
        alert.accept();
        if(mensajeRegistro.equals(mensajeText))
            mensajeOK=true;
        return mensajeOK;
    }

    public void ingresarDatoInputLogin(String name,String contrasena) throws Exception {
        sendKeysToWebElement(inputUserNameL,name);
        sendKeysToWebElement(inputPasswordUserL,contrasena);
    }

    public boolean mensajeBienvenida(String mensajeText) throws Exception,InterruptedException {
        boolean mensajeOK = false;
        String etiquetaText=getTextToWebElement(etiquetaBienvenida);
        System.out.println("Mensaja de Login: "+etiquetaText);
        Thread.sleep(2000);
        if(etiquetaText.equals(mensajeText))
            mensajeOK=true;
        return mensajeOK;
    }

    public void clickCategoria(String categoria) throws InterruptedException {
        String xpathButtonGenerico= replaceLabelXpath(btnCategoriaGenerica,categoria);
        waitAndClickElementsUsingByLocator( By.xpath(xpathButtonGenerico));
    }

    public void clickProducto(String producto) throws InterruptedException {
        String xpathButtonGenerico= replaceLabelXpath(etiquetaProducto,producto);
        waitAndClickElementsUsingByLocator( By.xpath(xpathButtonGenerico));
    }

    public void clickAddProductoCarrito() throws InterruptedException {
        waitAndClickElement(buttonAddToCart);
        Thread.sleep(2000);
    }

    public boolean compararMensajeAddCart(String mensajeText) {
        boolean mensajeOK = false;
        Alert alert = driver.switchTo().alert();
        String mensajeAdd = alert.getText();
        System.out.println("Mensaja de Registro: "+mensajeAdd);
        alert.accept();
        if(mensajeAdd.equals(mensajeText))
            mensajeOK=true;
        return mensajeOK;
    }

    public boolean productosCarrito(String datosPorduto) {
        boolean producto = false;
        String xpathByProductoCart= replaceLabelXpath(etiquetaProductoCart,datosPorduto);
        if(WaitUntilWebElementIsVisibleBy(By.xpath(xpathByProductoCart)))
            producto=true;
        return producto;
    }

}
