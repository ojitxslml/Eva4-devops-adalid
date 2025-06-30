package com.eva4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UsuarioFlowTest {
    private static Process webAppProcess;
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8080";

    @BeforeAll
    public static void setupAll() throws Exception {
        // Start the web application before all tests
        webAppProcess = new ProcessBuilder()
            .command("mvn", "exec:java")
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start();
        // Espera activa a que el servidor esté disponible
        int maxTries = 15;
        boolean started = false;
        for (int i = 0; i < maxTries; i++) {
            try {
                Thread.sleep(1000);
                HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080").openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(1000);
                connection.connect();
                if (connection.getResponseCode() == 200) {
                    started = true;
                    break;
                }
            } catch (Exception ignored) {}
        }
        if (!started) throw new RuntimeException("La aplicación web no inició en el puerto 8080");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testFlujoCompletoUsuario() {
        driver.get(BASE_URL);
        assertTrue(driver.getTitle().contains("Sistema de Usuario"));
        // Your test steps here...
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void tearDownAll() {
        if (webAppProcess != null && webAppProcess.isAlive()) {
            webAppProcess.destroy();
        }
    }
}