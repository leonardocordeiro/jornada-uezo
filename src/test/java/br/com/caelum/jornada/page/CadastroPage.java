package br.com.caelum.jornada.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.uezo.jornada.modelo.Usuario;

public class CadastroPage {

	private WebDriver driver;

	public CadastroPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void visitar() {
		driver.get("http://localhost:8080/");
	}
	
	private WebElement findElementByName(String name) { 
		return driver.findElement(By.name(name));
	}
	
	public boolean mostrouErroDeValidacao() { 
		String pageSource = driver.getPageSource();
		
		return pageSource.contains("has-error");
	}
	
	public void cadastraUsuario(Usuario usuario) {
		visitar();
		
		WebElement nome = findElementByName("nome");
		nome.sendKeys(usuario.getNome());
		
		WebElement email = findElementByName("email");
		email.sendKeys(usuario.getEmail());
		
		WebElement senha = findElementByName("senha");
		senha.sendKeys(usuario.getSenha());
	
		WebElement matricula = findElementByName("matricula");
		matricula.sendKeys(usuario.getMatricula());
		
		WebElement button = findElementByName("cadastrarButton");
		button.submit();
		
	}
}
