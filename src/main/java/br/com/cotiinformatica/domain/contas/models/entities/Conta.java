package br.com.cotiinformatica.domain.contas.models.entities;

import java.util.Date;

import br.com.cotiinformatica.domain.categorias.models.entities.Categoria;
import br.com.cotiinformatica.domain.contas.models.enums.TipoConta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_conta")
@Data
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "data", nullable = false)
	private Date data;

	@Column(name = "preco", nullable = false)
	private Double preco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoConta tipo;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
}






