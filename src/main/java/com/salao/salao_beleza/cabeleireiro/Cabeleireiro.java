package com.salao.salao_beleza.cabeleireiro;

import com.salao.salao_beleza.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cabeleireiro") //determina o nome da tabela dentro do banco de dados
@Entity(name = "Cabeleireiro")//define essa classe como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados
@AllArgsConstructor //gera um construtor com todos os atributos dessa classe
@NoArgsConstructor //gera um construtor sem parametros
@Getter //gera os metodos acessores dos atributos dessa classe
@EqualsAndHashCode(of = "id") //compara atraves do id se o obj que foi criado duas instancias, é o mesmo
public class Cabeleireiro {

    @Id //marca o atributo como chave primaria da entidade Cabeleireiro, vai identificar de forma exclusiva cada registro associado á entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Configura a chave primária para ser gerada automaticamente pelo banco de dados usando autoincremento
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;
    @Embedded//serve para mapear os atributos da classe endereço, a classe endereço não é uma tabela, mas os seus atributos podem ser utilizados em outra entidade (classe)
    private Endereco endereco;

    public Cabeleireiro(DadosCadastroCabelereiro dados){
        this.nome = dados.email();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());//é necessário a criação do obj pois os atributos de endereco estao dentro do seu record e nao no record de cadastroDeCabeleireiro
    }

    public void atualizarDadosCabeleireiro(DadosAtualizarCabeleireiro dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarDadosEndereco(dados.endereco());
        }
    }

    public void excluirCabeleireiro(){
        this.ativo = false;
    }
}
