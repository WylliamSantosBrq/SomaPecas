#Author: vssantos@brq.com/ymnoda@brq.com
@desligamento @comJustaCausa @gerente
Feature: Desligamento - Com Justa Causa - Gerente

	Background: 
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		And que eu esteja logado no Success Factors

	# Cenários 05 a 06
	Scenario Outline: Solicitar desligamento - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		#
		And preencher os campos obrigatórios com motivo "<motivo>"
		And que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o adm pessoal
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And inserir alguma justificativa
		And que eu clique em "APROVAR"
		#
		And que eu clique em "APROVAR (Confirmar)"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo              |
			| 6     | Fraude              |
			| 7     | Abandono de emprego |

	#Cenário 15
	@comAlerta @impeditivo
	Scenario Outline: Solicitar desligamento - Com alerta impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Then o sistema irá apresentar os alertas esperados
		Given que eu clique em "CONTINUAR"
		Then o sistema continua na tela de solicitação

		Examples: 
			| linha | motivo |
			| 16    | Fraude |

	#---------------------
	#Cenários 20 e 21
	@semAlerta @reprovacao @reprovacaoAmbulatorio
	Scenario Outline: Desligamento reprovado [Ambulatório] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		And que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o adm pessoal
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And inserir alguma justificativa
		And que eu clique em "REPROVAR"
		And que eu clique em "REPROVAR (Reprovar)"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo              |
			| 21    | Fraude              |
			| 22    | Abandono de emprego |

	#Cenários 32 e 33
	@semAlerta @devolucao @devolucaoAdmPessoal
	Scenario Outline: Devolução [ADM pessoal] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		And que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o adm pessoal
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And inserir alguma justificativa
		And que eu clique em "DEVOLVER"
		And que eu clique em "DEVOLVER (Devolver)"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "DEVOLVIDO"
		Given abrir resumo da solicitação atual
		And que eu clique em "EDITAR SOLICITAÇÃO"
		And que eu altere o motivo para "<motivo alterado>"
		And que eu altere a data de desligamento para não ter alertas
		And que eu altere a justificativa para "Justificativa alterada para fluxo de devolução"
		And anexar carta de desligamento
		And que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o adm pessoal
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And inserir alguma justificativa
		And que eu clique em "APROVAR"
		And que eu clique em "APROVAR (Confirmar)"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo              | motivo alterado     |
			| 33    | Fraude              | Abandono de emprego |
			| 34    | Abandono de emprego | Fraude              |

	#Cenário 43
	@semAlerta @cancelamento
	Scenario Outline: Cancelar [Solicitante] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		And que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And espero 45 segundos
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES EM ANDAMENTO"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO - ADM PESSOAL"
		Given abrir resumo da solicitação atual
		And que eu clique em "CANCELAR"
		And que eu clique em "SIM (Cancelar)"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CANCELADO"

		Examples: 
			| linha | motivo              |
			| 44    | Abandono de emprego |

	#Cenário 42
	@semAlerta @salvarRascunho
	Scenario Outline: Salvar rascunho e retomar edição
		Given que eu carregue todos os dados da linha <linha> da aba "Com Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o gerente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Given que eu clique em "SALVAR RASCUNHO"
		And que eu clique em "SIM (Rascunho)"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		Then o sistema apresenta uma mensagem para retomar a solicitação

		Examples: 
			| linha | motivo |
			| 43    | Fraude |
