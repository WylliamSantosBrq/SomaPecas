package com.brq.interfaces;

public interface Anexos {

	abstract void anexarArquivo(String caminhoDoArquivo);

	abstract void anexarArquivos(String... caminhosDosArquivos);
	
	abstract void anexarArquivos(int quantidadeDeArquivos);
	
}
