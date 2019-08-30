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
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cl.consalud.cal.login_logout.pages.LoginSucursalVirtual;
import cl.consalud.cal.sucursalvirtual.pages.MenuesPages;
import cl.consalud.cal.sucursalvirtual.pages.OrientacionHospitalariaSV;



public class Test_Orientacion_Hospitalaria_GC {
		private WebDriver driver;
		private ExtentReports extent;
		private ExtentTest test;
		private static String SUBDIR1 = "Orientacion Hospitalaria\\";
		private static Boolean TAKE_SS = true;
	
@BeforeSuite
public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/Consalud_Orientacion_Hospitalaria.html", true);
		}
	
//Desde la Linea de c�digo 40 hasta la 49, c�digo para ejecutar con herramienta Eclipse o v�a Consola. 
@BeforeMethod
/*public void configSelenium() {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Sucursal_Virtual", "AlejandroAscencio");
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://tclientes.consalud.cl/");
		}*/
	
//Desde la Linea de c�digo 52 hasta la 67, c�digo para ejecutar con herramienta Jenkins 
public void configSelenium() {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Consalud", "CP");
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
	
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://tclientes.consalud.cl/");
		}
	
@Test
@Parameters ({"rut2", "clave", "mailAfiliado", "celAfiliado"})
public void BeneficiarioConPresupuestoVigente(String rut2, String clave, String mailAfiliado, String celAfiliado) throws Exception {
		String subDir1 = SUBDIR1 + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Cliente con Presupuesto Vigente", "Requerimiento WEPPER_000047_GC");
		test.log(LogStatus.INFO, "Beneficiario con Presupuesto Vigente");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut2, clave, subDir1);
		login.assertLoginCorrecto();
		
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoOrientacionHospitalaria(subDir1);
		Ingreso.assertOrientacionHospitalaria1();
		
		OrientacionHospitalariaSV formulario = new OrientacionHospitalariaSV(driver, test, TAKE_SS);
		formulario.BeneficiarioConPresupuestoVigente(subDir1, "CLINICA ALEMANA DE SANTI", "Correci�n Nasal - NARIZ. CORRECCION NASAL PARC", mailAfiliado, celAfiliado);
		formulario.assertOrientacionHospitalaria();
		
		LoginSucursalVirtual Cierre = new LoginSucursalVirtual(driver, test, TAKE_SS);
		Cierre.cierreSesion(subDir1);
		Cierre.assertLogOut();
		}
		
@Test
@Parameters ({"rut3", "clave", "mailAfiliado", "celAfiliado"})
public void BeneficiarioSinPresupuestoVigente(String rut3, String clave, String mailAfiliado, String celAfiliado) throws Exception {
		String subDir1 = SUBDIR1 + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Cliente Sin Presupuesto Vigente", "Requerimiento WEPPER_000047_GC");
		test.log(LogStatus.INFO, "Beneficiario Sin Presupuesto Vigente");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut3, clave, subDir1);
		login.assertLoginCorrecto();
		
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoOrientacionHospitalaria(subDir1);
		Ingreso.assertOrientacionHospitalaria1();
		
		OrientacionHospitalariaSV formulario = new OrientacionHospitalariaSV(driver, test, TAKE_SS);
		formulario.BeneficiarioSinPresupuestoVigente(subDir1, "CLINICA ALEMANA DE SANTI", "Correci�n Nasal - NARIZ. CORRECCION NASAL PARC", mailAfiliado, celAfiliado);
		formulario.assertOrientacionHospitalaria();
		
		/*LoginSucursalVirtual Cierre = new LoginSucursalVirtual(driver, test, TAKE_SS);
		Cierre.cierreSesion(subDir1);
		Cierre.assertLogOut();*/
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
