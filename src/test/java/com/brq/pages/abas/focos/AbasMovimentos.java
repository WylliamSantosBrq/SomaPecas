package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasMovimentosElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasMovimentos extends Foco implements Campos {

	public AbasMovimentos() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validarCampoPreenchido(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "Saldo":
			validarCampoSaldo();
			break;			
		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampoPreenchido].", campo);
		}
		
	}
	public void validarCampoSaldo() {
		
		esperarSegundos(20);
		((Frame) AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(30)).entrar();
		
		String saldo = AbasMovimentosElementos.OUTPUT_SALDO.obterTexto();
		
		if(saldo == null || saldo.isEmpty() || saldo == "0")
			throw new ErroInesperado("Saldo não está preenchido ou retornou vazio.");
		
		BRQLogger.info("Saldo obtido: %s", saldo);
		
		AbasAbaElementos.FRAME_PRINCIPAL.sair();
	}

	@Override
	public void preencherCampo(String campo, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherCampos(Map<String, String> mapValores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limparCampo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limparCampo(String campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherCampos(String campos, String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampos(Map<String, Object> mapValoresEsperados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampo(String campo, Object valorEsperado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCamposDisponiveis(List<String> campos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCampoDisponivel(String campo) {
		// TODO Auto-generated method stub
		
	}
		
}
