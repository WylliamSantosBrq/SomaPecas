package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Texto;

public class AbasTempoAnaliseElementos {

	private AbasTempoAnaliseElementos() {}

	public static final Texto DATA_AVISO_SINISTRO = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Data Aviso Sinistro']]//following::tr/td[1]/span[@class='texto9']"));
	public static final Texto DIAS_ENCERRADO = new Texto(By.xpath("//*[span/u[text()='Quantidade dias encerrados']]//following::tr[1]/td[2]/span[@class='texto9Direita']"));
	public static final Texto DIAS_AGUARDANDO_DOC = new Texto(By.xpath("//*[span/u[text()='Quantidade dias aguardando documento']]//following::tr[1]/td[3]/span[@class='texto9Direita']"));
	public static final Texto DIAS_AGUARDANDO_VISTORIA = new Texto(By.xpath("//*[span/u[text()='Quantidade dias aguardando vistoria']]//following::tr[1]/td[4]/span[@class='texto9Direita']"));
	public static final Texto DATA_CONCLUSÃO_SINISTRO = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Data conclusão Sinistro']]//following::tr/td[5]/span[@class='texto9']"));
	public static final Texto TEMPO_TOTAL_REGULACAO = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Data Aviso Sinistro']]//following::tr[2]/td[2]/span[@class='texto9Direita']"));
	public static final Texto TEMPO_RESTANTE_REGULACAO = new Texto(By.xpath("//tr[td/span[normalize-space(text())='Data Aviso Sinistro']]//following::tr[3]/td[2]/span[@class='texto9Direita']"));
	
}

