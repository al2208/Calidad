package cl.consalud.cal.ejecucion.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cl.consalud.cal.login_logout.pages.LoginSucursalVirtual;
import cl.consalud.cal.sucursalvirtual.pages.BonoGesWeb;
import cl.consalud.cal.sucursalvirtual.pages.BonoSV;
import cl.consalud.cal.sucursalvirtual.pages.MenuesPages;
import cl.consalud.cal.sucursalvirtual.pages.PagoWebPay;


public class Test_Compra_Bono_GC {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "IngresoBonoGes\\\\";


	private static Boolean TAKE_SS = true;

@BeforeSuite
public void configExtentReports() {
	// ExtentReports config
	this.extent = new ExtentReports("ExtentReports/Bono_Ges.html", true);
	}

@BeforeMethod
//Desde la Linea de código 39 hasta la 50, código para ejecutar con herramienta Eclipse o vía Consola.
public void configSelenium() {
	// Selenium config
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("Sucursal_Virtual", "AlejandroAscencio");
	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to("http://tclientes.consalud.cl/");
	}


//Desde la Linea de código 54 hasta la 69, código para ejecutar con herramienta Jenkins 
/*public void configSelenium() {
	// Selenium config
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("Consalud", "CP");
	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "");	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("--no-sandbox");
	options.addArguments("--disable-gpu");
	
	
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to("http://tclientes.consalud.cl/");
	}*/
@Test
@Parameters ({"rut1", "clave"})
public void CompraBonoGes(String rut1, String clave) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Usuario Bono Ges", "Requerimineto CV-WEBPER-000051_GC");
		test.log(LogStatus.INFO, "ModuloBonoGes.-");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut1, clave, subDir);
		login.assertLoginCorrecto();
		
		MenuesPages ingreso = new MenuesPages (driver, test, TAKE_SS);
		ingreso.ingresoBonosyReemboslsos(subDir);
		
		MenuesPages bono = new MenuesPages (driver, test, TAKE_SS);
		bono.ingresoBonosyReemboslsos_BonoWeb(subDir);
		
		BonoSV redir = new BonoSV (driver, test, TAKE_SS);
		redir.ingresoVentaBonoGes(subDir);
		
		BonoGesWeb compra = new BonoGesWeb (driver, test, TAKE_SS);
		compra.ingresoBonoGesWeb(subDir);
		
		PagoWebPay pago = new PagoWebPay (driver, test, TAKE_SS);
		pago.inicioPagoWebPayCredito(subDir);
 	}

@AfterMethod
public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
		test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
		test.log(LogStatus.PASS, "Test passed.-");
		}
		
		//driver.close();
		extent.endTest(test);
		}

@AfterSuite
public void closeExtentReports() {
		// writing everything to document.
		extent.flush();
		}

}
