package com.brq.pages.somadesktop;

import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliFornecimentoPelaSeguradoraElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDJustificativaFornecimentoPage extends DesktopPage implements Campos {

	Screen s = new Screen();

	@Override
	public void preencherCampo(String campo, String valor) {
		BRQLogger.logMethod(campo, valor);

		switch (campo) {
		case "Justificativa":
			preencherCampoJustificativa(valor);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [preencherCampo].", campo);
		}
	}

	private void preencherCampoJustificativa(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.wait(SikuliFornecimentoPelaSeguradoraElementos.getInputJustificativa(), 10);
			s.click(SikuliFornecimentoPelaSeguradoraElementos.getInputJustificativa());
			s.type(valor);

		} catch (FindFailed e) {
			throw new ErroSistema(e, "O campo [Justificativa] não apareceu em tela.");
		}
	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCampo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Salvar":
			clicarEmSalvar();
			break;
			
		case "Cancelar":
			clicarEmCancelar();
			break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	private void clicarEmCancelar() {
		BRQLogger.logMethod();

		try {
			s.click(SikuliFornecimentoPelaSeguradoraElementos.getBtnCancelar());
			StepsMaster.setPaginaAtual(new SDVistoriaPecasPage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão [Cancelar] não está visível em tela.");
		}
	}

	private void clicarEmSalvar() {
		BRQLogger.logMethod();
		
		try {
			s.click(SikuliFornecimentoPelaSeguradoraElementos.getBtnSalvar());
			StepsMaster.setPaginaAtual(new SDVistoriaPecasPage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão [Salvar] não está visível em tela.");
		}
	}

	@Override
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCamposDisponiveis(List<String> campos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub
		
	}

}
