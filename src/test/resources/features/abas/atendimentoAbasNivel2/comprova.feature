#Auto generated Octane revision tag
@OCTANE_ID @abas @u10
Feature: [CT001][COLISÃO] Consulta de sinistro com marcação de vistoria

  Background: 
    Given que o usuário pegou um sinistro do tipo "Porto", natureza "Colisão" e estado "Roteirizada Inspetor" conectando direto com o Informix
    And que acessou a URL "http://aplwebhml/seweb/trs/"
    And que esteja logado no Sistemas Corporativos

  @colisao @porto
  Scenario: Abertura de sinistro com marcação de vistoria e acompanhamento de vistoria nos sistemas U10 e Abas
    # Consultar Sinistro
    Given que acessou o menu "Sistema de sinistro" -> "Novo Sinistro Auto"
    And que acessou o menu superior "Aviso de Sinistro" -> "Consultas" -> "Número do Sinistro"
    When pesquisar o sinistro
    And selecionar o primeiro resultado
    # Dados Básicos
    Then o sistema abrirá o sinistro na aba "Dados Basicos"
    # Notas
    When mudar para a aba "Notas"
    And apresentará os campos:
      | Apólice  |
      | Convênio |
      | Veículo  |
      | Placa    |
      | Segurado |
      | Chassi   |
      | Marca    |
    And clicar em "Modelo de Cartas"
    Then o sistema exibirá "Exibição de Itens da Árvore"
    # Gerar carta em PDF
    When acessar o menu "CARTAS" -> "ANÁLISE" -> "Carta Recusa" -> "CG 30" -> "Indenização Integral" -> "Agravamento"
    Then exibirá "Geração de Cartas em PDF"
    #	Preencher e mostrar carta
    #When preencher os campos:
    #| Data      | Hoje        |
    #| Apólice   | <apolice>   |
    #| Item      | <item>      |
    #| Suc       | <suc>       |
    #| Veículo   | <veiculo>   |
    #| Modelo    | <modelo>    |
    #| Sinistro  | <sinistro>  |
    #| Corretora | <corretora> |
    #| SUSEP     | <susep>     |
    #And clicar em "Visualizar Carta"
    #Then exibirá "Carta em PDF" # Impedimento (Arquivo não encontrado)
    #Enviar carta para aprovação
    #When voltar para "Geração de Cartas em PDF"
    #And clicar em "Enviar para Aprovação"
    #Then o sistema exibirá a mensagem "Uma carta COMPROVA foi enviada para aprovação"
    #Then o sistema exibirá a mensagem "Carta e Email registrados com sucesso."
    # Abas - Validar registro de envio de carta Comprova p/ aprovação
    When voltar para "Abas"
    #And atualizar a página
    And clicar em "Expandir Todas"
    And o sistema apresentar "Assunto: Registro Automático do Sistema"
    #Then validar o registro "Uma carta COMPROVA foi enviada para aprovação"
    #Tarefas
    When mudar para a aba "Tarefas"
    Then validar tarefa "Aprovação Carta Recusa Comprova - PP" informando:
      | Início | Data e hora designadas |
      | Fim    |                        |
    #Aprovação de Carta Recusa PP
    When editar a tarefa "Aprovação de Carta Recusa PP"
    And o sistema apresentar "Sinistro Auto - Análise da Carta"
    And selecionar a opção "Aprovar"
    And selecionar a opção "Reprovar"
    And clicar em "Confirmar"
    Then o sistema exibirá a mensagem "Carta Reprovada"
    Then o sistema exibirá a mensagem "Carta Aprovada"
    #Tarefas
    When em "Histórico de Processo"
    And validar tarefa "Aprovação de Carta Recusa PP" informando data e hora de início e de fim da aprovação
    And validar tarefa "Incluir tarefa de Reanalise de Carta Recusa – Comprova – PP" informando início em "<data>" e "<hora>" e fim em branco
    Then validar motivo da reprovação no campo "Informações Complementares"
    #Notas
    When mudar para a aba "Notas"
    And atualizar a página
    And clicar em "Expandir todas"
    And o sistema apresentar "Registro Automático do Sistema"
    Then validar o registro "E-mail enviado a DocuSign com sucesso."
    #Documentos
    When mudar para a aba "Documentos"
    And o sistema apresentar "Documentos de Processo"
    Then validar "Carta em PDF" em "Arquivos Enviados"
    And clicar em "Arquivo"
    And fechar a "Carta em PDF"
    #Tarefas
    When mudar para a aba "Tarefas"
    Then o sistema apresentará a tarefa "Aguardando Retorno DocuSign"
