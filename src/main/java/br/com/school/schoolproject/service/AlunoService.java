package br.com.school.schoolproject.service;

import br.com.school.schoolproject.domain.aluno.*;
import br.com.school.schoolproject.domain.escola.Escola;
import br.com.school.schoolproject.domain.escola.EscolaRepository;
import br.com.school.schoolproject.infra.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    /**
     * método de cadastro ded aluno
     * @param dados
     */

    public void cadastrar(DadosCadastroAluno dados){
        Optional<Escola> escolaOptional = escolaRepository.findById(dados.idEscola());
        if(escolaOptional.isPresent()){
            Escola escola = escolaOptional.get();
            Aluno aluno = new Aluno(null, dados.nome(), dados.idade(), dados.rg(), dados.endereco(), escola);
            alunoRepository.save(aluno);
            return;
        }
        //exception caso id de escola inválido
        throw new ValidacaoException("Escola com ID: "+dados.idEscola()+", invalido");


    }

    /**
     * método para detalhamento de aluno por id
     * @param id
     * @return
     */

    public DadosDetalhesAluno getAlunoById(Long id){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            DadosDetalhesAluno dadosDetalhesAluno = new DadosDetalhesAluno(aluno);
            return dadosDetalhesAluno;
        }

        //exception caso aluno com id do param não exista
        throw new ValidacaoException("Aluno com id: "+id+", não existe");


    }

    /**
     * método de detalhamentos de todos os alunos
     * @return
     */

    public List<DadosDetalhesAluno>getAllAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(DadosDetalhesAluno::new).toList();
    }


    /**
     * método de atualização de dados de determinado aluno
     * @param dados
     */

    public void atualizar(DadosAtualizacaoAluno dados){
        Optional<Aluno> alunoOptional = alunoRepository.findById(dados.id());
        if(alunoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            if(dados.nome() != null){
                aluno.setNome(dados.nome());

            }
            if(dados.idade() != null){
                aluno.setIdade( dados.idade());
            }

            if(dados.rg() != null){
                aluno.setRg(dados.rg());
            }

            if(dados.endereco() != null){
                aluno.setEndereco(dados.endereco());
            }
            alunoRepository.save(aluno);
            return;
        }
        //exception caso o id do param de aluno não exista
        throw new ValidacaoException("Aluno com id: "+dados.id()+", não existe");

    }

    /**
     * método de deleção de aluno por id
     * @param id
     */

    public void deletarPorId(Long id){
        alunoRepository.deleteById(id);
    }

}
