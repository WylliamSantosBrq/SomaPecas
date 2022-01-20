package com.brq.interfaces.somadesktop;

import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliAbaFotosElementos;
import com.brq.elementos.somadesktop.SikuliGeralElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Anexos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.steps.StepsMaster;
import com.brq.util.FileHelper;

public interface SDAnexo extends Anexos {

	Screen s = new Screen();

	@Override
	default void anexarArquivo(String caminhoDoArquivo) {
		// TODO Auto-generated method stub

	}

	@Override
	default void anexarArquivos(String... caminhosDosArquivos) {
		// TODO Auto-generated method stub

	}

	@Override
	default void anexarArquivos(int quantidadeDeArquivos) {
		BRQLogger.logMethod(quantidadeDeArquivos);

		if (quantidadeDeArquivos < 0)
			throw new ErroAutomacao("Não é possível anexar uma quantidade negativa de arquivos.");

		try {
			s.wait(SikuliGeralElementos.getInputAbrirAnexo(), 15);
			s.click(SikuliGeralElementos.getInputAbrirAnexo());
			s.type(FileHelper.projectFolder("src\\test\\resources\\anexos"));
			s.click(SikuliGeralElementos.getTituloAbrirAnexo().targetOffset(396, 33));
			StepsMaster.getPaginaAtual().esperarSegundos(1);
			s.click(SikuliGeralElementos.getArquivo1AbrirAnexo());
			s.keyDown(KeyEvent.VK_CONTROL);
			s.keyDown("a");
			StepsMaster.getPaginaAtual().esperarMilisegundos(50);
			s.keyUp();
			s.click(SikuliGeralElementos.getBtnAbrirAbrirAnexo());
			s.wait(SikuliAbaFotosElementos.getTituloUploadFotos(), 60);
			s.click(Region.create(673, 170, 1, 1));

		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o elemento em tela.");
		}
	}

}
