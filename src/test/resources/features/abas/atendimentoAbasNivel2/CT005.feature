#Auto generated Octane revision tag
@TID3009REV0.5.0 @abas @u10 @CT005 @colisao @terceiro
Feature: [CT005] [TERCEIRO] Consulta de aviso de sinistro no Abas
 			#revisar p/ dados do terceiro
  Background: 
    #Given que o usuário pegou um sinistro do tipo "Porto" e natureza "Colisão" conectando direto com o Informix
    Given que o usuário consultou um sinistro de ramo "553", ano "2021", número "2181" e item "01"
    And que acessou a URL "https://portalcorporativohml.portoseguro.brasil/portaislogin/loginSistemas.do"
    And que esteja logado no Sistemas Corporativos

  @porto
  Scenario: Abertura de sinistro com marcação de vistoria e acompanhamento de vistoria nos sistemas U10 e Abas
    # Consultar Sinistro
    Given que acessou o menu "Sistema de sinistro" -> "Novo Sinistro Auto"
    And que acessou o menu superior "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    When pesquisar o sinistro
    And selecionar o primeiro resultado
    # Dados Básicos
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    Then apresentará os campos:
      | Natureza           | COLISAO |
      | Código da Natureza |      10 |
      | Tipo Perda         | PARCIAL |
      | Tipo Perda Entrada |       2 |
    When acessar o menu lateral "AVISO DE SINISTRO2"
    And acessar o menu lateral "U10"
    #And o sistema apresentar "Acompanhamento de Sinistro"
    And clicar em "Download do resumo do Aviso"
    Then o arquivo "saferetriever.pdf" será baixado
    # Orçamento de Reparo
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Orçamento de Reparo"
    Then o sistema exibirá "Orçamento Detalhado"
    # Reagendar Vistoria de Sinistro
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Reagendar vistoria de sinistro"
    Then o sistema exibirá "Reagendamento vistoria de sinistro"
    # Documentação - Validar upload de arquivo
    When voltar para "Acompanhamento de sinistro"
    And selecionar a opção "Documento PDF - 382" no combo "Outros Documentos"
    And clicar em "Enviar"
    And anexar o PDF salvo
    And clicar em "Enviar documento"
    Then o sistema exibirá a mensagem ""
    # Mensagens
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Mensagens"
    Then o sistema exibirá uma lista de mensagens
    When fechar a caixa de "mensagens"
    # Sedex Reverso
    When clicar em "Sedex Reverso"
    And o sistema exibir "Solicitação de Autorização de Postagem em Agência"
    Then os seguintes campos estarão disponíveis para preenchimento:
      | CEP do remetente |
      | Logradouro       |
      | Número           |
      | Bairro           |
      | Estado           |
      | Cidade           |
    And o botão "Prosseguir" estará disponível
    And fechar a caixa de "Sedex Reverso"
    # Consultar Aviso
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Consultar Aviso"
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    # CHAT
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Atendimento Online"
    Then o sistema exibirá "CHAT virtual"
    # Finalizar Atendimento
    When fechar a janela de Atendimento Online
    #And clicar em "Finalizar Atendimento"
    #Then o sistema exibirá a mensagem "Consulta de processo de sinistro finalizada com sucesso."  
