package com.brq.pages.somadesktop;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.brq.elementos.somadesktop.SikuliIndiceDescontoMaoDeObra;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Mensagens;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.DesktopPage;
import com.brq.steps.StepsMaster;

public class SDIndiceDescontoMaoDeObraPage extends DesktopPage implements Campos, Mensagens {

	Screen s = new Screen();

	public SDIndiceDescontoMaoDeObraPage() {
		BRQLogger.logMethod();
	}

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Salvar":
			clicarEmSalvar();
			break;
			
		case "Ok":
			clicarEmOk();
			break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [clicarEm].", botao);
		}
	}

	@Override
	public void limparCampo() {
		BRQLogger.logMethod();

		s.keyDown(KeyEvent.VK_CONTROL);
		s.keyDown("a");
		s.keyDown(KeyEvent.VK_BACK_SPACE);
		s.keyUp();
	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarMensagem(String mensagemEsperada) {
		BRQLogger.logMethod(mensagemEsperada);

		switch (mensagemEsperada) {
		case "Cadastro de Índice de Desconto salvo com sucesso!":
			validarMensagemCadastroIndiceDescontoSalvo();
			break;

		default:
			throw new ErroAutomacao("A mensagem [%s] não foi definida no método [validarMensagem].", mensagemEsperada);
		}
	}

	@Override
	public void preencherCampo(String campo, String valor) {
		BRQLogger.logMethod(campo, valor);

		switch (campo) {
		case "IDP Funilaria":
			preencherCampoIDPFunilaria(valor);
			break;

		case "IDP Mecânica":
			preencherCampoIDPMecanica(valor);
			break;

		case "IDP Tapeçaria":
			preencherCampoIDPTapecaria(valor);
			break;

		case "IDP Acabamento":
			preencherCampoIDPAcabamento(valor);
			break;

		case "IDP Elétrica":
			preencherCampoIDPEletrica(valor);
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [preencherCampo].", campo);
		}

	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub
	}

	@Override
	public void preencherCampos(String campos, String valor) {
		BRQLogger.logMethod(campos, valor);

		switch (campos) {
		case "Índice de Desconto Peças":
			preencherCampoIDPFunilaria(valor);
			preencherCampoIDPMecanica(valor);
			preencherCampoIDPTapecaria(valor);
			preencherCampoIDPAcabamento(valor);
			preencherCampoIDPEletrica(valor);
			break;

		case "Valores de Mão de Obra":
			preencherCampoVMOFunilariaT(valor);
			preencherCampoVMOMecanicaT(valor);
			preencherCampoVMOTapecariaT(valor);
			preencherCampoVMOAcabamentoT(valor);
			preencherCampoVMOEletricaT(valor);
			preencherCampoVMOPinturaT(valor);
			preencherCampoVMOFunilariaR(valor);
			preencherCampoVMOMecanicaR(valor);
			preencherCampoVMOTapecariaR(valor);
			preencherCampoVMOAcabamentoR(valor);
			preencherCampoVMOEletricaR(valor);
			preencherCampoVMOFunilariaM(valor);
			preencherCampoVMOMecanicaM(valor);
			preencherCampoVMOTapecariaM(valor);
			preencherCampoVMOAcabamentoM(valor);
			preencherCampoVMOEletricaM(valor);
			break;

		default:
			throw new ErroAutomacao("A label de campos [%s] não foi definida no método [preencherCampos].");
		}
	}
	
	public void clicarEmSalvar() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliIndiceDescontoMaoDeObra.getBtnSalvar(), 5);
			s.click(SikuliIndiceDescontoMaoDeObra.getBtnSalvar());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão de salvar não foi encontrado.");
		}
		
		try {
			s.wait(SikuliIndiceDescontoMaoDeObra.getTituloJustifiqueIndiceDesconto(), 5);
			s.click(SikuliIndiceDescontoMaoDeObra.getBtnOkJustifiqueIndiceDesconto());
			s.wait(SikuliIndiceDescontoMaoDeObra.getTituloJustifiqueAAlteracao());
			s.type("Justificativa de alteraçao");
			s.click(SikuliIndiceDescontoMaoDeObra.getBtnContinuarJustifiqueAAlteracao());
		} catch (FindFailed e) {
			BRQLogger.info("A janela para inserir justificativa não apareceu em tela.");
		}
	}
	
	public void clicarEmOk() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliIndiceDescontoMaoDeObra.getBtnOkMsgCadastroIndiceDescontoSalvo(), 5);
			s.click(SikuliIndiceDescontoMaoDeObra.getBtnOkMsgCadastroIndiceDescontoSalvo());
			StepsMaster.setPaginaAtual(new SDVistoriaPecasPage());
		} catch (FindFailed e) {
			throw new ErroSistema(e, "O botão de ok não foi encontrado.");
		}
	}
	
	public void validarMensagemCadastroIndiceDescontoSalvo() {
		BRQLogger.logMethod();
		
		try {
			s.wait(SikuliIndiceDescontoMaoDeObra.getMsgCadastroIndiceDescontoSalvo(), 5);
		} catch (FindFailed e) {
			throw new ErroValidacao(e,
					"A mensagem [Cadastro de Índice de Desconto salvo com sucesso!] não foi encontrada em tela.");
		}
	}

	public void preencherCampoIDPFunilaria(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputIDPFunilaria());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [IDPFunilaria].");
		}
	}

	public void preencherCampoIDPMecanica(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputIDPMecanica());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [IDPMecanica].");
		}
	}

	public void preencherCampoIDPTapecaria(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputIDPTapecaria());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [IDPTapecaria].");
		}
	}

	public void preencherCampoIDPAcabamento(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputIDPAcabamento());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [IDPDPAcabamento].");
		}
	}

	public void preencherCampoIDPEletrica(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputIDPEletrica());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [IDPEletrica].");
		}
	}

	public void preencherCampoVMOFunilariaT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOFunilariaT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOFunilariaT].");
		}
	}

	public void preencherCampoVMOMecanicaT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOMecanicaT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOMecanicaT].");
		}
	}

	public void preencherCampoVMOTapecariaT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOTapecariaT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOTapecariaT].");
		}
	}

	public void preencherCampoVMOAcabamentoT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOAcabamentoT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOAcabamentoT].");
		}
	}

	public void preencherCampoVMOEletricaT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOEletricaT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOEletricaT].");
		}
	}

	public void preencherCampoVMOPinturaT(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOPinturaT());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOPinturaT].");
		}
	}

	public void preencherCampoVMOFunilariaR(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOFunilariaR());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOFunilariaR].");
		}
	}

	public void preencherCampoVMOMecanicaR(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOMecanicaR());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOMecanicaR].");
		}
	}

	public void preencherCampoVMOTapecariaR(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOTapecariaR());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOTapecariaR].");
		}
	}

	public void preencherCampoVMOAcabamentoR(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOAcabamentoR());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOAcabamentoR].");
		}
	}

	public void preencherCampoVMOEletricaR(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOEletricaR());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOEletricaR].");
		}
	}

	public void preencherCampoVMOFunilariaM(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOFunilariaM());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOFunilariaM].");
		}
	}

	public void preencherCampoVMOMecanicaM(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOMecanicaM());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOMecanicaM].");
		}
	}

	public void preencherCampoVMOTapecariaM(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOTapecariaM());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOTapecariaM].");
		}
	}

	public void preencherCampoVMOAcabamentoM(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOAcabamentoM());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOAcabamentoM].");
		}
	}

	public void preencherCampoVMOEletricaM(String valor) {
		BRQLogger.logMethod(valor);

		try {
			s.click(SikuliIndiceDescontoMaoDeObra.getInputVMOEletricaM());
			limparCampo();
			s.type(valor);
		} catch (FindFailed e) {
			throw new ErroInesperado(e, "Não foi possível encontrar o campo [VMOEletricaM].");
		}
	}

	@Override
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarListaDeMensagens() {
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
