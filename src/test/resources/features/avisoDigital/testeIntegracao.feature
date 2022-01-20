#Author: ymnoda@brq.com
@teste @integracao
Feature: Integração com automação realizada no Aviso Digital
	Como um desenvolvedor de automação
	Quero reaproveitar o código feito no Aviso Digital
	Para evitar retrabalho de algo já feito

	@gerarSinistro
	Scenario: Gerar um sinistro no Aviso Digital e capturar o número
		Given que eu gerei um sinistro com a apólice "112688922" do veículo com placa "EEI2777"

	@consultarServico
	Scenario: Consultar o serviço para pegar um número de sinistro
		Given que eu pego um sinistro conectando direto com o Informix
