package com.brq.elementos.somapecas;

import com.brq.elementos.Botao;
import com.brq.elementos.Texto;
import org.openqa.selenium.By;

public class SPTarefasEncerradasElementos {

    public static final Botao BTN_TAREFAS = new Botao(By.xpath("//a[text()='Tarefas Encerradas']"));
    public static final Texto TXT_FORNECEDOR = new Texto(By.xpath("//span[@class='text_title text_upper white_color']"));
    public static final Botao BTN_FORNECEDOR = new Botao(By.xpath("//table[@class='templateLinkPanel templateLinkPanel']//span[@class='text_template_link_bold']"));
    public static final Botao BTN_PEDIDO = new Botao(By.xpath("//span[contains(text(),'Pedido (')]"));
    public static final Botao BTN_ATENDER_PEDIDO_REALIZADO = new Botao(By.xpath("//span[contains(text(),'Atender Pedido: Realizada')]"));
}
