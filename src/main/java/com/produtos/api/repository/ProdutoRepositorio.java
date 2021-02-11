package com.produtos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.api.model.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> { 

}
