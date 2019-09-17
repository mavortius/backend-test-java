package br.com.fcamara.backendtestjava.response;

import br.com.fcamara.backendtestjava.model.AbstractEntity;
import com.querydsl.core.types.*;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@NoRepositoryBean
public abstract class QueryDslRepository<T extends AbstractEntity, ID extends Serializable> extends QuerydslRepositorySupport {

  private final EntityPath<T> entityPath;

  public QueryDslRepository(EntityPath<T> entityPath) {
    super(entityPath.getType());
    this.entityPath = entityPath;
  }

  public Optional<T> findOne(ID id) {
    return Optional.ofNullable(getEntityManager().find(entityPath.getType(), id));
  }

  public Optional<T> findOne(Predicate... predicates) {
    return Optional.ofNullable(createQuery(predicates).fetchFirst());
  }

  public Optional<T> findOne(Predicate predicate) {
    return Optional.ofNullable(createQuery(predicate).fetchFirst());
  }

  public <P> Optional<P> findOne(Expression<P> projection, Predicate... predicates) {
    return Optional.ofNullable(createQuery(predicates).select(projection).fetchFirst());
  }

  public <P> Optional<P> findOne(JPQLQuery<P> query) {
    return Optional.ofNullable(createQuery(query).fetchFirst());
  }

  public List<T> findAll(Predicate... predicates) {
    return createQuery(predicates).fetch();
  }

  public List<T> findAll(Predicate predicate) {
    return createQuery(predicate).fetch();
  }

  public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
    return createQuery(predicate).orderBy(orders).fetch();
  }

  public Page<T> findAll(Pageable pageable, Predicate predicates, OrderSpecifier<?>... orders) {
    final JPQLQuery<?> countQuery = createQuery(predicates);
    JPQLQuery<T> query = getQuerydsl().applyPagination(pageable, createQuery(predicates)).orderBy(orders);
    return PageableExecutionUtils.getPage(query.fetch(), pageable, countQuery::fetchCount);
  }

  public <P> Page<P> findAll(Pageable pageable, JPQLQuery<P> query) {
    JPQLQuery<P> attachedQuery = createQuery(query);
    JPQLQuery<P> pagedQuery = getQuerydsl().applyPagination(pageable, attachedQuery);
    return PageableExecutionUtils.getPage(pagedQuery.fetch(), pageable, attachedQuery::fetchCount);
  }

  public <P> List<P> findAll(JPQLQuery<P> query) {
    return createQuery(query).fetch();
  }

  public <P> List<P> findAllProjection(Expression<P> projection, Predicate... predicates) {
    return createQuery(predicates).select(projection).fetch();
  }

  public <P> Page<P> findAll(ConstructorExpression<P> projection, Pageable pageable,
                             Predicate... predicates) {
    final JPQLQuery<?> countQuery = createQuery(predicates);
    JPQLQuery<P> query = getQuerydsl().applyPagination(pageable, createQuery(predicates).select(projection));

    return PageableExecutionUtils.getPage(query.fetch(), pageable, countQuery::fetchCount);
  }

  public List<T> findAllDistinct(Predicate... predicates) {
    return createQuery(predicates).distinct().fetch();
  }

  public List<T> findAllDistinct(Predicate predicate, OrderSpecifier<?>... orders) {
    return createQuery(predicate).distinct().orderBy(orders).fetch();
  }

  public <P> List<P> findAllDistinct(Expression<P> projection, Predicate... predicates) {
    return createQuery(predicates).distinct().select(projection).fetch();
  }

  public Page<T> findAllDistinct(Pageable pageable, Predicate... predicates) {
    final JPQLQuery<?> countQuery = createQuery(predicates).distinct();
    JPQLQuery<T> query = getQuerydsl().applyPagination(pageable, createQuery(predicates)).distinct();
    return PageableExecutionUtils.getPage(query.fetch(), pageable, countQuery::fetchCount);
  }

  public <P> Page<P> findAllDistinct(Expression<P> projection, Pageable pageable,
                                     Predicate... predicates) {
    final JPQLQuery<?> countQuery = createQuery(predicates).distinct();
    JPQLQuery<P> query = getQuerydsl().applyPagination(pageable, createQuery(predicates).select(projection)).distinct();

    return PageableExecutionUtils.getPage(query.fetch(), pageable, countQuery::fetchCount);
  }

  public long count(Predicate predicate) {
    return createQuery(predicate).fetchCount();
  }

  public long count(Predicate... predicates) {
    return createQuery(predicates).fetchCount();
  }

  public <P> long count(JPQLQuery<P> query) {
    return createQuery(query).fetchCount();
  }

  public long countDistinct(Predicate... predicates) {
    return createQuery(predicates).distinct().fetchCount();
  }

  public <P> long countDistinct(JPQLQuery<P> query) {
    return createQuery(query).distinct().fetchCount();
  }

  public boolean exists(Predicate predicate) {
    return count(predicate) > 0;
  }

  public boolean exists(Predicate... predicates) {
    return count(predicates) > 0;
  }

  public <P> boolean exists(JPQLQuery<P> query) {
    return count(query) > 0;
  }

  @Transactional
  public T save(T entity) {
    if (entity.isNew()) {
      getEntityManager().persist(entity);
      return entity;
    } else {
      return getEntityManager().merge(entity);
    }
  }

  @Transactional
  public List<T> save(List<T> entities) {
    entities.forEach(e -> e = save(e));
    return entities;
  }

  public long update(List<? extends Path<?>> paths, List<?> values, Predicate... predicates) {
    return update(entityPath).set(paths, values).where(predicates).execute();
  }

  public <V> long update(Path<V> path, V value, Predicate... predicates) {
    return update(entityPath).set(path, value).where(predicates).execute();
  }

  public <V> long update(Path<V> path, Expression<? extends V> expression,
                         Predicate... predicates) {
    return update(entityPath).set(path, expression).where(predicates).execute();
  }

  @Transactional
  public void delete(ID id) {
    EntityManager em = getEntityManager();
    T entity = Objects.requireNonNull(em).getReference(entityPath.getType(), id);
    em.remove(entity);
  }

  @Transactional
  public void delete(T entity) {
    Objects.requireNonNull(getEntityManager()).remove(entity);
  }

  public long delete(Predicate... predicates) {
    return delete(entityPath).where(predicates).execute();
  }

  private JPQLQuery<T> createQuery(Predicate predicate) {
    return from(entityPath).where(predicate);
  }

  private JPQLQuery<T> createQuery(Predicate... predicates) {
    return from(entityPath).where(predicates);
  }

  private <P> JPQLQuery<P> createQuery(JPQLQuery<P> query) {
    return ((JPAQuery<P>) query).clone(Objects.requireNonNull(getEntityManager()));
  }
}
