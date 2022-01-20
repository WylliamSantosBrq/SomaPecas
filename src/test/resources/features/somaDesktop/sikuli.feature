#Author: ymnoda@brq.com
@sikuli
Feature: Testando Sikuli
  Quero testar o framework Sikuli para automação desktop

  @tag1
  Scenario: Title of your scenario
    Given que o usuário executou SOMA Desktop
    And que fez login no SOMA Desktop
    #And que eu acesse o menu lateral "Obter Vistorias"
    #And colocar o numero do sinistro que liberei
    #And clicar em "obter vistoria"
    #Then a vistoria ficará na minha grade de vistoria
    When filtrar por:
    #| Oficina | Scattini |
    | Veículo | Celta    |
    #And selecionar a vistoria desejada
    And que selecionou o primeiro resultado
    # Massa Nova
    #	Anexar fotos
    When mudar para a aba "Fotos"
    And clicar em "Adicionar Foto"
    And anexar 5 imagens
    Then o sistema deve carregar as 5 fotos com sucesso
    #	Carregar descontos
    When mudar para a aba "Peças"
    #And cliquei em "Ok"
    And preencher os campos de "Índice de Desconto Peças" com "10"
    And preencher os campos de "Valores de Mão de Obra" com "80"
    And clicar em "Salvar"
    #Justificativa
    Then o sistema exibirá a mensagem "Cadastro de Índice de Desconto salvo com sucesso!"
    #	Selecionar peça afetada
    When clicar em "Ok"
    And ter como foco o croqui
    And clicar em "Capuz Motor"
    And clicar em "Ferramenta"
    And preencher os campos:
      | Quilometragem | 100 |
    And selecionar nos combos:
      | Aspecto do Dano | Recente |
      | Impregnação     | Amarela |
      | Agrupamento     | SUV     |
    And fechar a janela "Orientação de Danos"
    #Then deve voltar para tela de orçamento
    #	Selecionar peças do veiculo
    And acessar o menu "OUTRAS AÇÕES" -> "Peças Manuais"
    And preencher a tabela "Adição de Peças":
      | Código   | Digite uma descrição                                     | T | R | M | Tipo de Uso | Tipo de Peça | Valor Bruto | Desconto | Valor Líquido | M.O | Pintura |
      | 93388452 | GUIA CJ-CO(GUIA DE COBERT. P/CHOQUE LD) - Val. 2003/2003 | X |   |   | FUNILARIA   | Fabricante   |      100000 |          |               |  80 |      80 |
    And clicar em "Adicionar"
    And desmarcar a célula "Fornec." do item "peca 1"
    And preencher o campo "Justificativa" com "Indenizaçao Integral - Indenizaçao Integral - Indenizaçao Integral"
    And clicar em "Salvar"
    Then o sistema carregará a peça na tabela de orçamento do veículo
    #	Finalizar vistoria
    When mudar para a aba "Finalização"
    And clicar em "SALVAR E TRANSMITIR"
    And clicar em "Sim"
    And selecionar o radio "23 - indenização integral" em "Situações obrigatórias"
    And clicar em "Ok"
    And clicar em "Sim"
    And digitar codigo "123"
