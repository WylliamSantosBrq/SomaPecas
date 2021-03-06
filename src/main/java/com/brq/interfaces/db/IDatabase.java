package com.brq.interfaces.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brq.interfaces.log.BRQLogger;

import oracle.jdbc.pool.OracleDataSource;

public interface IDatabase {

	default String executeQuery(String query, String coluna) {
		String queryReturn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = getDBConnection().createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				queryReturn = rs.getString(coluna);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (rs != null)
					rs.close();
				if (getDBConnection() != null)
					getDBConnection().close();

			} catch (Exception e) {
				BRQLogger.info("CONEXAO NAO PODE SER RELIZADA");
			}
		}

		return queryReturn;

	}

	default void executeQuery(String query) {
		Statement statement = null;
		ResultSet rs = null;

		try {
			statement = getDBConnection().createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			BRQLogger.info(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (rs != null)
					rs.close();
				if (getDBConnection() != null)
					getDBConnection().close();

			} catch (SQLException e) {
				BRQLogger.info(e.getMessage());
			}
		}
	}

	default Connection getDBConnection() {

		Connection conn = null;
		try {
			String url = null;
			String username = null;
			String password = null;

			// Conexão com o Oracle
			OracleDataSource ds;
			ds = new OracleDataSource();
			ds.setURL(url);
			conn = ds.getConnection(username, password);

		} catch (SQLException e) {
			BRQLogger.info("Falha ao conectar com o Oracle: " + e.getMessage());
		}

		return conn;

	}

}
