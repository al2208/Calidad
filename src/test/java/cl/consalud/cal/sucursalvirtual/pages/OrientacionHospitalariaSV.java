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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;



import cl.consalud.cal.helpers.Helper;
public class OrientacionHospitalariaSV {
	

	
	//Atributos a Utilizar
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	// Variables declaradas de Módulo Mis Prestaciones definidos según su función
	
	private By ingresoRegion;
	private By lugarAtencion;
	private By seleccionLugar;
	private By nombreCirugia;
    private By detalleCirugia;
	private By fechaEstimada;
	private By seleccionFecha;
	private By beneficiario;
	private By mailAfiliado;
	private By celAfiliado;
	private By botonContinuar;
	private By cargaBoleta;
	private By documentoOpcional;
	private By agregarDocumentoOpcional;
	private By cerrar;
	
	
	//Variables para validación de Pruebas Correctas
	
	private By validadorIngresoUoc;
	
	
	//Laq Siglas finales despúes del nombre de cada Clase indicará a que aplicación pertenece, en este caso SV = Sucursal Virtual
	public OrientacionHospitalariaSV (WebDriver driver , ExtentTest test, Boolean TAKE_SS) {
		
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;
		
		// Constructor de Clase 
		
		ingresoRegion = By.xpath("//*[@id=\"ddlRegion\"]/option[14]");
		lugarAtencion = By.xpath("//*[@id=\"ddlPrestador_autocomplete\"]/input");
		seleccionLugar = By.xpath("//*[@id=\"ui-id-1\"]");
		nombreCirugia = By.xpath("//*[@id=\"ddlPrestacion_autocomplete\"]/input");
		detalleCirugia = By.xpath("//*[@id=\"ui-id-2\"]");
		fechaEstimada = By.id("fechaEstimada");
		seleccionFecha = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a");//*[@id="ui-datepicker-div"]/table/tbody/tr[5]/td[2]/a
		beneficiario = By.xpath("//*[@id=\"ddlBeneficiario\"]/option"); 
		mailAfiliado = By.id("mailAfiliado");
		celAfiliado = By.id("celAfiliado");
		botonContinuar = By.id("fire-modal");
		cargaBoleta = By.xpath("//*[@id=\"standardForm\"]/div[2]/div/div[2]/ul/li[1]/label[2]"); 
		documentoOpcional = By.xpath("//*[@id=\"dochide\"]/a/p"); //*[@id="docadd"]/label[2]
		agregarDocumentoOpcional = By.xpath("//*[@id=\"docadd\"]/label[2]");
		cerrar = By.xpath("//*[@id=\"standardForm\"]/div[2]/div/div[3]/button");
		
		
		//Constructor para validación de Pruebas Correctas
		validadorIngresoUoc = By.xpath("//*[@id=\"MensajeTop\"]/h1");
		
	}
			
		public void BeneficiarioConPresupuestoVigente (String subDir, String lugar, String cirugia, String mail, String cel) throws Exception {
		
			
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
		driver.findElement(ingresoRegion).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 1 ", subDir, "Paso 1_AUT-297");
		Helper.waitSeconds(10);
		
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
		driver.findElement(lugarAtencion).click();
		driver.findElement(lugarAtencion).sendKeys(lugar);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 2 ", subDir, "Paso 2_AUT-297");
		Helper.waitSeconds(10);
				
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
		driver.findElement(seleccionLugar).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 3 ", subDir, "Paso 3_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
		driver.findElement(nombreCirugia).click();
		driver.findElement (nombreCirugia).sendKeys(cirugia);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 4 ", subDir, "Paso 4_AUT-297");
		Helper.waitSeconds(10);
				
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(detalleCirugia).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 5 ", subDir, "Paso 5_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(fechaEstimada).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 6 ", subDir, "Paso 6_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(seleccionFecha).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 7 ", subDir, "Paso 7_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(beneficiario).click();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 8 ", subDir, "Paso 8_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(mailAfiliado).clear();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 9 ", subDir, "Paso 9_AUT-297");
		Helper.waitSeconds(10);
	
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(mailAfiliado).sendKeys(mail);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 10 ", subDir, "Paso 10_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(celAfiliado).clear();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 11 ", subDir, "Paso 11_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		driver.findElement(celAfiliado).sendKeys(cel + Keys.TAB + Keys.TAB + Keys.ENTER);
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 12 ", subDir, "Paso 12_AUT-297");
		Helper.waitSeconds(10);
		
		//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
		/*driver.findElement(botonContinuar).click();
		driver.switchTo().alert().accept();
		Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 13 ", subDir, "Paso 13_AUT-297");
		Helper.waitSeconds(5);*/
		
		}
	
