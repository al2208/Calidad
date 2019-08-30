package cl.consalud.cal.ejecucion.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
import cl.consalud.cal.sucursalvirtual.pages.MenuesPages;
import cl.consalud.cal.sucursalvirtual.pages.MisPrestacionesSV;


public class Test_Mis_Prestaciones_IE {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "IngresoMisPrestaciones\\\\";
	
	
	private static Boolean TAKE_SS = true;

	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/Consalud_Mis_Prestaciones.html", true);
	}

	@BeforeMethod
	public void configSelenium() {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Sucursal_Virtual", "AlejandroAscencio");
		System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://tqaclientes.consalud.cl/");
		
		
	}

	@Test
	@Parameters ({"rut", "clave", "seleccionBeneficiario"})
	    public void AfiliadoConPrestaciones(String rut, String clave, String seleccionBeneficiario) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Usuario con Prestaciones", "Requerimineto CV-WEBPER-000051_GC");
		test.log(LogStatus.INFO, "ModuloPrestaciones.-");
		LoginSucursalVirtual login = new LoginSucursalVirtual(driver, test, TAKE_SS);
		login.inicioDeSession(rut, clave, subDir);
		login.assertLoginCorrecto();
	
		MenuesPages Ingreso = new MenuesPages(driver, test, TAKE_SS);
		Ingreso.ingresoMisPrestaciones(subDir);
		//Ingreso.assertMisPrestaciones();
			
		MisPrestacionesSV Seleccion = new MisPrestacionesSV(driver, test, TAKE_SS);
		Seleccion.selecionBeneficiarioSV(subDir, seleccionBeneficiario);
		Seleccion.assertSeleccionBeneficiario();
		
		MisPrestacionesSV Visualizar = new MisPrestacionesSV(driver, test, TAKE_SS);
		Visualizar.visualizarDetalleSV(subDir);
		Visualizar.assertVisualizarDetalle();
			
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
