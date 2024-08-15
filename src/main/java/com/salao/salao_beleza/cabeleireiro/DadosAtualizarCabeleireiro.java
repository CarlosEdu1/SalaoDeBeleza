package com.salao.salao_beleza.cabeleireiro;

import com.salao.salao_beleza.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCabeleireiro(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
