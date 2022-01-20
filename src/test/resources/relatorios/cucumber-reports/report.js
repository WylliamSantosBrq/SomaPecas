$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AvisoDeSinistro/geradorDeMassa.feature");
formatter.feature({
  "line": 1,
  "name": "Essa feature serve apenas para integração com outros projetos e não pertence ao projeto do Digital",
  "description": "",
  "id": "essa-feature-serve-apenas-para-integração-com-outros-projetos-e-não-pertence-ao-projeto-do-digital",
  "keyword": "Feature"
});
formatter.before({
  "duration": 172804800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "capturei um número de apólice do informix de natureza \"Roubo\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "que estou na janela de agendamento de vistoria como \"persona\u003dAtendente\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Roubo",
      "offset": 55
    }
  ],
  "location": "InformixStep.captureiUmNúmeroDeApóliceDoInformixDeNatureza(String)"
});
formatter.result({
  "duration": 5776580200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "persona\u003dAtendente",
      "offset": 53
    }
  ],
  "location": "IdentificacaoStep.queEstouNaJanelaDeAgendamentoDeVistoriaComo(String)"
});
formatter.result({
  "duration": 49061875800,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Apólice -\u003e Sinistro",
  "description": "",
  "id": "essa-feature-serve-apenas-para-integração-com-outros-projetos-e-não-pertence-ao-projeto-do-digital;apólice--\u003e-sinistro",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@gerarMassa"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#Given me identifico com \"Segurado\",\"\",\"\",\"36\",\"139140390\""
    }
  ],
  "line": 10,
  "name": "me identifico com dados armazenados",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "clico no botao continuar e avanço para a sessão de \"Quando e onde\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "especifico data entre \"01/01/2021\" e \"01/03/2021\" e hora \"00:00\" para territorio \"Nacional\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "clico no botao continuar e avanço para a sessão de \"Natureza\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "escolho a natureza \"ROUBO OU FURTO\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "se aparecer a mensagem \"Este aviso de sinistro já está em andamento\" clicar em \"Sim\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "se aparecer a mensagem \"Já existe um sinistro aberto para esta data, número:\" clicar em \"Sim\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "voltar até \"está comunicando o sinistro de Roubo/Furto?\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "seleciono o motivo \"não viu que levaram\" usado para a pergunta \"está comunicando o sinistro de Roubo/Furto?\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 19,
      "value": "#And clico no botao continuar da sessão de \"Informações do Segurado\""
    }
  ],
  "line": 20,
  "name": "preencho telefone \"11940028923\" e email \"teste@teste.com\" do terceiro",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "clico no botao continuar e avanço para a sessão de \"Quem dirigia\"",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "clico no botao continuar da sessão de \"Quem dirigia\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 23,
      "value": "#And informo os detalhes do condutor:"
    },
    {
      "line": 24,
      "value": "#| CPF         | Vínculo                 | Nome Completo     | Data de nascimento |"
    },
    {
      "line": 25,
      "value": "#| 61055586008 | Funcionário do segurado | Abnair dos Santos | 01/01/2000         |"
    },
    {
      "line": 26,
      "value": "#When clico no botao continuar da sessão de \"Dados do condutor\""
    },
    {
      "line": 27,
      "value": "#When seleciono que \"Era o segurado\" que dirigia o veículo no momento do sinistro"
    },
    {
      "line": 28,
      "value": "#When clico no botao continuar e avanço para a sessão de \"Local do sinistro\""
    }
  ],
  "line": 29,
  "name": "especifico que o local foi \"Garagem\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "seleciono o local \"São Paulo\",\"São Paulo\",\"Paulista\",\"Av Paulista\" e nº \"123\"",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "clico no botao continuar e avanço para a sessão de \"Detalhes do sinistro\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "adiciono detalhes do sinistro",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "clico no botao continuar e avanço para a sessão de \"Boletim de ocorrência\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "O segurado conseguiu registrar o Boletim de Ocorrencia \"Sim,já Registrou.\"",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "especifico boletim de ocorrência \"000000\"",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "opto por finalizar agendamento",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "o sistema apresenta a mensagem de sucesso na abertura do sinistro",
  "keyword": "Then "
});
formatter.match({
  "location": "IdentificacaoStep.meIdentificoComDadosArmazenados()"
});
formatter.result({
  "duration": 2943544500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Quando e onde",
      "offset": 52
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarEAvanco(String)"
});
formatter.result({
  "duration": 8985186900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01/01/2021",
      "offset": 23
    },
    {
      "val": "01/03/2021",
      "offset": 38
    },
    {
      "val": "00:00",
      "offset": 58
    },
    {
      "val": "Nacional",
      "offset": 82
    }
  ],
  "location": "DataHoraSinistroStep.especificoDataEntreEEHoraParaTerritorio(String,String,String,String)"
});
formatter.result({
  "duration": 4315063700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Natureza",
      "offset": 52
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarEAvanco(String)"
});
formatter.result({
  "duration": 3020428400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ROUBO OU FURTO",
      "offset": 20
    }
  ],
  "location": "NaturezaStep.escolhoANatureza(String)"
});
formatter.result({
  "duration": 5790528700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Este aviso de sinistro já está em andamento",
      "offset": 24
    },
    {
      "val": "Sim",
      "offset": 80
    }
  ],
  "location": "GeralStep.seAparecerAMensagemClicarEm(String,String)"
});
formatter.result({
  "duration": 5195779900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Já existe um sinistro aberto para esta data, número:",
      "offset": 24
    },
    {
      "val": "Sim",
      "offset": 89
    }
  ],
  "location": "GeralStep.seAparecerAMensagemClicarEm(String,String)"
});
formatter.result({
  "duration": 5175310400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "está comunicando o sinistro de Roubo/Furto?",
      "offset": 12
    }
  ],
  "location": "GeralStep.optoPorVoltarAté(String)"
});
formatter.result({
  "duration": 2231885700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "não viu que levaram",
      "offset": 20
    },
    {
      "val": "está comunicando o sinistro de Roubo/Furto?",
      "offset": 64
    }
  ],
  "location": "MotivoStep.selecionoOMotivo(String,String)"
});
formatter.result({
  "duration": 3613552200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11940028923",
      "offset": 19
    },
    {
      "val": "teste@teste.com",
      "offset": 41
    }
  ],
  "location": "DetalhesAcidenteStep.preenchoTelefoneEEmailDoTerceiro(String,String)"
});
formatter.result({
  "duration": 3744819300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Quem dirigia",
      "offset": 52
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarEAvanco(String)"
});
formatter.result({
  "duration": 1365768200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Quem dirigia",
      "offset": 39
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarDaSessãoDe(String)"
});
formatter.result({
  "duration": 1514593000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Garagem",
      "offset": 28
    }
  ],
  "location": "LocalSinistroStep.especificoQueOLocalFoi(String)"
});
formatter.result({
  "duration": 1548834700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "São Paulo",
      "offset": 19
    },
    {
      "val": "São Paulo",
      "offset": 31
    },
    {
      "val": "Paulista",
      "offset": 43
    },
    {
      "val": "Av Paulista",
      "offset": 54
    },
    {
      "val": "123",
      "offset": 73
    }
  ],
  "location": "LocalSinistroStep.selecionoOLocalENº(String,String,String,String,String)"
});
formatter.result({
  "duration": 8682737400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Detalhes do sinistro",
      "offset": 52
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarEAvanco(String)"
});
formatter.result({
  "duration": 1453763200,
  "status": "passed"
});
formatter.match({
  "location": "DetalhesSinistroStep.adicionoDetalhesDoSinistro()"
});
formatter.result({
  "duration": 1391000500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Boletim de ocorrência",
      "offset": 52
    }
  ],
  "location": "GeralStep.clicoNoBotaoContinuarEAvanco(String)"
});
formatter.result({
  "duration": 1655180800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sim,já Registrou.",
      "offset": 56
    }
  ],
  "location": "BoletimDeOcorrenciaStep.oSeguradoConseguiuRegistrarOBoletimDeOcorrencia(String)"
});
formatter.result({
  "duration": 465055400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "000000",
      "offset": 34
    }
  ],
  "location": "BoletimDeOcorrenciaStep.especificoBoletimDeOcorrência(String)"
});
formatter.result({
  "duration": 580208800,
  "status": "passed"
});
formatter.match({
  "location": "AgendamentoVistoriaPresencialStep.optoPorFinalizarAgendamento()"
});
formatter.result({
  "duration": 8177906000,
  "status": "passed"
});
formatter.match({
  "location": "AgendamentoVistoriaPresencialStep.oSistemaApresentaAMensagemDeSucessoNaAberturaDoSinistro()"
});
formatter.result({
  "duration": 212073100,
  "status": "passed"
});
formatter.after({
  "duration": 2101451600,
  "status": "passed"
});
});