package com.brq.utils.informix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.brq.dados.DadosSinistro;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroMassaDeDados;
import com.brq.erros.ErroSistema;
import com.brq.interfaces.log.BRQLogger;

public class SegmentoQueryHelper {
	
	private String usuario = "wdssgn";
	private String senha = "wdssgn";
	private String host = "scansgnhm";
	private String port = "1521";
	private String servico = "sgnhmsv";
	private String query = "SELECT * " + //
			"FROM ifaksinsgmprc sin " + //
			"join ifaksgmprc prc on sin.sgmprcide = prc.sgmprcide " + //
			"WHERE prc.sgmmtzcod = 1080 " + //
			"AND sin.ramcod = %s " + //
			"AND sin.sinano = %s " + //
			"AND sin.sinnum = %s " + //
			"AND sin.sinitmseq = 0";

	public void executeLambda(String query, CarregamentoDeDados metodoDeCarregamento) {
		BRQLogger.logMethod();

		String url = String.format("jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = %s)(PORT = %s)))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = %s)))", host, port, servico);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new ErroInesperado(e, "A classe [oracle.jdbc.driver.OracleDriver] não foi encontrada.");
		}
		
		try (Connection conn = DriverManager.getConnection(url, usuario, senha);) {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			metodoDeCarregamento.carregarDados(rs);
			
		} catch (SQLException e) {
			throw new ErroMassaDeDados(e, "Ocorreu um erro ao acessar o bando de dados.");
		}
	}

	public Boolean executeLambda(String query, Validacao validacaoLambda) {
		BRQLogger.logMethod(query, validacaoLambda);
		
//		String url = String.format("jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = %s)(PORT = %s)))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = %s)))", host, port, servico);
		String url = String.format("jdbc:oracle:thin:@//%s:%s/%s", host, port, servico);
		
//		jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = scansgnhm)(PORT = 1521)))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = sgnhmsv)))
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new ErroInesperado(e, "A classe [oracle.jdbc.driver.OracleDriver] não foi encontrada.");
		}
		
		try (Connection conn = DriverManager.getConnection(url, usuario, senha);) {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			return validacaoLambda.validar(rs);
			
		} catch (SQLException e) {
			throw new ErroMassaDeDados(e, "Ocorreu um erro ao acessar o bando de dados.");
		}
	}

	public void salvarDadosDoSinistro(String naturezaDoSinistro) {
		BRQLogger.logMethod(naturezaDoSinistro);

		executeLambda(getQuery(naturezaDoSinistro), carregamento);
	}

	public String getQuery(String... args) {
		BRQLogger.logMethod(args);

		StringBuilder querySB = new StringBuilder();
		querySB.append(String.format(query, args[0], args[1], args[2]));

//		switch (args[3]) {
//		case "Roubo":
//			break;
//
//		case "Colisão":
//			break;
//
//		default:
//			throw new ErroAutomacao(
//					"Tipo de sinistro [%s] não definido no método [getQuery].",
//					args[0]);
//		}

		return querySB.toString();
	}

	private static final CarregamentoDeDados carregamento = rs -> {
		String aRamcod = null;
		String aSinano = null;
		String aSinnum = null;
		String bSinntzcod;
		String bPrdtipcod;

		JSONArray sinistros = new JSONArray();

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

	private static final Validacao cadastradoNoSap = rs -> {
		try {
			String segmento;
			
			while (rs.next()) {
				segmento = rs.getString("sgmmtzcod");

				BRQLogger.info("Segmento: %s", //
						segmento);

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	};

	public JSONArray removerSinistrosForaDoSap(JSONArray lista) {
		BRQLogger.logMethod(lista);
		
		JSONArray listaNovos = new JSONArray();
		
		lista.forEach(sinistro -> {
			if (true) {
				listaNovos.put(sinistro);
			}
		});
		
		return listaNovos;
	}
	
	public Boolean sinistroComSegmento1080(String ramo, String ano, String numero) {
		BRQLogger.logMethod(ramo, ano, numero);
		
		return executeLambda(getQuery(ramo, ano, numero), cadastradoNoSap);
	}

}
