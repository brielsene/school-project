package br.com.school.schoolproject.controller;

import br.com.school.schoolproject.domain.escola.*;
import br.com.school.schoolproject.service.EscolaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEscola dados){
        escolaService.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesEscola>buscarDetalhesEscolaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(escolaService.buscarDetalhesEscolaPorId(id));
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoEscola dados){
        escolaService.atualizar(dados);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity deletar(@RequestBody DadosDelecaoEscola dados){
        escolaService.deletar(dados);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
