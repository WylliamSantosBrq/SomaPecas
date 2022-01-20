package com.brq.domain.fornecimentoDePecas;

import java.util.ArrayList;
import java.util.List;

import com.brq.domain.excel.AtributosMassa;
import com.brq.domain.excel.JsonAtributosMassa;
import com.brq.domain.solicitarFornecimentoDePecas.LocalSolicitacaoFornecimento;
import com.brq.domain.solicitarFornecimentoDePecas.OficinaSolicitacaoFornecimento;
import com.brq.domain.solicitarFornecimentoDePecas.PecaSolicitacaoFornecimento;
import com.brq.domain.solicitarFornecimentoDePecas.Pecas;
import com.brq.domain.solicitarFornecimentoDePecas.ProcessoSolicitacaoFornecimento;
import com.brq.domain.solicitarFornecimentoDePecas.SolicitacaoFornecimentoPeca;
import com.brq.domain.solicitarFornecimentoDePecas.SolicitarFornecimentoPeca;
import com.brq.domain.solicitarFornecimentoDePecas.TelefoneLocalSolicitacaoFornecimento;
import com.brq.domain.solicitarFornecimentoDePecas.TipoOficinaAtendimentoSolicitacao;
import com.brq.domain.solicitarFornecimentoDePecas.VeiculoSolicitacaoFornecimento;
import com.mongodb.util.JSON;

public class FornecimentoDePecas {
	AtributosMassa atributos;

	public FornecimentoDePecas () {
		atributos = new AtributosMassa();
	}

	public FornecimentoDePecas (JSON entrada) {
		atributos = new JsonAtributosMassa(entrada);
	}

	public SolicitarFornecimentoPeca solicitarFornecimentoPeca() {
        SolicitarFornecimentoPeca solicitar = new SolicitarFornecimentoPeca();
        solicitar.setSolicitacaoFornecimentoPeca(solicitacaoFornecimentoPeca());
        return solicitar;
    }

    private SolicitacaoFornecimentoPeca solicitacaoFornecimentoPeca() {
        SolicitacaoFornecimentoPeca solicitacao = new SolicitacaoFornecimentoPeca();
        solicitacao.setCpfCnpjSolicitante(atributos.getCpfCnpjSolicitante());
        solicitacao.setLocalSolicitacaoFornecimento(localSolicitacaoFornecimento());
        solicitacao.setOficinaSolicitacaoFornecimento(oficinaSolicitacaoFornecimento());
        solicitacao.setPecaSolicitacaoFornecimento(pecaSolicitacaoFornecimento());
        solicitacao.setProcessoSolicitacaoFornecimento(processoSolicitacaoFornecimento());
        solicitacao.setVeiculoSolicitacaoFornecimento(veiculoSolicitacaoFornecimento());
        return solicitacao;
    }

    private LocalSolicitacaoFornecimento localSolicitacaoFornecimento() {
        LocalSolicitacaoFornecimento lsf = new LocalSolicitacaoFornecimento();
        lsf.setCodigoTipoLocalSolicitacao(atributos.getCodigoTipoLocalSolicitacao());
        lsf.setNomeLogradouro(atributos.getNomeLogradouro());
        lsf.setNumeroLogradouro(atributos.getNumeroLogradouro());
        lsf.setNomeBairro(atributos.getNomeBairro());
        lsf.setNumeroCep(atributos.getNumeroCep());
        lsf.setSiglaUnidadeFederacao(atributos.getSiglaUnidadeFederacao());
        lsf.setNomeCidade(atributos.getNomeCidade());
        lsf.setTelefoneLocalSolicitacaoFornecimento(telefoneLocalSolicitacaoFornecimento());
        lsf.setLatitude(atributos.getLatitude());
        lsf.setLongitude(atributos.getLongitude());
        return lsf;
    }

    private TelefoneLocalSolicitacaoFornecimento telefoneLocalSolicitacaoFornecimento() {
        TelefoneLocalSolicitacaoFornecimento tlsf = new TelefoneLocalSolicitacaoFornecimento();
        tlsf.setCodigoTelefone(atributos.getCodigoTelefone());
//        tlsf.setDddTelefone(atributos.getDddTelefone());
        tlsf.setNumeroTelefone(atributos.getNumeroTelefone());
        return tlsf;
    }

    private OficinaSolicitacaoFornecimento oficinaSolicitacaoFornecimento() {
        OficinaSolicitacaoFornecimento osf = new OficinaSolicitacaoFornecimento();
        osf.setNumeroCnpjCpfOficina(atributos.getNumeroCnpjCpfOficina());
        osf.setNomeRazaoSocialOficina(atributos.getNomeRazaoSocialOficina());
        osf.setNomeFantasiaOficina(atributos.getNomeFantasiaOficina());
        osf.setCodigoTipoPessoa(atributos.getCodigoTipoPessoa());
        osf.setTipoOficinaAtendimentoSolicitacao(tipoOficinaAtendimentoSolicitacao());
        osf.setNomeEnderecoEmailOficina(atributos.getNomeEnderecoEmailOficina());
        return osf;
    }

