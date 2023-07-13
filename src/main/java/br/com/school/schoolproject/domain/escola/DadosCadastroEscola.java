package br.com.school.schoolproject.domain.escola;

import br.com.school.schoolproject.domain.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEscola(
        @NotBlank
        String nome,
        Endereco endereco) {
}
