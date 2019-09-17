package br.com.fcamara.backendtestjava.repository;

import br.com.fcamara.backendtestjava.model.Veiculo;
import br.com.fcamara.backendtestjava.response.QueryDslRepository;
import org.springframework.stereotype.Repository;

import static br.com.fcamara.backendtestjava.query.VeiculoQuery.VEICULO;

@Repository
public class VeiculoRepositoy extends QueryDslRepository<Veiculo, Long> {

  public VeiculoRepositoy() {
    super(VEICULO);
  }
}
