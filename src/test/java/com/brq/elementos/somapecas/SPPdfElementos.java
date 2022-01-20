package com.brq.elementos.somapecas;

import com.brq.elementos.Campo;
import org.openqa.selenium.By;

public class SPPdfElementos {

    private SPPdfElementos(){}

    public static final Campo viewPdf = new Campo(By.id("viewer"));
    public static final Campo pluginPdf = new Campo(By.id("plugin"));
}
