package com.brq.steps.avisodigital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brq.dados.DadosSinistro;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroMassaDeDados;
import com.brq.interfaces.log.BRQLogger;
import com.brq.steps.StepsMaster;
import com.brq.utils.informix.EstadoQueryHelper;
import com.brq.utils.informix.SegmentoQueryHelper;
import com.brq.utils.informix.SinistroAutoQueryHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AvisoDigitalSteps extends StepsMaster {

	public AvisoDigitalSteps() {
	}

	@Given("^que (?:o usuário )?pegou um sinistro do tipo \"(.*?)\" e natureza \"(.*?)\" conectando direto com o Informix$")
	@When("^(?:o usuário )pegar um sinistro do tipo \"(.*?)\" e natureza \"(.*?)\" conectando direto com o Informix$")
	public void pegarUmSinistroConectandoDiretoComOInformix(String tipo, String natureza) {
		SinistroAutoQueryHelper sinistroQuery = new SinistroAutoQueryHelper();

//		sinistroQuery.executeLambda(sinistroQuery.getQuery("roubo"), SinistroAutoQueryHelper.getCarregamento());

		String aRamcod = null;
		String aSinano = null;
		String aSinnum = null;
		String bSinntzcod;
		String bPrdtipcod;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT distinct a.ramcod, a.sinano, a.sinnum, b.sinntzcod, b.prdtipcod " //
				+ "FROM ssamsin a, ssamitem b, sanmsin e, sanmavs j, sanmcvnsin s " //
				+ "WHERE avsdat > today - 10 "//
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
				+ "AND sinavsabrcnlcod in (10,11,12,13,14,15,17,16,19) " //
				+ "AND EXISTS " //
				+ "(SELECT * " //
				+ "FROM ssammvto c " //
				+ "WHERE a.ramcod = c.ramcod " //
				+ "AND a.sinano = c.sinano " //
				+ "AND a.sinnum = c.sinnum) " //
		);

		switch (natureza.toLowerCase()) {
		case "colisão":
			queryBuilder.append("AND b.sinntzcod = 10 ");
			break;

		case "furto parcial":
			queryBuilder.append("AND b.sinntzcod = 12 ");
			break;

		case "incêndio":
			queryBuilder.append("AND b.sinntzcod = 20 ");
			break;

		case "roubo":
			queryBuilder.append("AND b.sinntzcod = 30 ");
			break;

		case "furto total":
			queryBuilder.append("AND b.sinntzcod = 36 ");
			break;

		case "atos danosos":
			queryBuilder.append("AND b.sinntzcod = 40 ");
			break;

		case "enchente/inundação":
			queryBuilder.append("AND b.sinntzcod = 50 ");
			break;

		case "capotagem":
			queryBuilder.append("AND b.sinntzcod = 52 ");
			break;

		case "abalroamento":
			queryBuilder.append("AND b.sinntzcod = 53 ");
			break;

		case "choque":
			queryBuilder.append("AND b.sinntzcod = 57 ");
			break;

		case "outros":
			queryBuilder.append("AND b.sinntzcod = 60 ");
			break;

		case "roubo localizado":
			queryBuilder.append("AND b.sinntzcod = 64 ");
			break;

		case "roubo de acessórios":
			queryBuilder.append("AND b.sinntzcod = 65 ");
			break;

		case "furto localizado":
			queryBuilder.append("AND b.sinntzcod = 68 ");
			break;

		case "blindados-vidros":
			queryBuilder.append("AND b.sinntzcod = 77 ");
			break;

		case "acidentes pessoais":
			queryBuilder.append("AND b.sinntzcod = 90 ");
			break;

		default:
			throw new ErroAutomacao(
					"A natureza [%s] não foi definida no método [pegarUmSinistroConectandoDiretoComOInformix].",
					natureza);
		}

		switch (tipo.toLowerCase()) {
		case "porto seguro":
		case "porto":
			queryBuilder.append("AND s.cvnnum = 0 ");
			break;

		case "itau":
		case "itaú":
			queryBuilder.append("AND s.cvnnum in (108, 109) ");
			break;

		case "itau frota":
		case "itaú frota":
			queryBuilder.append("AND s.cvnnum in (114, 115) ");
			break;

		default:
			throw new ErroAutomacao(
					"O tipo [%s] não foi definido no método [pegarUmSinistroConectandoDiretoComOInformix].", tipo);
		}

		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			String url = "jdbc:informix-sqli://u189:1538/porto:informixserver=u15h";
			Connection conn = DriverManager.getConnection(url, "usuar", "usuar");
			PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString().trim());
			ResultSet rs = preparedStatement.executeQuery();

			int i = 0;
			SegmentoQueryHelper segmentoQuery = new SegmentoQueryHelper();
			EstadoQueryHelper estadoQuery = new EstadoQueryHelper();

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

				System.out.println(String.format("%s %s %s", aRamcod, aSinano, aSinnum));
				
				if (!segmentoQuery.sinistroComSegmento1080(aRamcod, aSinano, aSinnum))
					continue;

				if (SinistroAutoQueryHelper.sinistroUsado(aRamcod, aSinano, aSinnum))
					continue;

				break;
			}

			conn.close();

