package com.salao.salao_beleza.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//Record (DadosEndereco): Facilita a criação de uma estrutura
// de dados imutável com menos código, ideal para transferir dados de forma clara e concisa.
// aqui eu determino quais são as regras que eu quero dentro dos atributos, se ele pode
//por exemplo ser ou não um campo nulo dentro do banco de dados

public record DadosEndereco(

        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "//{8}")
        String cep,
        @NotBlank
        String cidade,
        String complemento,
        String numero,
        String uf
) {
}
