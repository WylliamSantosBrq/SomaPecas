package com.brq.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import com.brq.dados.DadosUsuarioDesligamento;
import com.brq.interfaces.log.BRQLogger;
import com.cucumber.listener.Reporter;

/**
 * Classe para ajudar no evidenciamento de cenários, tanto para limpar a pasta
 * de evidências quanto para adicionar logs no report gerado no final da
 * execução.
 * 
 * @author leonardoananias
 *
 */
public class EvidenciasHelper {

	private EvidenciasHelper() {
	}

	/**
	 * Deleta os prints a cada nova execução
	 * 
	 * @author leonardoananias
	 */
	public static void deletarPrints() {
		BRQLogger.logMethod();

		deletarSePossuiArquivos(getPastaDeEvidencia("Prints_Erro"));
		deletarSePossuiArquivos(getPastaDeEvidencia("Prints_Sucesso"));
		deletarSePossuiArquivos(getPastaDeEvidencia(null));
	}

	/**
	 * Veriica se possui arquivos na pasta desejada
	 * 
	 * @author leonardoananias
	 * @param caminho
	 */
	private static void deletarSePossuiArquivos(String caminho) {
		BRQLogger.logMethod(caminho);

		try {
			File file = new File(caminho);
			if (file.listFiles().length > 0) {
				Arrays.stream(file.listFiles()).forEach(File::delete);
			}
		} catch (Exception e) {
			BRQLogger.info("Não foi possível excluir os prints");
		}
	}

	/**
	 * Retorna a pasta com as evidencias.
	 * 
	 * @author leonardoananias
	 * @param nomeDaPasta
	 * @return
	 */
	private static String getPastaDeEvidencia(String nomeDaPasta) {
		BRQLogger.logMethod(nomeDaPasta);

		String caminho = System.getProperty("user.dir").concat(File.separator.concat("Evidencias"));
		caminho = nomeDaPasta == null ? caminho : caminho.concat(File.separator.concat(nomeDaPasta));
		return caminho;
	}

	/**
	 * Adiciona log no cenário com base nas tags vinculadas com o cenário atual.
	 * 
	 * @param tagsDoCenario
	 */
	public static void logEvidencias(Collection<String> tagsDoCenario) {
		BRQLogger.logMethod(tagsDoCenario);

		StringBuilder builder = new StringBuilder();

		for (String tagDoCenario : tagsDoCenario) {
			switch (tagDoCenario) {
			case "@desligamento":
				builder.append(String.format("Colaborador: %s%n", DadosUsuarioDesligamento.getNome()));
				builder.append(String.format("Vice Presidente: %s%n", DadosUsuarioDesligamento.getVicePresidente()));
				break;
			}
		}

		Reporter.addScenarioLog(builder.toString()); //
	}
}
