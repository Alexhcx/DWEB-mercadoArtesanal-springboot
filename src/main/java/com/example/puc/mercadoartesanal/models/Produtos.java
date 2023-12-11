package com.example.puc.mercadoartesanal.models;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PRODUTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produtos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProduto;
    private String nomeProduto;
    private String tipoProduto;
    private String descricao;
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private BigDecimal preco;

}
