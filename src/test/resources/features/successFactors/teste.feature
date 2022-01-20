#Author: ymnoda@brq.com
@successFactors @teste
Feature: Testes de automação

	@massaDeDados
	Scenario Outline: Carregar massa de dados
		Given que eu carregue todos os dados da linha <linha> da aba "Sem Justa Causa" da planilha "MassaDeDadosRH.xlsx"
		Then todos os dados de usuário estarão salvos na memória

		Examples: 
			| linha |
			| 2     |
			| 3     |
			| 4     |
			| 5     |
			| 6     |

	@sistema
	Scenario: Sistema disponível
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		Then estou na tela de login

	@login
	Scenario Outline: Login esperado
		Given que eu acesse a URL "https://hcm8preview.sapsf.com/sf/home?_s.crb=5kVtBRSUFytQy2QXTbjDpFSc%252fLQ%253d#Shell-home"
		Then estou na tela de login
		Given que eu esteja logado no Success Factors

		Examples: 
			| login |
			| again |
			| again |

	@fluxo
	Scenario: Montar fluxo
		Given montar o fluxo de gerente
		
	@docstring
	Scenario: Printar docstring
		When eu coloco a docstring:
		"""
		a
		b
		c
		"""
		Then estará salvo na variavel str