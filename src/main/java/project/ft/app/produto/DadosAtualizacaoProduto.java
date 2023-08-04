package project.ft.app.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
    Long id,
    String nome,
    String descricao,

    @NotNull
    double preco
    ){

}  
