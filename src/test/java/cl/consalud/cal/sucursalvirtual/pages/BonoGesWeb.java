package cl.consalud.cal.sucursalvirtual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import cl.consalud.cal.helpers.Helper;

public class BonoGesWeb {
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	private By bonoGes;
	private By continuar;
	private By selPatologia;
	private By tipoPrestacion;
	private By submit;
	private By submit2;
	private By consulta;
	private By carroCompra;
	private By continuar2;
	private By inicioPago;
	

public BonoGesWeb (WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
	
	this.driver = driver;
	this.test = test;
	this.TAKE_SS = TAKE_SS;
	
	bonoGes = By.id("div-atenciones-ges");
	continuar = By.id("welcome-submit");
	selPatologia = By.xpath("//*[@id=\"ddlPatologia\"]/option[2]");
	tipoPrestacion = By.xpath("//*[@id=\"ddlTipoPatologia\"]/option[2]");
	submit = By.id("welcome-submit");
	submit2 = By.id("welcome-submit2");
	consulta = By.xpath("//*[@id=\"ctl01_prestaciones\"]/li[5]/span/label");
	carroCompra = By.id("carroCompra");
	continuar2 = By.xpath("//*[@id=\"btnContinuar\"]");
	inicioPago = By.xpath("//*[@id=\"content\"]/div/div/div/section/div/a");
	
	}

public void ingresoBonoGesWeb (String subDir) {
	
	driver.findElement(bonoGes).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(3);
	
	driver.findElement(continuar).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(5);
	
	driver.findElement(selPatologia).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(5);
	
	driver.findElement(tipoPrestacion).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(5);
	
	driver.findElement(submit).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(5);
	
	driver.findElement(submit2).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(5);
	
	driver.findElement(consulta).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(10);
	
	driver.findElement(carroCompra).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(60);
	
	driver.findElement(continuar2).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(70);
	
	driver.findElement(inicioPago).click();
	Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-294: Seleccionar Beneficiario", subDir, "Paso 1_AUT-294");
	Helper.waitSeconds(35);
	
	
	
	}
}
