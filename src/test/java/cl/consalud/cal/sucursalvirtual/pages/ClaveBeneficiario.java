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
public class ClaveBeneficiario {

	// Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;

	// Variables declaradas de Módulo Mis Prestaciones definidos según su función
	
	private By verBeneficiario;
	private By fonoFijo;
	private By fonoMovil;
	private By mail;
	private By guardarDatos;
	private By confirmarDatos;
	private By cerrar;
	
	
	
	
	
	
	// Variables para prueba correcta
	
	private By datosBeneficiario;
	private By confimarDatosGuardados;
	
	
	
	

	public ClaveBeneficiario(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {

		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;

		// Constructor de Clase
		//ingresoMisPrestaciones = By.id("ITEM5");
		verBeneficiario = By.xpath("//*[@id=\"SpBenef\"]/h4[2]/a");
		fonoFijo = By.xpath ("//*[@id=\"TxtNumFonoCarga_1\"]");
		fonoMovil = By.id("TxtNumCelCarga_1");
		mail = By.xpath("TxtMailCarga_1"); //mail = By.id("TxtMailCarga_1");
		guardarDatos = By.name("btnGuardar_1");
		confirmarDatos = By.xpath("//*[@id=\"actualiza_datos\"]/div[6]/div[3]/div/button[1]");//*[@id="actualiza_datos"]/div[6]/div[3]/div/button[1]
		cerrar = By.xpath("//*[@id=\"actualiza_datos\"]/div[6]/div[3]/div/button");
		
		//Constructor de pruebas correctas
		datosBeneficiario = By.xpath("//*[@id=\"datos_usr_sv\"]/div[2]/span[1]");
		confimarDatosGuardados = By.xpath("//*[@id=\"datos_usr_sv\"]/div[2]/span[1]");

	}

	// Ver datos de Beneficiario
	public void verBeneficiario(String subDir) {
		driver.findElement(verBeneficiario).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Ver Beneficiario: Paso 1 ", subDir, "Paso 1_ClaveBenef");
		Helper.waitSeconds(5);
	        }
	
	// Validador de Prueba correcta
		public void assertDatosBeneficiario() {
			Assert.assertTrue(driver.findElement(datosBeneficiario).getText().equalsIgnoreCase("Bienvenido:"));
			Helper.waitSeconds(5);
			}
		
	
		
	//Modificación de Telefono Fijo	
	public void fonoFijo(String subDir, String fonofijo) {
		driver.findElement(fonoFijo).clear();
		Helper.addEvidence(TAKE_SS, driver, test, "Modificar Fono Fijo: Paso 2 ", subDir, "Paso 2_ClaveBenef");
		Helper.waitSeconds(5);
		
		
		driver.findElement(fonoFijo).sendKeys(fonofijo);
		Helper.addEvidence(TAKE_SS, driver, test, "Modificar Fono Fijo: Paso 3", subDir, "Paso 3_ClaveBenef");
		Helper.waitSeconds(5);
	        }
		
	// Validador de Prueba correcta Telefono Fijo
	public void assertFonoFijo() {
			Assert.assertTrue(driver.findElement(datosBeneficiario).getText().equalsIgnoreCase("Bienvenido:"));
			Helper.waitSeconds(5);
			}
	
	
	
	//Modificación de Telefono Movil
	public void fonoMovil(String subDir, String fonomovil) {
		driver.findElement(fonoMovil).clear();
		Helper.addEvidence(TAKE_SS, driver, test, "Modificar Fono Movil: Paso 4", subDir, "Paso 4_ClaveBenef");
		Helper.waitSeconds(5);
		
		driver.findElement(fonoMovil).sendKeys(fonomovil);
		Helper.addEvidence(TAKE_SS, driver, test, "Modificar Fono Movil: Paso 5 ", subDir, "Paso 5_ClaveBenef");
		Helper.waitSeconds(5);
		
			}
		
			

	// Validador de Prueba correcta Telefono Movil
	public void assertFonoMovil() {
		Assert.assertTrue(driver.findElement(datosBeneficiario).getText().equalsIgnoreCase("Bienvenido:"));
		    }
	
	//Modificación de Mail
	public void Email(String subDir, String correo) {
			driver.findElement(mail).clear();
			Helper.addEvidence(TAKE_SS, driver, test, "Modificar Email: Paso 6 ", subDir, "Paso 6_ClaveBenef");
			Helper.waitSeconds(5);
			
			driver.findElement(mail).sendKeys(correo);
			Helper.addEvidence(TAKE_SS, driver, test, "Modificar Email: Paso 7 ", subDir, "Paso 7_ClaveBenef");
			Helper.waitSeconds(5);
			}
			
	// Validador de Prueba correcta Mail
	public void assertMail() {
			Assert.assertTrue(driver.findElement(datosBeneficiario).getText().equalsIgnoreCase("Bienvenido:"));
			}
	
	//Guardar Datos Modificados
	public void guardarDatos(String subDir) {
		driver.findElement(guardarDatos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Guardar Datos: Paso 8 ", subDir, "Paso 8_ClaveBenef");
		Helper.waitSeconds(5);
	}
	
	//Confirmar Guardar Datos modificados de Beneficiarios
	public void confirmarDatos (String subDir) {
		driver.findElement(confirmarDatos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Confirmar Datos: Paso 9 ", subDir, "Paso 9_ClaveBenef");
		Helper.waitSeconds(20);
		}

	public void assertconfirmarDatosGuardados() {
		Assert.assertTrue(driver.findElement(confimarDatosGuardados).getText().equalsIgnoreCase("Bienvenido:"));
	}
	
	//Confirmacion de datos modificados con exito
	public void cerrarDatosModificados (String subDir) {
		driver.findElement(cerrar).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Cerrar Datos Modificados: Paso 10  ", subDir, "Paso 10_ClaveBenef");
		Helper.waitSeconds(10);
	}
	
	public void assertconfirmarDatosModificados() {
		Assert.assertTrue(driver.findElement(confimarDatosGuardados).getText().equalsIgnoreCase("Bienvenido:"));
	}
}
