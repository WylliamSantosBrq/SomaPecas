package com.brq.elementos.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.Combo;
import org.openqa.selenium.By;

public class SPCadastrosElementos {

    public static final Botao BTN_CAD_FORNECEDORES = new Botao(By.xpath("//table[@id='formFornecimento:cadastro']//span[text()='CONSULTA DE FORNECEDORES']"));
    public static final Combo CBX_TIPO_FORNECEDOR = new Combo(By.cssSelector("select[id='formFornecimento:tipoFornecedor']"));
    public static final Botao BTN_SALVAR = new Botao(By.cssSelector("table[id='formFornecimento:tabCrudFornecedor'] input[value='Salvar']"));
}
