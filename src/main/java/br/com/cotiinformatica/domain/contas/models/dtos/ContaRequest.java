package br.com.cotiinformatica.domain.contas.models.dtos;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContaRequest {

	@NotEmpty(message = "Informe o nome da conta.")
	@Size(min = 6, max = 100, message = "O nome da conta deve ter de 6 a 100 caracteres.")
	private String nome;

	@NotNull(message = "Informe a data da conta.")
	private Date data;

	@NotNull(message = "Informe o valor da conta.")
	@Min(value = 0, message = "Informe o valor da conta maior ou igual a zero.")
	private Double preco;

	@Pattern(regexp = "^(PAGAR|RECEBER)$", 
			message = "Informe somente as opções 'PAGAR' ou 'RECEBER'.")
	@NotEmpty(message = "Informe o tipo da conta.")
	private String tipo;

	@NotNull(message = "Informe a categoria da conta.")
	private Integer categoriaId;
}
