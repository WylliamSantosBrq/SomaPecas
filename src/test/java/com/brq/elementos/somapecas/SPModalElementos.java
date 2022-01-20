package com.brq.elementos.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.Elemento;
import com.brq.elementos.Texto;
import gherkin.lexer.El;
import org.openqa.selenium.By;

public class SPModalElementos {

    public static final Elemento MODAL_AVISO = new Elemento(By.cssSelector("div#solicitacaoMudancaModalContentDiv"));
    public static final Texto LBL_MENSAGEM = new Texto(By.cssSelector("div#solicitacaoMudancaModalContentDiv span[class='rich-messages-label']"));
    public static final Botao BTN_OK = new Botao(By.cssSelector("div#solicitacaoMudancaModalContentDiv input[name='solicitacaoMudancaForm:confirmDlg']"));
}
