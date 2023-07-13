package br.com.school.schoolproject.domain.escola;

import br.com.school.schoolproject.domain.aluno.Aluno;
import br.com.school.schoolproject.domain.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "escola")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "escola")
    @JsonManagedReference
    private List<Aluno> alunos;


}
