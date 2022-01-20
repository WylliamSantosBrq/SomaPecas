package com.brq.utils.informix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.erros.ErroMassaDeDados;
import com.brq.interfaces.log.BRQLogger;

public class EstadoQueryHelper {

	private String usuario = "SOSMEHJ3";
	private String senha = "SOSMEHJ3";
	private String host = "scansnmtephm";
	private String port = "1521";
	private String servico = "snmtephmsv";
	private String query = "SELECT sin.sinnum, sit.vstrtrsitdes " + //
			"FROM smemvstorc orc " + //
			"JOIN smemvstsin sin on sin.VSTORCNUM = orc.VSTORCNUM " + //
			"JOIN smekvstrtrsit sit on orc.VSTRTRSITCOD = sit.VSTRTRSITCOD " + //
			"WHERE sin.sinnum = '%s%s%s' ";

	public Boolean executeLambda(String query, Validacao validacaoLambda) {
		BRQLogger.logMethod();

		String url = String.format(
				"jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = %s)(PORT = %s)))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = %s)))",
				host, port, servico);

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

	public String getQuery(String... args) {
		BRQLogger.logMethod(args);

		StringBuilder querySB = new StringBuilder();
		querySB.append(String.format(query, args[0], args[1], args[2]));
		switch (args[3]) {
		case "Recebida Seguradora":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Recebida%%Seguradora%%' ");
			break;
			
		case "Roterizada Reguladora":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Roterizada%%Reguladora%%' ");
			break;
			
		case "Roteirizada Inspetor":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Roteirizada%%Inspetor%%' ");
			break;
			
		case "Carregada Inspetor":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Carregada%%Inspetor%%' ");
			break;
			
		case "Vistoria Realizada":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Vistoria%%Realizada%%' ");
			break;
			
		case "Pendente Confere":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Pendente%%Confere%%' ");
			break;
			
		case "Carregada Confere":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Carregada%%Confere%%' ");
			break;
			
		case "Confere Realizada":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Confere%%Realizada%%' ");
			break;
			
		case "Devolvida para Seguradora":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Devolvida%%para%%Seguradora%%' ");
			break;
			
		case "Cancelada":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Cancelada%%' ");
			break;
			
		case "Roterizada Oficina":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Roterizada%%Oficina%%' ");
			break;
			
		case "Sugerida Inspetor":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Sugerida%%Inspetor%%' ");
			break;
			
		case "Vistoria Realizada Aguardando Fotos":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Vistoria%%Realizada%%Aguardando%%Fotos%%' ");
			break;
			
		case "Pendente Confere Aguardando Fotos":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Pendente%%Confere%%Aguardando%%Fotos%%' ");
			break;
			
		case "Confere Realizada Aguardando Fotos":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Confere%%Realizada%%Aguardando%%Fotos%%' ");
			break;
			
		case "Devolvendo para seguradora":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Devolvendo%%para%%seguradora%%' ");
			break;
			
		case "Erro na devolução":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Erro%%na%%devolução%%' ");
			break;
			
		case "Incompleto versoes orçamento":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Incompleto%%versoes%%orçamento%%' ");
			break;
			
		case "Em copia versoes orçamento":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Em%%copia%%versoes%%orçamento%%' ");
			break;
			
		case "Finalizado copia versoes orçamento":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Finalizado%%copia%%versoes%%orçamento%%' ");
			break;
			
		case "Aguardando fotos - Digital":
			querySB.append("AND sit.vstrtrsitdes LIKE '%%Aguardando%%fotos%%Digital%%' ");
			break;
			
		default:
			throw new ErroAutomacao("O estado [%s] não foi definido no método [getQuery].", args[3]);
		}

		return querySB.toString();
	}

	private static final Validacao estadoValido = rs -> {
		try {
			String estado;

			while (rs.next()) {
				estado = rs.getString("VSTRTRSITDES");

				BRQLogger.info("Estado: %s", //
						estado);

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	};

	public Boolean estadoDoSinistro(String ramo, String ano, String numero, String estado) {
		BRQLogger.logMethod(ramo, ano, numero, estado);

		return executeLambda(getQuery(ramo, ano, numero, estado), estadoValido);
	}

}