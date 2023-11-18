package projetoselenium.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String URL_BASE = "src/test/java/projetoselenium/resources/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/projetoselenium/resources/chromedriver-v114.0.5735.90.exe";

    @BeforeClass
    protected void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }
    
    @AfterClass
    private static void finalizar(){
        driver.quit();
    }

}
