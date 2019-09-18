package br.com.fcamara.backendtestjava.service;

import br.com.fcamara.backendtestjava.dto.AbstractRequestData;
import br.com.fcamara.backendtestjava.exception.ResourceNotFoundException;
import br.com.fcamara.backendtestjava.model.AbstractEntity;
import br.com.fcamara.backendtestjava.response.QueryDslRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudService<T extends AbstractEntity, ID extends Serializable> {

  private Class<T> domainClass;

  public AbstractCrudService(Class<T> domainClass) {
    this.domainClass = domainClass;
  }

  public List<T> list(Predicate predicate) {
    return getRepository().findAll(predicate);
  }

  public List<T> list(Predicate predicate, OrderSpecifier<?>... orders) {
    return getRepository().findAll(predicate, orders);
  }

  public Page<T> list(Pageable pageable, Predicate predicate, OrderSpecifier<?>... orders) {
    return getRepository().findAll(pageable, predicate, orders);
  }

  public T get(ID id) {
    return getRepository().findOne(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Transactional
  public T create(AbstractRequestData<T, ID> dto) throws Exception {
    return save(dto, domainClass.newInstance());
  }

  @Transactional
  public T update(ID id, AbstractRequestData<T, ID> dto) {
    T entity = get(id);
    return save(dto, entity);
  }

  @Transactional
  public void delete(ID id) {
    T entity = get(id);
    getRepository().delete(entity);
  }

  protected T save(AbstractRequestData<T, ID> source, T target) {
    source.copyTo(target);
    return getRepository().save(target);
  }

  protected abstract QueryDslRepository<T, ID> getRepository();

}
