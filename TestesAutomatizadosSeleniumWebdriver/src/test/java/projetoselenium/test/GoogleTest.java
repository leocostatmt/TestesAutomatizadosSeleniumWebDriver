package projetoselenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import projetoselenium.pageObject.GooglePO;

public class GoogleTest extends BaseTest {

    private static WebDriver driver;
    private final String URL_BASE = "https://www.google.com/";
    private final String CAMINHO_DRIVER = "src/test/java/projetoselenium/resources/chromedriver-v114.0.5735.90.exe";
    
    protected void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    private static GooglePO googlePage;
    @BeforeClass
    public static void prepararTestes(){
        googlePage = new GooglePO(driver);
    }

    @Test
    public void testeDePesquisaGoogle(){
        iniciar();

        googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
        String result = googlePage.divResultadoPesquisa.getText();

        assertTrue(result, result.contains("Aproximadamente"));

    }

}
