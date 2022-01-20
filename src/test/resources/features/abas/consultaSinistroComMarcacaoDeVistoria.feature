#Auto generated Octane revision tag
@TID3017REV0.12.0 @abas @u10
Feature: [CT001][COLISÃO] Consulta de sinistro com marcação de vistoria

  Background: 
    Given que o usuário pegou um sinistro do tipo "Porto" e natureza "Colisão" conectando direto com o Informix
    And que acessou a URL "http://aplwebhml/seweb/trs/"
    And que esteja logado no Sistemas Corporativos

  @colisao @porto @regressivo
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
    # Local
    When mudar para a aba "Local"
    Then apresentará os campos:
      | CEP |
    #	Questionário
    When mudar para a aba "Questionário"
    Then validar que a pergunta "Veículo está alienado?" foi respondida com um "NAO"
    #Segurado
    When mudar para a aba "Segurado"
    Then validar que a pergunta "Segurado vai utilizar o seguro para reparar seu veículo?" foi respondida com um "Sim"
    # Apólice
    When mudar para a aba "Apólice"
    Then apresentará os campos:
      | Tipo Cobertura |
      | Licença        |
    # Notas
    When mudar para a aba "Notas"
    Then apresentará os campos:
      | Apólice  | 3-7303644                             |
      | Convênio |                                     0 |
      | Veículo  | NOVO COBALT LTZ 1.8 8V ECONOFLEX AUT. |
      | Placa    | PDD0129                               |
      | Segurado | NILSON BELTRAO                        |
      | Chassi   | 9BGJC6920KB131822                     |
      | Marca    | CHEVROLET                             |
    When clicar em "Expandir Todas"
    Then o sistema apresentar "Assunto: Registro Automático do Sistema"
    Then validar o registro "Emissão do laudo"
    # Histórico
    When mudar para a aba "Histórico"
    Then o sistema apresentará os seguintes campos preenchidos na tabela "Histórico de alterações":
      | Data |
      | Hora |
    And salvar todos os dados do "Histórico de alterações"
    # Tarefa
    #When mudar para a aba "Tarefas"
    #Then o sistema apresentará a tarefa "Histórico de Processo"
    #Then validar tarefa "Comunicação Processo: Agendamento Vistoria"
    #And obter todos os detalhes do "Histórico de Processo"
    # SIASI Online
    When mudar para a aba "SIASI Online"
    And clicar em "Obter Informações Atualizadas"
    Then o sistema apresentará o resultado da análise
    #Documentos
    When mudar para a aba "Documentos"
    Then validar que o botão "Solicitar Tarefas" está disponível
    #Movimentos
    #When mudar para a aba "Movimentos"
    #Then apresentar o campo "Saldo" preenchido
    #Ocorrências
    When mudar para a aba "Ocorrências"
    Then o sistema apresentará os seguintes campos preenchidos na tabela "Avisos relacionados a esta ocorrência":
      | Placa |
    #Liberação
    When mudar para a aba "Liberação"
    Then apresentar o campo "Valor a liberar" preenchido
    #Causador
    When mudar para a aba "Causador"
    Then validar se possui dados do veículo causador
    #Tempo Análise
    #When mudar para a aba "Tempo Análise"
    #Then obter todos os detalhes do "Tempo de Análise"
    #Menu Lateral Marcação de Vistoria
    #When acessar o menu lateral "MARCAÇÃO DE VISTORIA"
    #Then validar que o sinistro possui vistoria "em andamento" em uma oficina
    #U10
    #When acessar o menu lateral "AVISO DE SINISTRO"
    And acessar o menu lateral "U10"
    #And o sistema apresentar "Acompanhamento de Sinistro"
    #And clicar em "Download do resumo do Aviso"
    #Then o arquivo "saferetriever.pdf" será baixado
    # Orçamento de Reparo
    #When voltar para "Acompanhamento de sinistro"
    #And clicar em "Orçamento de Reparo"
    #Then abrirá uma página informando "Orçamento Detalhado"
    # Reagendar Vistoria de Sinistro
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Reagendar vistoria de sinistro"
    Then exibirá "Reagendamento vistoria de sinistro"
    # Documentação - Validar upload de arquivo
    When voltar para "Acompanhamento de sinistro"
    And selecionar a opção "Documento PDF - 382" no combo "Outros Documentos"
    And clicar em "Enviar"
    And anexar o PDF salvo
    And clicar em "Enviar documento"
    #Then o sistema exibirá a mensagem ""
    # Mensagens
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Mensagens"
    Then o sistema exibirá uma lista de mensagens
    When fechar a caixa de mensagens
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
    And fechar a caixa de Sedex Reverso
    #Then o sistema abrirá o sinistro na aba "Dados Basicos"
    #	# CHAT
    And clicar em "Atendimento Online"
    Then o sistema exibirá "CHAT virtual"
    # Finalizar Atendimento
    When fechar a janela de Atendimento Online
    #And clicar em "Finalizar Atendimento"
    #Then o sistema exibirá a mensagem "Consulta de processo de sinistro finalizada com sucesso."  