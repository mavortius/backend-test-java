package br.com.fcamara.backendtestjava.model;

import javax.persistence.Entity;

@Entity
public class Empresa extends AbstractEntity<Long> {

    private String nome;

    private String cnpj;

    private String endereco;

    private String telefone;

    private int quantidadeVagasMotos;

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
