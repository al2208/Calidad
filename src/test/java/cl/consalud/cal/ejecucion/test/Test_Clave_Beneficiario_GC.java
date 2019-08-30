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
import cl.consalud.cal.sucursalvirtual.pages.ClaveBeneficiario;
import cl.consalud.cal.sucursalvirtual.pages.MenuesPages;


public class Test_Clave_Beneficiario_GC {
		private WebDriver driver;
		private ExtentReports extent;
		private ExtentTest test;
		private static String SUBDIR = "IngresoClaveBeneficiario\\\\";
	
	
		private static Boolean TAKE_SS = true;

@BeforeSuite
public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/Consalud_Clave_Beneficiario.html", true);
		}

@BeforeMethod
//Desde la Linea de código 42 hasta la 51, código para ejecutar con herramienta Eclipse o vía Consola.
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
public void AfiliadoSinBeneficiario(String rut1, String clave) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Usuario sin Beneficiario", "Modulo Clave Beneficiario_GC");
		test.log(LogStatus.INFO, "Modulo Clave Beneficiario.-");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut1, clave, subDir);
		login.assertLoginCorrecto();
	
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoClaveBeneficiario(subDir);
							
		LoginSucursalVirtual Cierre = new LoginSucursalVirtual(driver, test, TAKE_SS);
		Cierre.cierreSesion(subDir);
		Cierre.assertLogOut();			
		}
	
@Test
@Parameters ({"rut4", "clave"})
public void AfiliadoConBeneficiarios (String rut4, String clave) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Usuario con Beneficiario_Solo Visualizar", "Modulo Clave Beneficiario_GC");
		test.log(LogStatus.INFO, "Modulo Clave Beneficiario.-");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut4, clave, subDir);
		login.assertLoginCorrecto();
	
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoClaveBeneficiario(subDir);
							
		LoginSucursalVirtual Cierre = new LoginSucursalVirtual(driver, test, TAKE_SS);
		Cierre.cierreSesion(subDir);
		Cierre.assertLogOut();	
		}
	
	
@Test
@Parameters ({"rut4", "clave", "fonofijo", "fonomovil", "correo"})
public void BeneficiariosModificarDatos (String rut4, String clave, String fonofijo, String fonomovil, String correo) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Usuario con Beneficiario_Modificar Datos", "Modulo Clave Beneficiario_GC");
		test.log(LogStatus.INFO, "Modulo Clave Beneficiario.-");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut4, clave, subDir);
		login.assertLoginCorrecto();
	
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoClaveBeneficiario(subDir);
		
		ClaveBeneficiario Cambio = new ClaveBeneficiario (driver, test, TAKE_SS);
		Cambio.verBeneficiario(subDir);
		Cambio.assertDatosBeneficiario();
		
		ClaveBeneficiario Fijo = new ClaveBeneficiario (driver, test, TAKE_SS);
		Fijo.fonoFijo(subDir, fonofijo);
		Fijo.assertFonoFijo();
		
		ClaveBeneficiario Movil = new ClaveBeneficiario (driver, test, TAKE_SS);
		Movil.fonoMovil(subDir, fonomovil);
		Movil.assertFonoMovil();
		
		ClaveBeneficiario Mail = new ClaveBeneficiario (driver, test, TAKE_SS);
		Mail.Email(subDir, correo);
		Mail.assertMail();
		
		ClaveBeneficiario Guardar = new ClaveBeneficiario (driver, test, TAKE_SS);
		Guardar.guardarDatos(subDir);
		
		ClaveBeneficiario Confirmar = new ClaveBeneficiario (driver, test, TAKE_SS);
		Confirmar.confirmarDatos(subDir);
		Confirmar.assertconfirmarDatosGuardados();
		
		ClaveBeneficiario ConfirmarDatos = new ClaveBeneficiario (driver, test, (TAKE_SS));
		ConfirmarDatos.cerrarDatosModificados(subDir);
		ConfirmarDatos.assertconfirmarDatosModificados();
		
		LoginSucursalVirtual Cierre = new LoginSucursalVirtual(driver, test, TAKE_SS);
		Cierre.cierreSesion(subDir);
		Cierre.assertLogOut();
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
		
		driver.close();
		extent.endTest(test);
		}

@AfterSuite
public void closeExtentReports() {
		// writing everything to document.
		extent.flush();
		}
}

