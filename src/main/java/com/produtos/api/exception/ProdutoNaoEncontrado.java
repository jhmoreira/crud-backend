package com.produtos.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProdutoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontrado(String aviso) {
		super(aviso);
	}
}
