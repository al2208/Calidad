package cl.consalud.cal.sucursalvirtual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import cl.consalud.cal.helpers.Helper;

public class PagoWebPay {
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;

	private By tarjetaCredito;
	private By tarjetaDebito;
	

public PagoWebPay (WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
	
	this.driver = driver;
	this.test = test;
	this.TAKE_SS = TAKE_SS;	
	
	tarjetaCredito = By.xpath("/html/body/app-root/app-home/main/div/div/div/app-payment/a[1]");
	tarjetaDebito = By.xpath("/html/body/app-root/app-home/main/div/div/div/app-payment/a[2]");
	}
			
public void inicioPagoWebPayCredito (String subDir) {
	driver.findElement(tarjetaCredito).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(10);
			
	}

//public void inicioPagoWebPayDebito (String subDir) {
//	driver.findElement(tarjetaDebito).click();
//	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
//	Helper.waitSeconds(10);
//		
//	}
}
