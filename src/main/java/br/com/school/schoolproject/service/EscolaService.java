package br.com.school.schoolproject.service;

import br.com.school.schoolproject.domain.escola.*;
import br.com.school.schoolproject.infra.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository escolaRepository;

    /**
     * método para cadastramento de escola
     * @param dados
     */

    public void cadastrar(DadosCadastroEscola dados){
        Escola escola = new Escola(null, dados.nome(), dados.endereco(), null);
        escolaRepository.save(escola);
    }

    /**
     * método para detalhar escola, busca por id
     * @param id
     * @return
     */

    public DadosDetalhesEscola buscarDetalhesEscolaPorId(Long id){


        Optional<Escola> byId = escolaRepository.findById(id);
        if(byId.isPresent()){
            Escola escola = byId.orElseThrow(() -> new ValidacaoException("Escola com id: " + id + " não existe"));
            DadosDetalhesEscola dadosDetalhesEscola = new DadosDetalhesEscola(escola);
            return dadosDetalhesEscola;
        }

        throw new ValidacaoException("Escola com id: "+id+", não existe");
    }

    /**
     * método para atualizar dados da escola
     * @param dados
     */

    public void atualizar(DadosAtualizacaoEscola dados){
        Optional<Escola> byId = escolaRepository.findById(dados.id());
        if(byId.isPresent()){
            Escola escola = byId.get();
            if(dados.nome() != null){
                escola.setNome(dados.nome());
            }
            if(dados.endereco() != null){
                escola.setEndereco(dados.endereco());
            }
            escolaRepository.save(escola);
        }
        throw new ValidacaoException("Escola com ID: "+dados.id()+", não encontrada");

    }

    /**
     * método para deletar escola
     * @param dados
     */

    public void deletar(DadosDelecaoEscola dados){
        escolaRepository.deleteById(dados.id());
    }

}
