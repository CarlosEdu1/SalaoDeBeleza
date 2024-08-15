package com.salao.salao_beleza.cabeleireiro;

public record DadosListagemCabelereiro(Long id, String nome, String email, String cpf) {

    public DadosListagemCabelereiro(Cabeleireiro cabeleireiro) {
        this(cabeleireiro.getId(),cabeleireiro.getNome(),cabeleireiro.getEmail(),cabeleireiro.getCpf());
    }
}
