package com.brq.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Classe para facilitar na manipulação de arquivos do projeto.
 * 
 * @author ymnoda
 *
 */
public class FileHelper {
	private static String fs = File.separator;

	private FileHelper() {
	}

	/**
	 * Formata as pastas definidas para um caminho do projeto.
	 * 
	 * <dt>Exemplo (no Windows):</dt>
	 * <dd>projectFolder("src", "test", "resources") ->
	 * System.getProperty("user.dir") + "/src/test/resources/"</dd>
	 * 
	 * 
	 * @param caminho A(s) pasta(s) usada(s) para definir o caminho no sistema.
	 * @return Uma String contendo o caminho específicado, com a raíz do projeto e
	 *         os separadores específicos do sistema.
	 */
	public static String projectFolder(String... caminho) {
		return String.format("%s%s%s%s", System.getProperty("user.dir"), fs, String.join(fs, caminho), fs);
	}

	/**
	 * Formata as pastas definidas para um caminho do projeto. Exemplo (Windows):
	 * projectFolder("src", "main", "java", "com.brq.util", "FileHelper.java") ->
	 * System.getProperty("user.dir") + "/src/main/java/com.brq.util/FileHelper.java"
	 * 
	 * @param caminho A(s) pasta(s) usada(s) para definir o caminho no sistema,
	 *                sendo o último argumento o arquivo com extensão.
	 * @return Uma String contendo o arquivo com caminho específicado, com a raíz do
	 *         projeto e os separadores específicos do sistema.
	 */
	public static String projectFile(String... caminho) {
		return String.format("%s%s%s", System.getProperty("user.dir"), fs, String.join(fs, caminho));
	}

	/**
	 * Substitui todas as barras (/) da String definida pelo separador específico do
	 * sistema.
	 * 
	 * @param caminho A String a ser formatada. Exemplo: "src/test/java".
	 * @return A String com os separadores corretos.
	 */
	public static String formatFileSeparator(String caminho) {
		return caminho.replace("/", fs);
	}

	/**
	 * Identifica e altera a extensão do arquivo com base no sistema operacional
	 * atual.
	 * 
	 * @param file O arquivo que terá a extensão modificada.
	 * @return O arquivo com a extensão apropriada.
	 */
	public static String osExtensionFile(String file) {
		String[] splitFile = file.split("\\.");

		if (getOs().contains("linux"))
			splitFile[1] = splitFile[1].toUpperCase();
		else if (getOs().contains("windows"))
			splitFile[1] = splitFile[1].toLowerCase();

		return String.join(".", splitFile);
	}

	/**
	 * Obtém o sistema operacional atual.
	 * 
	 * @return O sistema operacional da máquina rodando o script.
	 */
	public static String getOs() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	public static void appendTextToFile(String arquivo, String texto) {
		try {
			Files.write(
					Paths.get(projectFile("src", "test", "resources", "temp", arquivo)),
			        (texto + System.lineSeparator()).getBytes(),
			        StandardOpenOption.CREATE, StandardOpenOption.APPEND
			    );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
