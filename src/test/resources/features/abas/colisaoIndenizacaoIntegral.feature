#Author: ymnoda@brq.com
@TID1006REV0.8.0 @abas @sinistro
Feature: Validação II
  Eu como um usuário
  Quero consultar o sinistro no Abas
  Para validar as informações do sinistro

  Background: 
    Given que eu pego um sinistro conectando direto com o Informix
    And que eu acesse a URL "http://aplwebhml/seweb/trs/"
    And que eu esteja logado no Sistemas Corporativos

	@pp @colisao
  Scenario: Validar os dados do sinistro presentes no Abas (CT1)
    #	Consultar Sinistro
    Given que acessou o menu "Sistema de sinistro" -> "Novo Sinistro Auto"
    And que acessou o menu "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    When pesquisar o sinistro
    And selecionar o primeiro resultado
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    #	Rodar SIASI
    When mudar para a aba "SIASI Online"
    And clicar em "Obter Informações Atualizadas"
    Then o sistema apresentará o resultado da análise
    #	Validar Segmentação e tarefa de liberação
    When mudar para a aba "Tarefas"
    Then o sistema apresentará a tarefa "Re-segmentação de Processo"
    And o sistema apresentará a tarefa "Aguardando Fotos da Vistoria - A Analisar"
    #	Liberar Sinistro
    When mudar para a aba "Liberação"
    And selecionar a opção "93 - Liberação Condicionada" no combo "Próxima ação"
    And clicar em "Concluir análise"
    Then o sistema exibirá a mensagem "Sinistro liberado com Sucesso"
    #	Enviar Documentos
    When mudar para a aba "Documentos"
    And clicar em "Nova solicitação de documentos"
    And selecionar a opção "AUTO - ANÁLISE - P.P." no combo "Combo de documentos"
    And clicar em "Concluir solicitação de documentos"
    Then o sistema exibirá a mensagem "Combo de documento enviado"
    #	Marcar vistoria
    When Selecionar "Marcação de Vistoria"
    And Selecionar "Nova vistoria"
    And Selecionar "Oficina Especifica -  Código Oficina: - 343 - Agendar Vistoria - Primeira Vistoria"
    And Selecionar a data para dois dias úteis
    Then o sistema apresentará a mensagem "Marcação de vistoria agendada com sucesso"
    #	Obter vistoria
    Given logado no sistema SOMA desktop
    Then Selecionar em "obter vistoria"
    And Colocar o numero do sinistro que liberei
    And Clicar em "obter vistoria"
    Then a vistoria ficará na minha grade de vistoria
    #	Anexar fotos
    Then Cliquei na aba fotos
    And cliquei em "Carregar fotos"
    And selecionar 5 imagens no desktop
    Then deve carregar as 5 fotos com sucesso
