package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.dados.abas.AbasHistoricoDados;
import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasHistoricoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.Tabelas;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.pages.Foco;

public class AbasHistorico extends Foco implements Tabelas {

	public AbasHistorico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvarDados(String conjuntoDeDados) {
		BRQLogger.logMethod(conjuntoDeDados);

		switch (conjuntoDeDados) {
		case "Histórico de alterações":
			salvarDadosHistoricoDeAlteracoes();
			break;

		default:
			throw new ErroAutomacao("O conjunto de dados [%s] não foi definido no método [salvarDados].",
					conjuntoDeDados);
		}
	}

	private void salvarDadosHistoricoDeAlteracoes() {
		BRQLogger.logMethod();

		String data, hora, tipoHistorico, tipoInformante, nomeInformante, atendenteAnalista, canalAbertura;

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			data = AbasHistoricoElementos.CAMPO_DATA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			hora = AbasHistoricoElementos.CAMPO_HORA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			tipoHistorico = AbasHistoricoElementos.CAMPO_TIPO_HISTORICO.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			tipoInformante = AbasHistoricoElementos.CAMPO_TIPO_INFORMANTE.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			nomeInformante = AbasHistoricoElementos.CAMPO_NOME_INFORMANTE.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			atendenteAnalista = AbasHistoricoElementos.CAMPO_ATENDENTE_ANALISTA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
			canalAbertura = AbasHistoricoElementos.CAMPO_CANAL_ABERTURA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
		
		BRQLogger.logList("Dados capturados", data, hora, tipoHistorico, tipoInformante, nomeInformante, atendenteAnalista, canalAbertura);

		AbasHistoricoDados.setData(data);
		AbasHistoricoDados.setHora(hora);
		AbasHistoricoDados.setTipoHistorico(tipoHistorico);
		AbasHistoricoDados.setTipoInformante(tipoInformante);
		AbasHistoricoDados.setNomeInformante(nomeInformante);
		AbasHistoricoDados.setAtendenteAnalista(atendenteAnalista);
		AbasHistoricoDados.setCanalAbertura(canalAbertura);
	}

	@Override
	public void clicarCelula(String tabela, int linha, String coluna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clicarCelula(String tabela, String linha, String coluna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCelula(String tabela, int linha, String coluna, Object valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherCelula(String tabela, String linha, String coluna, Object valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherColuna(String tabela, String coluna, List<Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherLinha(String tabela, String linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherLinha(String tabela, int linha, Map<String, Object> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preencherLinhas(String tabela, List<Map<String, Object>> valores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCelula(String tabela, int linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCelula(String tabela, String linha, String coluna, Object valorEsperado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarColuna(String tabela, String coluna, List<Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinha(String tabela, String linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinha(String tabela, int linha, Map<String, Object> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarLinhas(String tabela, List<Map<String, Object>> valoresEsperados) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarCelulas(String tabela, List<String> camposEsperados) {
		BRQLogger.logMethod(tabela, camposEsperados);

		for (String campo : camposEsperados) {
			validarCampo(tabela, campo);
		}
	}

	@Override
	public void validarCampo(String tabela, String campo) {
		BRQLogger.logMethod(tabela, campo);

		switch (campo) {
		case "Data":
			validarCampoData();
			break;

		case "Hora":
			validarCampoHora();
			break;
		}
	}

	public void validarCampoData() {
		BRQLogger.logMethod();
		
		IEsperaWeb.esperarSegundos(20);
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			AbasHistoricoElementos.CAMPO_DATA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
			BRQLogger.logMethod("O campo [Data] apareceu em tela.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
	}

	public void validarCampoHora() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			AbasHistoricoElementos.CAMPO_HORA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
			BRQLogger.logMethod("O campo [Hora] apareceu em tela.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
	}

	@Override
	public void validarCampoPreenchido(String tabela, String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "Data":
			validarCampoDataPreenchido();
			break;

		case "Hora":
			validarCampoHoraPreenchido();
			break;
		}
	}

	public void validarCampoDataPreenchido() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			AbasHistoricoElementos.CAMPO_DATA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
			BRQLogger.logMethod("O campo [Data] apareceu em tela.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
	}

	public void validarCampoHoraPreenchido() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			AbasHistoricoElementos.CAMPO_HORA.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT);
			BRQLogger.logMethod("O campo [Hora] apareceu em tela.");
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
	}

}
