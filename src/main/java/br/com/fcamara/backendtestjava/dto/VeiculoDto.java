package br.com.fcamara.backendtestjava.dto;

import br.com.fcamara.backendtestjava.model.AbstractDataModel;
import br.com.fcamara.backendtestjava.model.TipoVeiculo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VeiculoDto extends AbstractDataModel<Long> {

  @NotEmpty(message = "Marca é obrigatório")
  private String marca;

  @NotEmpty(message = "Modelo é obrigatório")
  private String modelo;

  @NotEmpty(message = "Cor é obrigatório")
  private String cor;

  @Pattern(regexp = "[a-zA-Z]{3}[0-9]{4}", message = "Formato de placa inválido")
  @NotEmpty(message = "Placa é obrigatório")
  private String placa;

  private TipoVeiculo tipo;

  @NotNull(message = "Estabelecimento é obrigatório")
  private EmpresaDto estabelecimento;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public TipoVeiculo getTipo() {
    return tipo;
  }

  public void setTipo(TipoVeiculo tipo) {
    this.tipo = tipo;
  }

  public EmpresaDto getEstabelecimento() {
    return estabelecimento;
  }

  public void setEstabelecimento(EmpresaDto estabelecimento) {
    this.estabelecimento = estabelecimento;
  }
}
