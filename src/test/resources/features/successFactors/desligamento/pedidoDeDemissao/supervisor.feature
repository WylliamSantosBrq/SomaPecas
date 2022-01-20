#Author: vssantos@brq.com / ymnoda@brq.com
@desligamento @pedidoDemissao @supervisor
Feature: Desligamento - Pedido de Demissão - Supervisor

	Background: 
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		And que eu esteja logado no Success Factors

	# Cenários 01 a 04
	@semAlerta
	Scenario Outline: Solicitar desligamento - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o supervisor
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
		And que eu clique em "APROVAR"
		And que eu clique em "APROVAR (Confirmar)"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o supervisor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo                                    |
			| 2     | Motivos pessoais                          |
			| 3     | Efetivado                                 |
			| 4     | Falta de desafios e perspectivas          |
			| 5     | Melhor oportunidade profissional/salarial |

	#Cenário 25
	@comAlerta @impeditivo
	Scenario Outline: Solicitar desligamento - Com alerta impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o supervisor
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
			| linha | motivo           |
			| 26    | Motivos pessoais |

	#Cenários 30 a 33
	@semAlerta @reprovacao @reprovacaoAdmPessoal
	Scenario Outline: Reprovação (ADM pessoal) - Sem alerta impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o supervisor
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
		And que eu represente o supervisor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo                                    |
			| 31    | Motivos pessoais                          |
			| 32    | Efetivado                                 |
			| 33    | Falta de desafios e perspectivas          |
			| 34    | Melhor oportunidade profissional/salarial |

	#--------------
	#Cenários 54 a 57
	@semAlerta @devolucao @devolucaoAdmPessoal
	Scenario Outline: Devolução [ADM pessoal] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o supervisor
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
		And que eu represente o supervisor
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
		And que eu represente o supervisor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo                                    | motivo alterado                           |
			| 55    | Motivos pessoais                          | Efetivado                                 |
			| 56    | Efetivado                                 | Falta de desafios e perspectivas          |
			| 57    | Falta de desafios e perspectivas          | Melhor oportunidade profissional/salarial |
			| 58    | Melhor oportunidade profissional/salarial | Motivos pessoais                          |

	#Cenário 78
	@emAndamento 
	Scenario Outline: Fluxo em andamento
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o supervisor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		Then o sistema apresenta uma mensagem que já tem um fluxo em andamento

		Examples: 
			| linha |
			| 79    |
