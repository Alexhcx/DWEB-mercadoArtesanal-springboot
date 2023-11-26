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

import com.example.puc.mercadoartesanal.dtos.ArtesanalRecordDto;
import com.example.puc.mercadoartesanal.models.ArtesanalModel;
import com.example.puc.mercadoartesanal.repositories.ArtesanalRepository;

import jakarta.validation.Valid;

@RestController
public class ArtesanalController {

    @Autowired
    ArtesanalRepository artesanalRepository;

    @PostMapping("/produtosArtesanais")
    public ResponseEntity<ArtesanalModel> cadastrarProduto(@RequestBody @Valid ArtesanalRecordDto artesanalRecordDto) {
        var artesanalModel = new ArtesanalModel();
        BeanUtils.copyProperties(artesanalRecordDto, artesanalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(artesanalRepository.save(artesanalModel));
    }

    @GetMapping("/produtosArtesanais")
    public ResponseEntity<List<ArtesanalModel>> listarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(artesanalRepository.findAll());
    }

    @GetMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> listarProdutoPorId(@PathVariable(value="id") long id) {
        Optional<ArtesanalModel> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoArtesanal.get());
    }

    @PutMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value="id") long id, @RequestBody @Valid ArtesanalRecordDto artesanalRecordDto) {
        Optional<ArtesanalModel> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var artesanalModel = produtoArtesanal.get();
        BeanUtils.copyProperties(artesanalRecordDto, artesanalModel);
        return ResponseEntity.status(HttpStatus.OK).body(artesanalRepository.save(artesanalModel));
    }

    @DeleteMapping("/produtosArtesanais/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value="id") long id) {
        Optional<ArtesanalModel> produtoArtesanal = artesanalRepository.findById(id);
        if (produtoArtesanal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        artesanalRepository.delete(produtoArtesanal.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}
