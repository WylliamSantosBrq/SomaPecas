#Author: ymnoda@brq.com
@TID1005REV2.2.0 @abas @sinistro
Feature: Consultar Sinistro no Abas
  Eu como um usuário
  Quero consultar o sinistro no Abas
  Para validar os dados salvos

  Background: 
    Given que o usuário pegou um sinistro conectando direto com o Informix
    And que acessou a URL "http://aplwebhml/seweb/trs/"
    And que esteja logado no Sistemas Corporativos

  @ii @roubo
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
    And o sistema apresentará a tarefa "Abertura de Laudo"
    #	Validar Segmentação e tarefa de liberação
    When finalizar a tarefa "Abertura de Laudo"
    And esperar 5 segundos
    And atualizar a página
    And acessar o menu "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    And pesquisar o sinistro
    And selecionar o primeiro resultado
    And mudar para a aba "Tarefas"
    #Then o sistema concluirá a tarefa "Abertura de Laudo"
    #And clicar em "Atualizar"
    Then o sistema apresentará a tarefa "A Analisar"
    When mudar para a aba "Liberação"
    And selecionar a opção "Enviar para Preparação de Documentos" no combo "Razão da liberação"
    And selecionar a opção "Sem restrição" no combo "Restrição"
    And clicar em "Concluir análise"
    #Then o sistema exibirá a mensagem "Sinistro enviado para preparação"
    Then o sistema exibirá a mensagem "Análise concluída!"
    #	Validar preparação de documentos
    When espero 5 segundos
    And atualizar a página
    And que eu acesse o menu "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    And pesquisar o sinistro
    And selecionar o primeiro resultado
    And mudar para a aba "Tarefas"
    Then o sistema apresentará a tarefa "Preparação de Documentos sem Financiamento"
    #	Liberar Sinistro
    When mudar para a aba "Liberação"
    And selecionar a opção "93 - Liberação Condicionada" no combo "Razão da liberação"
    And clicar em "Liberar Sinistro"
    Then o sistema exibirá a mensagem "Sinistro liberado com Sucesso"
    #	Enviar Documentos
    When mudar para a aba "Documentos"
    And clicar em "Nova solicitação de documentos"
    And selecionar a opção "AUTO - ANÁLISE - I.I." no combo "Combo de documentos"
    And clicar em "Concluir solicitação de documentos"
    Then o sistema exibirá a mensagem "Combo de documento enviado"
    #	Concluir contato acerto
    When mudar para a aba "Notas"
    And clicar em "Registrar notas automaticas"
    And acessar o menu "LIQUIDAÇÃO" -> "INDENIZAÇÃO INTEGRAL" -> "PROGRAMAÇÃO DE PAGAMENTO I.I. / RF" -> "Programação Reembolso (Guincho/2aVia DUT/Outros)"
    And clicar em "Salvar"
    Then o sistema exibirá a mensagem "Nota e E-mail registrados com sucesso!"
    #	Validar fluxo de pagamento
    When voltar para "Abas"
    And espero 5 segundos
    And atualizar a página
    And que eu acesse o menu "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    And pesquisar o sinistro
    And selecionar o primeiro resultado
    And mudar para a aba "Tarefas"
    Then o sistema apresentará a tarefa "Pagamento"
