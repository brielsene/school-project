package br.com.school.schoolproject.domain.escola;

import br.com.school.schoolproject.domain.aluno.Aluno;
import br.com.school.schoolproject.domain.endereco.Endereco;

import java.util.List;

public record DadosDetalhesEscola(String nome, Endereco endereco, List<Aluno>alunos) {
    public DadosDetalhesEscola(Escola escola){
        this(escola.getNome(), escola.getEndereco(), escola.getAlunos());
    }
}
