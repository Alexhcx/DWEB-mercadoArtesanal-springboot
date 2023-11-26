package com.example.puc.mercadoartesanal.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArtesanalRecordDto(

    @NotBlank @NotNull String nomeProduto, 
    @NotBlank @NotNull String tipoProduto,
    @NotNull String descricao, 
    @NotBlank @NotNull String imagem, 
    @NotNull BigDecimal preco ) {

}
