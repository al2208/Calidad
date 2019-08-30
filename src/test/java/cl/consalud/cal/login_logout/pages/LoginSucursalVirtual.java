package cl.consalud.cal.login_logout.pages;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import cl.consalud.cal.helpers.Helper;


public class LoginSucursalVirtual {
	//Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;

	// Variables declaradas de para ingresar a Sucursal Virtual
	private By rut;
	private By clave;
	private By botonIngresar;
	private By cerrarSesion;
	
	// Variables de Pruebas Correctas
	private By validadorLoginCorrecto;
	private By validadorLogOut;
	
	
	// Variables declaradas para salir de Sucursal Virtual
public LoginSucursalVirtual(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;
			
		// Constructor de Clase Ingreso a Sucursal Virtual
		rut = By.id("usr");
		clave = By.id("pwd");
		botonIngresar = By.id("ingresar");
		
		// Constructor salir Sucursal Virtual
		cerrarSesion = By.id("sv_logout");
		
		
		// Constructor de elementos para validar pruebas correctas
		validadorLoginCorrecto = By.xpath("//*[@id=\"datos_usr_sv\"]/div[2]/span[1]");// Validamos que aparezca "Bienvenido:"
		validadorLogOut = By.xpath("//*[@id=\"btn_back_cons\"]/a");
	}
	
	
		// Metodos definimos la funsion de los Atributos y Variables
public void inicioDeSession(String user, String pass2, String subDir) {
		
		//Se ingresa el comportamiento correspondiente a Sucursal Virtual según caso de Prueba
		driver.findElement(rut).sendKeys(user);
		Helper.waitSeconds(8);	
		
		
		//Ingreso de Clave Correcta
		
		driver.findElement(clave).sendKeys(pass2);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Ingreso Datos Usuario y Password  ", subDir, "Paso 2_AUT-285");
		Helper.waitSeconds(8);		
		
		//Presionar Botón Ingresar a Sucursal_Virual
		driver.findElement(botonIngresar).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Ingresar a Sucursal Virtual ", subDir, "Paso 3_AUT-285");
		Helper.waitSeconds(8);
					
	}


//Validacion de Prueba Correcta de Inicio de Sesion
public void assertLoginCorrecto() {
		Assert.assertTrue(driver.findElement(validadorLoginCorrecto).getText().equalsIgnoreCase("Bienvenido:"));
	}
		
		// Metodos definimos la funsion de los Atributos y Variables
public void cierreSesion(String subDir) {
					
		//Presionar Boton Cerrar Sesion
		driver.findElement(cerrarSesion).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-330:Cierre Sesion", subDir, "Paso 1_AUT-330");
		Helper.waitSeconds(8);
		}

public void assertLogOut() {
	Assert.assertTrue(driver.findElement(validadorLogOut).getText().equalsIgnoreCase("volver a consalud.cl"));
        }
		
	

	}
