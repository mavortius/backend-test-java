package br.com.fcamara.backendtestjava.response;

import br.com.fcamara.backendtestjava.model.AbstractDataModel;
import br.com.fcamara.backendtestjava.model.Empresa;
import br.com.fcamara.backendtestjava.model.TipoVeiculo;
import br.com.fcamara.backendtestjava.model.Veiculo;
import com.querydsl.core.annotations.QueryProjection;

public class VeiculoDataResponse extends AbstractDataModel<Long> {

  private final String marca;
  private final String modelo;
  private final String cor;
  private final String placa;
  private final TipoVeiculo tipo;
  private final Empresa estabelecimento;

  @QueryProjection
  public VeiculoDataResponse(Veiculo veiculo) {
    this.marca = veiculo.getMarca();
    this.modelo = veiculo.getModelo();
    this.cor = veiculo.getCor();
    this.placa = veiculo.getPlaca();
    this.tipo = veiculo.getTipo();
    this.estabelecimento = veiculo.getEstabelecimento();
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public String getCor() {
    return cor;
  }

  public String getPlaca() {
    return placa;
  }

  public TipoVeiculo getTipo() {
    return tipo;
  }

  public Empresa getEstabelecimento() {
    return estabelecimento;
  }
}
