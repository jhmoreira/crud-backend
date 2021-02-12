package com.produtos.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.exception.ProdutoNaoEncontrado;
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
	
	//Lista produto pelo ID
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> retornaProdutoPorId(@PathVariable Long id) {
		Produto produto= produtoRepositorio.findById(id).orElseThrow(()-> new ProdutoNaoEncontrado("Não existe produto com id: "+id));
		return ResponseEntity.ok(produto);
	}

	// Atualiza produto
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody Produto produtoAtt) {
		Produto produto= produtoRepositorio.findById(id).orElseThrow(()-> new ProdutoNaoEncontrado("Não existe produto com id: "+id));
		
		produto.setNomeProduto(produtoAtt.getNomeProduto());
		produto.setDescricaoProduto(produtoAtt.getDescricaoProduto());
		
	Produto produtoAtualizado=	produtoRepositorio.save(produto);
	return ResponseEntity.ok(produtoAtualizado);
	}
	
	// Deleta Produto
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity <Map<String, Boolean>> apagaProduto(@PathVariable Long id){
			Produto produto= produtoRepositorio.findById(id).orElseThrow(()-> new ProdutoNaoEncontrado("Não existe produto com id: "+id));
		
			produtoRepositorio.delete(produto);
			Map<String, Boolean>response =new HashMap<>();
;
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
	}
}