    private TipoOficinaAtendimentoSolicitacao tipoOficinaAtendimentoSolicitacao() {
        TipoOficinaAtendimentoSolicitacao toas = new TipoOficinaAtendimentoSolicitacao();
        toas.setCodigoTipoOficinaAtendimento(atributos.getCodigoTipoOficinaAtendimento());
        return toas;
    }

    private List<PecaSolicitacaoFornecimento> pecaSolicitacaoFornecimento() {
        Pecas pecas = new Pecas();
        List<PecaSolicitacaoFornecimento> itens = new ArrayList<>();

        PecaSolicitacaoFornecimento peca01 = new PecaSolicitacaoFornecimento();
        peca01.setValorPrecoPeca(atributos.getValorPrecoPeca());
        peca01.setCodigoPeca(atributos.getCodigoPeca());
        peca01.setQuantidadePeca(atributos.getQuantidadePeca());
        peca01.setFlagPecaManual(atributos.getFlagPecaManual());
        peca01.setNomePecaSolicitacao(atributos.getNomePecaSolicitacao());
        peca01.setCodigoMarcaVeiculo(atributos.getCodigoMarcaVeiculo());
        peca01.setCodigoTipoUsoPeca(atributos.getCodigoTipoUsoPeca());

        PecaSolicitacaoFornecimento peca02 = new PecaSolicitacaoFornecimento();
        peca02.setValorPrecoPeca(atributos.getValorPrecoPeca());          
        peca02.setCodigoPeca(atributos.getCodigoPeca());                  
        peca02.setQuantidadePeca(atributos.getQuantidadePeca());          
        peca02.setFlagPecaManual(atributos.getFlagPecaManual());          
        peca02.setNomePecaSolicitacao(atributos.getNomePecaSolicitacao());
        peca02.setCodigoMarcaVeiculo(atributos.getCodigoMarcaVeiculo());  
        peca02.setCodigoTipoUsoPeca(atributos.getCodigoTipoUsoPeca());    

        //TODO - Implementar a parte da flag
        boolean flag = false;
        if (flag == Boolean.TRUE) {
            itens.add(peca01);
            itens.add(peca02);
        } else {
            itens.add(peca01);
        }

        pecas.setPecaSolicitacaoFornecimento(itens);
        return pecas.getPecaSolicitacaoFornecimento();
    }

    private ProcessoSolicitacaoFornecimento processoSolicitacaoFornecimento() {
        ProcessoSolicitacaoFornecimento psf = new ProcessoSolicitacaoFornecimento();
        psf.setCodigoChaveProcessoSinistro(atributos.getCodigoChaveProcessoSinistro());
        psf.setCodigoProcessoSinistro(atributos.getCodigoProcessoSinistro());
        psf.setNumeroOrcamentoVistoria(atributos.getNumeroOrcamentoVistoria());
        psf.setNumeroVersaoOrcamentoVistoria(atributos.getNumeroVersaoOrcamentoVistoria());
        psf.setDataRecebidoVistoria(atributos.getDataRecebidoVistoria());
        psf.setStatusLiberacaoVistoria(atributos.getStatusLiberacaoVistoria());
        psf.setCodigoNumeroApoliceSinistro(atributos.getCodigoNumeroApoliceSinistro());
        psf.setNomeSeguradoApoliceSinistro(atributos.getNomeSeguradoApoliceSinistro());
        psf.setCodigoNaturezaSinistro(atributos.getCodigoNaturezaSinistro());
        return psf;
    }

    private VeiculoSolicitacaoFornecimento veiculoSolicitacaoFornecimento() {
        VeiculoSolicitacaoFornecimento vsf = new VeiculoSolicitacaoFornecimento();
        vsf.setCodigoLicencaVeiculo(atributos.getCodigoLicencaVeiculo());
        vsf.setCodigoChassiVeiculo(atributos.getCodigoChassiVeiculo());
        vsf.setAnoModeloVeiculo(atributos.getAnoModeloVeiculo());
        vsf.setDescricaoVeiculo(atributos.getDescricaoVeiculo());
        vsf.setCodigoModeloVeiculo(atributos.getCodigoModeloVeiculo());
        vsf.setCodigoCategoriaTarifaVeiculo(atributos.getCodigoCategoriaTarifaVeiculo());
        vsf.setAnoFabricacaoVeiculo(atributos.getAnoFabricacaoVeiculo());
        return vsf;
    }


}