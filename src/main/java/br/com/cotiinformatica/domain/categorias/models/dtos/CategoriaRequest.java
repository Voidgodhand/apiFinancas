package br.com.cotiinformatica.domain.categorias.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaRequest {

	@NotEmpty(message = "Informe o nome da categoria")
	@Size(min = 6, max = 50, message = "Informe o nome da categoria de 6 a 50 caracteres.")
	private String nome;
}
