package com.example.puc.mercadoartesanal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.puc.mercadoartesanal.dtos.ProdutosDTO;
import com.example.puc.mercadoartesanal.models.Produtos;
import com.example.puc.mercadoartesanal.repositories.ArtesanalRepository;

import jakarta.validation.Valid;

@RestController
public class ArtesanalController {

    @Autowired
    ArtesanalRepository artesanalRepository;

        /**
     * Endpoint para criar um novo produto artesanal.
     * @param artesanalRecordDto - DTO com as informações do produto a ser criado.
     * @return ResponseEntity com o status HTTP e o produto criado.
     */

    @PostMapping("/produtosArtesanais")
    public ResponseEntity<Produtos> cadastrarProduto(@RequestBody @Valid ProdutosDTO artesanalRecordDto) {
        var artesanalModel = new Produtos();
        BeanUtils.copyProperties(artesanalRecordDto, artesanalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(artesanalRepository.save(artesanalModel));
    }

    /**
     * Endpoint para listar todos os produtos artesanais.
     * @return ResponseEntity com o status HTTP e a lista de produtos.
     */

    @GetMapping("/produtosArtesanais")
    public ResponseEntity<List<Produtos>> listarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(artesanalRepository.findAll());
    }

     /**
     * Endpoint para buscar um produto artesanal pelo ID.
     * @param id - ID do produto a ser buscado.
     * @return ResponseEntity com o status HTTP e o produto encontrado, ou mensagem de erro se não encontrado.
     */

    @GetMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> listarProdutoPorId(@PathVariable(value="id") long id) {
        Optional<Produtos> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoArtesanal.get());
    }

     /**
     * Endpoint para atualizar um produto artesanal.
     * @param id - ID do produto a ser atualizado.
     * @param artesanalRecordDto - DTO com as novas informações do produto.
     * @return ResponseEntity com o status HTTP e o produto atualizado, ou mensagem de erro se não encontrado.
     */

    @PutMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value="id") long id, @RequestBody @Valid ProdutosDTO artesanalRecordDto) {
        Optional<Produtos> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var artesanalModel = produtoArtesanal.get();
        BeanUtils.copyProperties(artesanalRecordDto, artesanalModel);
        return ResponseEntity.status(HttpStatus.OK).body(artesanalRepository.save(artesanalModel));
    }

        /**
     * Endpoint para deletar um produto artesanal.
     * @param id - ID do produto a ser deletado.
     * @return ResponseEntity com o status HTTP e mensagem de sucesso, ou mensagem de erro se não encontrado.
     */

    @DeleteMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value="id") long id) {
        Optional<Produtos> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        artesanalRepository.delete(produtoArtesanal.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}
