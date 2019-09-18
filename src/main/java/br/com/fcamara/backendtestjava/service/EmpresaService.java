package br.com.fcamara.backendtestjava.service;

import br.com.fcamara.backendtestjava.model.Empresa;
import br.com.fcamara.backendtestjava.repository.EmpresaRepository;
import br.com.fcamara.backendtestjava.response.QueryDslRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmpresaService extends AbstractCrudService<Empresa, Long> {

  private final EmpresaRepository repository;

  public EmpresaService(EmpresaRepository repository) {
    super(Empresa.class);
    this.repository = repository;
  }

  @Override
  protected QueryDslRepository<Empresa, Long> getRepository() {
    return repository;
  }
}
