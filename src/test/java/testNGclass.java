import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;


public class testNGclass {
    @Test (groups = {"hw3_0"})
    public static void testOne(){
        System.setProperty("webdriver.chrome.driver",  "resources/chromedriver.exe");
        WebDriver driverCH = new ChromeDriver();

        WebElement loginField, passwordField, submitLogin;
        //login in Admin panel
        driverCH.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        loginField = driverCH.findElement(By.id("email"));
        loginField.sendKeys("webinar.test@gmail.com");
        passwordField = driverCH.findElement(By.id("passwd"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        submitLogin = driverCH.findElement(By.name("submitLogin"));
        submitLogin.click();

        //wait
        WebDriverWait wait = new WebDriverWait(driverCH, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("employee_avatar_small")));

        //2 Выбрать пункт меню Каталог -> товары и дождаться загрузки страницы продуктов.
        WebElement subMenuCatalog, quickView;
        subMenuCatalog = driverCH.findElement(By.id("subtab-AdminCatalog"));
        //subMenuCatalog = driverCH.findElement(By.xpath("//input[@id='subtab-AdminCatalog']"));
        //private By emailField = By.xpath("//input[@id='email']");
        quickView = driverCH.findElement(By.id("subtab-AdminProducts"));
        Actions actions = new Actions(driverCH);
        actions.moveToElement(subMenuCatalog).pause(5).click(quickView).build().perform();
        System.out.println("СТраница 'Каталог' -> 'Товары' открыта");


        //3 Нажать «Новый товар» для перехода к созданию нового продукта, дождаться загрузки страницы.
        WebElement createNewProduct = driverCH.findElement(By.id("page-header-desc-configuration-add"));
        createNewProduct.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_step1_name_1")));
        System.out.println("Форма добавдения элемента открыта");

        // 4 Заполнить следующие свойства нового продукта: Название продукта, Количество, Цена.
        // Свойства продукта должны генерироваться случайно (случайное название продукта, количество от 1 до 100, цена от 0.1 ₴ до 100 ₴).
        WebElement newProductName = driverCH.findElement(By.id("form_step1_name_1"));
        WebElement newProductCountTab = driverCH.findElement(By.linkText("Количества"));
        WebElement newProductCount = driverCH.findElement(By.id("form_step3_qty_0"));
        WebElement newProductPriceTab = driverCH.findElement(By.linkText("Цены"));
        WebElement newProductPrice = driverCH.findElement(By.id("form_step2_price"));

        newProductName.sendKeys("product1");
        System.out.println("Название нового товара задано");
        newProductCountTab.click();
        newProductCount.sendKeys("10");
        System.out.println("Количество нового товара задано");
        newProductPriceTab.click();
        newProductPrice.sendKeys("66");
        System.out.println("Цена нового товара задано");

        //5. После заполнения полей активировать продукт используя переключатель на нижней плавающей панели.
        // После активации продукта дождаться всплывающего уведомления о сохранении настроек и закрыть его.
        WebElement tumbler = driverCH.findElement(By.className("switch-input"));
        tumbler.click();
        System.out.println("Тумблер переведен");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Настройки обновлены.")));
//        System.out.println("Обнаружнено всплывающее сообщение");
//        WebElement closeGrowlMessage = driverCH.findElement(By.className("growl-close"));
//        closeGrowlMessage.click();
//        System.out.println("Сообщение закрыто");



        //6. Сохранить продукт нажав на кнопку «Сохранить». Дождаться всплывающего уведомления о сохранении настроек и закрыть его.
        WebElement saveNewProductButton = driverCH.findElement(By.className("btn btn-primary save uppercase"));
        saveNewProductButton.click();
        System.out.println("Товар сохранен");

        driverCH.quit();
    }

    /*@Test(groups = {"hw3_1"})
    public static void testTwo() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver chromeDriver = getDriver();
        chromeDriver.manage().window().fullscreen();

        chromeDriver.get("http://prestashop-automation.qatestlab.com.ua/");
        chromeDriver.quit();

    }
    //@BeforeMethod
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",  "resources/chromedriver.exe");
        return new ChromeDriver();
    }*/
}

