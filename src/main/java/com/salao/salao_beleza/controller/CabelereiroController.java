package com.salao.salao_beleza.controller;

import com.salao.salao_beleza.cabeleireiro.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/cab")
public class CabelereiroController {

    @Autowired
    private CabelereiroRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCabelereiro(@RequestBody @Valid DadosCadastroCabelereiro dados) {
        repository.save(new Cabeleireiro(dados));
    }

    @GetMapping
    public Page<DadosListagemCabelereiro> listarCabelereiro(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemCabelereiro::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCabeleireiro(@RequestBody @Valid DadosAtualizarCabeleireiro dados) {
    var cabeleireiro = repository.getReferenceById(dados.id());
    cabeleireiro.atualizarDadosCabeleireiro(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluirCabeleireiro(@PathVariable Long id) {
         var cabeleireiro = repository.getReferenceById(id);
         cabeleireiro.excluirCabeleireiro();
    }
}

