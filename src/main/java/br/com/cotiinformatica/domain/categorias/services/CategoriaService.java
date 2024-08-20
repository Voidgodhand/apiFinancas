package br.com.cotiinformatica.domain.categorias.services;

import java.util.List;

import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;

public interface CategoriaService {

	CategoriaResponse criar(CategoriaRequest request) throws Exception;

	CategoriaResponse alterar(Integer id, CategoriaRequest request) throws Exception;

	CategoriaResponse excluir(Integer id) throws Exception;

	List<CategoriaResponse> consultar() throws Exception;

	CategoriaResponse obterPorId(Integer id) throws Exception;
}
