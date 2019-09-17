package br.com.fcamara.backendtestjava.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity extends AbstractDataModel<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Override
  public Long getId() {
    return super.getId();
  }

  public boolean isNew() {
    return getId() == null;
  }

}
