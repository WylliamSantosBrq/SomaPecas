#Auto generated Octane revision tag
@TID3005REV0.4.0 @abas @U10
Feature: Eu, como usuario quero consultar Sinistro de natureza Colisão – Novo Sinistro Auto (Abas).

  Background: 
    Given pego um sinistro conectando direto com o Informix
    And acesse a URL "http://aplwebhml/seweb/trs/"
    And esteja logado no Sistemas Corporativos

  Scenario: Título # Definir um título que descreva o objetivo do cenário.
    Given acesse o menu "Sistema de sinistro" -> "Novo Sinistro Auto"
    And acesse o menu "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    When pesquisar o sinistro
    And selecionar o primeiro resultado
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    When mudar para a aba "Local"
    #COMEÇO DE ONDE PRECISA SER REESCRITO
    When caso apresente as informações da aba "Local"
    Then tirar print da pagina inteira
    And clicar na aba "questionario"
    When caso apresente as informações da aba "questionario"
    Then tirar print da pagina inteira
    And clicar na aba "segurado"
    When caso apresente as informações da aba "segurado"
    Then tirar print da pagina inteira
    And clicar na aba "apolice"
    When caso apresente as informações da aba "apolice"
    Then tirar print da pagina inteira
    And clicar na aba "notas"
    When caso apresente as informações da aba "notas"
    Then tirar print da pagina inteira
    And clicar na aba "historico"
    When caso apresente as informações da aba "historico"
    Then tirar print da pagina inteira
    And clicar na aba "causador"
    When caso apresente as informações da aba "causador"
    Then tirar print da pagina causador
    And clicar na aba "liberação"
    When caso apresente as informações da aba "liberação"
    Then tirar print da pagina inteira
    And clicar na aba "ocorrencias"
    When caso apresente as informações da aba "ocorrencias"
    Then tirar print da pagina inteira
    And clicar na aba "movimentos"
    When caso apresente as informações da aba "movimentos"
    Then tirar print da pagina inteira
    And clicar na aba "documentos"
    When caso apresente as informações da aba "documentos"
    Then tirar print da pagina inteira
    And clicar na aba "SIASI Online"
    When caso apresente as informações da aba "SIASI Online"
    Then tirar print da pagina inteira
    And clicar na aba "tarefas"
    When caso apresente as informações da aba "tarefas"
    Then tirar print da pagina inteira
    And clicar na aba "tempo analise"
    When caso apresente as informações da aba "tempo analise"
    Then tirar print da pagina inteira
    #FIM
    When clicar em "MARCAÇÃO DE VISTORIA"
    Then o sistema exibirá a vistoria desejada
    When volte para "Sistemas Corporativos"
    And acesse o menu "Sistema de sinistro" -> "U10"
    And clicar em "Por Número do Sinistro"
    And pesquisar o sinistro
    Then as informações do veículo estarão presentes
    When clicar em "CHAT"
    Then os dados serão informados #?
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Download do resumo do Aviso"
    Then um arquivo será baixado
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Mensagens"
    Then o sistema exibirá uma lista de mensagens
    When fechar caixa de mensagens
    And clicar em "Sedex Reverso"
    Then o sistema exibirá a mensagem "Solicitação de Autorização de Postagem em Agência"
    When fechar Sedex Reverso
    And selecionar a opção "Documento PDF - 382" no combo "Outros Documentos"
    And clicar em "Enviar"
    And anexar PDF salvo
    And clicar em "Enviar documento"
    Then o documento será enviado com sucesso
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Reagendar vistoria de sinistro"
    And clicar em "Reagendar vistoria"
    Then o sistema apresentará campos para preencher
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Consultar Aviso"
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    When voltar para "Acompanhamento de Sinistro"
    And clicar em "Finalizar Atendimento"
    Then o sistema exibirá a mensagem "Consulta de processo de sinistro finalizada com sucesso."
