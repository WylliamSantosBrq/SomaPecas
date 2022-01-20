package com.brq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.brq.erros.ErroAutomacao;

/**
 * Classe para obtenção de com.brq.dados do arquivo
 * src/test/resources/properties/project.properties.
 */
public class PropertiesHelper {
	static String fs = File.separator;
	private static String propertiesPath = FileHelper.projectFile("src", "test", "resources", "properties",
			"project.properties");

	private PropertiesHelper() {
	}

	/**
	 * Obtém a propriedade definida do arquivo project.properties.
	 * 
	 * @param property A propriedade a ser obtida.
	 * @return O valor da propriedade.
	 */
	public static String getProjectProperty(String property) {
		try (FileInputStream fileInputStream = new FileInputStream(propertiesPath)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties.getProperty(property);
		} catch (IOException e) {
			throw new ErroAutomacao(e, "Ocorreu um erro ao acessar [%s].", propertiesPath);
		}
	}

}