	//Validador de Prueba correcta
		public void assertOrientacionHospitalaria() {
		Helper.waitSeconds(5);	
		Assert.assertTrue(driver.findElement(validadorIngresoUoc).getText().equalsIgnoreCase("Orientación Hospitalaria"));
		} 
		
		
		public void BeneficiarioSinPresupuestoVigente (String subDir, String lugar, String cirugia, String mail, String cel) throws Exception {
			
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
			driver.findElement(ingresoRegion).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 1 ", subDir, "Paso 1_AUT-297");
			Helper.waitSeconds(10);
			
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
			driver.findElement(lugarAtencion).click();
			driver.findElement(lugarAtencion).sendKeys(lugar);
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 2 ", subDir, "Paso 2_AUT-297");
			Helper.waitSeconds(10);
					
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
			driver.findElement(seleccionLugar).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 3 ", subDir, "Paso 3_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos		
			driver.findElement(nombreCirugia).click();
			driver.findElement (nombreCirugia).sendKeys(cirugia);
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 4 ", subDir, "Paso 4_AUT-297");
			Helper.waitSeconds(10);
					
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(detalleCirugia).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 5 ", subDir, "Paso 5_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(fechaEstimada).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 6 ", subDir, "Paso 6_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(seleccionFecha).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 7 ", subDir, "Paso 7_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(beneficiario).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 8 ", subDir, "Paso 8_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(mailAfiliado).clear();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 9 ", subDir, "Paso 9_AUT-297");
			Helper.waitSeconds(10);
		
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(mailAfiliado).sendKeys(mail);
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 10 ", subDir, "Paso 10_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(celAfiliado).clear();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 11 ", subDir, "Paso 11_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(celAfiliado).sendKeys(cel + Keys.TAB + Keys.TAB + Keys.ENTER);
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 12 ", subDir, "Paso 12_AUT-297");
			Helper.waitSeconds(10);
			
			//Carga de Archivo Autoit.exe		
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(cargaBoleta).click();
			Runtime.getRuntime().exec("C:\\Users\\aascencio.ex\\CargaArchivo.exe");
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 14 ", subDir, "Paso 14_AUT-297");
			Helper.waitSeconds(10);
			
			driver.findElement(documentoOpcional).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 14 ", subDir, "Paso 14_AUT-297");
			Helper.waitSeconds(10);
			
			driver.findElement(agregarDocumentoOpcional).click();
			Runtime.getRuntime().exec("C:\\Users\\aascencio.ex\\CargaArchivo1.exe");
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 14 ", subDir, "Paso 14_AUT-297");
			Helper.waitSeconds(10);
			
			//ID-TESTLINK: AUTOMATON-297:Realizar ingreso de datos
			driver.findElement(cerrar).click();
			Helper.addEvidence(TAKE_SS, driver, test, "AUTOMATON-297: Paso 15 ", subDir, "Paso 15_AUT-297");
			Helper.waitSeconds(10);
			
			
			}
		
		//Validador de Prueba correcta
			public void assertOrientacionHospitalaria1() {
			Assert.assertTrue(driver.findElement(validadorIngresoUoc).getText().equalsIgnoreCase("Orientación Hospitalaria"));
			} 


}

 
