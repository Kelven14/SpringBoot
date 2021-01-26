package com.example.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.farmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

}
