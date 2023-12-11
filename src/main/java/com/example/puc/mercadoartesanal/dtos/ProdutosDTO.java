package com.example.puc.mercadoartesanal.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutosDTO(

    @NotBlank @NotNull String nomeProduto, 
    @NotBlank @NotNull String tipoProduto,
    @NotNull String descricao, 
    @NotBlank @NotNull String imagem1,
    @NotBlank @NotNull String imagem2,
    @NotBlank @NotNull String imagem3,   
    @NotNull BigDecimal preco ) {

}
