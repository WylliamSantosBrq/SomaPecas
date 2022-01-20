package com.brq.elementos.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.Campo;
import com.brq.elementos.Tabela;
import org.openqa.selenium.By;

public class SPConsultaFornecedoresElementos {

    public static final Campo TXT_RAZAO_SOCIAL = new Campo(By.cssSelector("input[id='formFornecimento:filtroRazaoSocialFornecedor']"));
    public static final Botao BTN_BUSCAR = new Botao(By.cssSelector("input[id='formFornecimento:btn_buscar_fornecedores']"));
    public static final Tabela TBL_LISTA_FORNECEDOR = new Tabela("//tbody[@id='formFornecimento:listFornecedores:tb']");

}
