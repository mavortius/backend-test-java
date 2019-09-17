package br.com.fcamara.backendtestjava.model;

import java.io.Serializable;

public abstract class AbstractDataModel<ID extends Serializable> implements Identifiable<ID> {

  private ID id;

  @Override
  public ID getId() {
    return id;
  }
}
