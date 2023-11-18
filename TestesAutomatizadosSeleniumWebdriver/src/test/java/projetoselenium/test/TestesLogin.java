package projetoselenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesLogin {

    private final static String CAMINHO_DRIVER = "src/test/java/projetoselenium/resources/chromedriver-v114.0.5735.90.exe";

    public static void main(String[] args) {
        // Configuração do WebDriver para o Chrome
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        WebDriver driver = new ChromeDriver();

        // Teste 1: Login válido
        testeLoginValido(driver);

        // Teste 2: Email inválido
        testeEmailInvalido(driver);

        // Teste 3: Senha inválida
        testeSenhaInvalida(driver);

        // Fechar o navegador
        driver.quit();
    }

    public static void testeLoginValido(WebDriver driver) {
        driver.get("src/test/java/projetoselenium/resources/sistema/login.html");

        WebElement campoEmail = driver.findElement(By.id("email"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
        WebElement botaoEntrar = driver.findElement(By.id("btn-entrar"));

        campoEmail.sendKeys("admin@admin.com");
        campoSenha.sendKeys("admin@123");
        botaoEntrar.click();

        // Verificar se a página foi redirecionada corretamente
        String urlAtual = driver.getCurrentUrl();
        if (urlAtual.contains("produtos.html")) {
            System.out.println("Teste 1 - Login Válido: PASSOU");
        } else {
            System.out.println("Teste 1 - Login Válido: FALHOU");
        }
    }

    public static void testeEmailInvalido(WebDriver driver) {
        driver.get("src/test/java/projetoselenium/resources/sistema/login.html");

        WebElement campoEmail = driver.findElement(By.id("email"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
        WebElement botaoEntrar = driver.findElement(By.id("btn-entrar"));

        campoEmail.sendKeys("leocosta@gmail.com");
        campoSenha.sendKeys("admin@123");
        botaoEntrar.click();

        // Verificar se a mensagem de alerta é exibida corretamente
        try {
            WebElement alerta = driver.findElement(By.xpath("//span[@id='mensagem']"));
            if (alerta.getText().equals("E-mail ou senha inválidos")) {
                System.out.println("Teste 2 - Email Inválido: PASSOU");
            } else {
                System.out.println("Teste 2 - Email Inválido: FALHOU");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Teste 2 - Email Inválido: FALHOU (Mensagem de alerta não encontrada)");
        }
    }

    public static void testeSenhaInvalida(WebDriver driver) {
        driver.get("src/test/java/projetoselenium/resources/sistema/login.html");

        WebElement campoEmail = driver.findElement(By.id("email"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
        WebElement botaoEntrar = driver.findElement(By.id("btn-entrar"));

        campoEmail.sendKeys("admin@admin.com");
        campoSenha.sendKeys("123456");
        botaoEntrar.click();

        // Verificar se a mensagem de alerta é exibida corretamente
        try {
            WebElement alerta = driver.findElement(By.xpath("//span[@id='mensagem']"));
            if (alerta.getText().equals("E-mail ou senha inválidos")) {
                System.out.println("Teste 3 - Senha Inválida: PASSOU");
            } else {
                System.out.println("Teste 3 - Senha Inválida: FALHOU");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Teste 3 - Senha Inválida: FALHOU (Mensagem de alerta não encontrada)");
        }
    }
}
