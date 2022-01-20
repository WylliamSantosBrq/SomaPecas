package com.brq.pages.somadesktop;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaFotosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.somadesktop.SDAnexo;
import com.brq.interfaces.somadesktop.SDVistoriaAbas;
import com.brq.pages.Pagina;

public class SDVistoriaFotosPage extends Pagina implements SDVistoriaAbas, SDAnexo {

	Screen s = new Screen();
	
	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);
		
		switch (botao) {
		case "Adicionar Foto":
			try {
				s.wait(SikuliAbaFotosElementos.getBtnAdicionarFoto(), 30);
				s.click(SikuliAbaFotosElementos.getBtnAdicionarFoto());
			} catch (FindFailed e) {
				throw new ErroInesperado(e, "Não foi possível encontrar o elemento em tela.");
			}
			break;
		
		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}
	
	public void validarFotosCarregadas(int quantidadeDeFotos) {
		BRQLogger.logMethod(quantidadeDeFotos);
		
		try {
			s.wait(SikuliAbaFotosElementos.getTextoFotosEnvolvidos(), 30);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
	
}
