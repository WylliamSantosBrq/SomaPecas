package com.brq.dados;

import java.time.LocalDate;

import com.brq.interfaces.dados.Resetable;
import com.brq.interfaces.log.Loggable;

/**
 * Classe para armazenar as informações que o usuário tem para permitir a
 * execução dos testes de desligamento.
 * 
 * @author ymnoda
 *
 */
public class DadosUsuarioDesligamento implements Resetable, Loggable {

	private static String cenariosRelacionados;
	private static Integer numeroDaFilial;
	private static String matricula;
	private static String nome;
	private static LocalDate dataDeNascimento;
	private static LocalDate admissao;
	private static String descricaoDoLocal;
	private static LocalDate dataDeDemissao;
	private static String cargo;
	private static String sindicato;
	private static Boolean preAposentadoria;
	private static Boolean pcd;
	private static Integer idade;
	private static Integer tempoDeEmpresa;
	private static LocalDate[] feriasProgramadas;
	private static String periodoDeFerias;
	private static Boolean vinculo;
	private static Boolean afastamento;
	private static Boolean estabilidade;
	private static Boolean ficha;
	private static Boolean restricaoDesligamento;
	private static String avaliacao;
	private static Boolean festaDaLembranca;
	private static Boolean transicaoDeCarreira;
	private static Boolean dataBase;
	private static String consultoraRH;
	private static String apelidoConsultoraRH;
	private static String supervisor;
	private static String apelidoSupervisor;
	private static String coordenador;
	private static String apelidoCoordenador;
	private static String gerente;
	private static String apelidoGerente;
	private static String superintendente;
	private static String apelidoSuperintendente;
	private static String diretor;
	private static String apelidoDiretor;
	private static String vicePresidente;
	private static String apelidoVicePresidente;
	private static String[] mensagensDeAlerta;
	private static LocalDate dataDeTerminoDeContrato;

	public static int getNumeroDaFilial() {
		return numeroDaFilial;
	}

	public static void setNumeroDaFilial(int numeroDaFilial) {
		DadosUsuarioDesligamento.numeroDaFilial = numeroDaFilial;
	}

	public static String getMatricula() {
		return matricula;
	}

	public static void setMatricula(String matricula) {
		DadosUsuarioDesligamento.matricula = matricula;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		DadosUsuarioDesligamento.nome = nome;
	}

	public static LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public static void setDataDeNascimento(LocalDate dataDeNascimento) {
		DadosUsuarioDesligamento.dataDeNascimento = dataDeNascimento;
	}

	public static LocalDate getAdmissao() {
		return admissao;
	}

	public static void setAdmissao(LocalDate admissao) {
		DadosUsuarioDesligamento.admissao = admissao;
	}

	public static LocalDate getDataDeDemissao() {
		return dataDeDemissao;
	}

	public static void setDataDeDemissao(LocalDate dataDeDemissao) {
		DadosUsuarioDesligamento.dataDeDemissao = dataDeDemissao;
	}

	public static String getCargo() {
		return cargo;
	}

	public static void setCargo(String cargo) {
		DadosUsuarioDesligamento.cargo = cargo;
	}

	public static String getSindicato() {
		return sindicato;
	}

	public static void setSindicato(String sindicato) {
		DadosUsuarioDesligamento.sindicato = sindicato;
	}

	public static boolean isPreAposentadoria() {
		return preAposentadoria;
	}

	public static void setPreAposentadoria(boolean preAposentadoria) {
		DadosUsuarioDesligamento.preAposentadoria = preAposentadoria;
	}

	public static boolean isPcd() {
		return pcd;
	}

	public static void setPcd(boolean pcd) {
		DadosUsuarioDesligamento.pcd = pcd;
	}

	public static int getIdade() {
		return idade;
	}

	public static void setIdade(int idade) {
		DadosUsuarioDesligamento.idade = idade;
	}

	public static int getTempoDeEmpresa() {
		return tempoDeEmpresa;
	}

	public static void setTempoDeEmpresa(int tempoDeEmpresa) {
		DadosUsuarioDesligamento.tempoDeEmpresa = tempoDeEmpresa;
	}

	public static LocalDate[] getFeriasProgramadas() {
		return feriasProgramadas;
	}

	public static void setFeriasProgramadas(LocalDate[] feriasProgramadas) {
		DadosUsuarioDesligamento.feriasProgramadas = feriasProgramadas;
	}

	public static String getPeriodoDeFerias() {
		return periodoDeFerias;
	}

	public static void setPeriodoDeFerias(String periodoDeFerias) {
		DadosUsuarioDesligamento.periodoDeFerias = periodoDeFerias;
	}

	public static boolean isVinculo() {
		return vinculo;
	}

	public static void setVinculo(boolean vinculo) {
		DadosUsuarioDesligamento.vinculo = vinculo;
	}

	public static boolean isAfastamento() {
		return afastamento;
	}

	public static void setAfastamento(boolean afastamento) {
		DadosUsuarioDesligamento.afastamento = afastamento;
	}

	public static boolean isEstabilidade() {
		return estabilidade;
	}

	public static void setEstabilidade(boolean estabilidade) {
		DadosUsuarioDesligamento.estabilidade = estabilidade;
	}

	public static boolean isFicha() {
		return ficha;
	}

	public static void setFicha(boolean ficha) {
		DadosUsuarioDesligamento.ficha = ficha;
	}

