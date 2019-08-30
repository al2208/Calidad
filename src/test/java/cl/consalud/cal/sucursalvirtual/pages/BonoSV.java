package cl.consalud.cal.sucursalvirtual.pages;

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

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import cl.consalud.cal.helpers.Helper;

public class BonoSV {
	// Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	private By reDirVentaBono;
	
	
public BonoSV(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
	
	this.driver = driver;
	this.test = test;
	this.TAKE_SS = TAKE_SS;
	
	reDirVentaBono = By.id("ibVentaBono");
	
	}

public void ingresoVentaBonoGes(String subDir) {
	driver.findElement(reDirVentaBono).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(3);
	
	ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
	int tab_index = 1;
	driver.switchTo().window(tabs_windows.get(tab_index));
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 2_AUT-294");
	Helper.waitSeconds(80);	
			
	
	}


}
