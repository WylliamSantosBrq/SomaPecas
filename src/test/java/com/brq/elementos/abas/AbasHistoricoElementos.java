package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Texto;

public class AbasHistoricoElementos {

	private AbasHistoricoElementos() {}

	public static final Texto CAMPO_DATA = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Data']]//following::tr/td[1][@class='tabela_celula']/span[@class='texto']"));
	public static final Texto CAMPO_HORA = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[2][@class='tabela_celula']/span[@class='texto']"));
	public static final Texto CAMPO_TIPO_HISTORICO = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[3]/span[@class='texto']"));
	public static final Texto CAMPO_TIPO_INFORMANTE = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[4]/span[@class='texto']"));
	public static final Texto CAMPO_NOME_INFORMANTE = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[5]/span[@class='texto']"));
	public static final Texto CAMPO_ATENDENTE_ANALISTA = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[6]/span[@class='texto']"));
	public static final Texto CAMPO_CANAL_ABERTURA = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Hora']]//following::tr/td[7]/span[@class='texto']"));
	
}