	public static boolean isRestricaoDesligamento() {
		return restricaoDesligamento;
	}

	public static void setRestricaoDesligamento(boolean restricaoDesligamento) {
		DadosUsuarioDesligamento.restricaoDesligamento = restricaoDesligamento;
	}

	public static String getAvaliacao() {
		return avaliacao;
	}

	public static void setAvaliacao(String avaliacao) {
		DadosUsuarioDesligamento.avaliacao = avaliacao;
	}

	public static boolean isFestaDaLembranca() {
		return festaDaLembranca;
	}

	public static void setFestaDaLembranca(boolean festaDaLembranca) {
		DadosUsuarioDesligamento.festaDaLembranca = festaDaLembranca;
	}

	public static boolean isTransicaoDeCarreira() {
		return transicaoDeCarreira;
	}

	public static void setTransicaoDeCarreira(boolean transicaoDeCarreira) {
		DadosUsuarioDesligamento.transicaoDeCarreira = transicaoDeCarreira;
	}

	public static boolean isDataBase() {
		return dataBase;
	}

	public static void setDataBase(boolean dataBase) {
		DadosUsuarioDesligamento.dataBase = dataBase;
	}

	public static String getCoordenador() {
		return coordenador;
	}

	public static void setCoordenador(String coordenador) {
		DadosUsuarioDesligamento.coordenador = coordenador;
	}

	public static String getGerente() {
		return gerente;
	}

	public static void setGerente(String gerente) {
		DadosUsuarioDesligamento.gerente = gerente;
	}

	public static String getSuperintendente() {
		return superintendente;
	}

	public static void setSuperintendente(String superintendente) {
		DadosUsuarioDesligamento.superintendente = superintendente;
	}

	public static String getDiretor() {
		return diretor;
	}

	public static void setDiretor(String diretor) {
		DadosUsuarioDesligamento.diretor = diretor;
	}

	public static String getVicePresidente() {
		return vicePresidente;
	}

	public static void setVicePresidente(String vicePresidente) {
		DadosUsuarioDesligamento.vicePresidente = vicePresidente;
	}

	public static String getCenariosRelacionados() {
		return cenariosRelacionados;
	}

	public static void setCenariosRelacionados(String cenariosRelacionados) {
		DadosUsuarioDesligamento.cenariosRelacionados = cenariosRelacionados;
	}

	public static String getConsultoraRH() {
		return consultoraRH;
	}

	public static void setConsultoraRH(String consultoraRH) {
		DadosUsuarioDesligamento.consultoraRH = consultoraRH;
	}

	public static String getSupervisor() {
		return supervisor;
	}

	public static void setSupervisor(String supervisor) {
		DadosUsuarioDesligamento.supervisor = supervisor;
	}

	public static String getApelidoConsultoraRH() {
		return apelidoConsultoraRH;
	}

	public static void setApelidoConsultoraRH(String apelidoConsultoraRH) {
		DadosUsuarioDesligamento.apelidoConsultoraRH = apelidoConsultoraRH;
	}

	public static String getApelidoSupervisor() {
		return apelidoSupervisor;
	}

	public static void setApelidoSupervisor(String apelidoSupervisor) {
		DadosUsuarioDesligamento.apelidoSupervisor = apelidoSupervisor;
	}

	public static String getApelidoCoordenador() {
		return apelidoCoordenador;
	}

	public static void setApelidoCoordenador(String apelidoCoordenador) {
		DadosUsuarioDesligamento.apelidoCoordenador = apelidoCoordenador;
	}

	public static String getApelidoGerente() {
		return apelidoGerente;
	}

	public static void setApelidoGerente(String apelidoGerente) {
		DadosUsuarioDesligamento.apelidoGerente = apelidoGerente;
	}

	public static String getApelidoSuperintendente() {
		return apelidoSuperintendente;
	}

	public static void setApelidoSuperintendente(String apelidoSuperintendente) {
		DadosUsuarioDesligamento.apelidoSuperintendente = apelidoSuperintendente;
	}

	public static String getApelidoDiretor() {
		return apelidoDiretor;
	}

	public static void setApelidoDiretor(String apelidoDiretor) {
		DadosUsuarioDesligamento.apelidoDiretor = apelidoDiretor;
	}

	public static String getApelidoVicePresidente() {
		return apelidoVicePresidente;
	}

	public static void setApelidoVicePresidente(String apelidoVicePresidente) {
		DadosUsuarioDesligamento.apelidoVicePresidente = apelidoVicePresidente;
	}

	public static String[] getMensagensDeAlerta() {
		return mensagensDeAlerta;
	}

	public static void setMensagensDeAlertas(String[] mensagensDeAlerta) {
		DadosUsuarioDesligamento.mensagensDeAlerta = mensagensDeAlerta;
	}

	public static LocalDate getDataDeTerminoDeContrato() {
		return dataDeTerminoDeContrato;
	}

	public static void setDataDeTerminoDeContrato(LocalDate dataDeTerminoDeContrato) {
		DadosUsuarioDesligamento.dataDeTerminoDeContrato = dataDeTerminoDeContrato;
	}

	public static String getDescricaoDoLocal() {
		return descricaoDoLocal;
	}

	public static void setDescricaoDoLocal(String descricaoDoLocal) {
		DadosUsuarioDesligamento.descricaoDoLocal = descricaoDoLocal;
	}

}
