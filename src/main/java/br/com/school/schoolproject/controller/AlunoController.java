package br.com.school.schoolproject.controller;

import br.com.school.schoolproject.domain.aluno.DadosAtualizacaoAluno;
import br.com.school.schoolproject.domain.aluno.DadosCadastroAluno;
import br.com.school.schoolproject.domain.aluno.DadosDetalhesAluno;
import br.com.school.schoolproject.service.AlunoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroAluno dados){
        alunoService.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlunoById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAlunoById(id));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhesAluno>>getAllAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAllAlunos());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoAluno dados){
        alunoService.atualizar(dados);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id")Long id){
        alunoService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
