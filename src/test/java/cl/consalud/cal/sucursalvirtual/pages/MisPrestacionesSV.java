package cl.consalud.cal.sucursalvirtual.pages;

//import java.util.NoSuchElementException;

/**
 * Sucursal Virtual java:
 * 
 *  Clase que muestra ejemplos de comentarios de documentación de código. 
 * 
 * @author AAscencio
 * @version 1.0, 21/01/2019
 * @see documento "Programación Sucursal Virtual v1.0"
 * @since jdk 8.0_191
 * @FechaÚltimaModificación
 * @AnalistaqueModifico
 * @MetodoModificado 
 */
//import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import cl.consalud.cal.helpers.Helper;

//Laq Siglas finales despúes del nombre de cada Clase indicará a que aplicación pertenece, en este caso SV = Sucursal Virtual
public class MisPrestacionesSV {

	// Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;

	// Variables declaradas de Módulo Mis Prestaciones definidos según su función
	
	private By seleccionBeneficiario;
	private By verDetalleBeneficiario;
	private By cierreMsj;
	
	
	// Variables para prueba correcta
	
	private By validadorBeneficiario;
	private By validadorDetallePrestacion;

	public MisPrestacionesSV(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {

		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;

		// Constructor de Clase
		//ingresoMisPrestaciones = By.id("ITEM5");
		seleccionBeneficiario = By.id("ddlBeneficiarios");
		verDetalleBeneficiario = By.xpath("//*[@id=\"tbHistorialPrestaciones\"]/tbody/tr[2]/td[6]/a");
		cierreMsj = By.xpath("//*[@id=\"divMensajeTop\"]/div/div");
		
		//Constructor de pruebas correctas
		//validadorMisPrestaciones = By.xpath("//*[@id=\"MensajeTop\"]/h1");
		validadorBeneficiario = By.xpath("//*[@id=\"MensajeBot\"]/p/a[2]");
		validadorDetallePrestacion = By.xpath("//*[@id=\"datos_usr_sv\"]/div[2]/span[1]");

	}

	// ID-TESTLINK: AUTOMATON-294:Seleccionar beneficiario
	public void selecionBeneficiarioSV(String subDir, String benef) {
		driver.findElement(seleccionBeneficiario).sendKeys(benef);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario ", subDir, "Paso 1_AUT-294");
		Helper.waitSeconds(3);
	        }
	
	// Validador de Prueba correcta
		public void assertSeleccionBeneficiario() {
			Assert.assertTrue(driver.findElement(validadorBeneficiario).getText().equalsIgnoreCase("Facebook"));
			}

	public void visualizarDetalleSV(String subDir) {
		// ID-TESTLINK: AUTOMATON-88:Visualizar Detalle
		driver.findElement(verDetalleBeneficiario).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-88: Ver detalles de Prestaciones ", subDir, "Paso 1_AUT-88");
		Helper.waitSeconds(3);
		
		// Re-direccionamiento hacia Módulo HOME
		driver.get("https://tclientes.consalud.cl/Default.aspx");
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-88: Redireccionar a Home ", subDir, "Paso 2_AUT-88");
		Helper.waitSeconds(3);
		
		driver.findElement(cierreMsj).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-88: Cierre de Mensaje Importante ", subDir, "Paso 3_AUT-88");
		Helper.waitSeconds(3);
	        }	

	// Validador de Prueba correcta
	public void assertVisualizarDetalle() {
		Assert.assertTrue(driver.findElement(validadorDetallePrestacion).getText().equalsIgnoreCase("Bienvenido:"));
		    }

}
