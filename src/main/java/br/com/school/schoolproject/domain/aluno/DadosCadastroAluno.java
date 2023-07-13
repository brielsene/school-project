package br.com.school.schoolproject.domain.aluno;

import br.com.school.schoolproject.domain.endereco.Endereco;

public record DadosCadastroAluno(String nome, Integer idade, String rg, Endereco endereco, Long idEscola) {

}
