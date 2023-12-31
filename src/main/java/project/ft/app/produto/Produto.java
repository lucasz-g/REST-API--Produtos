package project.ft.app.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") 

public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(DadosCadastroProduto dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco(); 
    }

    public void atualizarProdutos(DadosAtualizacaoProduto dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco(); 
    }
}


