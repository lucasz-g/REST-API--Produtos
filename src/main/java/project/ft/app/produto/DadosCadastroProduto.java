package project.ft.app.produto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
    @NotNull
    String nome,
    @NotNull 
    String descricao,
    @NotNull 
    double preco
    ){
} 
