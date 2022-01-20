package com.brq.dados;

import com.brq.interfaces.dados.Resetable;
import com.brq.interfaces.log.Loggable;

public class DadosSinistro implements Resetable, Loggable {

	private static String ramoDoSinistro;
	private static String anoDoSinistro;
	private static String numeroDoSinistro;
	private static String itemDoSinistro;

	public static String getSinistroCompleto() {
		if (itemDoSinistro != null && !itemDoSinistro.isEmpty())
			return String.format("%s %s %s %s", ramoDoSinistro, anoDoSinistro, numeroDoSinistro, itemDoSinistro);
		else
			return String.format("%s %s %s", ramoDoSinistro, anoDoSinistro, numeroDoSinistro);
	}

	public static String getRamoDoSinistro() {
		return ramoDoSinistro;
	}

	public static void setRamoDoSinistro(String ramoDoSinistro) {
		DadosSinistro.ramoDoSinistro = ramoDoSinistro;
	}

	public static String getAnoDoSinistro() {
		return anoDoSinistro;
	}

	public static void setAnoDoSinistro(String anoDoSinistro) {
		DadosSinistro.anoDoSinistro = anoDoSinistro;
	}

	public static String getNumeroDoSinistro() {
		return numeroDoSinistro;
	}

	public static void setNumeroDoSinistro(String numeroDoSinistro) {
		DadosSinistro.numeroDoSinistro = numeroDoSinistro;
	}

	public static String getItemDoSinistro() {
		return itemDoSinistro;
	}

	public static void setItemDoSinistro(String itemDoSinistro) {
		DadosSinistro.itemDoSinistro = itemDoSinistro;
	}

}
