#Author: vssantos@brq.com/ymnoda@brq.com
@desligamento @semJustaCausa @diretor
Feature: Desligamento - Sem justa causa - Diretor

	Background: 
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		And que eu esteja logado no Success Factors

	# Cenários 37 a 45
	@semAlerta
	Scenario Outline: Solicitar desligamento - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Sem justa causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
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
		And que eu represente o consultor de RH
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
		And que eu represente o ambulatório
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And que eu clique em "DOWNLOAD CARTA DE DESLIGAMENTO"
		And anexar carta de desligamento
		And que eu clique em "ENVIAR"
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo                                   |
			| 38    | Baixo desempenho                         |
			| 39    | Fraude                                   |
			| 40    | Excesso de ausências no trabalho         |
			| 41    | Falta de adaptação à escala de trabalho  |
			| 42    | Transição de Carreira                    |
			| 43    | Aposentadoria                            |
			| 44    | Falta de adaptação à cultura da empresa  |
			| 45    | Reestruturação                           |
			| 46    | Falta de adaptação à área/função/produto |

	#Cenário 72
	@comAlerta @naoImpeditivo
	Scenario Outline: Solicitar desligamento - Com alerta não-impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Sem justa causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
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
		And que eu represente o consultor de RH
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
		And que eu represente o ambulatório
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And que eu clique em "DOWNLOAD CARTA DE DESLIGAMENTO"
		And anexar carta de desligamento
		And que eu clique em "ENVIAR"
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "CONCLUÍDO"

		Examples: 
			| linha | motivo           |
			| 73    | Baixo desempenho |

	#Cenário 73
	@comAlerta @impeditivo
	Scenario Outline: Solicitar desligamento - Com alerta impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Sem justa causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
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
			| 74    | Fraude |

	#Cenário 102
	@comAlerta @naoImpeditivo @reprovacao @reprovacaoAmbulatorio
	Scenario Outline: Desligamento reprovado - Ambulatório - Com alerta não-impeditivo
		Given que eu carregue todos os dados da linha <linha> da aba "Sem Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
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
		And que eu represente o consultor de RH
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
		And que eu represente o ambulatório
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo                           |
			| 103   | Excesso de ausências no trabalho |

	#Cenário 103
	@semAlerta @reprovacao @reprovacaoConsultorRH
	Scenario Outline: Desligamento reprovado - Consultor RH - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Sem Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Given que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o consultor de RH
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo                                  |
			| 104   | Falta de adaptação à escala de trabalho |

	#Cenário 104
	@semAlerta @reprovacao @reprovacaoAdmPessoal
	Scenario Outline: Desligamento reprovado - ADM Pessoal [Etapa Final] - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Sem Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Given que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o consultor de RH
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
		And que eu represente o ambulatório
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "EM APROVAÇÃO"
		Given abrir resumo da solicitação atual
		And que eu clique em "DOWNLOAD CARTA DE DESLIGAMENTO"
		And anexar carta de desligamento
		And que eu clique em "ENVIAR"
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo                |
			| 105   | Transição de Carreira |

	#Cenário 105
	@semAlerta @reprovacao @reprovacaoAmbulatorio
	Scenario Outline: Desligamento reprovado - Ambulatório - Sem alerta
		Given que eu carregue todos os dados da linha <linha> da aba "Sem Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		#
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Minha Equipe"
		And que eu pesquise o colaborador
		And que eu selecione o primeiro resultado
		And que eu clique em "DESLIGAR"
		And preencher os campos obrigatórios com motivo "<motivo>"
		Given que eu clique em "CONTINUAR"
		Then validar as informações preenchidas no cadastro
		Given que eu clique em "ENVIAR"
		Then o sistema apresenta o número sequencial da solicitação
		Given que eu clique em "FECHAR"
		And voltar para "Success Factors - Home"
		#
		And que eu represente o consultor de RH
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
		And que eu represente o ambulatório
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
		And que eu represente o diretor
		And que eu clique em "Workflow RH"
		And que eu acesse o menu "Acompanhar Solicitações"
		And que eu mude para a aba "SOLICITAÇÕES CONCLUÍDAS"
		And que eu pesquise a solicitação atual
		Then o status atual da solicitação estará "REPROVADO"

		Examples: 
			| linha | motivo        |
			| 106   | Aposentadoria |
