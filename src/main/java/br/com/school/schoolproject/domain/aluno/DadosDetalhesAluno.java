package br.com.school.schoolproject.domain.aluno;

import br.com.school.schoolproject.domain.endereco.Endereco;

public record DadosDetalhesAluno(String nome, Integer idade, String rg, Endereco endereco) {
    public DadosDetalhesAluno(Aluno aluno){
        this(aluno.getNome(), aluno.getIdade(), aluno.getRg(), aluno.getEndereco());
    }
}
