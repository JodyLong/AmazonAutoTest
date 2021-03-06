package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeTest;
import java.util.Properties;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


@FluentConfiguration(implicitlyWait = 5000L,
        screenshotMode = ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL ,
        driverLifecycle = ConfigurationProperties.DriverLifecycle.CLASS)
public class BasicTest extends FluentTestNg
{
    private Properties prop = null;

    @Page
    public SignInPage signInPage;

    @Page
    public MainPage mainPage;

    /*
        Test Configurations
     */
    public String URL;
    public String username;
    public String password;

    @BeforeTest
    public void readFile()
    {

        /*
            Important: please update the filepath of the property file
         */
        File file = new File("E:/Amazon/amazon.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        try {
            prop.load(fileInput);
            System.out.println("Login url " + prop.getProperty("URL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties prop()
    {
        return prop;
    }

    @BeforeTest
    public void setUp()
    {
        //URL = "https://www.amazon.ca";
        //username = "testama@dispostable.com";
        //password = "Amazon1861";
        URL = prop.getProperty("URL");
        username = prop.getProperty("username");
        password =  prop.getProperty("password");

        System.out.println(username +"    " + password + "    " + URL);
    }

    @Override
    public WebDriver newWebDriver()
    {
        System.out.println("settingup WebDriver");
        /*
            Important: the automation test cases for this project requires chromedriver to be executed
            Update the following path in order to run test cases
         */
        System.setProperty("webdriver.chrome.driver","E:/Amazon/Driver/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new ChromeDriver(capabilities);
        return driver;
    }

    public void gotoURL()
    {
        goTo(URL);
        await().explicitlyFor(2500);
    }

    public void signIn()
    {
        mainPage.navTools().signIn();
        signInPage.signIn().fillInEmailAddr(username).fillInPassword(password);
        await().explicitlyFor(1000);
    }

    public void signOut()
    {
        mainPage.navTools().signOut();
    }

    public void stun(int time)
    {
        await().explicitlyFor(time);
    }

    public void reset()
    {
        goTo(URL);
    }

    public void caseInfo(String caseNum, String description)
    {
        System.out.println("===================");
        System.out.println("Test Case " + caseNum +" : " + description);
        System.out.println("===================");
    }
}
