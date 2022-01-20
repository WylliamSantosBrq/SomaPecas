package com.brq.utils.json;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.brq.interfaces.log.BRQLogger;

public class SinistroJsonHelper {

	public static void appendSinistro(String ramo, String ano, String numero) {
		BRQLogger.logMethod(ramo, ano, numero);

		try {
			JSONArray lista = JsonHelper.readJsonArray("sinistrosUsados.json");
			JSONObject novoSinistro = new JSONObject();
			novoSinistro.put("ramo", ramo);
			novoSinistro.put("ano", ano);
			novoSinistro.put("numero", numero);
			lista.put(novoSinistro);
			JsonHelper.writeJson("sinistrosUsados.json", lista);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
