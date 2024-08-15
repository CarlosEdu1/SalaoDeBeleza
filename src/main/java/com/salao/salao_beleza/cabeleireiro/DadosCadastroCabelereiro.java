package com.salao.salao_beleza.cabeleireiro;


import com.salao.salao_beleza.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCabelereiro(

        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "//{11}") //o padrao do cpf tem que ser 11 numeros
        String cpf,
        @NotBlank @Valid //não pode ficar em branco esse obj tb vai ter validação
        DadosEndereco endereco
) {
}
