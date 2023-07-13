package br.com.school.schoolproject.domain.escola;

import br.com.school.schoolproject.domain.endereco.Endereco;

public record DadosAtualizacaoEscola(Long id, String nome, Endereco endereco) {
}
