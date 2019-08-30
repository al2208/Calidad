package cl.consalud.cal.sucursalvirtual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import cl.consalud.cal.helpers.Helper;

public class MenuesPages {
	// Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;

	// Variables declaradas de Módulo de Sucursal Virtual
	private By miConsalud;
	private By miConsalud_ResumenConstrato;
	private By miConsalud_ActualizarDatos;
	private By miConsalud_CuentasBancarias;
	private By miConsalud_Certificados;
	private By miConsalud_DocumentosContractuales;
	private By miConsalud_ClickDoctor;
	private By miConsalud_MisMensajes;
	private By miConsalud_ClaveBeneficiario;
	private By complementos;
	private By claveBeneficiario;
	private By bonoYReembolsos;
	private By bonoYReembolsos_BonoWeb;
	private By bonoYReembolsos_ReembolsoWeb;
	private By misCotizaciones;
	private By misCotizaciones_PagoCotizaciones;
	private By misCotizaciones_AnalisisCotizaciones;
	private By misCotizaciones_DevolucionExcesos;
	private By misPrestaciones;
	private By misLicencias;
	private By consultaAranceles;
	private By pagosPendientes;
	private By uOC;
	
	
	//Variables para validación de Pruebas Correctas
	
	private By validadorIngresoUoc;

	public MenuesPages(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;

		// Constructor de Clase
		miConsalud = By.id("ITEM1");
		miConsalud_ResumenConstrato = By.id("SUB-ITEM1-0");
		miConsalud_ActualizarDatos = By.id("SUB-ITEM1-1");
		miConsalud_CuentasBancarias = By.id("SUB-ITEM1-2");
		miConsalud_Certificados = By.id("SUB-ITEM1-3");
		miConsalud_DocumentosContractuales = By.id("SUB-ITEM1-5");
		miConsalud_ClickDoctor = By.id("SUB-ITEM1-7");
		miConsalud_MisMensajes = By.id("SUB-ITEM1-8");
		miConsalud_ClaveBeneficiario = By.id("SUB-ITEM1-9");
		
		complementos = By.id("ITEM2");
		claveBeneficiario = By.id("ITEM16");
		
		bonoYReembolsos = By.id("ITEM3");
		bonoYReembolsos_BonoWeb = By.id("SUB-ITEM3-0");
		bonoYReembolsos_ReembolsoWeb = By.id("SUB-ITEM3-1");
		
		misCotizaciones = By.id("ITEM4");
		misCotizaciones_PagoCotizaciones = By.id("SUB-ITEM4-0");
		misCotizaciones_AnalisisCotizaciones = By.id("SUB-ITEM4-1");
		misCotizaciones_DevolucionExcesos = By.id("SUB-ITEM4-2");
		
		misPrestaciones = By.id("ITEM5");
		misLicencias = By.id("ITEM6");
		consultaAranceles = By.id("ITEM7");
		pagosPendientes = By.id("ITEM8");
		uOC = By.id("ITEM10");
		
		
		
		//validador de Pruebas
		validadorIngresoUoc = By.xpath("//*[@id=\"MensajeTop\"]/h1");
	}

	public void ingresoMiConsalud(String subDir) {

		driver.findElement(miConsalud).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_ResumenContrato(String subDir) {

		driver.findElement(miConsalud_ResumenConstrato).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_ActualizarDatos(String subDir) {

		driver.findElement(miConsalud_ActualizarDatos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_CuentasBancarias(String subDir) {

		driver.findElement(miConsalud_CuentasBancarias).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_Certificados(String subDir) {

		driver.findElement(miConsalud_Certificados).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_DocumentosContractuales(String subDir) {

		driver.findElement(miConsalud_DocumentosContractuales).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_ClickDoctor(String subDir) {

		driver.findElement(miConsalud_ClickDoctor).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_MisMensajes(String subDir) {

		driver.findElement(miConsalud_MisMensajes).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMiConsalud_ClaveBeneficiario(String subDir) {

		driver.findElement(miConsalud_ClaveBeneficiario).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoComplementos(String subDir) {

		driver.findElement(complementos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoClaveBeneficiario(String subDir) {

		driver.findElement(claveBeneficiario).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoBonosyReemboslsos(String subDir) {

		driver.findElement(bonoYReembolsos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoBonosyReemboslsos_BonoWeb(String subDir) {

		driver.findElement(bonoYReembolsos_BonoWeb).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoBonosyReemboslsos_ReembolsoWeb(String subDir) {

		driver.findElement(bonoYReembolsos_ReembolsoWeb).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisCotizaciones(String subDir) {

		driver.findElement(misCotizaciones).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisCotizaciones_PagoCotizaciones(String subDir) {

		driver.findElement(misCotizaciones_PagoCotizaciones).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisCotizaciones_AnalisisCotizaciones(String subDir) {

		driver.findElement(misCotizaciones_AnalisisCotizaciones).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisCotizaciones_DevolucionExcesos(String subDir) {

		driver.findElement(misCotizaciones_DevolucionExcesos).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisPrestaciones(String subDir) {

		driver.findElement(misPrestaciones).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Ingreso Mis Prestaciones  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoMisLicencias(String subDir) {

		driver.findElement(misLicencias).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoConsultaAranceles(String subDir) {

		driver.findElement(consultaAranceles).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}
	
	public void ingresoPagosPendientes(String subDir) {

		driver.findElement(pagosPendientes).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}

	public void ingresoOrientacionHospitalaria(String subDir) {

		driver.findElement(uOC).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-285: Paso 1  ", subDir, "Paso 1_AUT-285");
		Helper.waitSeconds(2);
	}
	
	//Validador de Prueba correcta
			public void assertOrientacionHospitalaria1() {
			Assert.assertTrue(driver.findElement(validadorIngresoUoc).getText().equalsIgnoreCase("Orientación Hospitalaria"));
			}
}
