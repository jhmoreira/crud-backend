package com.produtos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.model.Produto;
import com.produtos.api.repository.ProdutoRepositorio;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	
	
	// Listando todos os Produtos
	
	
	@GetMapping("/produtos")
	public List<Produto> listaTodosOsProdutos(){
		return produtoRepositorio.findAll();
	}
	
	// Adiciona produto
	@PostMapping("produtos")
	public Produto criarProduto(@RequestBody Produto produto) {
		return produtoRepositorio.save(produto);
	}
	

}
