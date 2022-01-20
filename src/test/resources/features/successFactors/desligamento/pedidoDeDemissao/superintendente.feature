#Author: vssantos@brq.com/ymnoda@brq.com
@desligamento @pedidoDemissao @superintendente
Feature: Desligamento - Pedido de demissão - Superintendente

	Background: 
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		And que eu esteja logado no Success Factors

	# Cenários 13 a 16
	@semAlerta
	Scenario Outline: Solicitar desligamento - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o superintendente
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
		And que eu represente o superintendente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo                                    |
			| 14    | Motivos pessoais                          |
			| 15    | Efetivado                                 |
			| 16    | Falta de desafios e perspectivas          |
			| 17    | Melhor oportunidade profissional/salarial |

	#Cenário 29
	@comAlerta @naoImpeditivo
	Scenario Outline: Solicitar desligamento - Com alerta não impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o superintendente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Then o sistema irá apresentar os alertas esperados
		Given que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		And que eu clique em "SIM"
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
		And que eu represente o superintendente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo           |
			| 30    | Motivos pessoais |

	#---------------------
	#Cenários 42 a 45
	@semAlerta @reprovacao @reprovacaoAdmPessoal
	Scenario Outline: Desligamento reprovado - Ambulatório - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o superintendente
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
		And que eu represente o superintendente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo                                    |
			| 43    | Motivos pessoais                          |
			| 44    | Efetivado                                 |
			| 45    | Falta de desafios e perspectivas          |
			| 46    | Melhor oportunidade profissional/salarial |

	#--------------
	#Cenários 66 a 69
	@semAlerta @devolucao @devolucaoAdmPessoal
	Scenario Outline: Devolução [ADM pessoal] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Pedido de Demissão" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o superintendente
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
		And que eu represente o superintendente
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
		And que eu represente o superintendente
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo                                    | motivo alterado                           |
			| 67    | Motivos pessoais                          | Efetivado                                 |
			| 68    | Efetivado                                 | Falta de desafios e perspectivas          |
			| 69    | Falta de desafios e perspectivas          | Melhor oportunidade profissional/salarial |
			| 70    | Melhor oportunidade profissional/salarial | Motivos pessoais                          |
