package br.com.fcamara.backendtestjava.dto;

import br.com.fcamara.backendtestjava.model.AbstractDataModel;
import br.com.fcamara.backendtestjava.model.AbstractEntity;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public abstract class AbstractRequestData<T extends AbstractEntity, ID extends Serializable> extends AbstractDataModel<ID> {

  public void setId(ID id) {
    this.id = id;
  }

  public void copyTo(T target) {
    BeanUtils.copyProperties(this, target);
  }

  public void copyTo(T target, String... ignoreProperties) {
    BeanUtils.copyProperties(this, target, ignoreProperties);
  }

}
