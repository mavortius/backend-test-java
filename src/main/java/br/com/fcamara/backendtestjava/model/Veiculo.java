package br.com.fcamara.backendtestjava.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo extends AbstractEntity {

  private String marca;
  private String modelo;
  private String cor;
  private String placa;

  @ManyToOne
  private Empresa estabelecimento;

  @Enumerated(EnumType.STRING)
  private TipoVeiculo tipo;

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

  public Empresa getEstabelecimento() {
    return estabelecimento;
  }

  public void setEstabelecimento(Empresa estabelecimento) {
    this.estabelecimento = estabelecimento;
  }
}
