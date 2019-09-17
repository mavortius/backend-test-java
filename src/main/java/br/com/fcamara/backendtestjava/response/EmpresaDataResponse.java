package br.com.fcamara.backendtestjava.response;

import br.com.fcamara.backendtestjava.model.AbstractDataModel;
import br.com.fcamara.backendtestjava.model.Empresa;
import com.querydsl.core.annotations.QueryProjection;

public class EmpresaDataResponse extends AbstractDataModel<Long> {

  private final String nome;
  private final String cnpj;
  private final String endereco;
  private final String telefone;
  private final int quantidadeVagasMotos;
  private final int quantidadeVagasCarros;

  @QueryProjection
  public EmpresaDataResponse(Empresa empresa) {
    this.nome = empresa.getNome();
    this.cnpj = empresa.getCnpj();
    this.endereco = empresa.getEndereco();
    this.telefone = empresa.getTelefone();
    this.quantidadeVagasMotos = empresa.getQuantidadeVagasMotos();
    this.quantidadeVagasCarros = empresa.getQuantidadeVagasCarros();
  }

  public String getNome() {
    return nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public int getQuantidadeVagasMotos() {
    return quantidadeVagasMotos;
  }

  public int getQuantidadeVagasCarros() {
    return quantidadeVagasCarros;
  }
}
