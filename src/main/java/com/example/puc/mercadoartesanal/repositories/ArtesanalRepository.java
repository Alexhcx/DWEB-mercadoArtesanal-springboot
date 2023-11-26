package com.example.puc.mercadoartesanal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.puc.mercadoartesanal.models.ArtesanalModel;

@Repository
public interface ArtesanalRepository extends JpaRepository<ArtesanalModel, Long>{
    
}
