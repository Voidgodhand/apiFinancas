package br.com.cotiinformatica.domain.categorias.models.entities;

import java.util.List;

import br.com.cotiinformatica.domain.contas.models.entities.Conta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_categoria")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Conta> contas;
}
