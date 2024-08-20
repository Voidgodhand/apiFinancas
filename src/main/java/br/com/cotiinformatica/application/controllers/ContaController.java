package br.com.cotiinformatica.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contas.models.dtos.ContaRequest;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaResponse;
import br.com.cotiinformatica.domain.contas.services.ContaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

	@Autowired //injeção de dependência
	private ContaService contaService;
	
	@PostMapping
	public ContaResponse post(@RequestBody @Valid ContaRequest request) throws Exception {
		return contaService.criar(request);
	}
	
	@PutMapping("{id}")
	public ContaResponse put(@PathVariable Integer id, @RequestBody @Valid ContaRequest request) throws Exception {
		return contaService.alterar(id, request);
	}
	
	@DeleteMapping("{id}")
	public ContaResponse delete(@PathVariable Integer id) throws Exception {
		return contaService.excluir(id);
	}
	
	@GetMapping
	public List<ContaResponse> getAll() throws Exception {
		return contaService.consultar();
	}
	
	@GetMapping("{id}")
	public ContaResponse getById(@PathVariable Integer id) throws Exception {
		return contaService.obterPorId(id);
	}
}









