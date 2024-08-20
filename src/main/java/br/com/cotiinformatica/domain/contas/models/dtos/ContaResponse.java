package br.com.cotiinformatica.domain.contas.models.dtos;

import java.util.Date;

import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;
import lombok.Data;

@Data
public class ContaResponse {

	private Integer id;
	private String nome;
	private Date data;
	private Double preco;
	private String tipo;
	private CategoriaResponse categoria;
}
