package br.com.fcamara.backendtestjava.repository;

import br.com.fcamara.backendtestjava.model.Empresa;
import br.com.fcamara.backendtestjava.response.QueryDslRepository;
import org.springframework.stereotype.Repository;

import static br.com.fcamara.backendtestjava.query.EmpresaQuery.EMPRESA;

@Repository
public class EmpresaRepository extends QueryDslRepository<Empresa, Long> {

  public EmpresaRepository() {
    super(EMPRESA);
  }
}
