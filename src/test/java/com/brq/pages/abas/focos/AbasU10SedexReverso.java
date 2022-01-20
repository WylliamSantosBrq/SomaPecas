package com.brq.pages.abas.focos;

import java.util.Map;

import org.codehaus.plexus.util.StringUtils;

import com.brq.elementos.Campo;
import com.brq.elementos.Frame;
import com.brq.elementos.abas.AbasAbaElementos;
import com.brq.elementos.abas.AbasU10SedexReversoElementos;
import com.brq.erros.ErroAutomacao;
import com.brq.erros.ErroSistema;
import com.brq.erros.ErroValidacao;
import com.brq.interfaces.Campos;
import com.brq.interfaces.log.BRQLogger;
import com.brq.pages.Foco;

public class AbasU10SedexReverso extends Foco implements Campos {

	@Override
	public void esperarExibicao(String objeto) {
		BRQLogger.logMethod(objeto);

		switch (objeto) {
		case "Solicitação de Autorização de Postagem em Agência":
			esperarSolicitacaoDeAutorizacaoDePostagemEmAgencia(10);
			break;

		default:
			throw new ErroAutomacao("O objeto [%s] não foi definido no método [esperarExibicao].", objeto);
		}
	}

	@Override
	public void validarBotaoDisponivel(String botao) {
		BRQLogger.logMethod(botao);

		switch (botao) {
		case "Prosseguir":
			validarBotaoProsseguirDisponivel();
			break;

		default:
			throw new ErroAutomacao("O botão [%s] não foi definido no método [validarBotaoDisponivel].", botao);
		}
	}

	@Override
	public void fecharCaixa(String caixa) {
		BRQLogger.logMethod(caixa);

		switch (caixa) {
		case "Sedex Reverso":
			fecharCaixaSedexReverso();
			break;

		default:
			throw new ErroAutomacao("A caixa [%s] não foi definida no método [fecharCaixa].", caixa);
		}
	}

	public void fecharCaixaSedexReverso() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			AbasU10SedexReversoElementos.BTN_FECHAR.esperarSerVisivel(5).mover().clicar();

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void validarBotaoProsseguirDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!AbasU10SedexReversoElementos.BTN_PROSSEGUIR.estaDisponivel())
					throw new ErroSistema("O botão [Prosseguir] não está disponível.");
				BRQLogger.info("O botão prosseguir está disponível em tela.");

			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
	}

	public void esperarSolicitacaoDeAutorizacaoDePostagemEmAgencia(int tempoEmSegundos) {
		BRQLogger.logMethod(tempoEmSegundos);

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.esperarExistir(5).entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				AbasU10SedexReversoElementos.TEXTO_SOLICITACAO_AUTORIZACAO.esperarSerVisivel(tempoEmSegundos);

			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroSistema(e);
		}
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

	@Override
	public void validarCampoDisponivel(String campo) {
		BRQLogger.logMethod(campo);

		switch (campo) {
		case "CEP do remetente":
			validarCampoCEPDoRemetenteDisponivel();
			break;

		case "Logradouro":
			validarCampoLogradouroDisponivel();
			break;

		case "Número":
			validarCampoNumeroDisponivel();
			break;

		case "Bairro":
			validarCampoBairroDisponivel();
			break;

		case "Estado":
			validarCampoEstadoDisponivel();
			break;

		case "Cidade":
			validarCampoCidadeDisponivel();
			break;

		default:
			throw new ErroAutomacao("O campo [%s] não foi definido no método [validarCampoDisponivel].", campo);
		}
	}

	private void validarCampoCEPDoRemetenteDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!((Campo) AbasU10SedexReversoElementos.INPUT_CEP_DO_REMETENTE.esperarSerVisivel(5)).estaDisponivel()
						|| !((Campo) AbasU10SedexReversoElementos.INPUT_DIGITO_DO_REMETENTE.esperarSerVisivel(5))
						.estaDisponivel())
					throw new ErroSistema("O campo [CEP do remetente] não está disponível para preenchimento.");
				BRQLogger.info("O campo [CEP do remetente] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

	private void validarCampoLogradouroDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!((Campo) AbasU10SedexReversoElementos.INPUT_LOGRADOURO.esperarSerVisivel(5)).estaDisponivel())
					throw new ErroSistema("O campo [Logradouro] não está disponível para preenchimento.");
				BRQLogger.info("O campo [Logradouro] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

	private void validarCampoNumeroDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!((Campo) AbasU10SedexReversoElementos.INPUT_NUMERO.esperarSerVisivel(5)).estaDisponivel())
					throw new ErroSistema("O campo [Número] não está disponível para preenchimento.");
				BRQLogger.info("O campo [Número] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

	private void validarCampoBairroDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!((Campo) AbasU10SedexReversoElementos.INPUT_BAIRRO.esperarSerVisivel(5)).estaDisponivel())
					throw new ErroSistema("O campo [Bairro] não está disponível para preenchimento.");
				BRQLogger.info("O campo [Bairro] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

	private void validarCampoEstadoDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (StringUtils.isNotBlank(
						AbasU10SedexReversoElementos.COMBO_ESTADO.esperarSerVisivel(5).obterAtributo("disabled")))
					throw new ErroSistema("O campo [Estado] não está disponível para preenchimento.");
				BRQLogger.info("O campo [Estado] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

	private void validarCampoCidadeDisponivel() {
		BRQLogger.logMethod();

		try (Frame framePrincipal = AbasAbaElementos.FRAME_PRINCIPAL.entrar()) {
			try (Frame frameSedexReverso = AbasU10SedexReversoElementos.FRAME_SEDEX_REVERSO.entrar()) {
				if (!((Campo) AbasU10SedexReversoElementos.INPUT_CIDADE.esperarSerVisivel(5)).estaDisponivel())
					throw new ErroSistema("O campo [Cidade] não está disponível para preenchimento.");
				BRQLogger.info("O campo [Cidade] está disponível para preenchimento.");
			} catch (Exception e) {
				throw new ErroSistema(e);
			}

		} catch (Exception e) {
			throw new ErroValidacao(e);
		}
	}

}
