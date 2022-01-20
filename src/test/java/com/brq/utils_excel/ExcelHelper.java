package com.brq.utils_excel;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroMassaDeDados;
import com.brq.interfaces.log.LogWeb;

/**
 * Classe estática para facilitar no manuseio da planilha. Para obter o valor
 * das células, ao mesmo tempo em que se aplica uma tratativa nela, pode ser
 * utilizado a interface de lambdas {@link utils.excel.ValorCelula ValorCelula}.
 * 
 * @author ymnoda
 * @see utils.excel.ValorCelula
 */
public class ExcelHelper {
	private static String caminhoDasPlanilhas =System.getProperty("user.dir") + "\\src\\test\\resources\\massaDeDados" + File.separator;
	private static String nomeDoArquivo = "MassaDeDadosExcel" + ".xlsx";
	private static XSSFWorkbook planilha;
	private static XSSFSheet abaDaPlanilha;
	private static CarregamentoDeDados metodoDeCarregamento;
//	static Logger logger = LogWeb.getLogger(MetodosDeCarregamento.class);
	
	private ExcelHelper() {
	}

	/**
	 * Carrega a planilha, armazenando na variável {@link ExcelHelper#planilha}.
	 * 
	 * @param nomeDoArquivo O nome do arquivo na pasta
	 *                      src/test/resources/massaDeDados/ à ser carregado.
	 * @throws ErroMassaDeDados Caso tenha ocorrido um IOException.
	 * @throws ErroAutomacao    Caso o arquivo passado não esteja no formato
	 *                          esperado.
	 */
	public static void carregarPlanilha() {
		try (OPCPackage pkg = OPCPackage.open(caminhoDasPlanilhas + nomeDoArquivo)) {
			ExcelHelper.planilha = new XSSFWorkbook(pkg);

		} catch (IOException e) {
			// Se der um erro OpenXML4JRuntimeException, o seu pom.xml pode estar
			// desatualizado
			throw new ErroMassaDeDados(e,
					"Ocorreu um erro ao carregar a planilha [%s].\nCertifique-se que a mesma não esteja aberta.",
					nomeDoArquivo);
		} catch (InvalidFormatException e) {
			throw new ErroAutomacao(e, "O formato do arquivo [%s] não é válido.", nomeDoArquivo);
		}
	}

	/**
	 * Carrega a aba da planilha definida, armazenando na variável
	 * {@link ExcelHelper#abaDaPlanilha}.
	 * 
	 * @param nomeDaAba O nome da aba à ser carregada.
	 * @throws ErroAutomacao    Caso a planilha ainda não tenha sido carregada.
	 * @throws ErroMassaDeDados Caso a aba não tenha sido encontrado na planilha.
	 */
	public static void carregarAba(String nomeDaAba) {
		if (ExcelHelper.planilha == null)
			throw new ErroAutomacao(
					"A planilha ainda não foi definida. Use o método carregarPlanilha para carregar a mesma antes de carregar alguma aba.");

		switch(nomeDaAba) {
		case "SolicitacaoFornecimento":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoSolicitacao;
		break;
		case "LocalFornecimento":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoLocal;
		break;
		case "TelefoneSolicitacao":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoTelefone;
		break;
		case "OficinaSolicitacao":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoOficina;
		break;
		case "PecaSolicitacao":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoPeca;
		break;
		case "ProcessoSolicitacao":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoProcesso;
		break;
		case "VeiculoSolicitacao":
			metodoDeCarregamento =  MetodosDeCarregamento.carregamentoVeiculo;
		break;
		
		default:
			
			break;
		}

		ExcelHelper.abaDaPlanilha = ExcelHelper.planilha.getSheet(nomeDaAba);
        assertNotNull("Metodo de Carregamento não Definido", metodoDeCarregamento);
		if (ExcelHelper.abaDaPlanilha == null)
			throw new ErroMassaDeDados("Não foi possível encontrar a aba [%s] da planilha.", nomeDaAba);
	}

	/**
	 * Carrega os dados da aba definida, armazenando na classe
	 * {@link dados.DadosUsuario DadosUsuario}.
	 * 
	 * @param linha O índice da linha de onde será obtido os dados.
	 * @throws ErroAutomacao    Caso a aba ainda não tenha sido definida.
	 * @throws ErroMassaDeDados Caso alguma das células não tenha sido definida
	 *                          corretamente.
	 */
	public static void carregarDadosDaLinha(int linha) {
		if (ExcelHelper.abaDaPlanilha == null)
			throw new ErroAutomacao(
					"A aba ainda não foi definida. Use o método carregarAba para carregar a mesma antes de carregar os dados da linha.");

		XSSFRow row = ExcelHelper.abaDaPlanilha.getRow(linha);

		try {
			metodoDeCarregamento.carregarDados(row);
		} catch (NullPointerException e) {
			throw new ErroMassaDeDados(e, "A linha %d de massa não foi definida corretamente na planilha.", linha);
		}

	}

}
