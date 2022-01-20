package com.brq.utils.informix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.brq.dados.DadosSinistro;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroMassaDeDados;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;
import com.brq.utils.json.JsonHelper;

public class SinistroAutoQueryHelper extends QueryHelper {

	public void executeLambda(String query, CarregamentoDeDados metodoDeCarregamento) {
		BRQLogger.logMethod();

		String url = "jdbc:informix-sqli://u189:1538/porto:informixserver=u15h";

		try {
			Class.forName("com.informix.jdbc.IfxDriver");
		} catch (ClassNotFoundException e) {
			throw new ErroInesperado(e, "A classe [com.informix.jdbc.IfxDriver] não foi encontrada.");
		}

		try (Connection conn = DriverManager.getConnection(url, "usuar", "usuar");) {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			metodoDeCarregamento.carregarDados(rs);

		} catch (SQLException e) {
			throw new ErroMassaDeDados(e, "Ocorreu um erro ao acessar o bando de dados.");
		}
	}

	public void salvarDadosDoSinistro(String naturezaDoSinistro) {
		BRQLogger.logMethod(naturezaDoSinistro);

		executeLambda(getQuery(naturezaDoSinistro), carregamento);
	}

	public String getQuery(String... naturezaDoSinistro) {
		BRQLogger.logMethod(naturezaDoSinistro);

		StringBuilder query = new StringBuilder();
		query.append("SELECT a.ramcod, a.sinano, a.sinnum, b.sinntzcod, b.prdtipcod " //
				+ "FROM ssamsin a, ssamitem b, sanmsin e, sanmavs j " //
				+ "WHERE a.avsdat > today - 5 "//
				+ "AND a.ramcod = 531 "//
				+ "AND a.ramcod = b.ramcod " //
				+ "AND a.sinano = b.sinano "//
				+ "AND a.sinnum = b.sinnum " //
				+ "AND e.sinramcod = b.ramcod " //
				+ "AND b.sinano = e.sinano "//
				+ "AND b.sinnum = e.sinnum " //
				+ "AND j.sinavsnum = e.sinavsnum " //
				+ "AND anllibtip is null "//
				+ "AND anllibdat is null " //
				+ "AND sinavsabrcnlcod in (10,11,12,13,14,15,17,16,19) "//
				+ "AND EXISTS " //
				+ "(SELECT * " //
				+ "FROM ssammvto c " //
				+ "WHERE a.ramcod = c.ramcod " //
				+ "AND a.sinano = c.sinano " //
				+ "AND a.sinnum = c.sinnum) ");

//		SELECT a.ramcod, a.sinano, a.sinnum, b.sinntzcod, b.prdtipcod
//		FROM ssamsin a, ssamitem b, sanmsin e, sanmavs j
//		WHERE avsdat > today - 5 
//		AND a.ramcod = 531 
//		AND a.ramcod = b.ramcod 
//		AND a.sinano = b.sinano 
//		AND a.sinnum = b.sinnum 
//		AND e.sinramcod = b.ramcod 
//		AND b.sinano = e.sinano
//		AND b.sinnum = e.sinnum 
//		AND j.sinavsnum = e.sinavsnum 
//		AND anllibtip is null
//		AND anllibdat is null 
//		AND sinavsabrcnlcod in (10,11,12,13,14,15,17,16,19)
//		AND EXISTS 
//		(SELECT * 
//		FROM ssammvto c 
//		WHERE a.ramcod = c.ramcod 
//		AND a.sinano = c.sinano 
//		AND a.sinnum = c.sinnum) 
//		AND b.sinntzcod in (30,36)

		switch (naturezaDoSinistro[0]) {
		case "Roubo":
		case "roubo":
			query.append("AND b.sinntzcod in (30,36)");
			break;

		case "Colisão":
			query.append("AND b.sinntzcod = 10");
			break;

		default:
			throw new ErroAutomacao(
					"Tipo de sinistro [%s] não definido no método [pegarUmSinistroDeConectandoDiretoComOInformix].",
					naturezaDoSinistro[0]);
		}

		return query.toString();
	}

	private static final CarregamentoDeDados carregamento = rs -> {
		String aRamcod = null;
		String aSinano = null;
		String aSinnum = null;
		String bSinntzcod;
		String bPrdtipcod;

		JSONArray sinistros = new JSONArray();
		SegmentoQueryHelper sapQuery = new SegmentoQueryHelper();

		try {
			while (rs.next()) {
				aRamcod = rs.getString("ramcod");
				aSinano = rs.getString("sinano");
				aSinnum = rs.getString("sinnum");
				bSinntzcod = rs.getString("sinntzcod");
				bPrdtipcod = rs.getString("prdtipcod");

				BRQLogger.info("%s | %s | %s | %s | %s", //
						aRamcod, //
						aSinano, //
						aSinnum, //
						bSinntzcod, //
						bPrdtipcod);

				JSONObject sinistro = new JSONObject();

				sinistro.put("ramcod", aRamcod);
				sinistro.put("sinano", aSinano);
				sinistro.put("sinnum", aSinnum);
				sinistros.put(sinistro);

				if (sapQuery.sinistroComSegmento1080(aRamcod, aSinano, aSinnum))
					break;
			}

			if (aRamcod == null)
				throw new ErroSistema("Não foi possível obter um sinistro da base de dados.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DadosSinistro.setRamoDoSinistro(aRamcod);
		DadosSinistro.setAnoDoSinistro(aSinano);
		DadosSinistro.setNumeroDoSinistro(aSinnum);
	};

	public static JSONArray removerSinistrosUsados(JSONArray lista) {
		BRQLogger.logMethod(lista);

		JSONArray listaNovos = new JSONArray();

		lista.forEach(sinistro -> {
			if (true) {
				listaNovos.put(sinistro);
			}
		});

		return listaNovos;
	}

	public static Boolean sinistroNaoUsado(JSONObject sinistroJson) {
		BRQLogger.logMethod(sinistroJson);

		return null;
	}

	public static Boolean sinistroUsado(String ramo, String ano, String numero) {
		BRQLogger.logMethod(ramo, ano, numero);

		try {
			JSONArray sinistrosUsados = JsonHelper.readJsonArray("sinistrosUsados.json");
			
			for (Object item: sinistrosUsados) {
				String tempRamo = (String) ((JSONObject) item).get("ramo");
				String tempAno = (String) ((JSONObject) item).get("ano");
				String tempNumero = (String) ((JSONObject) item).get("numero");

				BRQLogger.info("%s/%s/%s", tempRamo, tempAno, tempNumero);
				BRQLogger.info("%s/%s/%s", ramo, ano, numero);
				BRQLogger.info("");
				
				if (tempRamo.equals(ramo) && //
						tempAno.equals(ano) && //
						tempNumero.equals(numero))
					return true;
			}
			
		} catch (IOException e) {
			throw new ErroAutomacao(e, "Ocorreu um erro ao ler o arquivo .json de sinistros usados.");
		}

		return false;
	}

	public static JSONObject getUltimoSinistroNaoUsado(JSONArray lista) {
		BRQLogger.logMethod(lista);

		return null;
	}

	public static CarregamentoDeDados getCarregamento() {
		return carregamento;
	}

}