//			if (aRamcod == null)
//				throw new ErroSistema("Não foi possível obter um sinistro da base de dados.");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (aSinnum == null)
			throw new ErroMassaDeDados("Não foi possível obter nenhum número de sinistro.");

//		TODO Parâmetros para serem usado quando for possível pegar a massa pelo Informix.
		DadosSinistro.setRamoDoSinistro(aRamcod);
		DadosSinistro.setAnoDoSinistro(aSinano);
		DadosSinistro.setNumeroDoSinistro(aSinnum);

//		TODO Deschumbar a massa.
//		DadosSinistro.setRamoDoSinistro("531");
//		DadosSinistro.setAnoDoSinistro("2021");
//		DadosSinistro.setNumeroDoSinistro("3703");

//		SinistroJsonHelper.appendSinistro(aRamcod, aSinano, aSinnum);
	}

	@Given("^que (?:o usuário )?pegou um sinistro do tipo \"(.*?)\", natureza \"(.*?)\" e estado \"(.*?)\" conectando direto com o Informix$")
	@When("^(?:o usuário )pegar um sinistro do tipo \"(.*?)\", natureza \"(.*?)\" e estado \"(.*?)\" conectando direto com o Informix$")
	public void pegarUmSinistroConectandoDiretoComOInformix(String tipo, String natureza, String estado) {
		SinistroAutoQueryHelper sinistroQuery = new SinistroAutoQueryHelper();

//		sinistroQuery.executeLambda(sinistroQuery.getQuery("roubo"), SinistroAutoQueryHelper.getCarregamento());

		String aRamcod = null;
		String aSinano = null;
		String aSinnum = null;
		String bSinntzcod;
		String bPrdtipcod;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT distinct a.ramcod, a.sinano, a.sinnum, b.sinntzcod, b.prdtipcod " //
				+ "FROM ssamsin a, ssamitem b, sanmsin e, sanmavs j, sanmcvnsin s " //
				+ "WHERE avsdat > today - 10 "//
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
				+ "AND sinavsabrcnlcod in (10,11,12,13,14,15,17,16,19) " //
				+ "AND EXISTS " //
				+ "(SELECT * " //
				+ "FROM ssammvto c " //
				+ "WHERE a.ramcod = c.ramcod " //
				+ "AND a.sinano = c.sinano " //
				+ "AND a.sinnum = c.sinnum) " //
		);

		switch (natureza.toLowerCase()) {
		case "colisão":
			queryBuilder.append("AND b.sinntzcod = 10 ");
			break;

		case "furto parcial":
			queryBuilder.append("AND b.sinntzcod = 12 ");
			break;

		case "incêndio":
			queryBuilder.append("AND b.sinntzcod = 20 ");
			break;

		case "roubo":
			queryBuilder.append("AND b.sinntzcod = 30 ");
			break;

		case "furto total":
			queryBuilder.append("AND b.sinntzcod = 36 ");
			break;

		case "atos danosos":
			queryBuilder.append("AND b.sinntzcod = 40 ");
			break;

		case "enchente/inundação":
			queryBuilder.append("AND b.sinntzcod = 50 ");
			break;

		case "capotagem":
			queryBuilder.append("AND b.sinntzcod = 52 ");
			break;

		case "abalroamento":
			queryBuilder.append("AND b.sinntzcod = 53 ");
			break;

		case "choque":
			queryBuilder.append("AND b.sinntzcod = 57 ");
			break;

		case "outros":
			queryBuilder.append("AND b.sinntzcod = 60 ");
			break;

		case "roubo localizado":
			queryBuilder.append("AND b.sinntzcod = 64 ");
			break;

		case "roubo de acessórios":
			queryBuilder.append("AND b.sinntzcod = 65 ");
			break;

		case "furto localizado":
			queryBuilder.append("AND b.sinntzcod = 68 ");
			break;

		case "blindados-vidros":
			queryBuilder.append("AND b.sinntzcod = 77 ");
			break;

		case "acidentes pessoais":
			queryBuilder.append("AND b.sinntzcod = 90 ");
			break;

		default:
			throw new ErroAutomacao(
					"A natureza [%s] não foi definida no método [pegarUmSinistroConectandoDiretoComOInformix].",
					natureza);
		}

		switch (tipo.toLowerCase()) {
		case "porto seguro":
		case "porto":
			queryBuilder.append("AND s.cvnnum = 0 ");
			break;

		case "itau":
		case "itaú":
			queryBuilder.append("AND s.cvnnum in (108, 109) ");
			break;

		case "itau frota":
		case "itaú frota":
			queryBuilder.append("AND s.cvnnum in (114, 115) ");
			break;

		default:
			throw new ErroAutomacao(
					"O tipo [%s] não foi definido no método [pegarUmSinistroConectandoDiretoComOInformix].", tipo);
		}

		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			String url = "jdbc:informix-sqli://u189:1538/porto:informixserver=u15h";
			Connection conn = DriverManager.getConnection(url, "usuar", "usuar");
			PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString().trim());
			ResultSet rs = preparedStatement.executeQuery();

			int i = 0;
			SegmentoQueryHelper segmentoQuery = new SegmentoQueryHelper();
			EstadoQueryHelper estadoQuery = new EstadoQueryHelper();

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

				System.out.println(String.format("%s %s %s", aRamcod, aSinano, aSinnum));
				
				if (!estadoQuery.estadoDoSinistro(aRamcod, aSinano, aSinnum, estado)) 
					continue;

				if (!segmentoQuery.sinistroComSegmento1080(aRamcod, aSinano, aSinnum))
					continue;

				if (SinistroAutoQueryHelper.sinistroUsado(aRamcod, aSinano, aSinnum))
					continue;

				break;
			}

			conn.close();

