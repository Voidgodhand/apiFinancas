package br.com.cotiinformatica.domain.categorias.services;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.categorias.models.entities.Categoria;
import br.com.cotiinformatica.infrastructure.repositories.CategoriaRepository;
@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoriaResponse criar(CategoriaRequest request) throws Exception {
		//capturar os dados da categoria
		Categoria categoria = modelMapper.map(request, Categoria.class);
		
		//salvar no banco de dados
		categoriaRepository.save(categoria);
		
		//retornar os dados
		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}
	@Override
	public CategoriaResponse alterar(Integer id, CategoriaRequest request) throws Exception {
		//buscar a categoria no banco de dados através do ID
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		//alterar os dados da categoria
		categoria.setNome(request.getNome());
		
		//atualizando no banco de dados
		categoriaRepository.save(categoria);
		
		//retornar os dados
		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}
	@Override
	public CategoriaResponse excluir(Integer id) throws Exception {
		//buscar a categoria no banco de dados através do ID
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		//excluir a categpria
		categoriaRepository.delete(categoria);
		
		//retornar os dados
		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}
	@Override
	public List<CategoriaResponse> consultar() throws Exception {
		//buscar todas as categorias cadastradas no banco de dados
		List<Categoria> categorias = categoriaRepository.findAll();
		
		//criando uma lista da classe de resposta
		List<CategoriaResponse> lista = new ArrayList<CategoriaResponse>();
		
		//percorrendo cada categoria obtida do banco de dados
		for(Categoria categoria : categorias) {
			//copiar os dados da categoria para a classe response
			CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
			lista.add(response); //adicionando na lista
		}
		
		//retornar os dados
		return lista;
	}
	@Override
	public CategoriaResponse obterPorId(Integer id) throws Exception {
		//consultar a categoria no banco de dados através do ID
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		//retornar os dados
		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}
}