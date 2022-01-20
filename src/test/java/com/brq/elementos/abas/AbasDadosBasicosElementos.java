package com.brq.elementos.abas;

import org.openqa.selenium.By;

import com.brq.elementos.Campo;

public class AbasDadosBasicosElementos {

	private AbasDadosBasicosElementos() {}

	public static final Campo OUTPUT_NATUREZA = new Campo(By.id("descricaoNaturezaSinistro"));
	public static final Campo OUTPUT_CODIGO_NATUREZA = new Campo(By.id("codigoNaturezaSinistro"));
	public static final Campo OUTPUT_TIPO_PERDA = new Campo(By.id("descricaoTipoPerda"));
	public static final Campo OUTPUT_TIPO_PERDA_ENTRADA = new Campo(By.id("tipoPerda"));
	
}
