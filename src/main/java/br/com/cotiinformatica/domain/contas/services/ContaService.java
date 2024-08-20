package br.com.cotiinformatica.domain.contas.services;

import java.util.List;

import br.com.cotiinformatica.domain.contas.models.dtos.ContaRequest;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaResponse;

public interface ContaService {

	ContaResponse criar(ContaRequest request) throws Exception;

	ContaResponse alterar(Integer id, ContaRequest request) throws Exception;

	ContaResponse excluir(Integer id) throws Exception;

	List<ContaResponse> consultar() throws Exception;

	ContaResponse obterPorId(Integer id) throws Exception;
}
