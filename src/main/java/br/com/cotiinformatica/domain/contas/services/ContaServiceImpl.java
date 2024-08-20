package br.com.cotiinformatica.domain.contas.services;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cotiinformatica.domain.categorias.models.entities.Categoria;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaRequest;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaResponse;
import br.com.cotiinformatica.domain.contas.models.entities.Conta;
import br.com.cotiinformatica.domain.contas.models.enums.TipoConta;
import br.com.cotiinformatica.infrastructure.repositories.CategoriaRepository;
import br.com.cotiinformatica.infrastructure.repositories.ContaRepository;
@Service
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ContaResponse criar(ContaRequest request) throws Exception {
		//consultando a categoria da conta através do ID
		Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		//copiar os dados da entidade
		Conta conta = modelMapper.map(request, Conta.class);
		conta.setCategoria(categoria); //associando a categoria da conta
		
		//salvar no banco de dados
		contaRepository.save(conta);
		
		//retornar os dados
		ContaResponse response = modelMapper.map(conta, ContaResponse.class);
		return response;
	}
	@Override
	public ContaResponse alterar(Integer id, ContaRequest request) throws Exception {
		//consultar a conta através do ID
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
		
		//consultar a categoria através do ID
		Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		//alterando os dados da conta
		conta.setNome(request.getNome());
		conta.setData(request.getData());
		conta.setPreco(request.getPreco());
		conta.setTipo(TipoConta.valueOf(request.getTipo()));
		conta.setCategoria(categoria);
		
		//salvando a conta no banco de dados (atualizando)
		contaRepository.save(conta);
		
		//retornar os dados
		ContaResponse response = modelMapper.map(conta, ContaResponse.class);
		return response;
	}
	@Override
	public ContaResponse excluir(Integer id) throws Exception {
		//buscar a conta no banco de dados através do ID
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
		
		//excluindo a conta no banco de dados
		contaRepository.delete(conta);
		
		//retornar os dados
		ContaResponse response = modelMapper.map(conta, ContaResponse.class);
		return response;
	}
	@Override
	public List<ContaResponse> consultar() throws Exception {
		//consultando as contas no banco de dados
		List<Conta> contas = contaRepository.findAll();
		
		//criando uma lista da classe response
		List<ContaResponse> lista = new ArrayList<ContaResponse>();
		
		//percorrer todas as contas obtidas do banco de dados e copiar para a lista de resposta
		for(Conta conta : contas) {
			ContaResponse response = modelMapper.map(conta, ContaResponse.class);
			lista.add(response); //adiciona nja lista
		}
		
		//retornar a lista
		return lista;
	}
	@Override
	public ContaResponse obterPorId(Integer id) throws Exception {
		//consultando os dados da conta através do ID
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
		
		//retornar os dados
		ContaResponse response = modelMapper.map(conta, ContaResponse.class);
		return response;
	}
}