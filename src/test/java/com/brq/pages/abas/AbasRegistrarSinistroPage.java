package com.brq.pages.abas;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Texto;
import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.Botoes;
import com.brq.interfaces.Campos;
import com.brq.interfaces.Radios;
import com.brq.interfaces.Tabelas;
import com.brq.interfaces.abas.AbasAba;
import com.brq.interfaces.abas.AbasCarregamento;
import com.brq.interfaces.abas.AbasMenuAvisoLateral;
import com.brq.interfaces.abas.AbasMenuSuperior;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;
import com.brq.pages.Pagina;
import com.brq.pages.abas.focos.AbasApolice;
import com.brq.pages.abas.focos.AbasCausador;
import com.brq.pages.abas.focos.AbasDadosBasicos;
import com.brq.pages.abas.focos.AbasDocumentos;
import com.brq.pages.abas.focos.AbasHistorico;
import com.brq.pages.abas.focos.AbasLiberacao;
import com.brq.pages.abas.focos.AbasLocal;
import com.brq.pages.abas.focos.AbasLocalizacao;
import com.brq.pages.abas.focos.AbasMovimentos;
import com.brq.pages.abas.focos.AbasNotas;
import com.brq.pages.abas.focos.AbasOcorrencias;
import com.brq.pages.abas.focos.AbasQuestionario;
import com.brq.pages.abas.focos.AbasSegurado;
import com.brq.pages.abas.focos.AbasSiasiOnline;
import com.brq.pages.abas.focos.AbasTarefas;
import com.brq.pages.abas.focos.AbasTempoAnalise;
import com.brq.pages.abas.focos.AbasVitima;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class AbasRegistrarSinistroPage extends Pagina implements AbasAba, AbasCarregamento, AbasMenuAvisoLateral, AbasMenuSuperior, Campos, Tabelas {

	public AbasRegistrarSinistroPage() {
		BRQLogger.logMethod();

		esperarPaginaAbrirContains("Aviso de Sinistro", 30);

		setFocoAtual(getFocoAbaAtual());
	}

	public AbasRegistrarSinistroPage(String aba){
		BRQLogger.logMethod();
		esperarPaginaAbrirContains(aba, 30);
	}

	public Foco getFocoAbaAtual() {
		BRQLogger.logMethod();

		switch (getAbaAtual()) {

		case "Tempo Analise":
			return new AbasTempoAnalise();

		case "Dados Basicos":
			return new AbasDadosBasicos();

		case "Local":
			return new AbasLocal();

		case "Questionario":
			return new AbasQuestionario();

		case "Vitima":
			return new AbasVitima();

		case "Apolice":
			return new AbasApolice();

		case "Notas":
			return new AbasNotas();

		case "Historico":
			return new AbasHistorico();

		case "Tarefas":
			return new AbasTarefas();

		case "SIASI Online":
			return new AbasSiasiOnline();

		case "Localização":
			return new AbasLocalizacao();

		case "Documentos":
			return new AbasDocumentos();

		case "Movimentos":
			return new AbasMovimentos();

		case "Ocorrencias":
			return new AbasOcorrencias();

		case "Liberação":
			return new AbasLiberacao();

		case "Segurado":
			return new AbasSegurado();	

		case "Causador":
			return new AbasCausador();				
			
		default:
			throw new ErroAutomacao("Aba [%s] não definida no método [getFocoAbaAtual].");
		}
	}

	@Override
	public void salvarDados(String conjuntoDeDados) {
		getFocoAtual().salvarDados(conjuntoDeDados);
	}

	@Override
	public void fecharJanela(String texto){

	}

	@Override
	public void preencherCampo(String campo, String valor) {
		// TODO Auto-generated method stub
		
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
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		BRQLogger.logMethod(mapValoresEsperados);
		
		((Campos) getFocoAtual()).validarCampos(mapValoresEsperados);
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		// TODO Auto-generated method stub
		
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
	public void validarCelulas(String tabela, List<String> celulasEsperadas) {
		BRQLogger.logMethod(tabela, celulasEsperadas);
		
		((Tabelas) getFocoAtual()).validarCelulas(tabela, celulasEsperadas);
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

	  public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);
		
		((Botoes) getFocoAtual()).validarBotaoDisponivel(botao);
		
	}	

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod();
		
		((Campos) getFocoAtual()).validarCampoPreenchido(campo);
		
	}

	public void validarPerguntaResposta(String pergunta, String resposta) {
		BRQLogger.logMethod(pergunta,resposta);
		
		((Radios) getFocoAtual()).validarPerguntaResposta(pergunta,resposta);
		
	}
	
	public void validarDadosCausador() {
		BRQLogger.logMethod();
		
		((AbasCausador) getFocoAtual()).validarDadosCausador();
	}

	@Override
	public void validarCamposDisponiveis(List<String> campos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampo(String tabela, String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoPreenchido(String tabela, String campo) {
		((Tabelas) getFocoAtual()).validarCampoPreenchido(tabela, campo);
	}

	public void modalDadosBasicos(){
		Texto abaDados = new Texto(By.xpath("//form[@id='abasForm']//span[text()='Dados Basicos']"));
		String aba = abaDados.esperarSerVisivel(DEFAULT_STEPS_TIMEOUT).obterTexto();
		Assertions.assertEquals("Dados Basicos", aba);
	}
}
