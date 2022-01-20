package com.brq.util.geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.brq.interfaces.log.BRQLogger;

public class GeradorEndereco {
	Random random = new Random();
	List<String> listaDeEnderecos = new ArrayList<>();
	String[] logradouro = { "Vila", "Largo", "Travessa", "Viela", "Loteamento", "Patio", "Viaduto", "Area", "Via",
			"Distrito", "Vale", "Nucleo", "Trevo", "Trecho", "Estrada", "Sitio", "Morro", "Rua", "Chacara", "Rodovia",
			"Avenida", "Colonia", "Recanto", "Quadra", "Praca", "Parque", "Conjunto", "Alameda" };
	String[] complemento = { "Reinado do Cavalo Marinho", "Na paz do seu sorriso", "Borboletas Psicodelicas",
			"Ary da Rocha", "Itapolis", "Senador Vergueiro", "Joao Moura", "Doutor Bacelar", "Agostinho Gomes",
			"Taquari", "Dom Pedro II ", "Maranhao", " das Flores", "José Bonifácio", "Da Paz", "Santo Antônio",
			"Sete de Setembro", "São Sebastião", "Brasil", "Gonçalo de Carvalho", "Pedro Basso", "Bento Gonçalves",
			"Aurora" };

	public String gerarEndereco() {
		BRQLogger.logMethod();

		int logradouroAleatorio = 0 + random.nextInt(logradouro.length);
		int complementoAleatorio = 0 + random.nextInt(complemento.length);

		String enderecoCompleto = logradouro[logradouroAleatorio] + " "
				+ (complemento[complementoAleatorio] + ", " + random.nextInt(1000));
		listaDeEnderecos.add(enderecoCompleto);
		return enderecoCompleto;
	}

	public List<String> gerarEndereco(int quantidade) {
		BRQLogger.logMethod(quantidade);

		for (int i = 0; i < quantidade; i++)
			gerarEndereco();

		return listaDeEnderecos;
	}
}