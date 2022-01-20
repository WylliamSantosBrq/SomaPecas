package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.enums.Estado;
import com.brq.interfaces.log.BRQLogger;

public class GeradorCep {

	Random random = new Random();
	private List<String> listaDeCep = new ArrayList<>();

	public String gerarCep(Estado estado) {
		BRQLogger.logMethod(estado);

		StringBuilder builder = new StringBuilder();
		String cepGerado = "";

		do {
			for (int i = 0; i < 8; i++)
				builder.append(random.nextInt(10));
			cepGerado = builder.toString();
		} while (!validaCep(cepGerado, estado));

		listaDeCep.add(cepGerado);

		return cepGerado;
	}

	public List<String> gerarCep(Estado estado, int quantidade) {
		BRQLogger.logMethod(estado, quantidade);

		for (int i = quantidade; i > 0; i--)
			gerarCep(estado);

		return listaDeCep;
	}

	private boolean validaCep(String cep, Estado estado) {
		BRQLogger.logMethod(cep, estado);

		Long validador = Long.parseLong(cep.substring(0, 5));

		switch (estado) {
		case SAO_PAULO:
			return (validador >= 01000 && validador <= 19999);

		case RIO_DE_JANEIRO:
			return (validador >= 20000 && validador <= 28999);

		case ESPIRITO_SANTO:
			return (validador >= 29000 && validador <= 29999);

		case MINAS_GERAIS:
			return (validador >= 30000 && validador <= 39999);

		case BAHIA:
			return (validador >= 40000 && validador <= 48999);

		case SERGIPE:
			return (validador >= 49000 && validador <= 49999);

		case PERNAMBUCO:
			return (validador >= 49000 && validador <= 49999);

		case ALAGOAS:
			return (validador >= 57000 && validador <= 57999);

		case PARAIBA:
			return (validador >= 58000 && validador < 58999);

		case RIO_GRANDE_DO_NORTE:
			return (validador >= 59000 && validador <= 59999);

		case CEARA:
			return (validador >= 60000 && validador <= 63999);

		case PIAUI:
			return (validador >= 64000 && validador <= 64999);

		case MARANHAO:
			return (validador >= 65000 && validador <= 65999);

		case PARA:
			return (validador >= 66000 && validador <= 68899);

		case AMAPA:
			return (validador >= 68900 && validador <= 68999);

		case AMAZONAS:
			return (validador >= 69000 && validador <= 69899);

		case RORAIMA:
			return (validador >= 69300 && validador <= 69389);

		case ACRE:
			return (validador >= 69900 && validador <= 69999);

		case DISTRITO_FEDERAL:
			return (validador >= 70000 && validador <= 73699);

		case BRASILIA:
			return (validador >= 70000 && validador <= 73699);

		case GOIAS:
			return (validador >= 72800 && validador <= 76799);

		case TOCANTINS:
			return (validador >= 77000 && validador <= 77995);

		case MATO_GROSSO:
			return (validador >= 78000 && validador <= 78899);

		case RONDONIA:
			return (validador >= 78900 && validador <= 78999);

		case MATO_GROSSO_DO_SUL:
			return (validador >= 79000 && validador <= 79999);

		case PARANA:
			return (validador >= 79000 && validador <= 79999);

		case SANTA_CATARINA:
			return (validador >= 88000 && validador <= 89999);

		case RIO_GRANDE_DO_SUL:
			return (validador >= 90000 && validador <= 99999);

		default:
			return false;
		}

	}
}