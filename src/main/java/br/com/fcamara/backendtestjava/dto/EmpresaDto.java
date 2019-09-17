package br.com.fcamara.backendtestjava.dto;

import br.com.fcamara.backendtestjava.model.AbstractDataModel;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class EmpresaDto extends AbstractDataModel<Long> {

  @NotEmpty(message = "Nome é obrigatório")
  private String nome;

  @NotNull(message = "CNPJ é obrigatório")
  @CNPJ(message = "CNPJ informado inválido")
  private String cnpj;

  @NotEmpty(message = "Endereço é obrigatório")
  private String endereco;

  @Pattern(regexp = ".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}", message = "Formato de telefone inválido")
  @NotNull(message = "Telefone é obrigatório")
  private String telefone;

  @NotNull(message = "Quantidade de vagas por motos é obrigatório")
  @PositiveOrZero(message = "Quantidade de vagas por motos precisa ser um valor igual ou maior que zero")
  private int quantidadeVagasMotos;

  @NotNull(message = "Quantidade de vagas por carros é obrigatório")
  @PositiveOrZero(message = "Quantidade de vagas por carros precisa ser um valor igual ou maior que zero")
  private int quantidadeVagasCarros;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public int getQuantidadeVagasMotos() {
    return quantidadeVagasMotos;
  }

  public void setQuantidadeVagasMotos(int quantidadeVagasMotos) {
    this.quantidadeVagasMotos = quantidadeVagasMotos;
  }

  public int getQuantidadeVagasCarros() {
    return quantidadeVagasCarros;
  }

  public void setQuantidadeVagasCarros(int quantidadeVagasCarros) {
    this.quantidadeVagasCarros = quantidadeVagasCarros;
  }
}
