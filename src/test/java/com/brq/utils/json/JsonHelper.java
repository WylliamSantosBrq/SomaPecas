package com.brq.utils.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.brq.erros.ErroAutomacao;
import com.brq.util.FileHelper;

import lombok.Getter;

public class JsonHelper {

	private static final @Getter String pastaRaiz = FileHelper.projectFolder("src", "test", "resources", "json");
	
	public static JSONObject readJsonObject(String path) throws IOException {
		File arquivo = new File(getPastaRaiz() + path);
		String conteudo = FileUtils.readFileToString(arquivo, "utf-8");
		return new JSONObject(conteudo);
	}
	
	/**
	 * 
	 * @param path Pasta raíz é src/test/resources
	 * @return
	 * @throws IOException
	 */
	public static JSONArray readJsonArray(String path) throws IOException {
		File arquivo = new File(getPastaRaiz() + path);
		String conteudo = FileUtils.readFileToString(arquivo, "utf-8");
		return new JSONArray(conteudo);
	}
	
	public static void writeJson(String path, JSONObject json) {
		try (FileWriter fw = new FileWriter(path)) {
			fw.write(json.toString());
		} catch (IOException e) {
			throw new ErroAutomacao(e, "Ocorreu um erro ao escrever o arquivo JSON.");
		} 
	}
	
	public static void writeJson(String path, JSONArray lista) {
		try (FileWriter fw = new FileWriter(getPastaRaiz() + path)) {
			fw.write(lista.toString());
		} catch (IOException e) {
			throw new ErroAutomacao(e, "Ocorreu um erro ao escrever o arquivo JSON.");
		} 
	}
	
}
