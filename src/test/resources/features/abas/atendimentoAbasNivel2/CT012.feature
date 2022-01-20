#Auto generated Octane revision tag
@TID3017REV0.2.0 @abas @u10 @CT012 @enchente
Feature: [CT012] [ENCHENTE] Acompanhamento de sinistro marcação de vistoria com DNC

  Background: 
    Given que o usuário consultou um sinistro de ramo "531", ano "2021" e número "3143"
    And que acessou a URL "http://aplwebhml/seweb/trs/"
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
      | Natureza           | ENCHENTE/INUNDACAO |
      | Código da Natureza |                 50 |
      | Tipo Perda         | PARCIAL            |
      | Tipo Perda Entrada |                  2 |
    # Local
    When mudar para a aba "Local"
    Then apresentará os campos:
      | CEP | 07810000 |
    #	Questionário
    When mudar para a aba "Questionario"
    Then validar que a pergunta "Veículo está alienado?" foi respondida com um "NAO"
    # Segurado
    When mudar para a aba "Segurado"
    Then validar que a pergunta "Segurado vai utilizar o seguro para reparar seu veículo?" foi respondida com um "Sim"
    # Apólice
    When mudar para a aba "Apólice"
    Then apresentará os campos:
      | Tipo Cobertura | COLISAO, INCENDIO E ROUBO |
      | Licença        | OLX1254                   |
    # Histórico
    When mudar para a aba "Histórico"
    Then o sistema apresentará os seguintes campos na tabela "Histórico de alterações":
      | Data |
      | Hora |
    And salvar todos os dados do "Histórico de alterações"
    # Notas
    When mudar para a aba "Notas"
    And apresentará os campos:
      | Apólice  | 34-139175808                   |
      | Convênio |                              0 |
      | Veículo  | X1 SDRIVE 20I 2.0 TB FLEX AUT. |
      | Placa    | OLX1254                        |
      | Segurado | ALESSANDRO TESTE MAR           |
      | Chassi   | 9D4V565D4F5V415F4              |
      | Marca    | BMW                            |
    And clicar em "Expandir Todas"
    Then o sistema apresentar "Assunto: Registro Automático do Sistema"
    Then validar o registro "Emissão do laudo"
    And validar o registro "Sugestão de Perda Parcial"
    # Tarefa
    When mudar para a aba "Tarefas"
    Then o sistema apresentará a tarefa "Comunicação Processo: Agendamento Vistoria"
    And o sistema apresentará a tarefa "Confere Automático"
    # SIASI Online
    When mudar para a aba "SIASI Online"
    And clicar em "Obter Informações Atualizadas"
    Then o sistema apresentará o resultado da análise
    # Documentos
    When mudar para a aba "Documentos"
    Then validar que o botão "Solicitar Tarefas" está disponível
    # Movimentos
    When mudar para a aba "Movimentos"
    Then apresentar o campo "Saldo" preenchido
    # Ocorrências
    When mudar para a aba "Ocorrências"
    Then o sistema apresentará os seguintes campos na tabela "Avisos relacionados a esta ocorrência":
      | Placa | OLX1254 |
    # Liberação
    When mudar para a aba "Liberação"
    Then apresentar o campo "Valor a liberar" preenchido
    # Causador
    When mudar para a aba "Causador"
    Then validar se possui dados do veículo causador
    # Tempo Análise
    When mudar para a aba "Tempo Análise"
    Then salvar todos os dados do "Tempo de Análise"
    # Menu Lateral Marcação de Vistoria
    When acessar o menu lateral "MARCAÇÃO DE VISTORIA"
    Then validar que o sinistro possui vistoria "concluída" em uma oficina
    # U10
    When acessar o menu lateral "AVISO DE SINISTRO"
    And acessar o menu lateral "U10"
    #And o sistema apresentar "Acompanhamento de Sinistro"
    #And clicar em "Download do resumo do Aviso"
    #Then o arquivo "saferetriever.pdf" será baixado
    # Orçamento de Reparo
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Orçamento de Reparo"
    Then o sistema exibirá "Orçamento Detalhado"
    # Reagendar Vistoria de Sinistro
    When voltar para "Acompanhamento de sinistro"
    And clicar em "Reagendar vistoria de sinistro"
    Then o sistema exibirá "Reagendamento vistoria de sinistro"
    # Documentação - Validar upload de arquivo
    #When voltar para "Acompanhamento de sinistro"
    #And selecionar a opção "Documento PDF - 382" no combo "Outros Documentos"
    #And clicar em "Enviar"
    #And anexar o PDF salvo
    #And clicar em "Enviar documento"
    #Then o sistema exibirá a mensagem ""
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
    #When voltar para "Acompanhamento de sinistro"
    #And clicar em "Consultar Aviso"
    #Then o sistema abrirá o sinistro na aba "Dados Basicos"
    #	# CHAT
    And clicar em "Atendimento Online"
    Then o sistema exibirá "CHAT virtual"
    # Finalizar Atendimento
    When fechar a janela de Atendimento Online
    #And clicar em "Finalizar Atendimento"
    #Then o sistema exibirá a mensagem "Consulta de processo de sinistro finalizada com sucesso."  