//			if (aRamcod == null)
//				throw new ErroSistema("Não foi possível obter um sinistro da base de dados.");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (aSinnum == null)
			throw new ErroMassaDeDados("Não foi possível obter nenhum número de sinistro.");

//		TODO Parâmetros para serem usado quando for possível pegar a massa pelo Informix.
		DadosSinistro.setRamoDoSinistro(aRamcod);
		DadosSinistro.setAnoDoSinistro(aSinano);
		DadosSinistro.setNumeroDoSinistro(aSinnum);

//		TODO Deschumbar a massa.
//		DadosSinistro.setRamoDoSinistro("531");
//		DadosSinistro.setAnoDoSinistro("2021");
//		DadosSinistro.setNumeroDoSinistro("3703");

//		SinistroJsonHelper.appendSinistro(aRamcod, aSinano, aSinnum);
	}

	@Given("^que eu pego um sinistro de \"(.*?)\" conectando direto com o Informix$")
	@When("^pegar um sinistro de \"(.*?)\" conectando direto com o Informix$")
	public void pegarUmSinistroDeConectandoDiretoComOInformix(String naturezaDoSinistro) {
		new SinistroAutoQueryHelper().salvarDadosDoSinistro(naturezaDoSinistro);
//		String aRamcod = null;
//		String aSinano = null;
//		String aSinnum = null;
//		String bSinntzcod;
//		String bPrdtipcod;
//
//		try {
//			Class.forName("com.informix.jdbc.IfxDriver");
//			String url = "jdbc:informix-sqli://u189:1538/porto:informixserver=u15h";
//			Connection conn = DriverManager.getConnection(url, "usuar", "usuar");
//			StringBuilder query = new StringBuilder();
//			query.append("SELECT a.ramcod, a.sinano, a.sinnum, b.sinntzcod, b.prdtipcod " //
//					+ "FROM ssamsin a, ssamitem b, sanmsin e, sanmavs j " //
//					+ "WHERE avsdat > today - 5 "//
//					+ "AND a.ramcod = 531 "//
//					+ "AND a.ramcod = b.ramcod " //
//					+ "AND a.sinano = b.sinano "//
//					+ "AND a.sinnum = b.sinnum " //
//					+ "AND e.sinramcod = b.ramcod " //
//					+ "AND b.sinano = e.sinano "//
//					+ "AND b.sinnum = e.sinnum " //
//					+ "AND j.sinavsnum = e.sinavsnum " //
//					+ "AND anllibtip is null "//
//					+ "AND anllibdat is null " //
//					+ "AND sinavsabrcnlcod in (10,11,12,13,14,15,17,16,19) "//
//					+ "AND EXISTS " //
//					+ "(SELECT * " //
//					+ "FROM ssammvto c " //
//					+ "WHERE a.ramcod = c.ramcod " //
//					+ "AND a.sinano = c.sinano " //
//					+ "AND a.sinnum = c.sinnum) ");
//
//			switch (naturezaDoSinistro) {
//			case "Roubo":
//				query.append("AND b.sinntzcod in (30,36)");
//				break;
//
//			case "Colisão":
//				query.append("AND b.sinntzcod = 10");
//				break;
//
//			default:
//				throw new ErroAutomacao(
//						"Tipo de sinistro [%s] não definido no método [pegarUmSinistroDeConectandoDiretoComOInformix].",
//						naturezaDoSinistro);
//			}
//
//			PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
//			ResultSet rs = preparedStatement.executeQuery();
//
//			int i = 0;
//
//			while (rs.next()) {
//				aRamcod = rs.getString("ramcod");
//				aSinano = rs.getString("sinano");
//				aSinnum = rs.getString("sinnum");
//				bSinntzcod = rs.getString("sinntzcod");
//				bPrdtipcod = rs.getString("prdtipcod");
//
//				BRQLogger.info("%s | %s | %s | %s | %s", //
//						aRamcod, //
//						aSinano, //
//						aSinnum, //
//						bSinntzcod, //
//						bPrdtipcod);
//
//				System.out.println(String.format("%s %s %s", aRamcod, aSinano, aSinnum));
//
//				if (i++ == 3)
//					break;
//			}
//
//			conn.close();
//
//			if (aRamcod == null)
//				throw new ErroSistema("Não foi possível obter um sinistro da base de dados.");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		TODO Parâmetros para serem usado quando for possível pegar a massa pelo Informix.
//		DadosSinistro.setRamoDoSinistro(aRamcod);
//		DadosSinistro.setAnoDoSinistro(aSinano);
//		DadosSinistro.setNumeroDoSinistro(aSinnum);

//		TODO Deschumbar a massa.
//		DadosSinistro.setRamoDoSinistro("531");
//		DadosSinistro.setAnoDoSinistro("2020");
//		DadosSinistro.setNumeroDoSinistro("4337");
	}
	
	@Given("^que o usuário consultou um sinistro de ramo \"([^\"]*)\", ano \"([^\"]*)\" e número \"([^\"]*)\"$")
	@When("^(?:o usuário )consultar um sinistro de ramo \\\"([^\\\"]*)\\\", ano \\\"([^\\\"]*)\\\" e número \\\"([^\\\"]*)\\\"$")
	public void consultarSinistroEspecifico(String ramo, String ano, String numero) {
//		if (ramo.isBlank() || ano.isBlank() || numero.isBlank())
		if (ramo == null || ramo.isEmpty() || ano == null || ano.isEmpty() || numero == null || numero.isEmpty())
			throw new ErroMassaDeDados("Não é possível obter sinistro com os valores: ramo [%s], ano do sinistro [%s], numero do sinistro [%s]", ramo, ano, numero);
		
		DadosSinistro.setRamoDoSinistro(ramo);
		DadosSinistro.setAnoDoSinistro(ano);
		DadosSinistro.setNumeroDoSinistro(numero);

	}

	@Given("^que o usuário consultou um sinistro de ramo \"([^\"]*)\", ano \"([^\"]*)\", número \"([^\"]*)\" e item \"([^\"]*)\"$")
	public void consultarSinistroEspecificoComItem(String ramo, String ano, String numero, String item) {
//		if (ramo.isBlank() || ano.isBlank() || numero.isBlank())
		if (ramo == null || ramo.isEmpty() || ano == null || ano.isEmpty() || numero == null || numero.isEmpty())
			throw new ErroMassaDeDados("Não é possível obter sinistro com os valores: ramo [%s], ano do sinistro [%s], numero do sinistro [%s]", ramo, ano, numero);

		DadosSinistro.setRamoDoSinistro(ramo);
		DadosSinistro.setAnoDoSinistro(ano);
		DadosSinistro.setNumeroDoSinistro(numero);
		DadosSinistro.setItemDoSinistro(item);

	}

}
