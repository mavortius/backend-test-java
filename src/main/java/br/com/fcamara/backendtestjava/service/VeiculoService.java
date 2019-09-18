package br.com.fcamara.backendtestjava.service;

import br.com.fcamara.backendtestjava.model.Veiculo;
import br.com.fcamara.backendtestjava.repository.VeiculoRepository;
import br.com.fcamara.backendtestjava.response.QueryDslRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VeiculoService extends AbstractCrudService<Veiculo, Long> {

  private final VeiculoRepository repository;

  public VeiculoService(VeiculoRepository repository) {
    super(Veiculo.class);
    this.repository = repository;
  }

  @Override
  protected QueryDslRepository<Veiculo, Long> getRepository() {
    return repository;
  }
}
