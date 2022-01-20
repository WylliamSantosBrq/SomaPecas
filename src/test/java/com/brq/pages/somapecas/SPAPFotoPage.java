package com.brq.pages.somapecas;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.brq.elementos.somapecas.SPAPFotosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroValidacao;
import com.brq.executar.CucumberExecuteTest;
import com.brq.interfaces.Fotos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Pagina;
import com.brq.pages.somapecas.focos.SPAtenderPedido;
import com.brq.steps.StepsMaster;
import com.brq.util.StringHelper;

public class SPAPFotoPage extends Pagina implements Fotos {

	private Integer ultimoWidth;
	private static final Integer MINIATURA_TIMEOUT = 60;

	@Override
	public void clicarEm(String botao) {
		BRQLogger.logMethod(botao);

		if (botao.endsWith(" miniatura")) {
			String strOrdinal = StringHelper.getGroup(botao, "(.*?) miniatura").get(0);
			clicarNaMiniatura(StringHelper.getZeroBasedOrdinal(strOrdinal));
			return;
		}

		switch (botao) {
		case "Lupa+":
		case "Lupa +":
		case "Lupa(+)":
			ampliar();
//			clicarEmLupaAmpliar();
			break;

		default:
			throw new ErroAutomacao();
		}
	}

	public void clicarNaMiniatura(Integer indice) {
		BRQLogger.logMethod(indice);

		SPAPFotosElementos.BTN_MINIATURA_FOTO//
				.esperarSerVisivel(MINIATURA_TIMEOUT)
				.esperarSerClicavel(MINIATURA_TIMEOUT)
				.clicarJavascript(indice);
	}

	public void clicarEmLupaAmpliar() {
		BRQLogger.logMethod();

		SPAPFotosElementos.BTN_ZOOM_IN.esperarSerVisivel(CucumberExecuteTest.DEFAULT_STEPS_TIMEOUT);
		SPAPFotosElementos.BTN_ZOOM_IN.clicar();
	}

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "Fotos":
			esperarExibicaoFotos(EXTREMELY_LONG_STEPS_TIMEOUT);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	private void esperarExibicaoFotos(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		SPAPFotosElementos.JANELA_FOTOS.esperarExistir(tempoEmSegundos);
	}

	@Override
	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		switch (caixa) {
		case "Fotos":
			fecharCaixaFotos();
			break;

		default:
			throw new ErroAutomacao("");
		}
	}

	public void fecharCaixaFotos() {
		BRQLogger.logMethod();

		SPAPFotosElementos.BTN_FECHAR.clicar();

		StepsMaster.setPaginaAtual(new SPDashBoardPage(new SPAtenderPedido()));
	}

	@Override
	public void esperarFotos(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		SPAPFotosElementos.IMG_FOTO.esperarExistir(tempoEmSegundos);
	}

	@Override
	public void ampliar() {
		BRQLogger.logMethod();

		String style = SPAPFotosElementos.IMG_FOTO.obterAtributo("style");
		String width = StringHelper.getGroup(style, "width: ?(\\d+)\\w+").get(0);
		setUltimoWidth(Integer.valueOf(width));

		clicarEmLupaAmpliar();
	}

	@Override
	public void reduzir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarZoom() {
		BRQLogger.logMethod();

		String style = SPAPFotosElementos.IMG_FOTO.obterAtributo("style");
		String width = StringHelper.getGroup(style, "width: ?(\\d+)\\w+").get(0);

		assertNotNull(width);
		assertNotNull(getUltimoWidth());
		if (Integer.valueOf(width) <= getUltimoWidth())
			throw new ErroValidacao("A foto não foi ampliada.");
	}

	public Integer getUltimoWidth() {
		return ultimoWidth;
	}

	public void setUltimoWidth(Integer ultimoWidth) {
		this.ultimoWidth = ultimoWidth;
	}

}
