package com.example.farmacia.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public  List <Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
}
