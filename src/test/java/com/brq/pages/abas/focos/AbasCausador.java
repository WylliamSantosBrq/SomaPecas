package com.brq.pages.abas.focos;

import java.util.List;
import java.util.Map;

import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasCausadorElementos;
import com.brq.erros.ErroInesperado;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasCausador extends Foco implements Campos {

	public AbasCausador() {
		// TODO Auto-generated constructor stub
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
	public void validarCampoPreenchido(String campo) {
		// TODO Auto-generated method stub
		
	}

	public void validarDadosCausador() {
		
		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			String causador = AbasCausadorElementos.SPAN_RADIO_COD_CAUSADOR_SINISTRO.obterTexto();
			if(causador=="Sim") {
				BRQLogger.info("O condutor do veículo segurado se considera responsável pela ocorrência.");
			} else if (causador=="Não") {
				validarSePossuiDadosDoCausador();
			} else {
				BRQLogger.info("Responsável não definido.");
			}
		} catch (Exception e) {
			throw new ErroInesperado(e, "Ocorreu um erro inesperado ao acessar o iframe principal.");
		}
	}

	private void validarSePossuiDadosDoCausador() {
		String possuiDados = AbasCausadorElementos.SPAN_POSSUI_DADOS_CAUSADOR.obterTexto();
		
		String descricao = AbasCausadorElementos.DESCRICAO_VEICULO_CAUSADOR.obterTexto();
		String placa = AbasCausadorElementos.PLACA_VEICULO_CAUSADOR.obterTexto();
		String chassi = AbasCausadorElementos.CHASSI_VEICULO_CAUSADOR.obterTexto();
		
		if(possuiDados == "Sim" ) {
			BRQLogger.info("Dados do causador: \n Descrição: %s\n Placa: %s\n Chassi: %s\n", descricao, placa, chassi);
		} else {
			BRQLogger.info("Não possui dados do causador.");
		}
			
		
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
