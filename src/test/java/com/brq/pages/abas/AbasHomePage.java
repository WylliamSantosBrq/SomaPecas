package com.brq.pages.abas;

import org.openqa.selenium.WebDriver;

import com.brq.drivers.web.DriverWeb;
import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.interfaces.web.IValidacoesBrowser;
import com.brq.pages.Pagina;

public class AbasHomePage extends Pagina implements AbasMenuSuperior {

	public AbasHomePage() {
		BRQLogger.logMethod();
		trocarJanelaPorIndice(0);
		WebDriver driver = DriverWeb.getDriver();
		
		String urlOriginal;
		do{
		urlOriginal = driver.getCurrentUrl();
		}
		while(urlOriginal==null);
		
		
        System.out.println(MessageFormat.format("URL:{0}",urlOriginal));
        
        Set<String> janelas = DriverWeb.getDriver().getWindowHandles();
        for(String janela:janelas)       {
                driver.switchTo().window(janela);
                System.out.println(MessageFormat.format("Janela encontrada:{0}\nTítulo:{1}\nURL:{2}",//
                janela,driver.getTitle(),driver.getCurrentUrl()));
            }
        
        String novaURL = null;
		if ( urlOriginal.contains("apphubhml")) {
		novaURL = urlOriginal.replace("apphubhml", "apphubhml.portoseguro.brasil");
		}
       System.out.println(MessageFormat.format("URL:{0}",novaURL));
		abrirUrl(novaURL);
		esperarPaginaAbrirContains("Aviso de Sinistro", 30);
		}
		
//		IEsperaWeb.esperarJanelaComTitulo("Aviso de Sinistro", 30);
//		esperarPaginaAbrirContains("Aviso de Sinistro", 30);
	}


