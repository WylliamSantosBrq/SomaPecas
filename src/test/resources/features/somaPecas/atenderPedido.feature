@TID3024REV0.17.0 @SomaPecas @AtenderPedido
Feature: SOMA Pecas
  Validar todas as funcionalidades disponíveis na aba de tarefas Atender Pedido

  Background:
    #Given que acessou a URL "http://172.26.171.101/security-somapecas/login.xhtml"
    Given que acessou o sistema SOMA Peças

  #- Ter login e senha de fornecedor ativo no SOMA Peças
  #- Massa para testes (vistorias com confere finalizado e código 91 inserido) na condição de Atender Pedido
  #- Ter fornecedor ativo que atenda a bandeira do veículo no sistema SOMA Peças
  @CT001
  Scenario: Validar as Funcionalidade das Ferramentas Disponíveis em Atender Pedido
    #Acessar Sistema
    Given que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When clicar em "Atender Pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Fotos
    When clicar no ícone de foto do terceiro pedido
    Then o sistema exibirá "Fotos"
    When clicar na primeira miniatura
    And apresentará as fotos
    When clicar em "Lupa(+)"
    Then a imagem será ampliada
    #Criticidade
    When fechar a caixa de "Fotos"
    And mover o cursor sobre "criticidade"
    Then o sistema apresentará data e hora do início e previsão de encerramento da tarefa
    #Validar Dados
    And o sistema apresentará os seguintes campos preenchidos:
      | Número do Sinistro  |
      | Data da Solicitação |
      | Número do pedido    |
      | Data do pedido      |
      | Marca               |
      | Veículo             |
      | Modelo              |
      | Placa               |
      | Chassi              |
      | Ano                 |
    #Tarefa
    When clicar em "Abrir Tarefa" do "primeiro" pedido
    Then o sistema apresentará as informações do primeiro pedido
    #Validar PDF
    When clicar em "PDF" do "primeiro" pedido
    Then o sistema abrirá um arquivo PDF com as informações do pedido
    #Informações da Oficina
    When voltar para "Atender Pedido"
    And clicar em "Informações Oficina"
    ######################################## ^DESENVOLVIDO
    And o sistema apresentará os seguintes campos preenchidos:
      | CNPJ                     |
      | Razão Social             |
      | Tipo de Oficina          |
      | Endereço                 |
      | Tipo Veículo Atendimento |
      #| Telefone Comercial       |
      | Telefone Fax             |
      | Email                   |
      | Horário de Atendimento   |
      | Observações              |
    #Histórico do Pedido
    When fechar a caixa de "Informações Oficina"
    And clicar em "Histórico do Pedido"
    And o sistema apresentará os seguintes campos preenchidos:
      | Data        |
      | Fluxo       |
      | Responsável |
      | Detalhe     |
    #Histórico da Peça
    When fechar a caixa de "Histórico - Pedido"
    And clicar em "Histórico da Peça"
    And o sistema apresentará os seguintes campos preenchidos:
      | Data - Peça         |
      | Descrição - Peça    |
      | Detalhe - Peça      |
      | Motivo - Peça       |
      | Responsável - Peça  |
    #Checkbox - Ação Alterar
    When fechar a caixa de "Histórico - Peça"
    And selecionar a opção "Alterar" no combo "Ação"
    Then o combo "Selecione" terá a opção "Alterar" selecionada em cada uma das peças
    And o sistema apresentará o combo "Solicitar mudança de" em cada uma das peças
    #Checkbox - Ação Atender
    And selecionar a opção "Atender" no combo "Ação"
    Then o combo "Selecione" terá a opção "Atender" selecionada em cada uma das peças
    #Checkbox - Ação Recusar
    And selecionar a opção "Recusar" no combo "Ação"
    Then o combo "Selecione" terá a opção "Recusar" selecionada em cada uma das peças
    And o sistema apresentará o combo "Justificativa" em cada uma das peças
    #Checkbox - Ação Atender (por peça)
    And selecionar a opção "Ação" no combo "Ação"
    And selecionar a opção "Atender" no combo "Ação da primeira peça"
    Then o combo "Selecione" terá a opção "Atender" selecionada na "primeira" peça
    Then o sistema apresenta o checkbox "Selecione" preenchido com a opção "Atender" para a "primeira" peça
    ## VER OS PASSOS AS ABAIXOS COM O YURI, A IMPLEMENTAÇÃO JÁ ESTÁ CORRETA É SÓ DESCOMENTAR
    #Checkbox - Ação Alterar (por peça)
    And selecionar a opção "Alterar" no combo "Ação da segunda peça"
    Then o combo "Selecione" terá a opção "Alterar" selecionada na "segunda" peça
    And o sistema apresentará o combo "Solicitar mudança de" na "segunda" peça
    #Checkbox - Ação Recusar (por peça)
    And selecionar a opção "Recusar" no combo "Ação da terceira peça"
    Then o combo "Selecione" terá a opção "Recusar" selecionada na "terceira" peça
    And o sistema apresentará o combo "Justificativa" na "terceira" peça

  #- Massa para testes (vistorias com confere finalizado e cófigo 91 inserido) na condição de Atender Pedido
  #- Ter fornecedor ativo que atenda a bandeira do veículo no sistema SOMA Peças
  #- Ter login e senha de fornecedor ativo no SOMA Peças
  @CT002
  Scenario: Validar a tarefa Atender Pedido - Ação Aceitar
    #Acessar Sistema
    Given que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When clicar em "Atender Pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Tarefa
    When clicar em "Abrir Tarefa" do "primeiro" pedido
    Then o sistema apresentará as informações do primeiro pedido    
    
    #Checkbox - Ação Atender
    And opto por selecionar ação "Atender" em atender pedido
    Then o combo "Selecione" terá a opção "Atender" selecionada em cada uma das peças
    When clico no botão "Confirmar"
    Then o sistema apresenta a mensagem de sucesso na funcionalidade atender pedido
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And opto por clicar em Pesquisar
    Then o sistema apresenta na tela o pedido pesquisado
    #Tarefas Encerradas
    When clico no botão "Tarefas Encerradas"
    And o sistema abre uma aba com o nome do fornecedor
    And opto por clicar na aba com o nome do fornecedor
    And clico no botão "Pedido"
    Then o sistema apresenta a opção "ATENDER PEDIDO: REALIZADA"
    And o sistema apresenta o status da peça "Peça Confirmada"
    And o sistema apresenta abertura da tarefa "Registrar Entrega"

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT003
  Scenario: Validar a tarefa Atender Pedido - Ação Recusar - Fornecedor Fabricante
    #Acessar Sistema
    Given que o usuário fez login como "Analista"
    Then o sistema exibirá a mensagem "Bem-vindo"

    #Buscar Fornecedor Cadastrado
    When clico no menu superior "Cadastro"
    And opto por expandir o menu "CONSULTA DE FORNECEDORES"
    And procuro o fornecedor pela "razão social" com o nome "Teste Apagar"
    And clico no botão "Buscar"
    Then o sistema apresenta o cadastro do fornecedor pesquisado "TESTE APAGAR"
    #Alterar fornecedor
    When clico no botão "Editar"
    And opto por alterar o combobox "tipo fornecedor" para "Fabricante (Original)"
    And clico no botão "Salvar"
    Then o sistema apresenta a mensagem "Operação realizada com sucesso"
    #Sair do Sistema e Logar como Fornecedor
    When faço logout do sistema
    And que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When clicar em "Atender Pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Tarefa
    When clicar em "Abrir Tarefa" do "segundo" pedido
    Then o sistema apresentará as informações do segundo pedido
    #Then o sistema abre a tarefa com as informações do pedido
    #Checkbox - Ação Atender e Recusar Peças
    And selecionar a opção "Atender" no combo Ação da "primeira" peça
    And selecionar a opção "Recusar" no combo Ação da "segunda" peça
    And seleciono uma justificativa
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem de sucesso na funcionalidade atender pedido
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clicar em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá Informações Fornecedor
    #Validar Status da Peça

    #Esse passo não faz sentido
    #When fecho Informações Fornecedor
    Then valido o status da peça como "Confirmado"
    #Peça Cancelada
    When clico no botão "Home"
    And opto por expandir o menu "Peça Cancelada"
    And localizo o pedido "<Pedido>"
    Then o sistema apresentará o pedido somente com as peças canceladas
    #Entregar peça na oficina
    When clico no botão "Home"
    And opto por expandir o menu "Entregar peça na oficina"
    And localizo o pedido "<Pedido>"
    Then o sistema apresentará o pedido somente com as peças que não foram canceladas
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    And que o usuário fez login como "Analista"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Distribuir Manual
    And opto por expandir o menu "Distribuir Manual"
    And localizo o sinistro "<Sinistro>"
    When clico em "Abrir Tarefa" para o pedido "<Pedido>"
    Then o sistema deve apresentar a tarefa "Distribuir Manual" para as peças recusadas

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT004
  Scenario: Validar a tarefa Atender Pedido - Ação Recusar - Fornecedor Genuíno

    #Acessar Sistema
    Given que o usuário fez login como "Analista"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Buscar Fornecedor Cadastrado
    When clico no menu superior "Cadastro"
    And opto por expandir o menu "CONSULTA DE FORNECEDORES"
    And procuro o fornecedor pela "razão social" com o nome "Teste Apagar"
    And clico no botão "Buscar"
    Then o sistema apresenta o cadastro do fornecedor pesquisado "TESTE APAGAR"
    #Alterar fornecedor
    When clico no botão "Editar"
    And opto por alterar o combobox "tipo fornecedor" para "Genuíno"
    And clico no botão "Salvar"
    Then o sistema apresenta a mensagem "Operacao realizada com sucesso"
    #Sair do Sistema e Logar como Fornecedor
    When faço logout do sistema
    And que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When clicar em "Atender Pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Tarefa
    When clicar em "Abrir Tarefa" do "segundo" pedido
    Then o sistema apresentará as informações do segundo pedido
    #Checkbox - Ação Atender e Recusar Peças
    And selecionar a opção "Atender" no combo Ação da "primeira" peça
    And selecionar a opção "Recusar" no combo Ação da "segunda" peça
    And seleciono uma justificativa
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem de sucesso na funcionalidade atender pedido
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clicar em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá "Informações Fornecedor"
    #Validar Status da Peça
    When fecho "Informações Fornecedor"
    Then valido o status da peça como "Confirmado"
    #Peça Cancelada
    When clico no botão "Home"
    And opto por expandir o menu "Peça Cancelada"
    And localizo o pedido "<Pedido>"
    Then o sistema apresentará o pedido somente com as peças canceladas
    #Entregar peça na oficina
    When clico no botão "Home"
    And opto por expandir o menu "Entregar peça na oficina"
    And localizo o pedido "<Pedido>"
    Then o sistema apresentará o pedido somente com as peças que não foram canceladas
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    Given que o usuário fez login como "Analista"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Distribuir Manual
    And opto por expandir o menu "Distribuir Manual"
    And localizo o sinistro "<Sinistro>"
    When clico em "Abrir Tarefa" para o pedido "<Pedido>"
    Then o sistema deve apresentar a tarefa "Distribuir Manual" para as peças recusadas

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT005
  Scenario: Validar a tarefa Atender Pedido - Ação Alterar Valores

    #Acessar Sistema
    Given que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When clicar em "Atender Pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Tarefa
    When clicar em "Abrir Tarefa" do "segundo" pedido
    Then o sistema apresentará as informações do segundo pedido
    #Checkbox - Ação Recusar Peças
    And opto por selecionar ação "Alterar" em atender pedido
    And opto por solicitar mudança de "Alterar o Valor"
    And seleciono uma justificativa na lista de justificativas de alteração
    And altero o valor para "3200,00"
    And preencho o motivo da alteração do valor
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem "Operação realizada com sucesso"
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clicar em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá Informações Fornecedor
    #Then o sistema exibirá "ATENDER PEDIDO: REALIZADA"
      # Then o sistema apresenta o status da peça como "Peça Alterada"
    Then o sistema apresenta o status da peça "Peça Confirmada"
    #Solicitação de Mudança
    When clicar em "Home"
    And opto por selecionar o menu principal "Solicitação de Mudança"
    When clicar em "Abrir Tarefa"
    Then o sistema não permitirá alteração de "solicitação de mudança"
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    Given que o usuário fez login como "Analista"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Solicitação de Mudança
    And opto por expandir o menu "Solicitação de Mudança"
    When clicar em "Abrir Tarefa"
    And seleciono a opção "Aprovar" na peça alterada
    And preencho o motivo da peça alterada
    And clico no botão "Confirmar"
    #Sair do Sistema e Logar como Fornecedor
    When faço logout do sistema
    Given que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Entregar peça na oficina
    And opto por expandir o menu "Entregar peça na oficina"
    And localizo o pedido
    Then o sistema apresentará aceite na alteração de valor pelo analista

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT006
  Scenario: Validar a tarefa Atender Pedido - Ação Alterar Prazo
    #Acessar Sistema
    Given que o usuário fez login como "Fornecedor"
    Then o sistema exibirá a mensagem "Bem-vindo"
    #Atender Pedido
    When opto por expandir o menu "Atender pedido"
    Then o sistema apresentará a lista de pedidos aguardando atendimento
    #Tarefa
    When clicar em "Abrir Tarefa" do "segundo" pedido
    Then o sistema apresentará as informações do segundo pedido
    #Checkbox - Ação Recusar Peças
    And opto por selecionar ação "Alterar" em atender pedido
    And opto por solicitar mudança de "Alterar o Prazo"
    And seleciono uma justificativa na lista de justificativas de alteração
    And altero o prazo para "5"
    And preencho o motivo da peça alterada
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem "Operação realizada com sucesso"
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clico em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá "Solicitaçao de Mudança"
    Then valido o status da peça como "Peça Alterada"
    #Solicitação de Mudança
    When clico no botão "Home"
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    Then o sistema não permitirá alteração
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    And opto por acessar o Soma Peças com perfil de "Analista"
    Then o sistema apresenta uma mensagem de boas vindas
    #Solicitação de Mudança
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    And seleciono a opção "Aprovar" na peça alterada
    And preencho o motivo
    And clico no botão "Confirmar"
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clico em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema gera novo pedido para peça alterada no prazo

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT007
  Scenario: Validar a tarefa Atender Pedido - Ação Alterar B.O.
    #Acessar Sistema
    When faço logout do sistema
    And opto por acessar o Soma Peças com perfil de "Fornecedor"
    Then o sistema apresenta uma mensagem de boas vindas
    #Atender Pedido
    When opto por expandir o menu "Atender pedido"
    Then o sistema apresenta a lista de pedidos aguardando atendimento
    #Tarefa
    When clico em "Abrir Tarefa" para o "primeiro" pedido
    Then o sistema abre a tarefa com as informações do pedido
    #Checkbox - Ação Recusar Peças
    And opto por selecionar ação "Alterar" em atender pedido
    And opto por solicitar mudança de "Peça em B.O."
    And seleciono uma justificativa na lista de justificativas de alteração
    And altero o prazo para "5"
    And altero o valor para "3200"
    And preencho o motivo
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem "Operação realizada com sucesso"
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clico em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá "Solicitaçao de Mudança"
    Then valido o status da peça como "Peça Alterada"
    #Solicitação de Mudança
    When clico no botão "Home"
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    Then o sistema não permitirá alteração
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    And opto por acessar o Soma Peças com perfil de "Analista"
    Then o sistema apresenta uma mensagem de boas vindas
    #Solicitação de Mudança
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    Then o sistema apresenta o pedido na tarefa "Solicitação de Mudança" para o analista

  #- Possuir login e senha de Fornecedor e Analista no SOMA Peças
  #- Possuir orçamento realizado no SOMADekstop com peças fornecidas pela seguradora, criando uma tarefa no SOMAPeças para o Fornecedor
  @CT008
  Scenario: Validar a tarefa Atender Pedido - Ação Alterar Código de Peças
    #Acessar Sistema
    When faço logout do sistema
    And opto por acessar o Soma Peças com perfil de "Fornecedor"
    Then o sistema apresenta uma mensagem de boas vindas
    #Atender Pedido
    When opto por expandir o menu "Atender pedido"
    Then o sistema apresenta a lista de pedidos aguardando atendimento
    #Tarefa
    When clico em "Abrir Tarefa" para o "primeiro" pedido
    Then o sistema abre a tarefa com as informações do pedido
    #Checkbox - Ação Recusar Peças
    And opto por selecionar ação "Alterar" em atender pedido
    And opto por solicitar mudança de "Alterar o Código"
    And seleciono uma justificativa na lista de justificativas de alteração
    And altero o código para "teste"
    And incluo uma descrição para a peça
    And preencho o motivo
    And clico no botão "Confirmar"
    Then o sistema apresenta a mensagem "Operação realizada com sucesso"
    #Pesquisar Pedido
    When clico no botão "OK"
    And opto por preencher o campo "Pedido" no menu lateral "Pesquisa"
    And clico no botão "Pesquisar"
    Then o sistema apresenta na tela o pedido pesquisado
    #Abrir Pedidos
    When clico em "Abrir Pedidos"
    And clico no fornecedor do pedido
    Then o sistema exibirá "Solicitaçao de Mudança"
    Then valido o status da peça como "Peça Alterada"
    #Solicitação de Mudança
    When clico no botão "Home"
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    Then o sistema não permitirá alteração
    #Sair do Sistema e Logar como Analista
    When faço logout do sistema
    And opto por acessar o Soma Peças com perfil de "Analista"
    Then o sistema apresenta uma mensagem de boas vindas
    #Solicitação de Mudança
    And opto por expandir o menu "Solicitação de Mudança"
    When clico em "Abrir Tarefa" para o pedido
    Then o sistema apresenta o pedido na tarefa "Solicitação de Mudança" para o analista