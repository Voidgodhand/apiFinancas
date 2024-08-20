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

import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.categorias.services.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public CategoriaResponse post(@RequestBody @Valid CategoriaRequest request) throws Exception {
		return categoriaService.criar(request);
	}
	
	@PutMapping("{id}")
	public CategoriaResponse put(@PathVariable Integer id, @RequestBody @Valid CategoriaRequest request) throws Exception {
		return categoriaService.alterar(id, request);
	}
	
	@DeleteMapping("{id}")
	public CategoriaResponse delete(@PathVariable Integer id) throws Exception {
		return categoriaService.excluir(id);
	}
	
	@GetMapping
	public List<CategoriaResponse> getAll() throws Exception {
		return categoriaService.consultar();
	}
	
	@GetMapping("{id}")
	public CategoriaResponse getById(@PathVariable Integer id) throws Exception {
		return categoriaService.obterPorId(id);
	}
}
