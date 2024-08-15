package com.salao.salao_beleza.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable// essa classe não é uma tabela no banco de dados, mas pode ser incorporada em por uma entidade
@Getter // para acessar o metodo para pegar o atributo
@NoArgsConstructor //gera um construtor padrao, sem nenhum parametros
@AllArgsConstructor //gera um construtor com todos os parametros

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) { //construtor que recebe os atributos do obj DadosEndereco
        this.bairro = dados.bairro();
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarDadosEndereco(DadosEndereco dados) {
        if (dados.bairro() != null) { //se o novo valor de bairro estiver diferente de nulo (tiver valor no atributo)
            this.bairro = dados.bairro();//então o atributo bairro, recebe o valor fornecido do atributo bairro (novo)
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.cep() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
    }
}
